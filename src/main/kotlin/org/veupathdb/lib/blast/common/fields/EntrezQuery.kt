package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagEntrezQuery
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseEntrezQuery(js: ObjectNode) =
  js[FlagEntrezQuery]?.let { EntrezQuery(it.reqString(FlagEntrezQuery)) } ?:
    EntrezQuery()


@JvmInline
value class EntrezQuery(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagEntrezQuery, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagEntrezQuery, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagEntrezQuery, value)
}