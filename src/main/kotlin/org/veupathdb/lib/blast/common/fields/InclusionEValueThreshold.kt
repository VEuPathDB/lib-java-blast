package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagInclusionEThresh
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqDub


internal fun ParseInclusionEValueThreshold(js: ObjectNode) =
  js[FlagInclusionEThresh]?.let {
    InclusionEValueThreshold(it.reqDub(FlagInclusionEThresh))
  } ?: InclusionEValueThreshold()


/**
 * -inclusion_ethresh `<Real>`
 *
 * E-value inclusion threshold for pairwise alignments
 *
 * Default = `0.002`
 */
@JvmInline
value class InclusionEValueThreshold(val value: Double = 0.002) : BlastField {
  override val isDefault get() = value == 0.002

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagInclusionEThresh, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagInclusionEThresh, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagInclusionEThresh, value)
}