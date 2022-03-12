package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyLCaseMasking = "-lcase_masking"
private const val DefaultLCaseMasking = false


internal fun ParseLowercaseMasking(js: ObjectNode) =
  LowercaseMasking(js.get(KeyLCaseMasking)?.booleanValue() ?: DefaultLCaseMasking)


@JvmInline
value class LowercaseMasking(
  val value: Boolean = DefaultLCaseMasking
) : BlastField {
  override val isDefault get() = value == DefaultLCaseMasking

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyLCaseMasking, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyLCaseMasking)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyLCaseMasking)
      cli.add(value.toString())
    }
  }
}