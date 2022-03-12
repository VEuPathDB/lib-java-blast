package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeySIL  = "-seqidlist"
private const val KeyNSIL = "-negative_seqidlist"


internal fun ParseSeqIdList(js: ObjectNode) =
  SeqIdList(js[KeySIL]?.textValue() ?: "")


@JvmInline
value class SeqIdList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeySIL, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeySIL).append(" '").append(value).append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeySIL)
      cli.add(value)
    }
  }
}


internal fun ParseNegSeqIdList(js: ObjectNode) =
  NegativeSeqIdList(js[KeyNSIL]?.textValue() ?: "")


@JvmInline
value class NegativeSeqIdList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyNSIL, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ')
        .append(KeyNSIL)
        .append(" '")
        .append(value)
        .append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyNSIL)
      cli.add(value)
    }
  }
}