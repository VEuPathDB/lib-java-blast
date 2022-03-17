package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNegativeTaxIDList
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseNegTaxIdList(js: ObjectNode) =
  js[FlagNegativeTaxIDList]?.let {
    NegativeTaxIdList(it.reqString(FlagNegativeTaxIDList))
  } ?: NegativeTaxIdList()


@JvmInline
value class NegativeTaxIdList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagNegativeTaxIDList, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagNegativeTaxIDList, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagNegativeTaxIDList, value)
}
