package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagWindowSize
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqInt


internal fun ParseWindowSize(js: ObjectNode) =
  js[FlagWindowSize]?.let { WindowSize(it.reqInt(FlagWindowSize)) }
    ?: WindowSize()


@JvmInline
value class WindowSize(val value: Int = -1) : BlastField {
  override val isDefault get() = value == -1

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagWindowSize, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagWindowSize, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagWindowSize, value)
}