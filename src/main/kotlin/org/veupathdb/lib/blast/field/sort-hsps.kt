package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyHSPSorting = "-shorthsps"


internal fun ParseSortHSPs(js: ObjectNode) =
  SortHSPs(js[KeyHSPSorting]?.intValue()?.let { HSPSorting.values()[it] } ?: HSPSorting.None)


@JvmInline
value class SortHSPs(val value: HSPSorting = HSPSorting.None) : BlastField {
  override val isDefault get() = value == HSPSorting.None

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyHSPSorting, value.value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyHSPSorting).append(' ').append(value.value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyHSPSorting)
      cli.add(value.value.toString())
    }
  }
}


////////////////////////////////////////////////////////////////////////////////


enum class HSPSorting {
  ByHSPExpectValue,
  ByHSPScore,
  ByHSPQueryStart,
  ByHSPPercentIdentity,
  ByHSPSubjectStart,
  None;

  val value =  ordinal
}