package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagOutASCIIPSSM
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseOutASCIIPSSMFile(js: ObjectNode) =
  js[FlagOutASCIIPSSM]?.let { OutASCIIPSSMFile(it.reqString(FlagOutASCIIPSSM)) }
    ?: OutASCIIPSSMFile()


@JvmInline
value class OutASCIIPSSMFile(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagOutASCIIPSSM, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagOutASCIIPSSM, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagOutASCIIPSSM, value)
}