package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.JSONConstructor.newInt
import org.veupathdb.lib.blast.util.JSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.annotation.JsonCreator
import java.lang.IllegalArgumentException

enum class TemplateLength(val value: Int) : JSONValue {
  Length16(16), Length18(18), Length21(21);

  @JsonValue
  override fun toJSON(): JsonNode = newInt(value)

  companion object {
    @JvmStatic
    fun fromIntValue(value: Int): TemplateLength {
      for (v in values())
        if (v.value == value)
          return v

      throw IllegalArgumentException(
        "Invalid template_length value \"$value\", must be one of 16, 18, or 21."
      )
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): TemplateLength {
      return fromIntValue(js.intValue())
    }
  }
}