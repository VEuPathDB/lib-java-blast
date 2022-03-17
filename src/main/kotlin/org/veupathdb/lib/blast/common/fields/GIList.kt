package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagGIList
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseGIList(js: ObjectNode) =
  js[FlagGIList]?.let { GIList(it.reqString(FlagGIList)) } ?: GIList()


@JvmInline
value class GIList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagGIList, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagGIList, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagGIList, value)
}
