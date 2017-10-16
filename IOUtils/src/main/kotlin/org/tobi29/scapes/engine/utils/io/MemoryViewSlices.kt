package org.tobi29.scapes.engine.utils.io

import org.tobi29.scapes.engine.utils.*

class MemoryViewByteArraySlice(
        private val view: ByteView
) : ByteArraySlice {
    override val size: Int get() = view.size

    override fun slice(index: Int,
                       length: Int): ByteArraySlice =
            view.slice(scale(index), scale(length)).let {
                if (it === view) this
                else MemoryViewByteArraySlice(
                        it)
            }

    override fun get(index: Int): Byte = view.getByte(index(index))
    override fun set(index: Int,
                     value: Byte) = view.setByte(index(index), value)

    private inline val bits get() = 0
    private inline fun scale(index: Int) = index shr bits
    private inline fun index(index: Int) =
            index(0, size, scale(index), 1 shl bits)
}

class MemoryViewShortArraySlice(
        private val view: ShortView
) : ShortArraySlice {
    override val size: Int get() = view.size

    override fun slice(index: Int,
                       length: Int): ShortArraySlice =
            view.slice(scale(index), scale(length)).let {
                if (it === view) this
                else MemoryViewShortArraySlice(
                        it)
            }

    override fun get(index: Int): Short = view.getShort(index(index))
    override fun set(index: Int,
                     value: Short) = view.setShort(index(index), value)

    private inline val bits get() = 1
    private inline fun scale(index: Int) = index shr bits
    private inline fun index(index: Int) =
            index(0, size, scale(index), 1 shl bits)
}

typealias MemoryViewCharArraySlice = MemoryViewShortArraySlice

class MemoryViewIntArraySlice(
        private val view: IntView
) : IntArraySlice {
    override val size: Int get() = view.size

    override fun slice(index: Int,
                       length: Int): IntArraySlice =
            view.slice(scale(index), scale(length)).let {
                if (it === view) this
                else MemoryViewIntArraySlice(
                        it)
            }

    override fun get(index: Int): Int = view.getInt(index(index))
    override fun set(index: Int,
                     value: Int) = view.setInt(index(index), value)

    private inline val bits get() = 2
    private inline fun scale(index: Int) = index shr bits
    private inline fun index(index: Int) =
            index(0, size, scale(index), 1 shl bits)
}

typealias MemoryViewFloatArraySlice = MemoryViewIntArraySlice

class MemoryViewLongArraySlice(
        private val view: LongView
) : LongArraySlice {
    override val size: Int get() = view.size

    override fun slice(index: Int,
                       length: Int): LongArraySlice =
            view.slice(scale(index), scale(length)).let {
                if (it === view) this
                else MemoryViewLongArraySlice(
                        it)
            }

    override fun get(index: Int): Long = view.getLong(index(index))
    override fun set(index: Int,
                     value: Long) = view.setLong(index(index), value)

    private inline val bits get() = 3
    private inline fun scale(index: Int) = index shr bits
    private inline fun index(index: Int) =
            index(0, size, scale(index), 1 shl bits)
}

typealias MemoryViewDoubleArraySlice = MemoryViewLongArraySlice