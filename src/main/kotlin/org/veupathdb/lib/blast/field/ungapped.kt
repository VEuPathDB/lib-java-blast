package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val DefaultUngappedAlignmentsOnly = false
private const val KeyUngappedAlignmentsOnly     = "-ungapped"


internal fun ParseUngappedAlignmentsOnly(js: ObjectNode) =
  UngappedAlignmentsOnly(js[KeyUngappedAlignmentsOnly]?.booleanValue()
    ?: DefaultUngappedAlignmentsOnly)


@JvmInline
value class UngappedAlignmentsOnly(
  val value: Boolean = DefaultUngappedAlignmentsOnly
) : BlastField {
  override val isDefault get() = value == DefaultUngappedAlignmentsOnly

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyUngappedAlignmentsOnly, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyUngappedAlignmentsOnly)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault)
      cli.add(KeyUngappedAlignmentsOnly)
  }
}