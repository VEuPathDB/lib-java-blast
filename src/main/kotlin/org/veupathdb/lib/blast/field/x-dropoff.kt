package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyXDropUngap    = "-xdrop_ungap"
private const val KeyXDropGap      = "-xdrop_gap"
private const val KeyXDropGapFinal = "-xdrop_gap_final"


internal fun ParseXDropUngap(js: ObjectNode) =
  ExtensionDropoffUngapped(js[KeyXDropUngap]?.doubleValue() ?: Double.NaN)


@JvmInline
value class ExtensionDropoffUngapped(val value: Double = Double.NaN) : BlastField {
  override val isDefault get() = value.isNaN()

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyXDropUngap, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyXDropUngap).append(' ').append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyXDropUngap)
      cli.add(value.toString())
    }
  }
}


internal fun ParseXDropGap(js: ObjectNode) =
  ExtensionDropoffPrelimGapped(js[KeyXDropGap]?.doubleValue() ?: Double.NaN)


@JvmInline
value class ExtensionDropoffPrelimGapped(val value: Double = Double.NaN) : BlastField {
  override val isDefault get() = value.isNaN()

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyXDropGap, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyXDropGap).append(' ').append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyXDropGap)
      cli.add(value.toString())
    }
  }
}


internal fun ParseXDropGapFinal(js: ObjectNode) =
  ExtensionDropoffFinalGapped(js[KeyXDropGapFinal]?.doubleValue() ?: Double.NaN)


@JvmInline
value class ExtensionDropoffFinalGapped(val value: Double = Double.NaN) : BlastField {
  override val isDefault get() = value.isNaN()

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyXDropGapFinal, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyXDropGapFinal).append(' ').append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyXDropGapFinal)
      cli.add(value.toString())
    }
  }
}
