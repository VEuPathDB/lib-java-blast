package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagReward
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqUInt


private const val Def = UInt.MAX_VALUE


internal fun ParseReward(js: ObjectNode) =
  js[FlagReward]?.let { Reward(it.reqUInt(FlagReward)) } ?: Reward()


@JvmInline
value class Reward(val value: UInt = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagReward, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagReward, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagReward, value)
}