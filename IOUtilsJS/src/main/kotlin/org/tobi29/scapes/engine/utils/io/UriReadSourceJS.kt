package org.tobi29.scapes.engine.utils.io

import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Int8Array
import org.tobi29.scapes.engine.utils.*
import org.w3c.dom.url.URL
import org.w3c.files.Blob
import org.w3c.files.File
import org.w3c.xhr.ARRAYBUFFER
import org.w3c.xhr.ProgressEvent
import org.w3c.xhr.XMLHttpRequest
import org.w3c.xhr.XMLHttpRequestResponseType
import kotlin.coroutines.experimental.intrinsics.COROUTINE_SUSPENDED
import kotlin.coroutines.experimental.intrinsics.suspendCoroutineOrReturn

class UriPath(private val uri: Uri) : Path {
    private var requested = false
    private var content: Result<ByteViewERO, Exception>? = null
    private var queue: ArrayList<() -> Unit>? = ArrayList()

    override fun toUri(): Uri = uri

    // TODO: Add resolve functionality to Uri
    override val parent: Path?
        get() = UnixPathEnvironment.run {
            UriPath(when (uri) {
                is UriHierarchicalAbsolute -> UriHierarchicalAbsolute(
                        uri.scheme,
                        uri.path.parent ?: return null, uri.query, uri.fragment)
                is UriHierarchicalNet -> UriHierarchicalNet(uri.scheme,
                        uri.userInfo, uri.host, uri.port,
                        uri.path?.parent ?: return null, uri.query,
                        uri.fragment)
                is UriRelative -> UriRelative(uri.path.parent ?: return null,
                        uri.query, uri.fragment)
                else -> throw UnsupportedOperationException(
                        "Cannot resolve from opaque URI")
            })
        }

    // TODO: Add resolve functionality to Uri
    override fun get(path: String): Path = UnixPathEnvironment.run {
        UriPath(when (uri) {
            is UriHierarchicalAbsolute -> UriHierarchicalAbsolute(uri.scheme,
                    uri.path.resolve(path), uri.query, uri.fragment)
            is UriHierarchicalNet -> UriHierarchicalNet(uri.scheme,
                    uri.userInfo, uri.host, uri.port,
                    (uri.path ?: "/").resolve(path), uri.query,
                    uri.fragment)
            is UriRelative -> UriRelative(uri.path.resolve(path), uri.query,
                    uri.fragment)
            else -> throw UnsupportedOperationException(
                    "Cannot resolve from opaque URI")
        })
    }

    override fun channel(): ReadableByteChannel {
        request()
        content?.let {
            return ReadableByteStreamChannel(
                    MemoryViewReadableStream(it.unwrap()))
        }
        return object : ReadableByteChannel {
            private var stream: MemoryViewReadableStream<*>? = null

            override fun read(buffer: ByteView): Int {
                while (true) {
                    stream?.let { return it.getSome(buffer) }
                    stream = MemoryViewReadableStream(
                            (this@UriPath.content ?: return 0).unwrap())
                }
            }

            override fun isOpen() = true
            override fun close() {}
        }
    }

    override suspend fun <R> readAsync(reader: suspend (ReadableByteStream) -> R): R {
        request()
        return reader(
                MemoryViewReadableStream(suspendCoroutineOrReturn { cont ->
                    content?.let { return@suspendCoroutineOrReturn it.unwrap() }
                    queue!!.add {
                        val content = content
                        when (content) {
                            is ResultOk -> cont.resume(content.value)
                            is ResultError -> cont.resumeWithException(
                                    content.value)
                        }
                    }
                    COROUTINE_SUSPENDED
                }))
    }

    private fun request() {
        if (requested) return
        requested = true
        val request = XMLHttpRequest()
        request.addEventListener("error", { event ->
            event as ProgressEvent
            content = ResultError(IOException(request.statusText))
        }, undefined)
        request.addEventListener("abort", { event ->
            event as ProgressEvent
            content = ResultError(IOException(request.statusText))
        }, undefined)
        request.addEventListener("load", { event ->
            event as ProgressEvent
            if (request.status != 200.toShort() || request.statusText != "OK") {
                content = ResultError(IOException(request.statusText))
            }
            val buffer: ArrayBuffer = request.response.asDynamic()
            content = ResultOk(
                    Int8Array(buffer, 0, buffer.byteLength).asArray().viewBE)
            queue?.forEach { it() }
            queue = null
        }, undefined)

        request.open("GET", uri.toString(), true)
        request.responseType = XMLHttpRequestResponseType.ARRAYBUFFER

        request.send(undefined)
    }
}

suspend fun <R> Blob.useUri(block: suspend (Uri) -> R): R {
    val url = URL.createObjectURL(this)
    try {
        return block(Uri(url))
    } finally {
        URL.revokeObjectURL(url)
    }
}

suspend fun <R> ByteViewRO.useUri(block: suspend (Uri) -> R): R =
        File(arrayOf(readAsInt8Array()), "").useUri(block)

suspend fun <R> ReadSource.useUri(block: suspend (Uri) -> R): R =
        toUri().let { uri ->
            if (uri == null) data().useUri(block)
            else block(uri)
        }
