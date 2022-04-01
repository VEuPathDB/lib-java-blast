package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagTaxIDList
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseTaxIDList(js: ObjectNode) =
  js[FlagTaxIDList]?.let { TaxIDList(it.reqString(FlagTaxIDList)) }
    ?: TaxIDList()


/**
 * -taxidlist `<String>`
 *
 * Restrict search of database to include only the specified taxonomy IDs
 */
@JvmInline
value class TaxIDList(val file: String = "") : BlastField {
  override val isDefault get() = file.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagTaxIDList, file)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagTaxIDList, file)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagTaxIDList, file)
}

