package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyNumAlignments     = "-num_alignments"
private const val DefaultNumAlignments = 250L


internal fun ParseNumAlignments(js: ObjectNode) =
  NumAlignments(js[KeyNumAlignments]?.longValue() ?: DefaultNumAlignments)


@JvmInline
value class NumAlignments(val value: Long = DefaultNumAlignments) : BlastField {
  override val isDefault get() = value == DefaultNumAlignments

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyNumAlignments, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyNumAlignments).append(' ').append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyNumAlignments)
      cli.add(value.toString())
    }
  }
}