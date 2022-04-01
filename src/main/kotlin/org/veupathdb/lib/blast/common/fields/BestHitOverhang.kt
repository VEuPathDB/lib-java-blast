package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagBestHitOverhang
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Def = -1.0


internal fun ParseBestHitOverhang(js: ObjectNode): BestHitOverhang {
  val tmp = js[FlagBestHitOverhang] ?: return BestHitOverhang()

  if (!tmp.isNumber)
    throw IllegalArgumentException("$FlagBestHitOverhang must be a numeric value > 0 and < 0.5")

  return BestHitOverhang(js.doubleValue())
}


/**
 * -best_hit_overhang `<Real, (>0 and <0.5)>`
 *
 * Best Hit algorithm overhang value (recommended value: 0.1)
 */
@JvmInline
value class BestHitOverhang(val value: Double = Def) : BlastField {
  init {
    if (value != Def && (value <= 0 || value >= 0.5))
      throw IllegalArgumentException("$FlagBestHitOverhang must be (>0 and <0.5)")
  }

  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagBestHitOverhang, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagBestHitOverhang, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagBestHitOverhang, value)
}