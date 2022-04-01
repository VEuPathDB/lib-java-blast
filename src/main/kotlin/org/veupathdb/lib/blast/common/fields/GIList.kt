package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagGIList
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseGIList(js: ObjectNode) =
  js[FlagGIList]?.let { GIList(it.reqString(FlagGIList)) } ?: GIList()


/**
 * -gilist `<String>`
 *
 * Restrict search of database to list of GIs
 */
@JvmInline
value class GIList(val file: String = "") : BlastField {
  override val isDefault get() = file.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagGIList, file)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagGIList, file)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagGIList, file)
}
