package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagPseudoCount
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqInt


internal fun ParsePseudoCount(js: ObjectNode) =
  js[FlagPseudoCount]?.let { PseudoCount(it.reqInt(FlagPseudoCount)) }
    ?: PseudoCount()


@JvmInline
value class PseudoCount(val value: Int = 0) : BlastField {
  override val isDefault get() = value == 0

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagPseudoCount, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagPseudoCount, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagPseudoCount, value)
}