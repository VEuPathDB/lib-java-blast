package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagOutPSSM
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseOutPSSMFile(js: ObjectNode) =
  js[FlagOutPSSM]?.let { OutPSSMFile(it.reqString(FlagOutPSSM)) }
    ?: OutPSSMFile()


@JvmInline
value class OutPSSMFile(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagOutPSSM, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagOutPSSM, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagOutPSSM, value)
}