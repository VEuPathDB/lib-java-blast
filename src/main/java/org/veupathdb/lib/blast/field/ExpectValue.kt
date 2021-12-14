package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.TextNode

import kotlin.jvm.JvmInline

import org.veupathdb.lib.blast.util.DefaultingJSONValue

@JvmInline
value class ExpectValue(val value: String) : DefaultingJSONValue
{
  companion object {
    const val DefaultValue = "10"
  }

  override val isDefault
    get() = DefaultValue == value

  @Override
  override fun toJSON(): JsonNode {
    return TextNode(value)
}
}
