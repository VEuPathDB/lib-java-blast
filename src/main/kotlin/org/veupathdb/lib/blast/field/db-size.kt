package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyDBSize = "-dbsize"
private const val DefaultDBSize: Byte = 0


internal fun ParseDBSize(js: ObjectNode) =
  DBSize(js[KeyDBSize]?.shortValue()?.toByte() ?: DefaultDBSize)


@JvmInline
value class DBSize(val value: Byte = DefaultDBSize) : BlastField {
  override val isDefault get() = value == DefaultDBSize

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyDBSize, value.toShort())
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyDBSize).append(' ').append(value.toInt())
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyDBSize)
      cli.add(value.toString())
    }
  }
}