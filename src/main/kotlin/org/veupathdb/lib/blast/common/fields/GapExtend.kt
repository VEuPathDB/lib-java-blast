package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagGapExtend
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Def = Integer.MIN_VALUE


internal fun ParseGapExtend(js: ObjectNode): GapExtend {
  val tmp = js[FlagGapExtend] ?: return GapExtend()

  if (!tmp.isIntegralNumber)
    throw IllegalArgumentException("$FlagGapExtend must be an integral number.")

  return GapExtend(tmp.intValue())
}


/**
 * -gapextend `<Integer>`
 *
 * Cost to extend a gap
 */
@JvmInline
value class GapExtend(val value: Int = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagGapExtend, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagGapExtend, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagGapExtend, value)
}