package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.JSONConstructor.newText
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import org.veupathdb.lib.blast.field.OutFile
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.JSONConstructor

@JvmInline
value class OutFile(val value: String) : DefaultingJSONValue {
  override val isDefault: Boolean
    get() = DefaultValue == value

  override fun toJSON(): JsonNode = newText(value)

  companion object {
    const val DefaultValue = "-"
  }
}