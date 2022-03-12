package org.veupathdb.lib.blast.blastn

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyTask = "-task"


internal fun ParseBlastNTask(js: ObjectNode) =
  BlastNTask(js[KeyTask].parseTask())


@JvmInline
value class BlastNTask(val value: BlastNTaskType = BlastNTaskType.Megablast)
  : BlastField
{
  override val isDefault get() = value == BlastNTaskType.Megablast

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyTask, value.value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyTask).append(' ').append(value.value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyTask)
      cli.add(value.value)
    }
  }
}


////////////////////////////////////////////////////////////////////////////////


private fun JsonNode?.parseTask(): BlastNTaskType {
  if (this == null)
    return BlastNTaskType.Megablast

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