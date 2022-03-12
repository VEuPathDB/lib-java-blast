package org.veupathdb.lib.blast.blastn

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeyUseIndex = "-use_index"
private const val DefUseIndex = false


internal fun ParseUseIndex(js: ObjectNode) =
  UseIndex(js[KeyUseIndex]?.booleanValue() ?: DefUseIndex)


@JvmInline
value class UseIndex(val value: Boolean = DefUseIndex) : BlastField {
  override val isDefault get() = value == DefUseIndex

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyUseIndex, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyUseIndex, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyUseIndex, value)
}