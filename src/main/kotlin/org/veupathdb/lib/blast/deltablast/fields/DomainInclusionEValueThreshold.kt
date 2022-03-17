package org.veupathdb.lib.blast.deltablast.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagDomainInclusionEThresh
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqDub


internal fun ParseDomainInclusionEValueThreshold(js: ObjectNode) =
  js[FlagDomainInclusionEThresh]?.let {
    DomainInclusionEValueThreshold(it.reqDub(FlagDomainInclusionEThresh))
  } ?: DomainInclusionEValueThreshold()


@JvmInline
value class DomainInclusionEValueThreshold(val value: Double = 0.05)
  : BlastField
{
  override val isDefault get() = value == 0.05

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagDomainInclusionEThresh, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagDomainInclusionEThresh, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagDomainInclusionEThresh, value)
}