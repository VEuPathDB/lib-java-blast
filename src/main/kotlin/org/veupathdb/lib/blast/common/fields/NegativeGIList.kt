package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNegativeGIList
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseNegGIList(js: ObjectNode) =
  js[FlagNegativeGIList]?.let {
    NegativeGIList(it.reqString(FlagNegativeGIList))
  } ?: NegativeGIList()


/**
 * -negative_gilist `<String>`
 *
 * Restrict search of database to everything except the specified GIs
 */
@JvmInline
value class NegativeGIList(val file: String = "") : BlastField {
  override val isDefault get() = file.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagNegativeGIList, file)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagNegativeGIList, file)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagNegativeGIList, file)
}
