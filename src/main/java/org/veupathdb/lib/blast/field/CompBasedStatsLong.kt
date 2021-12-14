package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.TextNode
import org.veupathdb.lib.blast.util.DefaultingJSONValue

enum class CompBasedStatsLong(vararg val keys: Char) : DefaultingJSONValue {
  ScoreAdjustment              ('2', 't', 'T', 'd', 'D'),
  None                         ('0', 'f', 'F'),
  Statistics                   ('1'),
  UnconditionalScoreAdjustment ('3'),
  ;

  override val isDefault: Boolean
    get() = this == Default

  @JsonValue
  override fun toJSON() = TextNode(keys[0].toString())

  companion object {
    @JvmStatic
    val Default = ScoreAdjustment

    @JvmStatic
    fun fromChar(c: Char): CompBasedStatsLong {
      for (value in values())
        for (key in value.keys)
          if (key == c)
            return value

      throw IllegalArgumentException("Invalid comp based stats value $c")
    }

    @JvmStatic
    fun fromString(s: String): CompBasedStatsLong {
      if (s.length != 1)
        throw IllegalArgumentException("Invalid comp based stats value $s")

      return fromChar(s[0])
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): CompBasedStatsLong {
      if (!js.isTextual)
        throw IllegalArgumentException("Invalid comp based stats value $js")

      return fromString(js.textValue())
    }
  }
}