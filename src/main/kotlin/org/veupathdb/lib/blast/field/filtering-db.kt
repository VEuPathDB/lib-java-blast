package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeyFilteringDB = "-index_name"


internal fun ParseFilteringDB(js: ObjectNode) =
  FilteringDB(js[KeyFilteringDB]?.textValue() ?: "")


@JvmInline
value class FilteringDB(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyFilteringDB, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyFilteringDB, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyFilteringDB, value)
}