package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagMaxTargetSeqs
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqLong


private const val Def = 500L


internal fun ParseMaxTargetSeqs(js: ObjectNode) =
  js[FlagMaxTargetSeqs]?.let { MaxTargetSeqs(it.reqLong(FlagMaxTargetSeqs)) }
    ?: MaxTargetSeqs()


@JvmInline
value class MaxTargetSeqs(val value: Long = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagMaxTargetSeqs, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagMaxTargetSeqs, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagMaxTargetSeqs, value)
}