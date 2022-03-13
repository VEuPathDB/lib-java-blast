package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField

private const val KeyTaxIds    = "-taxids"
private const val KeyNegTaxIds = "-negative_taxids"


internal fun ParseTaxIds(js: ObjectNode): TaxIds {
  val arr = js[KeyTaxIds] ?: return TaxIds()
  arr.isArray || return TaxIds()
  arr as ArrayNode

  val tmp = ArrayList<String>(arr.size())

  arr.forEach { tmp.add(it.textValue()) }

  return TaxIds(tmp)
}


@JvmInline
value class TaxIds(val value: List<String> = emptyList()) : BlastField {
  override val isDefault get() = value.isEmpty()

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      with(js.putArray(KeyTaxIds)) { value.forEach { add(it) } }
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault) {
      cli.append(' ').append(KeyTaxIds).append(" '")
      value.join(cli)
      cli.append('\'')
    }
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyTaxIds)

      val sb = StringBuilder(2048)
      value.join(sb)

      cli.add(sb.toString())
    }
  }
}


internal fun ParseNegTaxIds(js: ObjectNode): NegativeTaxIds {
  val arr = js[KeyNegTaxIds] ?: return NegativeTaxIds()
  arr.isArray || return NegativeTaxIds()
  arr as ArrayNode

  val tmp = ArrayList<String>(arr.size())

  arr.forEach { tmp.add(it.textValue()) }

  return NegativeTaxIds(tmp)
}


@JvmInline
value class NegativeTaxIds(val value: List<String> = emptyList()) : BlastField {
  override val isDefault get() = value.isEmpty()

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      with(js.putArray(KeyNegTaxIds)) { value.forEach { add(it) } }
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault) {
      cli.append(' ').append(KeyNegTaxIds).append(" '")
      value.join(cli)
      cli.append('\'')
    }
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyNegTaxIds)

      val sb = StringBuilder(2048)
      value.join(sb)

      cli.add(sb.toString())
    }
  }
}


private fun List<String>.join(sb: StringBuilder) {
  sb.append(this[0])

  for (i in 1 until size) {
    sb.append(',').append(this[i])
  }
}