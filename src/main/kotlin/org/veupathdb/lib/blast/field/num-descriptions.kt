package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyNumDescriptions     = "-num_descriptions"
private const val DefaultNumDescriptions = 500L


internal fun ParseNumDescriptions(js: ObjectNode) =
  NumDescriptions(js[KeyNumDescriptions]?.longValue() ?: DefaultNumDescriptions)


@JvmInline
value class NumDescriptions(
  val value: Long = DefaultNumDescriptions
) : BlastField {
  override val isDefault get() = value == DefaultNumDescriptions

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyNumDescriptions, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyNumDescriptions).append(' ').append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyNumDescriptions)
      cli.add(value.toString())
    }
  }
}