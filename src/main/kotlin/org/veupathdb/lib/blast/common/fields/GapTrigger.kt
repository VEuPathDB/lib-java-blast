package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagGapTrigger
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqDub


internal fun ParseGapTrigger(js: ObjectNode) =
  js[FlagGapTrigger]?.let { GapTrigger(it.reqDub(FlagGapTrigger)) }
    ?: GapTrigger()


@JvmInline
value class GapTrigger(val value: Double = 22.0) : BlastField {
  override val isDefault get() = value == 22.0

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagGapTrigger, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagGapTrigger, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagGapTrigger, value)
}