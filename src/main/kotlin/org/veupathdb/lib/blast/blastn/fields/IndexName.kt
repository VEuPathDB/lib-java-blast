package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


private const val Key = "-index_name"

internal fun ParseIndexName(js: ObjectNode) =
  js[Key]?.let { IndexName(it.reqString(Key)) } ?: IndexName()


@JvmInline
value class IndexName(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}