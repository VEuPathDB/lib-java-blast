package org.veupathdb.lib.blast.blastn

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeyPercentIdentity = "-perc_identity"
private const val DefPercentIdentity = -1.0


internal fun ParsePercentIdentity(js: ObjectNode) =
  PercentIdentity(js[KeyPercentIdentity]?.doubleValue() ?: DefPercentIdentity)


@JvmInline
value class PercentIdentity(val value: Double = DefPercentIdentity)
  : BlastField
{
  override val isDefault get() = value == DefPercentIdentity

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyPercentIdentity, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyPercentIdentity, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyPercentIdentity, value)
}