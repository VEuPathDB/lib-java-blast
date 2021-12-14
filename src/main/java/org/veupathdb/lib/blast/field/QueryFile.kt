package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.TextNode
import org.veupathdb.lib.blast.util.DefaultingJSONValue

@JvmInline
value class QueryFile(val value: String) : DefaultingJSONValue {
  companion object {
    const val DefaultValue = "-"
  }

  override val isDefault: Boolean
    get() = value == DefaultValue

  override fun toJSON(): JsonNode = TextNode(value)
}
