package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Key = "-subject_besthit"
private const val Def = false


internal fun ParseSubjectBestHit(js: ObjectNode): SubjectBestHit {
  val tmp = js[Key] ?: return SubjectBestHit()

  if (!tmp.isBoolean)
    throw IllegalArgumentException("$Key must be a boolean value.")

  return SubjectBestHit(tmp.booleanValue())
}


@JvmInline
value class SubjectBestHit(val value: Boolean = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}