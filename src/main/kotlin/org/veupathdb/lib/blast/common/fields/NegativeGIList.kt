package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNegativeGIList
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseNegGIList(js: ObjectNode) =
  js[FlagNegativeGIList]?.let {
    NegativeGIList(it.reqString(FlagNegativeGIList))
  } ?: NegativeGIList()


@JvmInline
value class NegativeGIList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagNegativeGIList, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagNegativeGIList, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagNegativeGIList, value)
}
