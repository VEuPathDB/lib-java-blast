package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.TextNode
import org.veupathdb.lib.blast.util.DefaultingJSONValue

enum class CompBasedStatsShort(vararg val keys: Char) : DefaultingJSONValue {
  Statistics ('1', 'T', 't', 'D', 'd'),
  None       ('0', 'F', 'f'),
  ;

  override val isDefault
    get() = this == Default

  @JsonValue
  override fun toJSON() = TextNode(this.keys[0].toString())

  companion object {
    @JvmStatic
    val Default = Statistics

    @JvmStatic
    fun fromChar(c: Char): CompBasedStatsShort {
      for (value in values())
        for (key in value.keys)
          if (key == c)
            return value

      throw IllegalArgumentException("Invalid comp based stats value $c")
    }

    @JvmStatic
    fun fromString(s: String): CompBasedStatsShort {
      if (s.length != 1)
        throw IllegalArgumentException("Invalid comp based stats value $s")

      return fromChar(s[0])
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): CompBasedStatsShort {
      if (!js.isTextual)
        throw IllegalArgumentException("Invalid comp based stats value $js")

      return fromString(js.textValue())
    }
  }
}
