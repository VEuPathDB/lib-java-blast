package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val DefaultMaxTargetSeqs = 500L
private const val KeyMaxTargetSeqs = "-max_target_seqs"


internal fun ParseMaxTargetSeqs(js: ObjectNode) =
  MaxTargetSeqs(js[KeyMaxTargetSeqs]?.longValue() ?: DefaultMaxTargetSeqs)


@JvmInline
value class MaxTargetSeqs(val value: Long = DefaultMaxTargetSeqs) : BlastField {
  override val isDefault get() = value == DefaultMaxTargetSeqs

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyMaxTargetSeqs, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyMaxTargetSeqs).append(' ').append(value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyMaxTargetSeqs)
      cli.add(value.toString())
    }
  }
}