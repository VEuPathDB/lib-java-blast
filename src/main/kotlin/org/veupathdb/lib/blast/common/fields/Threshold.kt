package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqDub


private const val Key = "-threshold"
private const val Def = -1.0


internal fun ParseThreshold(js: ObjectNode): Threshold {
  val dub = js[Key]?.reqDub(Key) ?: return Threshold()

  if (dub < 0)
    throw IllegalArgumentException("$Key must be >= 0")

  return Threshold(dub)
}


@JvmInline
value class Threshold(val value: Double = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}