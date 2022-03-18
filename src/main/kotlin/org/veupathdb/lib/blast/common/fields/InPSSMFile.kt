package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagInPSSM
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseInPSSM(js: ObjectNode) =
  js[FlagInPSSM]?.let { InPSSMFile(it.reqString(FlagInPSSM)) } ?: InPSSMFile()


@JvmInline
value class InPSSMFile(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagInPSSM, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagInPSSM, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagInPSSM, value)
}