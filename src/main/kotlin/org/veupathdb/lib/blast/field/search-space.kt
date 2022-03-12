package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeySearchSpace           = "-searchsp"
private const val DefaultSearchSpace: Byte = -1


internal fun ParseSearchSpace(js: ObjectNode) =
  SearchSpace(js[KeySearchSpace]?.shortValue()?.toByte() ?: DefaultSearchSpace)


@JvmInline
value class SearchSpace(val value: Byte = DefaultSearchSpace) : BlastField {
  override val isDefault get() = value == DefaultSearchSpace

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeySearchSpace, value.toShort())
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeySearchSpace).append(' ').append(value.toInt())
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeySearchSpace)
      cli.add(value.toString())
    }
  }
}