package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagFilteringDB
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseFilteringDB(js: ObjectNode): FilteringDB =
  js[FlagFilteringDB]?.let { FilteringDB(it.reqString(FlagFilteringDB)) }
    ?: FilteringDB()


@JvmInline
value class FilteringDB(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagFilteringDB, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagFilteringDB, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagFilteringDB, value)
}