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


@JvmInline
value class QueryFile(val value: String = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagQueryFile, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagQueryFile, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagQueryFile, value)
}