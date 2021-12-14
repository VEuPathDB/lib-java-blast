package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import org.veupathdb.lib.blast.util.JSONConstructor

@JvmInline
value class NumAlignments(val value: Long) : DefaultingJSONValue
{
  companion object {
    const val DefaultValue = 250L
  }

  override val isDefault
    get() = value == DefaultValue

  override fun toJSON(): JsonNode = JSONConstructor.newLong(value)
}
