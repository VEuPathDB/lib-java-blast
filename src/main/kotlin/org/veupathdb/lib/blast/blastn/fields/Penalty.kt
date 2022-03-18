package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagPenalty
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqInt


private const val Def = Int.MIN_VALUE


internal fun ParsePenalty(js: ObjectNode) =
  js[FlagPenalty]?.let { Penalty(it.reqInt(FlagPenalty)) } ?: Penalty()


@JvmInline
value class Penalty(val value: Int = Def) : BlastField {
  init {
    if (value > 0)
      throw IllegalArgumentException("$FlagPenalty must be <= 0")
  }

  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagPenalty, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagPenalty, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagPenalty, value)
}