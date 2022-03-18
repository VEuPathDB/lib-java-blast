package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagUseIndex
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseUseIndex(js: ObjectNode) =
  js[FlagUseIndex]?.let { UseIndex(it.reqBool(FlagUseIndex)) } ?: UseIndex()


@JvmInline
value class UseIndex(val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagUseIndex, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagUseIndex, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagUseIndex, value)
}