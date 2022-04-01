package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNegativeTaxIDs
import org.veupathdb.lib.blast.common.FlagTaxIDs
import org.veupathdb.lib.blast.serial.BlastField


internal fun ParseNegTaxIDs(js: ObjectNode): NegativeTaxIDs {
  val arr = js[FlagNegativeTaxIDs] ?: return NegativeTaxIDs()

  if (!arr.isArray)
    throw IllegalArgumentException("$FlagTaxIDs must be an array of strings.")

  arr as ArrayNode

  val tmp = ArrayList<String>(arr.size())

  arr.forEach {
    if (!it.isTextual)
      throw IllegalArgumentException("$FlagTaxIDs must be an array of strings.")

    tmp.add(it.textValue())
  }

  return NegativeTaxIDs(tmp)
}


/**
 * -negative_taxids `<String>`
 *
 * Restrict search of database to everything except the specified taxonomy IDs
 * (multiple IDs delimited by ',')
 */
@JvmInline
value class NegativeTaxIDs(val value: List<String> = emptyList()) : BlastField {
  override val isDefault get() = value.isEmpty()

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      with(js.putArray(FlagNegativeTaxIDs)) { value.forEach { add(it) } }
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault) {
      cli.append(' ').append(FlagNegativeTaxIDs).append(" '")
      value.join(cli)
      cli.append('\'')
    }
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(FlagNegativeTaxIDs)

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
