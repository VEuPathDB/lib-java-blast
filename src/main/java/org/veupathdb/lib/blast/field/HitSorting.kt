package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.JSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.JSONConstructor
import com.fasterxml.jackson.annotation.JsonCreator

enum class HitSorting : JSONValue {
  ByExpectValue, ByBitScore, ByTotalScore, ByPercentIdentity, ByQueryCoverage;

  val value = ordinal

  @JsonValue
  override fun toJSON(): JsonNode {
    return JSONConstructor.newInt(ordinal)
  }

  companion object {
    @JvmStatic
    fun fromIntValue(value: Int): HitSorting {
      return values()[value]
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): HitSorting {
      return fromIntValue(js.intValue())
    }
  }
}