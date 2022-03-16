package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagSubjectFile
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseSubjectFile(js: ObjectNode) =
  js[FlagSubjectFile]?.let { SubjectFile(it.reqString(FlagSubjectFile)) }
    ?: SubjectFile()


@JvmInline
value class SubjectFile(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagSubjectFile, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagSubjectFile, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagSubjectFile, value)
}