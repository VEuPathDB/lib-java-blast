package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.consts.Key
import org.veupathdb.lib.blast.field.FormatField.StandardFields
import org.veupathdb.lib.blast.field.FormatType.Companion.fromIntValue
import org.veupathdb.lib.blast.field.FormatType.Pairwise
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import org.veupathdb.lib.blast.util.JSONConstructor.newArray
import org.veupathdb.lib.blast.util.JSONConstructor.newObject
import org.veupathdb.lib.blast.util.JSONConstructor.newText

data class OutFormat(
  var type: FormatType? = null,
  var delimiter: String? = null,
  var fields: MutableList<FormatField?> = ArrayList(),
) : DefaultingJSONValue {

  override val isDefault: Boolean
    get() = (type == null || type === DefaultFormatType) &&
      (delimiter == null || delimiter!!.isBlank()) &&
      (fields.isEmpty() || fields.size == 1 && fields[0] === StandardFields)

  override fun toString(): String {
    val out = StringBuilder()

    if (type != null)
      out.append(type!!.value)

    if (delimiter != null && delimiter!!.isNotEmpty())
      out.append(" delim=").append(delimiter)

    for (field in fields)
      out.append(" ").append(field!!.value)

    return out.toString()
  }

  @JsonValue
  override fun toJSON(): JsonNode {
    val out = newObject()

    if (type != null)
      out.set<JsonNode>(Key.Type, type!!.toJSON())

    if (delimiter != null && delimiter!!.isNotBlank())
      out.set<JsonNode>(Key.Delimiter, newText(delimiter!!))

    if (fields.isNotEmpty() && (fields.size > 1 || fields[0] !== StandardFields))
      out.set<JsonNode>(Key.Fields, newArray(fields))

    return out
  }

  companion object {
    @JvmStatic
    val DefaultFormatType = Pairwise

    @JvmStatic
    fun fromString(value: String): OutFormat {

      if (value.isBlank())
        return OutFormat().apply { type = Pairwise }

      val split = value.split(" +").toTypedArray()
      val out = OutFormat()

      out.type = fromIntValue(split[0].toInt())

      if (split.size > 1) {
        var start = 1

        if (split[1].startsWith("delim=")) {
          out.delimiter = split[1].substring(6)
          start = 2
        }

        while (start < split.size) {
          out.fields.add(FormatField.fromString(split[start]))
          start++
        }
      }
      return out
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): OutFormat {
      val out = OutFormat()

      if (js.has(Key.Type))
        out.type = fromIntValue(js[Key.Type].intValue())

      if (js.has(Key.Delimiter))
        out.delimiter = js[Key.Delimiter].textValue()

      if (js.has(Key.Fields))
        js[Key.Fields].forEach { out.fields.add(FormatField.fromString(it.textValue())) }

      return out
    }
  }
}