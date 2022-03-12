package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField

private const val KeyWinSize = "-window_size"


internal fun ParseWindowSize(js: ObjectNode) =
  WindowSize(js[KeyWinSize]?.intValue() ?: -1)


@JvmInline
value class WindowSize(val value: Int = -1) : BlastField {
  override val isDefault get() = value == -1

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyWinSize, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyWinSize).append(' ').append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyWinSize)
      cli.add(value.toString())
    }
  }
}