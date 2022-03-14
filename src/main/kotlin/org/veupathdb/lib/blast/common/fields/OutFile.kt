package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagOut
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Def = "-"


internal fun ParseOutFile(js: ObjectNode) =
  OutFile(js[FlagOut]?.textValue() ?: Def)


@JvmInline
value class OutFile(val value: String = Def): BlastField {
  override val isDefault get() = value == Def || value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagOut, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagOut, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagOut, value)
}