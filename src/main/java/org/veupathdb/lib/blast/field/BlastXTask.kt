package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.DefaultingJSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.JSONConstructor
import com.fasterxml.jackson.annotation.JsonCreator
import java.lang.IllegalArgumentException

enum class BlastXTask(val value: String) : DefaultingJSONValue {
  BlastX("blastx"), BlastXFast("blastx-fast");

  override val isDefault: Boolean
    get() = this == DefaultTask

  @JsonValue
  override fun toJSON(): JsonNode {
    return JSONConstructor.newText(value)
  }

  companion object {
    @JvmStatic
    val DefaultTask = BlastX

    @JvmStatic
    fun fromString(value: String): BlastXTask {
      for (`val` in values()) if (`val`.value == value) return `val`
      throw IllegalArgumentException("Unrecognized blastx task value \"$value\"")
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): BlastXTask {
      return fromString(js.textValue())
    }
  }
}