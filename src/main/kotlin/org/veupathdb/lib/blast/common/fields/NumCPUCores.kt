package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Key = "-num_threads"

private const val Def: UByte = 1u


internal fun ParseNumCPUCores(js: ObjectNode): NumCPUCores {
  val tmp = js[Key] ?: return NumCPUCores()

  if (!tmp.isIntegralNumber)
    throw IllegalArgumentException("$Key must be an int value >= 1 and <= 10.")

  val int = tmp.intValue()

  if (int < 1 || int > 10)
    throw IllegalArgumentException("$Key must be an int value >= 1 and <= 10.")

  return NumCPUCores(int.toUByte())
}

@JvmInline
value class NumCPUCores(val value: UByte = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}