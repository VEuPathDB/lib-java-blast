package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqInt


private const val Key = "-penalty"
private const val Def = 1


internal fun ParsePenalty(js: ObjectNode) =
  js[Key]?.let { Penalty(it.reqInt(Key)) } ?: Penalty()


@JvmInline
value class Penalty(val value: Int = Def) : BlastField {
  override val isDefault get() = value > 0

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}