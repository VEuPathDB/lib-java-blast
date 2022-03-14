package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagHelpLong
import org.veupathdb.lib.blast.common.FlagHelpShort
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseHelpLong(js: ObjectNode) =
  js[FlagHelpLong]?.let { HelpLong(it.reqBool(FlagHelpLong)) } ?: HelpLong()


@JvmInline
value class HelpLong(val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagHelpLong, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagHelpLong)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagHelpShort)
}