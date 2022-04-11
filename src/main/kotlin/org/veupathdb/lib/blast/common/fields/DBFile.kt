package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagDBFile
import org.veupathdb.lib.blast.common.FlagDust
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.optString
import org.veupathdb.lib.blast.util.put


internal fun ParseDBFile(js: ObjectNode) =
  js.optString(FlagDBFile) { DBFile(it) } ?: DBFile()


/**
 * -db `<String>`
 *
 * BLAST database name
 */
@JvmInline
value class DBFile(val file: String = "") : BlastField {
  override val isDefault get() = file.isBlank()

  override val name: String
    get() = FlagDBFile

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagDBFile, file)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagDBFile, file)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagDBFile, file)
}