/*
 * Copyright 2017, Gray Watson
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.j256.simplemagik

/**
 * Information associated with some content, returned by the magic matching code in
 * [ContentInfoUtil.findMatch] and other methods.
 *
 * @author graywatson
 */
class ContentInfo {

    /**
     * Returns the internal enumerated type associated with the content or [ContentType.OTHER] if not known.
     */
    val contentType: ContentType?
    /**
     * Returns the short name of the content either from the content-type or extracted from the message. If the
     * content-type is known then this is a specific name string. Otherwise this is usually the first word of the
     * message generated by the magic file.
     */
    val name: String?
    /**
     * Returns the full message as generated by the magic matching code or null if none. This should be similar to the
     * output from the Unix file(1) command.
     */
    val message: String?
    /**
     * Returns the mime-type or null if none.
     */
    val mimeType: String?
    /**
     * Returns an array of associated file-extensions or null if none.
     */
    val fileExtensions: Array<String>?
    /**
     * Whether or not this was a partial match. For some of the types, there is a main matching pattern and then more
     * specific patterns which detect additional features of the type. A partial match means that none of the more
     * specific patterns fully matched the content. It's probably still of the type but just not a variant that the
     * entries from the magic file(s) know about.
     */
    val isPartial: Boolean

    constructor(
        name: String?,
        mimeType: String?,
        message: String,
        partial: Boolean
    ) {
        this.contentType = ContentType.fromMimeType(mimeType)
        if (this.contentType == ContentType.OTHER) {
            this.name = name
            this.fileExtensions = null
        } else {
            this.name = this.contentType.simpleName
            this.fileExtensions = this.contentType.fileExtensions
        }
        this.mimeType = mimeType
        this.message = message
        this.isPartial = partial
    }

    constructor(contentType: ContentType) {
        this.contentType = contentType
        this.name = contentType.simpleName
        this.mimeType = contentType.mimeType
        this.message = null
        this.fileExtensions = contentType.fileExtensions
        this.isPartial = false
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(name)
        if (contentType != null) {
            sb.append(", type ").append(contentType)
        }
        if (mimeType != null) {
            sb.append(", mime '").append(mimeType).append('\'')
        }
        if (message != null) {
            sb.append(", msg '").append(message).append('\'')
        }
        return sb.toString()
    }

    companion object {
        val EMPTY_INFO = ContentInfo(ContentType.EMPTY)
    }
}
