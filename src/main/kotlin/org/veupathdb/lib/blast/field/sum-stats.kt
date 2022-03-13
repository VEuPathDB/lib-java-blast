package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeySumStats = "-sum_stats"
private const val DefSumStats = false


internal fun ParseSumStats(js: ObjectNode) =
  SumStats(js[KeySumStats]?.booleanValue() ?: DefSumStats)


@JvmInline
value class SumStats(val value: Boolean = DefSumStats) : BlastField {
  override val isDefault get() = value == DefSumStats

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, KeySumStats, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeySumStats, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeySumStats, value)
}