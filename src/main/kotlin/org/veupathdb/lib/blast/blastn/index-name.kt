package org.veupathdb.lib.blast.blastn

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeyIndexName = "-index_name"


internal fun ParseIndexName(js: ObjectNode) =
  IndexName(js[KeyIndexName]?.textValue() ?: "")


@JvmInline
value class IndexName(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyIndexName, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyIndexName, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyIndexName, value)
}