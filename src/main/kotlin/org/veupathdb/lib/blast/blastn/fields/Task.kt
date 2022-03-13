package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Key = "-task"


internal fun ParseBlastNTask(js: ObjectNode) =
  BlastNTask(js[Key].parseTask())


@JvmInline
value class BlastNTask(val value: BlastNTaskType = BlastNTaskType.Megablast)
  : BlastField
{
  override val isDefault get() = value == BlastNTaskType.Megablast

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value.value)
}


////////////////////////////////////////////////////////////////////////////////


private fun JsonNode?.parseTask(): BlastNTaskType {
  if (this == null)
    return BlastNTaskType.Megablast

  if (!isTextual)
    throw IllegalArgumentException("$Key must be a string value.")

  val tmp = textValue()

  for (v in BlastNTaskType.values())
    if (tmp == v.value)
      return v

  throw IllegalArgumentException("Invalid value $tmp for enum BlastNTaskType")
}


enum class BlastNTaskType(val value: String) {
  BlastN("blastn"),
  BlastNShort("blastn-short"),
  DiscontiguousMegablast("dc-megablast"),
  Megablast("megablast"),
  RMBlastN("rmblastn");
}