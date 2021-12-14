package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.JSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.JSONConstructor
import com.fasterxml.jackson.annotation.JsonCreator

enum class HSPSorting : JSONValue {
  ByHSPExpectValue, ByHSPScore, ByHSPQueryStart, ByHSPPercentIdentity, ByHSPSubjectStart;

  val value =  ordinal

  @JsonValue
  override fun toJSON(): JsonNode {
    return JSONConstructor.newInt(ordinal)
  }

  companion object {
    @JvmStatic
    fun fromIntValue(value: Int): HSPSorting {
      return values()[value]
    }

    @JsonCreator
    @JvmStatic
    fun fromJSON(js: JsonNode): HSPSorting {
      return fromIntValue(js.intValue())
    }
  }
}