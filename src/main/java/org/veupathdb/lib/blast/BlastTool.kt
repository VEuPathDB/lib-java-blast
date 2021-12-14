package org.veupathdb.lib.blast

import org.veupathdb.lib.blast.util.JSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.JSONConstructor
import com.fasterxml.jackson.annotation.JsonCreator
import java.lang.IllegalArgumentException

enum class BlastTool(val value: String) : JSONValue {
  BlastN("blastn"),
  BlastP("blastp"),
  BlastX("blastx"),
  DeltaBlast("deltablast"),
  PSIBlast("psiblast"),
  RPSBlast("rpsblast"),
  RPSTBlastN("rpstblastn"),
  TBlastN("tblastn"),
  TBlastX("tblastx"),
  BlastFormatter("blast_formatter");

  @JsonValue
  override fun toJSON(): JsonNode {
    return JSONConstructor.newText(value)
  }

  companion object {
    @JvmStatic
    @JsonCreator
    fun fromJSON(value: JsonNode): BlastTool {
      require(value.isTextual) { "Cannot convert the value $value to an instance of BlastTool" }
      return fromString(value.textValue())
    }

    @JvmStatic
    fun fromString(value: String): BlastTool {
      for (`val` in values()) if (`val`.value == value) return `val`
      throw IllegalArgumentException("Unrecognized blast tool name \"$value\"")
    }
  }
}