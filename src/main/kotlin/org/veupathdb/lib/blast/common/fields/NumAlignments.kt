package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNumAlignments
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqLong


private const val DefaultNumAlignments = 250L


internal fun ParseNumAlignments(js: ObjectNode) =
  js[FlagNumAlignments]?.let { NumAlignments(it.reqLong(FlagNumAlignments)) }
    ?: NumAlignments()


/**
 * -num_alignments `<Integer, >=0>`
 *
 * Number of database sequences to show alignments for
 *
 * Default = `250`
 */
@JvmInline
value class NumAlignments(val value: Long = DefaultNumAlignments) : BlastField {
  override val isDefault get() = value == DefaultNumAlignments

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagNumAlignments, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagNumAlignments, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagNumAlignments, value)
}