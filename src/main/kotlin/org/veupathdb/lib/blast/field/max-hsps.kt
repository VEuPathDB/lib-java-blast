package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField

private const val KeyMaxHSPs = "-max_hsps"
private const val DefaultMaxHSPs = 0u


internal fun ParseMaxHSPs(js: ObjectNode) =
  MaxHSPs(js[KeyMaxHSPs]?.longValue()?.toUInt() ?: DefaultMaxHSPs)


@JvmInline
value class MaxHSPs(val value: UInt = DefaultMaxHSPs) : BlastField {
  override val isDefault get() = value == DefaultMaxHSPs

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyMaxHSPs, value.toLong())
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyMaxHSPs).append(' ').append(value.toLong())
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyMaxHSPs)
      cli.add(value.toString())
    }
  }
}

