@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.blast.util

import com.fasterxml.jackson.databind.JsonNode

/**
 * Ensures that the input [JsonNode] is wrapping a boolean value then returns
 * that value.
 *
 * @param key Key used when generating an error message.
 *
 * @receiver JsonNode to test.
 *
 * @return The value wrapped by the receiver node.
 */
internal inline fun JsonNode.reqBool(key: String) =
  if (!isBoolean)
    throw IllegalArgumentException("$key must be a boolean value.")
  else
    booleanValue()


/**
 * Ensures that the input [JsonNode] is wrapping a byte value then returns
 * that value.
 *
 * @param key Key used when generating an error message.
 *
 * @receiver JsonNode to test.
 *
 * @return The value wrapped by the receiver node.
 */
internal inline fun JsonNode.reqByte(key: String): Byte {
  if (!isIntegralNumber)
    throw IllegalArgumentException("$key must be a byte value.")

  val tmp = shortValue()

  if (tmp > Byte.MAX_VALUE || tmp < Byte.MIN_VALUE)
    throw IllegalArgumentException("$key must be a byte value.")

  return tmp.toByte()
}


/**
 * Ensures that the input [JsonNode] is wrapping a double value then returns
 * that value.
 *
 * @param key Key used when generating an error message.
 *
 * @receiver JsonNode to test.
 *
 * @return The value wrapped by the receiver node.
 */
internal inline fun JsonNode.reqDub(key: String) =
  if (!isNumber)
    throw IllegalArgumentException("$key must be a boolean value.")
  else
    doubleValue()


/**
 * Ensures that the input [JsonNode] is wrapping a double value then returns
 * that value.
 *
 * @param k Key provider used to get a key value to generate an error message.
 *
 * @receiver JsonNode to test.
 *
 * @return The value wrapped by the receiver node.
 */
internal inline fun JsonNode.reqDub(k: () -> String) =
  if (!isNumber)
    throw IllegalArgumentException("${k()} must be a boolean value.")
  else
    doubleValue()


/**
 * Ensures that the input [JsonNode] is wrapping an int value then returns
 * that value.
 *
 * @param key Key used when generating an error message.
 *
 * @receiver JsonNode to test.
 *
 * @return The value wrapped by the receiver node.
 */
internal inline fun JsonNode.reqInt(key: String): Int {
  if (!isIntegralNumber)
    throw IllegalArgumentException("$key must be an int value.")

  return intValue()
}

/**
 * Ensures that the input [JsonNode] is wrapping an int value then returns
 * that value.
 *
 * @param k Key provider used to get a key value to generate an error message.
 *
 * @receiver JsonNode to test.
 *
 * @return The value wrapped by the receiver node.
 */
internal inline fun JsonNode.reqInt(k: () -> String): Int {
  if (!isIntegralNumber)
    throw IllegalArgumentException("${k()} must be an int value.")

  return intValue()
}

internal inline fun JsonNode.reqString(key: String): String {
  if (!isTextual)
    throw IllegalArgumentException("$key must be a string value.")

  return textValue()
}

internal inline fun JsonNode.reqUByte(key: String): UByte {
  if (!isIntegralNumber)
    throw IllegalArgumentException("$key must be a uint value.")

  val tmp = longValue()

  if (tmp < 0 || tmp > 255)
    throw IllegalArgumentException("$key must be a uint value.")

  return tmp.toUByte()
}

internal inline fun JsonNode.reqUInt(key: String): UInt {
  if (!isIntegralNumber)
    throw IllegalArgumentException("$key must be a uint value.")

  val tmp = longValue()

  if (tmp < 0 || tmp > 42_949_672_95L)
    throw IllegalArgumentException("$key must be a uint value.")

  return tmp.toUInt()
}