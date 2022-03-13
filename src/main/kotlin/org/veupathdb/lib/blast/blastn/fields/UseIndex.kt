package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


private const val Key = "-use_index"
private const val Def = false


internal fun ParseUseIndex(js: ObjectNode) =
  js[Key]?.let { UseIndex(it.reqBool(Key)) } ?: UseIndex()


@JvmInline
value class UseIndex(val value: Boolean = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}