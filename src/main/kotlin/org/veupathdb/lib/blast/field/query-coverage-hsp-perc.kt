package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyQueryCovHSPPerc = "-qcov_hsp_perc"
private const val DefaultQueryCovHSPPerc = -1.0


internal fun ParseQueryCoverageHSPPercent(js: ObjectNode) =
  QueryCoverageHSPPercent(js.get(KeyQueryCovHSPPerc)?.doubleValue() ?: DefaultQueryCovHSPPerc)


@JvmInline
value class QueryCoverageHSPPercent(val value: Double = DefaultQueryCovHSPPerc)
  : BlastField
{
  override val isDefault get() = value == DefaultQueryCovHSPPerc

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyQueryCovHSPPerc, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyQueryCovHSPPerc).append(' ').append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    TODO("Not yet implemented")
  }
}