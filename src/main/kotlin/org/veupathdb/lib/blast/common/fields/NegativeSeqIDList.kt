package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNegativeSeqIDList
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseNegSeqIdList(js: ObjectNode) =
  js[FlagNegativeSeqIDList]?.let {
    NegativeSeqIDList(it.reqString(FlagNegativeSeqIDList))
  } ?: NegativeSeqIDList()


@JvmInline
value class NegativeSeqIDList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagNegativeSeqIDList, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagNegativeSeqIDList, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagNegativeSeqIDList, value)
}
