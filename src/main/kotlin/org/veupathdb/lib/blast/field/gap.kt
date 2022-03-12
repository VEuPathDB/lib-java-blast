package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeyGapOpen   = "-gapopen"
private const val KeyGapExtend = "-gapextend"


internal fun ParseGapOpen(js: ObjectNode) =
  GapOpen(js[KeyGapOpen]?.intValue() ?: 0)


@JvmInline
value class GapOpen(val value: Int = 0) : BlastField {
  override val isDefault get() = value == 0

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyGapOpen, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyGapOpen, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyGapOpen, value)
}


internal fun ParseGapExtend(js: ObjectNode) =
  GapExtend(js[KeyGapExtend]?.intValue() ?: 0)


@JvmInline
value class GapExtend(val value: Int = 0) : BlastField {
  override val isDefault get() = value == 0

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyGapExtend, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyGapExtend, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyGapExtend, value)
}