package org.veupathdb.lib.blast.psiblast.fields

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Key = "-comp_based_stats"

private val Def = CompBasedStatsPSIValue.ConditionalScoreAdjustment


internal fun ParseCompBasedStatsPSI(js: ObjectNode) =
  js[Key]?.let { CompBasedStatsPSI(parseEnum(it)) } ?: CompBasedStatsPSI()


@JvmInline
value class CompBasedStatsPSI(val value: CompBasedStatsPSIValue = Def)
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


private fun parseEnum(j: JsonNode): CompBasedStatsPSIValue {
  if (j.isTextual)
    return when (val v = j.textValue()) {
      "d", "D"      -> CompBasedStatsPSIValue.ConditionalScoreAdjustment
      "0", "f", "F" -> CompBasedStatsPSIValue.None
      "1"           -> CompBasedStatsPSIValue.Statistics
      "2", "t", "T" -> CompBasedStatsPSIValue.ConditionalScoreAdjustment
      "3"           -> CompBasedStatsPSIValue.UnconditionalScoreAdjustment
      else          -> throw IllegalArgumentException("Invalid value \"$v\" for $Key.")
    }

  if (j.isIntegralNumber)
    return when (val v = j.intValue()) {
      0    -> CompBasedStatsPSIValue.None
      1    -> CompBasedStatsPSIValue.Statistics
      2    -> CompBasedStatsPSIValue.ConditionalScoreAdjustment
      3    -> CompBasedStatsPSIValue.UnconditionalScoreAdjustment
      else -> throw IllegalArgumentException("Invalid value \"$v\" for $Key.")
    }

  throw IllegalArgumentException("$Key must be a string or int value.")
}


enum class CompBasedStatsPSIValue {
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