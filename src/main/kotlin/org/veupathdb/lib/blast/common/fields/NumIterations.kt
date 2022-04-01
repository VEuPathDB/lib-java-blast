package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNumIterations
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqUInt


internal fun ParseNumIterations(js: ObjectNode) =
  js[FlagNumIterations]?.let { NumIterations(it.reqUInt(FlagNumIterations)) }
    ?: NumIterations()


/**
 * -num_iterations `<Integer, >=0>`
 *
 * Number of iterations to perform (0 means run until convergence)
 *
 * Default = `1`
 */
@JvmInline
value class NumIterations(val value: UInt = 1u) : BlastField {
  override val isDefault get() = value == 1u

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagNumIterations, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagNumIterations, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagNumIterations, value)
}