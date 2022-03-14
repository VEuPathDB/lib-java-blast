package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNegativeIPGList
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString



internal fun ParseNegativeIPGList(js: ObjectNode) =
  js[FlagNegativeIPGList]?.let { NegativeIPGList(it.reqString(FlagNegativeIPGList)) } ?: NegativeIPGList()


@JvmInline
value class NegativeIPGList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagNegativeIPGList, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagNegativeIPGList, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagNegativeIPGList, value)
}