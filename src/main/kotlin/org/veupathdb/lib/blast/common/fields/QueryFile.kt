package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagQueryFile
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


private const val Def = "-"


internal fun ParseQueryFile(js: ObjectNode) =
  js[FlagQueryFile]?.let { QueryFile(it.reqString(FlagQueryFile)) }
    ?: QueryFile()


/**
 * -query `<File_In>`
 *
 * Input file name
 *
 * Default = `-`
 */
@JvmInline
value class QueryFile(val file: String = Def) : BlastField {
  override val isDefault get() = file == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagQueryFile, file)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagQueryFile, file)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagQueryFile, file)
}