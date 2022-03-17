package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagTaxIDList
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseTaxIdList(js: ObjectNode) =
  js[FlagTaxIDList]?.let { TaxIdList(it.reqString(FlagTaxIDList)) }
    ?: TaxIdList()


@JvmInline
value class TaxIdList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagTaxIDList, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagTaxIDList, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagTaxIDList, value)
}

