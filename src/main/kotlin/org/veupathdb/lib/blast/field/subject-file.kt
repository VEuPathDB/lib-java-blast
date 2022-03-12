package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeySubjectFile = "-index_name"


internal fun ParseSubjectFile(js: ObjectNode) =
  SubjectFile(js[KeySubjectFile]?.textValue() ?: "")


@JvmInline
value class SubjectFile(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeySubjectFile, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeySubjectFile, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeySubjectFile, value)
}