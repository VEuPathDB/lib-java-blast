package org.veupathdb.lib.blast.deltablast.fields

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagCompBasedStats
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


internal fun ParseCompBasedStatsDelta(js: ObjectNode) =
  js[FlagCompBasedStats]?.let { CompBasedStatsDelta(parseEnum(it)) }
    ?: CompBasedStatsDelta()


@JvmInline
value class CompBasedStatsDelta(
  val value: CompBasedStatsDeltaValue = CompBasedStatsDeltaValue.CompBasedStats
) : BlastField {
  override val isDefault
    get() = value == CompBasedStatsDeltaValue.CompBasedStats

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagCompBasedStats, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagCompBasedStats, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagCompBasedStats, value.value)
}


@Suppress("NOTHING_TO_INLINE")
private inline fun parseEnum(js: JsonNode): CompBasedStatsDeltaValue {
  if (js.isTextual)
    return when(val v = js.textValue()) {
      "D", "d"      -> CompBasedStatsDeltaValue.CompBasedStats
      "0", "F", "f" -> CompBasedStatsDeltaValue.NoCompBasedStats
      "1", "T", "t" -> CompBasedStatsDeltaValue.CompBasedStats
      else          -> throw IllegalArgumentException("Invalid $FlagCompBasedStats value: $v")
    }

  if (js.isIntegralNumber)
    return when(val v = js.intValue()) {
      0    -> CompBasedStatsDeltaValue.NoCompBasedStats
      1    -> CompBasedStatsDeltaValue.CompBasedStats
      else -> throw IllegalArgumentException("Invalid $FlagCompBasedStats value: $v")
    }

  throw IllegalArgumentException("Invalid $FlagCompBasedStats value: $js")
}


enum class CompBasedStatsDeltaValue {
  NoCompBasedStats,
  CompBasedStats;

  inline val value get() = ordinal
}