package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import org.veupathdb.lib.blast.util.JSONConstructor

@JvmInline
value class MaxTargetSeqs(val value: Long) : DefaultingJSONValue
{
  companion object {
    const val DefaultValue = 500L
  }

  override val isDefault: Boolean
    get() = value == DefaultValue

  override fun toJSON(): JsonNode = JSONConstructor.newLong(value)
}
