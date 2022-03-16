package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagSearchSpace
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqByte


private const val DefaultSearchSpace: Byte = -1


internal fun ParseSearchSpace(js: ObjectNode) =
  js[FlagSearchSpace]?.let { SearchSpace(it.reqByte(FlagSearchSpace)) }
    ?: SearchSpace()


@JvmInline
value class SearchSpace(val value: Byte = DefaultSearchSpace) : BlastField {
  override val isDefault get() = value == DefaultSearchSpace

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagSearchSpace, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagSearchSpace, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagSearchSpace, value)
}