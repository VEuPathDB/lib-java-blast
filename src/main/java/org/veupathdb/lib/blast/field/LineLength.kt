package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.JsonNode
import kotlin.jvm.JvmInline
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import org.veupathdb.lib.blast.util.JSONConstructor

@JvmInline
value class LineLength(val value: Int) : DefaultingJSONValue
{
  companion object {
    const val DefaultValue = 60
  }

  override val isDefault: Boolean
    get() = value == DefaultValue

  override fun toJSON(): JsonNode = JSONConstructor.newInt(value)
}
