package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Key = "-off_diagonal_range"
private const val Def = 0u


internal fun ParseOffDiagonalRange(js: ObjectNode): OffDiagonalRange {
  val tmp = js[Key] ?: return OffDiagonalRange()

  if (!tmp.isIntegralNumber)
    throw IllegalArgumentException("$Key must be an int value >= 0")

  val int = tmp.longValue()

  if (int < 0)
    throw IllegalArgumentException("$Key must be an int value >= 0")

  return OffDiagonalRange(int.toUInt())
}


@JvmInline
value class OffDiagonalRange(val value: UInt = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}