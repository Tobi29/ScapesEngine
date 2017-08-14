// GENERATED FILE, DO NOT EDIT DIRECTLY!!!
// Generation script can be found in `resources/codegen/GenNumberConversions.kts`.
// Run `resources/codegen/codegen.sh` to update sources.

@file:Suppress("NOTHING_TO_INLINE")

package org.tobi29.scapes.engine.utils

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Byte.toByteClamped(): Byte = this

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Byte.toShortClamped(): Short = toShort()

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Byte.toIntClamped(): Int = toInt()

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Byte.toLongClamped(): Long = toLong()

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Byte.toInt128Clamped(): Int128 = toInt128()

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Byte.toUInt128Clamped(): UInt128 = when {
    this <= UInt128.MIN_VALUE.toByte() -> UInt128.MIN_VALUE
    else -> toUInt128()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Short.toByteClamped(): Byte = when {
    this <= Byte.MIN_VALUE.toShort() -> Byte.MIN_VALUE
    this >= Byte.MAX_VALUE.toShort() -> Byte.MAX_VALUE
    else -> toByte()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Short.toShortClamped(): Short = this

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Short.toIntClamped(): Int = toInt()

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Short.toLongClamped(): Long = toLong()

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Short.toInt128Clamped(): Int128 = toInt128()

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Short.toUInt128Clamped(): UInt128 = when {
    this <= UInt128.MIN_VALUE.toShort() -> UInt128.MIN_VALUE
    else -> toUInt128()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int.toByteClamped(): Byte = when {
    this <= Byte.MIN_VALUE.toInt() -> Byte.MIN_VALUE
    this >= Byte.MAX_VALUE.toInt() -> Byte.MAX_VALUE
    else -> toByte()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int.toShortClamped(): Short = when {
    this <= Short.MIN_VALUE.toInt() -> Short.MIN_VALUE
    this >= Short.MAX_VALUE.toInt() -> Short.MAX_VALUE
    else -> toShort()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int.toIntClamped(): Int = this

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int.toLongClamped(): Long = toLong()

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int.toInt128Clamped(): Int128 = toInt128()

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int.toUInt128Clamped(): UInt128 = when {
    this <= UInt128.MIN_VALUE.toInt() -> UInt128.MIN_VALUE
    else -> toUInt128()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Long.toByteClamped(): Byte = when {
    this <= Byte.MIN_VALUE.toLong() -> Byte.MIN_VALUE
    this >= Byte.MAX_VALUE.toLong() -> Byte.MAX_VALUE
    else -> toByte()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Long.toShortClamped(): Short = when {
    this <= Short.MIN_VALUE.toLong() -> Short.MIN_VALUE
    this >= Short.MAX_VALUE.toLong() -> Short.MAX_VALUE
    else -> toShort()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Long.toIntClamped(): Int = when {
    this <= Int.MIN_VALUE.toLong() -> Int.MIN_VALUE
    this >= Int.MAX_VALUE.toLong() -> Int.MAX_VALUE
    else -> toInt()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Long.toLongClamped(): Long = this

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Long.toInt128Clamped(): Int128 = toInt128()

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Long.toUInt128Clamped(): UInt128 = when {
    this <= UInt128.MIN_VALUE.toLong() -> UInt128.MIN_VALUE
    else -> toUInt128()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int128.toByteClamped(): Byte = when {
    this <= Byte.MIN_VALUE.toInt128() -> Byte.MIN_VALUE
    this >= Byte.MAX_VALUE.toInt128() -> Byte.MAX_VALUE
    else -> toByte()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int128.toShortClamped(): Short = when {
    this <= Short.MIN_VALUE.toInt128() -> Short.MIN_VALUE
    this >= Short.MAX_VALUE.toInt128() -> Short.MAX_VALUE
    else -> toShort()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int128.toIntClamped(): Int = when {
    this <= Int.MIN_VALUE.toInt128() -> Int.MIN_VALUE
    this >= Int.MAX_VALUE.toInt128() -> Int.MAX_VALUE
    else -> toInt()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int128.toLongClamped(): Long = when {
    this <= Long.MIN_VALUE.toInt128() -> Long.MIN_VALUE
    this >= Long.MAX_VALUE.toInt128() -> Long.MAX_VALUE
    else -> toLong()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int128.toInt128Clamped(): Int128 = this

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun Int128.toUInt128Clamped(): UInt128 = when {
    this <= UInt128.MIN_VALUE.toInt128() -> UInt128.MIN_VALUE
    else -> toUInt128()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun UInt128.toByteClamped(): Byte = when {
    this >= Byte.MAX_VALUE.toUInt128() -> Byte.MAX_VALUE
    else -> toByte()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun UInt128.toShortClamped(): Short = when {
    this >= Short.MAX_VALUE.toUInt128() -> Short.MAX_VALUE
    else -> toShort()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun UInt128.toIntClamped(): Int = when {
    this >= Int.MAX_VALUE.toUInt128() -> Int.MAX_VALUE
    else -> toInt()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun UInt128.toLongClamped(): Long = when {
    this >= Long.MAX_VALUE.toUInt128() -> Long.MAX_VALUE
    else -> toLong()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun UInt128.toInt128Clamped(): Int128 = when {
    this >= Int128.MAX_VALUE.toUInt128() -> Int128.MAX_VALUE
    else -> toInt128()
}

/**
 * Converts the given number to another type, clamping the value into the
 * maximum range of the destination type instead of overflowing
 * @receiver Number to convert
 * @return Number as new type
 */
inline fun UInt128.toUInt128Clamped(): UInt128 = this