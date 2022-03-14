package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagHelpShort
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseHelpShort(js: ObjectNode) =
  js[FlagHelpShort]?.let { HelpShort(it.reqBool(FlagHelpShort)) } ?: HelpShort()


@JvmInline
value class HelpShort(private val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagHelpShort, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagHelpShort)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagHelpShort)
}
