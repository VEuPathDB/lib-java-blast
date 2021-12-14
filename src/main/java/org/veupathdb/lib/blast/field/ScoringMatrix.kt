package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.JSONConstructor.newText
import org.veupathdb.lib.blast.util.JSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.annotation.JsonCreator
import java.lang.IllegalArgumentException
import java.util.*

enum class ScoringMatrix : JSONValue {
  Blosum45, Blosum50, Blosum62, Blosum80, Blosum90, Pam30, Pam70, Pam250, Identity;

  val value: String
    get() = name.uppercase()

  @JsonValue
  override fun toJSON(): JsonNode = newText(value)

  companion object {
    @JvmStatic
    fun fromString(value: String): ScoringMatrix {
      Objects.requireNonNull(value)
      return when (value.lowercase()) {
        "blosum45" -> Blosum45
        "blosum50" -> Blosum50
        "blosum62" -> Blosum62
        "blosum80" -> Blosum80
        "blosum90" -> Blosum90
        "pam30"    -> Pam30
        "pam70"    -> Pam70
        "pam250"   -> Pam250
        "identity" -> Identity
        else       -> throw IllegalArgumentException(
          "Unrecognized scoring matrix value \"$value\""
        )
      }
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): ScoringMatrix {
      return fromString(js.textValue())
    }
  }
}