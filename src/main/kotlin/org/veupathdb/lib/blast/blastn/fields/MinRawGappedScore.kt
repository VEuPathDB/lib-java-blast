package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagMinRawGappedScore
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqInt


private const val Def = Integer.MAX_VALUE


internal fun ParseMinRawGappedScore(js: ObjectNode) =
  js[FlagMinRawGappedScore]?.let {
    MinRawGappedScore(it.reqInt(FlagMinRawGappedScore))
  } ?: MinRawGappedScore()


/**
 * -min_raw_gapped_score `<Integer>`
 *
 * Minimum raw gapped score to keep an alignment in the preliminary gapped and
 * traceback stages
 */
@JvmInline
value class MinRawGappedScore(val value: Int = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagMinRawGappedScore, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagMinRawGappedScore, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagMinRawGappedScore, value)
}