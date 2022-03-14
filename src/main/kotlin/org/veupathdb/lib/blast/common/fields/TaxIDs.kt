package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagTaxIDs
import org.veupathdb.lib.blast.serial.BlastField


internal fun ParseTaxIDs(js: ObjectNode): TaxIDs {
  val arr = js[FlagTaxIDs] ?: return TaxIDs()

  if (!arr.isArray)
    throw IllegalArgumentException("$FlagTaxIDs must be an array of strings.")

  arr as ArrayNode

  val tmp = ArrayList<String>(arr.size())

  arr.forEach {
    if (!it.isTextual)
      throw IllegalArgumentException("$FlagTaxIDs must be an array of strings.")

    tmp.add(it.textValue())
  }

  return TaxIDs(tmp)
}


@JvmInline
value class TaxIDs(val value: List<String> = emptyList()) : BlastField {
  override val isDefault get() = value.isEmpty()

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      with(js.putArray(FlagTaxIDs)) { value.forEach { add(it) } }
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault) {
      cli.append(' ').append(FlagTaxIDs).append(" '")
      value.join(cli)
      cli.append('\'')
    }
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(FlagTaxIDs)

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
