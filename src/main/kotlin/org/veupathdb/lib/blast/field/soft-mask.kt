package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeySoftMask = "-soft_masking"
private const val DefaultSoftMask = true


internal fun ParseSoftMasking(js: ObjectNode) =
  SoftMasking(js.get(KeySoftMask)?.booleanValue() ?: DefaultSoftMask)


@JvmInline
value class SoftMasking(val value: Boolean = DefaultSoftMask) : BlastField {
  override val isDefault get() = value == DefaultSoftMask

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeySoftMask, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ')
        .append(KeySoftMask)
        .append(' ')
        .append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeySoftMask)
      cli.add(value.toString())
    }
  }
}