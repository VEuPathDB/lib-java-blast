package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagIndexName
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseIndexName(js: ObjectNode) =
  js[FlagIndexName]?.let { IndexName(it.reqString(FlagIndexName)) }
    ?: IndexName()


@JvmInline
value class IndexName(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagIndexName, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagIndexName, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagIndexName, value)
}