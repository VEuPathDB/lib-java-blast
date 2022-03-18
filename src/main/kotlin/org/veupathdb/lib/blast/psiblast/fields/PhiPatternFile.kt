package org.veupathdb.lib.blast.psiblast.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagPHIPattern
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParsePhiPatternFile(js: ObjectNode) =
  js[FlagPHIPattern]?.let { PhiPatternFile(it.reqString(FlagPHIPattern)) }
    ?: PhiPatternFile()


@JvmInline
value class PhiPatternFile(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagPHIPattern, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagPHIPattern, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagPHIPattern, value)
}