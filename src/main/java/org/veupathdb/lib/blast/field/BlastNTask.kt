package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import org.veupathdb.lib.blast.util.JSONConstructor

enum class BlastNTask(val value: String): DefaultingJSONValue {

  BlastN("blastn"),
  BlastNShort("blastn-short"),
  DiscontiguousMegablast("dc-megablast"),
  Megablast("megablast"),
  RMBlastN("rmblastn");

  override val isDefault
    get() = this == DefaultTask

  @JsonValue
  override fun toJSON(): JsonNode = JSONConstructor.newText(value)

  companion object {
    @JvmStatic
    val DefaultTask = Megablast

    @JvmStatic
    fun fromString(value: String): BlastNTask {
      for (tmp in values())
        if (tmp.value == value)
          return tmp

      throw IllegalArgumentException("Unrecognized blastn task \"$value\"")
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): BlastNTask {
      return fromString(js.textValue())
    }
  }
}
