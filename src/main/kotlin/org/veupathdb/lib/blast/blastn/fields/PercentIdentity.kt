package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagPercentIdentity
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqDub


private const val Def = -1.0


internal fun ParsePercentIdentity(js: ObjectNode) =
  js[FlagPercentIdentity]?.let {
    PercentIdentity(it.reqDub(FlagPercentIdentity))
  } ?: PercentIdentity()


@JvmInline
value class PercentIdentity(val value: Double = Def)
  : BlastField
{
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagPercentIdentity, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagPercentIdentity, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagPercentIdentity, value)
}