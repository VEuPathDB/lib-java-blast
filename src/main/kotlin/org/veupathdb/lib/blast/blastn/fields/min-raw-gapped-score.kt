package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Key = "-min_raw_gapped_score"
private const val Def = Integer.MAX_VALUE


internal fun ParseMinRawGappedScore(js: ObjectNode): MinRawGappedScore {
  val tmp = js[Key] ?: return MinRawGappedScore()

  if (!tmp.isIntegralNumber)
    throw IllegalArgumentException("$Key must be an int value.")

  return MinRawGappedScore(tmp.intValue())
}


@JvmInline
value class MinRawGappedScore(val value: Int = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}