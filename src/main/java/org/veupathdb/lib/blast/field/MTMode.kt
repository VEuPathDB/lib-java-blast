package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.DefaultingJSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.JSONConstructor
import com.fasterxml.jackson.annotation.JsonCreator
import java.lang.IllegalArgumentException

enum class MTMode : DefaultingJSONValue {
  SplitByDBVolumes, SplitByQueries;

  fun getValue(): Int {
    return ordinal
  }

  override val isDefault
    get() = this == DefaultMTMode

  @JsonValue
  override fun toJSON(): JsonNode {
    return JSONConstructor.newInt(ordinal)
  }

  companion object {
    @JvmStatic
    val DefaultMTMode = SplitByDBVolumes

    @JvmStatic
    fun fromIntValue(value: Int): MTMode {
      for (`val` in values()) if (`val`.getValue() == value) return `val`
      throw IllegalArgumentException(
        "Illegal mt_mode value \"$value\", must be one of 0 or 1"
      )
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): MTMode {
      return fromIntValue(js.intValue())
    }
  }
}