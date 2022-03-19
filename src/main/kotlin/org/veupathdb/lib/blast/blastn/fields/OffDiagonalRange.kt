package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagOffDiagonalRange
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqUInt


private const val Def = 0u


internal fun ParseOffDiagonalRange(js: ObjectNode) =
  js[FlagOffDiagonalRange]?.let {
    OffDiagonalRange(it.reqUInt(FlagOffDiagonalRange))
  } ?: OffDiagonalRange()


@JvmInline
value class OffDiagonalRange(val value: UInt = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagOffDiagonalRange, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagOffDiagonalRange, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagOffDiagonalRange, value)
}