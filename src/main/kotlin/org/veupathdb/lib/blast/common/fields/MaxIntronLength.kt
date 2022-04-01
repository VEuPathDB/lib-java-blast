package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagMaxIntronLength
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqUInt


private const val Def = 0u


internal fun ParseMaxIntronLength(js: ObjectNode) =
  js[FlagMaxIntronLength]?.let { MaxIntronLength(it.reqUInt(FlagMaxIntronLength)) } ?: MaxIntronLength()


/**
 * -max_intron_length `<Integer, >=0>`
 *
 * Length of the largest intron allowed in a translated nucleotide sequence
 * when linking multiple distinct alignments
 *
 * Default = `0`
 */
@JvmInline
value class MaxIntronLength(val value: UInt = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagMaxIntronLength, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagMaxIntronLength, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagMaxIntronLength, value)
}