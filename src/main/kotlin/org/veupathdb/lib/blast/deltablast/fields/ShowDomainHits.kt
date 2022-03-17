package org.veupathdb.lib.blast.deltablast.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagShowDomainHits
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseShowDomainHits(js: ObjectNode) =
  js[FlagShowDomainHits]?.let { ShowDomainHits(it.reqBool(FlagShowDomainHits)) }
    ?: ShowDomainHits()


@JvmInline
value class ShowDomainHits(val value: Boolean = false): BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagShowDomainHits, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagShowDomainHits)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagShowDomainHits)
}