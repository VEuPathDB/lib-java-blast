package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagLineLength
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqInt


private const val Def = 60


internal fun ParseLineLength(js: ObjectNode) =
  js[FlagLineLength]?.let { LineLength(it.reqInt(FlagLineLength)) }
    ?: LineLength()


@JvmInline
value class LineLength(val value: Int = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagLineLength, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagLineLength, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagLineLength, value)
}