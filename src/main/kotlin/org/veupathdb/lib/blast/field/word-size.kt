package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


// TODO: The minimum value for this is app dependent, there should be multiple classes for this.

private const val KeyWordSize = "-word_size"
private const val DefWordSize = 0u


internal fun ParseWordSize(js: ObjectNode) =
  WordSize(js[KeyWordSize]?.longValue()?.toUInt() ?: DefWordSize)


@JvmInline
value class WordSize(val value: UInt = DefWordSize) : BlastField {
  override val isDefault get() = value == DefWordSize

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyWordSize, value.toLong())
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyWordSize).append(' ').append(value.toLong())
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyWordSize)
      cli.add(value.toString())
    }
  }
}