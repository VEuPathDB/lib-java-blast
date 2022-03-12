package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyTIL  = "-seqidlist"
private const val KeyNTIL = "-negative_seqidlist"


internal fun ParseTaxIdList(js: ObjectNode) =
  TaxIdList(js[KeyTIL]?.textValue() ?: "")


@JvmInline
value class TaxIdList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyTIL, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyTIL).append(" '").append(value).append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyTIL)
      cli.add(value)
    }
  }
}


internal fun ParseNegTaxIdList(js: ObjectNode) =
  NegativeTaxIdList(js[KeyNTIL]?.textValue() ?: "")


@JvmInline
value class NegativeTaxIdList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyNTIL, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ')
        .append(KeyNTIL)
        .append(" '")
        .append(value)
        .append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyNTIL)
      cli.add(value)
    }
  }
}