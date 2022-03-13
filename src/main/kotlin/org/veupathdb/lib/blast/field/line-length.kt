package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyLineLength     = "-line_length"
private const val DefaultLineLength = 60


internal fun ParseLineLength(js: ObjectNode) =
  LineLength(js[KeyLineLength]?.intValue() ?: DefaultLineLength)


@JvmInline
value class LineLength(val value: Int = DefaultLineLength) : BlastField {
  override val isDefault get() = value == DefaultLineLength

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyLineLength, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyLineLength).append(' ').append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyLineLength)
      cli.add(value.toString())
    }
  }
}