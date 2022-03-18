package org.veupathdb.lib.blast.psiblast.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagMSAMasterIndex
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqUInt


internal fun ParseMSAMasterIndex(js: ObjectNode) =
  js[FlagMSAMasterIndex]?.let { MSAMasterIndex(it.reqUInt(FlagMSAMasterIndex)) }
    ?: MSAMasterIndex()


@JvmInline
value class MSAMasterIndex(val value: UInt = 0u) : BlastField {
  override val isDefault get() = value == 0u

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagMSAMasterIndex, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagMSAMasterIndex, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagMSAMasterIndex, value)
}