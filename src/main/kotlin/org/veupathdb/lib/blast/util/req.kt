@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.blast.util

import com.fasterxml.jackson.databind.JsonNode

internal inline fun JsonNode.reqBool(key: String) =
  if (!isBoolean)
    throw IllegalArgumentException("$key must be a boolean value.")
  else
    booleanValue()

internal inline fun JsonNode.reqDub(key: String) =
  if (!isNumber)
    throw IllegalArgumentException("$key must be a boolean value.")
  else
    doubleValue()

internal inline fun JsonNode.reqDub(k: () -> String) =
  if (!isNumber)
    throw IllegalArgumentException("${k()} must be a boolean value.")
  else
    doubleValue()

internal inline fun JsonNode.reqInt(key: String): Int {
  if (!isIntegralNumber)
    throw IllegalArgumentException("$key must be an int value.")

  return intValue()
}

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

internal inline fun JsonNode.reqUInt(key: String): UInt {
  if (!isIntegralNumber)
    throw IllegalArgumentException("$key must be a uint value.")

  val tmp = longValue()

  if (tmp < 0)
    throw IllegalArgumentException("$key must be a uint value.")

  return tmp.toUInt()
}