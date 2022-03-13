package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Key = "-gapextend"
private const val Def = Integer.MIN_VALUE


internal fun ParseGapExtend(js: ObjectNode): GapExtend {
  val tmp = js[Key] ?: return GapExtend()

  if (!tmp.isIntegralNumber)
    throw IllegalArgumentException("$Key must be an integral number.")

  return GapExtend(tmp.intValue())
}


@JvmInline
value class GapExtend(val value: Int = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}