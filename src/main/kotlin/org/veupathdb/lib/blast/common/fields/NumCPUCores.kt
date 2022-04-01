package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNumThreads
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Def: UByte = 1u


/**
 * -num_threads `<Integer, >=1>`
 *
 * Number of threads (CPUs) to use in the BLAST search
 *
 * Default = `1`
 */
internal fun ParseNumCPUCores(js: ObjectNode): NumCPUCores {
  val tmp = js[FlagNumThreads] ?: return NumCPUCores()

  if (!tmp.isIntegralNumber)
    throw IllegalArgumentException("$FlagNumThreads must be an int value >= 1 and <= 10.")

  val int = tmp.intValue()

  if (int < 1 || int > 10)
    throw IllegalArgumentException("$FlagNumThreads must be an int value >= 1 and <= 10.")

  return NumCPUCores(int.toUByte())
}

@JvmInline
value class NumCPUCores(val value: UByte = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagNumThreads, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagNumThreads, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagNumThreads, value)
}