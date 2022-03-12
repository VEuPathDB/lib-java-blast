package org.veupathdb.lib.blast.blastn

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeyWindowMaskerDB = "-window_masker_db"


internal fun ParseWindowMaskerDB(js: ObjectNode) =
  WindowMaskerDB(js[KeyWindowMaskerDB]?.textValue() ?: "")


@JvmInline
value class WindowMaskerDB(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyWindowMaskerDB, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyWindowMaskerDB, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyWindowMaskerDB, value)
}