package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import org.veupathdb.lib.blast.util.JSONConstructor

enum class BlastPTask(val value: String): DefaultingJSONValue
{
  BlastP("blastp"),
  BlastPFast("blastp-fast"),
  BlastPShort("blastp-short");

  override val isDefault get() = this == DefaultTask

  @JsonValue
  override fun toJSON(): JsonNode {
    return JSONConstructor.newText(value)
  }

  companion object {
    @JvmStatic
    val DefaultTask = BlastP

    @JvmStatic
    fun fromString(value: String): BlastPTask {
      for (tmp in values())
        if (tmp.value == value)
          return tmp

      throw IllegalArgumentException()
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): BlastPTask {
      return fromString(js.textValue() ?: throw IllegalArgumentException())
    }
  }
}
