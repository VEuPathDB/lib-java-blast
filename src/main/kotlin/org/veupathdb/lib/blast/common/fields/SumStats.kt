package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagSumStats
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


private const val DefSumStats = false


internal fun ParseSumStats(js: ObjectNode) =
  js[FlagSumStats]?.let { SumStats(it.reqBool(FlagSumStats)) } ?: SumStats()


/**
 * -sum_stats `<Boolean>`
 *
 * Use sum statistics
 */
@JvmInline
value class SumStats(val value: Boolean = DefSumStats) : BlastField {
  override val isDefault get() = value == DefSumStats

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagSumStats, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagSumStats, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagSumStats, value)
}