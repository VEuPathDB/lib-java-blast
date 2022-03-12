package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeyReward = "-penalty"
private const val DefReward = UInt.MAX_VALUE


internal fun ParseReward(js: ObjectNode) =
  Reward(js[KeyReward]?.longValue()?.toUInt() ?: DefReward)


@JvmInline
value class Reward(val value: UInt = DefReward) : BlastField {
  override val isDefault get() = value == DefReward

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyReward, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyReward, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyReward, value)
}