package org.veupathdb.lib.blast.blastx.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


private const val Key = "-task"

private val Def = BlastXTaskType.BlastX


internal fun ParseBlastXTask(js: ObjectNode) =
  js[Key]?.let { BlastXTask(parseEnum(it.reqString(Key))) } ?: BlastXTask()


@JvmInline
value class BlastXTask(val value: BlastXTaskType = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value.value)
}


private fun parseEnum(value: String) =
  when(value.lowercase()) {
    "blastx"      -> BlastXTaskType.BlastX
    "blastx-fast" -> BlastXTaskType.BlastXFast
    else          -> throw IllegalArgumentException("Invalid value for $Key: $value")
  }

enum class BlastXTaskType {
  BlastX,
  BlastXFast;

  val value get() = when(this) {
    BlastX     -> "blastx"
    BlastXFast -> "blastx-fast"
  }
}