package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagQueryCoverageHSPPercent
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqDub


private const val DefaultQueryCovHSPPerc = -1.0


internal fun ParseQueryCoverageHSPPercent(js: ObjectNode) =
  js[FlagQueryCoverageHSPPercent]?.let {
    QueryCoverageHSPPercent(it.reqDub(FlagQueryCoverageHSPPercent))
  } ?: QueryCoverageHSPPercent()


/**
 * -qcov_hsp_perc `<Real, 0..100>`
 *
 * Percent query coverage per hsp
 */
@JvmInline
value class QueryCoverageHSPPercent(val value: Double = DefaultQueryCovHSPPerc)
  : BlastField
{
  override val isDefault get() = value == DefaultQueryCovHSPPerc

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagQueryCoverageHSPPercent, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagQueryCoverageHSPPercent, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagQueryCoverageHSPPercent, value)
}