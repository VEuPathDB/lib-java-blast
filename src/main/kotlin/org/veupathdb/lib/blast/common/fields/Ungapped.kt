package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagUngapped
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseUngappedAlignmentsOnly(js: ObjectNode) =
  js[FlagUngapped]?.let { UngappedAlignmentsOnly(it.reqBool(FlagUngapped)) }
    ?: UngappedAlignmentsOnly()


/**
 * -ungapped
 *
 * Perform ungapped alignment only?
 */
@JvmInline
value class UngappedAlignmentsOnly(val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagUngapped, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagUngapped)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagUngapped)
}