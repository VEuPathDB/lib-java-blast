package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagShowGIs
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseShowGIs(js: ObjectNode) =
  js[FlagShowGIs]?.let { ShowGIs(it.reqBool(FlagShowGIs)) } ?: ShowGIs()


@JvmInline
value class ShowGIs(val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagShowGIs, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagShowGIs)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagShowGIs)
}