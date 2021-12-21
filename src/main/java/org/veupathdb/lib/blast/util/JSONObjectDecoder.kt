package org.veupathdb.lib.blast.util

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.node.ObjectNode

@JsonDeserialize(using = JSONObjectDecoderDeserializer::class)
class JSONObjectDecoder(val js: ObjectNode) {

  fun decodeString(key: String, fn: (String) -> Unit) {
    val value = js.get(key)
    if (value != null)
      fn(value.textValue())
  }

  fun decodeLong(key: String, fn: (Long) -> Unit) {
    val value = js.get(key)
    if (value != null)
      fn(value.longValue())
  }

  fun decodeDouble(key: String, fn: (Double) -> Unit) {
    val value = js.get(key)
    if (value != null)
      fn(value.doubleValue())
  }

  fun decodeBool(key: String, fn: (Boolean) -> Unit) {
    val value = js.get(key)
    if (value != null)
      fn(value.booleanValue())
  }

  fun decodeInt(key: String, fn: (Int) -> Unit) {
    val value = js.get(key)
    if (value != null)
      fn(value.intValue())
  }

  fun decodeByte(key: String, fn: (Byte) -> Unit) {
    val value = js.get(key)
    if (value != null) {
      fn(value.intValue().toByte())
    }
  }

  fun decodeShort(key: String, fn: (Short) -> Unit) {
    val value = js.get(key)
    if (value != null)
      fn(value.shortValue())
  }

  inline fun decodeStringList(key: String, fn: (List<String>) -> Unit) {
    val value = js.get(key)

    if (value == null || value.isEmpty)
      return

    val tmp = ArrayList<String>(value.size())

    value.forEach { v -> tmp.add(v.textValue()) }

    fn(tmp)
  }

  inline fun decodeJSON(key: String, fn: (JsonNode) -> Unit) {
    val value = js.get(key)
    if (value != null)
      fn(value)
  }

  override fun toString() = js.toString()
}
