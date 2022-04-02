package org.veupathdb.lib.blast.rpstblastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagSoftMasking
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseSoftMaskingRPSTN(js: ObjectNode) =
  js[FlagSoftMasking]?.let { SoftMaskingRPSTN(it.reqBool(FlagSoftMasking)) }
    ?: SoftMaskingRPSTN()


/**
 * -soft_masking `<Boolean>`
 *
 * Apply filtering locations as soft masks
 *
 * Default = `false`
 */
@JvmInline
value class SoftMaskingRPSTN(val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagSoftMasking, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagSoftMasking, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagSoftMasking, value)
}