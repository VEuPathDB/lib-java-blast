package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagCullingLimit
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Def = UInt.MAX_VALUE


internal fun ParseCullingLimit(js: ObjectNode): CullingLimit {
  val tmp = js[FlagCullingLimit] ?: return CullingLimit()

  if (!tmp.isIntegralNumber)
    throw IllegalArgumentException("$FlagCullingLimit must be an integral number >= 0")

  val int = tmp.longValue()

  if (int < 0)
    throw IllegalArgumentException("$FlagCullingLimit must be an integral number >= 0")

  return CullingLimit(int.toUInt())
}


@JvmInline
value class CullingLimit(val value: UInt = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagCullingLimit, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagCullingLimit, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagCullingLimit, value)
}