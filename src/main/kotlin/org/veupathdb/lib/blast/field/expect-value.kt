package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyEValue     = "-evalue"
private const val DefaultEValue = "10"


internal fun ParseEValue(j: ObjectNode) =
  ExpectValue(j.get(KeyEValue)?.textValue() ?: DefaultEValue)


@JvmInline
value class ExpectValue(val value: String = DefaultEValue): BlastField {
  override val isDefault get() = value == DefaultEValue

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyEValue, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyEValue).append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyEValue)
      cli.add(value)
    }
  }
}
