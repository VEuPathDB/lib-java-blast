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


/**
 * -out_ascii_pssm `<File_Out>`
 *
 * File name to store ASCII version of PSSM
 */
@JvmInline
value class OutASCIIPSSMFile(val file: String = "") : BlastField {
  override val isDefault get() = file.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagOutASCIIPSSM, file)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagOutASCIIPSSM, file)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagOutASCIIPSSM, file)
}