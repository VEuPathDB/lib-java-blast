package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.JSONConstructor.newText
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.annotation.JsonCreator

enum class TBlastNTask(val value: String) : DefaultingJSONValue {
  TBlastN("tblastn"), TBlastNFast("tblastn-fast");

  override val isDefault: Boolean
    get() = this == DefaultTask

  @JsonValue
  override fun toJSON(): JsonNode {
    return newText(value)
  }

  companion object {
    @JvmStatic
    val DefaultTask = TBlastN

    @JvmStatic
    fun fromString(value: String): TBlastNTask {
      for (tmp in values())
        if (tmp.value == value)
          return tmp

      throw IllegalArgumentException("Unrecognized task value \"$value\".")
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): TBlastNTask {
      return fromString(js.textValue())
    }
  }
}