package org.veupathdb.lib.blast.blastp.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


private const val Key = "-task"


internal fun ParseBlastPTask(js: ObjectNode) =
  js[Key]?.let { BlastPTask(parseTask(it.reqString(Key))) } ?: BlastPTask()


@JvmInline
value class BlastPTask(val value: BlastPTaskType = BlastPTaskType.BlastP)
  : BlastField
{
  override val isDefault get() = value == BlastPTaskType.BlastP

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value.value)
}


private fun parseTask(value: String) = when(value) {
  "blastp"       -> BlastPTaskType.BlastP
  "blastp-fast"  -> BlastPTaskType.BlastPFast
  "blastp-short" -> BlastPTaskType.BlastPShort
  else           -> throw IllegalArgumentException("Invalid value $value for enum BlastPTaskType")
}


enum class BlastPTaskType {
  BlastP,
  BlastPFast,
  BlastPShort;

  val value get() = when(this) {
    BlastP      -> "blastp"
    BlastPFast  -> "blastp-fast"
    BlastPShort -> "blastp-short"
  }
}