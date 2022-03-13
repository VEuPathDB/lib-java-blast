package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqInt

private const val Key = "-window_masker_taxid"
private const val Def = -1


internal fun ParseWindowMaskerTaxID(js: ObjectNode) =
  js[Key]?.let { WindowMaskerTaxID(it.reqInt(Key)) } ?: WindowMaskerTaxID()


@JvmInline
value class WindowMaskerTaxID(val value: Int = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}