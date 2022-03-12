package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyHitSorting = "-sorthits"


internal fun ParseSortHits(js: ObjectNode) =
  SortHits(js[KeyHitSorting]?.intValue()?.let { HitSorting.values()[it] } ?: HitSorting.None)


@JvmInline
value class SortHits(val value: HitSorting = HitSorting.None) : BlastField {
  override val isDefault get() = value == HitSorting.None

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyHitSorting, value.value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyHitSorting).append(' ').append(value.value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyHitSorting)
      cli.add(value.value.toString())
    }
  }
}


////////////////////////////////////////////////////////////////////////////////


enum class HitSorting {
  ByExpectValue,
  ByBitScore,
  ByTotalScore,
  ByPercentIdentity,
  ByQueryCoverage,
  None;

  val value = ordinal
}