package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagLineLength
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.*


private const val Def = 60


internal fun ParseLineLength(js: ObjectNode) =
  js.optInt(FlagLineLength) { LineLength(it) } ?: LineLength()


/**
 * -line_length `<Integer, >=1>`
 *
 * Line length for formatting alignments
 *
 * Not applicable for outfmt > 4
 *
 * Default = `60`
 */
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