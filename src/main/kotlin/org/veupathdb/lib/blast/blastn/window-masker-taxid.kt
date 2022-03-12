package org.veupathdb.lib.blast.blastn

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put

private const val KeyWindowMaskerTaxID = "-window_masker_taxid"
private const val DefWindowMaskerTaxID = -1


internal fun ParseWindowMaskerTaxID(js: ObjectNode) =
  WindowMaskerTaxID(js[KeyWindowMaskerTaxID]?.intValue() ?: DefWindowMaskerTaxID)


@JvmInline
value class WindowMaskerTaxID(val value: Int = DefWindowMaskerTaxID)
  : BlastField
{
  override val isDefault get() = value == DefWindowMaskerTaxID

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyWindowMaskerTaxID, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyWindowMaskerTaxID, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyWindowMaskerTaxID, value)
}