package org.veupathdb.lib.blast.blastp.field

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Key = "-comp_based_stats"

private val Def = CompBasedStatsPValue.ConditionalScoreAdjustment


internal fun ParseCompBasedStatsP(js: ObjectNode) =
  js[Key]?.let { CompBasedStatsP(parseEnum(it)) } ?: CompBasedStatsP()


@JvmInline
value class CompBasedStatsP(val value: CompBasedStatsPValue = Def)
  : BlastField
{
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value.value)
}


private fun parseEnum(j: JsonNode): CompBasedStatsPValue {
  if (j.isTextual)
    return when (val v = j.textValue()) {
      "d", "D"      -> CompBasedStatsPValue.ConditionalScoreAdjustment
      "0", "f", "F" -> CompBasedStatsPValue.None
      "1"           -> CompBasedStatsPValue.Statistics
      "2", "t", "T" -> CompBasedStatsPValue.ConditionalScoreAdjustment
      "3"           -> CompBasedStatsPValue.UnconditionalScoreAdjustment
      else          -> throw IllegalArgumentException("Invalid value \"$v\" for $Key.")
    }

  if (j.isIntegralNumber)
    return when (val v = j.intValue()) {
      0    -> CompBasedStatsPValue.None
      1    -> CompBasedStatsPValue.Statistics
      2    -> CompBasedStatsPValue.ConditionalScoreAdjustment
      3    -> CompBasedStatsPValue.UnconditionalScoreAdjustment
      else -> throw IllegalArgumentException("Invalid value \"$v\" for $Key.")
    }

  throw IllegalArgumentException("$Key must be a string or int value.")
}


enum class CompBasedStatsPValue {
  None,
  Statistics,
  ConditionalScoreAdjustment,
  UnconditionalScoreAdjustment;

  val value
    get() = when (this) {
      None                         -> 0
      Statistics                   -> 1
      ConditionalScoreAdjustment   -> 2
      UnconditionalScoreAdjustment -> 3
    }
}