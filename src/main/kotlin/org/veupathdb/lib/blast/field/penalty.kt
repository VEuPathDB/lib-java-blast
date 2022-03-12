package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeyPenalty = "-penalty"
private const val DefPenalty = 1


internal fun ParsePenalty(js: ObjectNode) =
  Penalty(js[KeyPenalty]?.intValue() ?: DefPenalty)


@JvmInline
value class Penalty(val value: Int = DefPenalty) : BlastField {
  override val isDefault get() = value > 0

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyPenalty, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyPenalty, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyPenalty, value)
}