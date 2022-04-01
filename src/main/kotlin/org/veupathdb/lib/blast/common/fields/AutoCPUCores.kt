package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNumThreads
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.*
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put

private val Def = AutoCPUCoresValue.Disable

internal fun ParseAutoCPUCores(js: ObjectNode) =
  js.optInt(FlagNumThreads) { AutoCPUCores(parse(it)) } ?: AutoCPUCores()

/**
 * -num_threads <Integer, >=0>
 *
 * Number of threads to use in RPS BLAST search:
 * * 0 (auto = num of databases)
 * * 1 (disable)
 *
 * Max number of threads = num of databases
 *
 * Default = `1`
 */
@JvmInline
value class AutoCPUCores(val value: AutoCPUCoresValue = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagNumThreads, value.ordinal)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagNumThreads, value.ordinal)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagNumThreads, value.ordinal)
}

private fun parse(v: Int) =
  AutoCPUCoresValue.values()[v.inSet(FlagNumThreads, 0, 1)]

enum class AutoCPUCoresValue {
  Enable,
  Disable
}