package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.JSONConstructor.newText
import org.veupathdb.lib.blast.util.JSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.JSONConstructor
import com.fasterxml.jackson.annotation.JsonCreator
import java.lang.IllegalArgumentException

enum class TemplateType(val value: String) : JSONValue {
  Coding("coding"), CodingAndOptimal("coding_and_optimal"), Optimal("optimal");

  @JsonValue
  override fun toJSON(): JsonNode = newText(value)

  companion object {
    @JvmStatic
    fun fromString(value: String): TemplateType {
      for (`val` in values()) if (`val`.value == value) return `val`
      throw IllegalArgumentException("Unrecognized template_type value \"$value\".")
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): TemplateType {
      return fromString(js.textValue())
    }
  }
}