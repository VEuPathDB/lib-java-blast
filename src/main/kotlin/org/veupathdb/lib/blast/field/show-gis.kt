package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val DefaultShowGIs = false
private const val KeyShowGIs     = "-show_gis"


internal fun ParseShowGIs(js: ObjectNode) =
  ShowGIs(js[KeyShowGIs]?.booleanValue() ?: DefaultShowGIs)


@JvmInline
value class ShowGIs(val value: Boolean = DefaultShowGIs) : BlastField {
  override val isDefault get() = value == DefaultShowGIs

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyShowGIs, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyShowGIs)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault)
      cli.add(KeyShowGIs)
  }
}