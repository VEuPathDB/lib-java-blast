package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.JSONConstructor.newText
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.annotation.JsonCreator
import java.lang.IllegalArgumentException
import java.util.*

enum class Strand : DefaultingJSONValue {
  Both, Minus, Plus;

  val value: String
    get() = name.lowercase()
  override val isDefault: Boolean
    get() = this == DefaultStrand

  @JsonValue
  override fun toJSON(): JsonNode {
    return newText(value)
  }

  companion object {
    @JvmStatic
    val DefaultStrand = Both

    @JvmStatic
    fun fromString(value: String): Strand {
      Objects.requireNonNull(value)
      return when (value.lowercase()) {
        "both"  -> Both
        "minus" -> Minus
        "plus"  -> Plus
        else    -> throw IllegalArgumentException("Unrecognized strand value \"$value\"")
      }
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): Strand {
      return fromString(js.textValue())
    }
  }
}