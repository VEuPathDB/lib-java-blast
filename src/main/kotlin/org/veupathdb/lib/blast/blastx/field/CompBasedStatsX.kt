package org.veupathdb.lib.blast.blastx.field

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Key = "-comp_based_stats"

private val Def = CompBasedStatsXValue.ConditionalScoreAdjustment


internal fun ParseCompBasedStatsX(js: ObjectNode) =
  js[Key]?.let { CompBasedStatsX(parseEnum(it)) } ?: CompBasedStatsX()


@JvmInline
value class CompBasedStatsX(val value: CompBasedStatsXValue = Def)
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


private fun parseEnum(j: JsonNode): CompBasedStatsXValue {
  if (j.isTextual)
    return when (val v = j.textValue()) {
      "d", "D" -> CompBasedStatsXValue.ConditionalScoreAdjustment
      "f", "F" -> CompBasedStatsXValue.None
      "t", "T" -> CompBasedStatsXValue.ConditionalScoreAdjustment
      else     -> throw IllegalArgumentException("Invalid value \"$v\" for $Key.")
    }

  if (j.isIntegralNumber)
    return when (val v = j.intValue()) {
      0    -> CompBasedStatsXValue.None
      1    -> CompBasedStatsXValue.Statistics
      2    -> CompBasedStatsXValue.ConditionalScoreAdjustment
      3    -> CompBasedStatsXValue.UnconditionalScoreAdjustment
      else -> throw IllegalArgumentException("Invalid value \"$v\" for $Key.")
    }

  throw IllegalArgumentException("$Key must be a string or int value.")
}


enum class CompBasedStatsXValue {
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