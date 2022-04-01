package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagStrand
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseStrand(js: ObjectNode) =
  js[FlagStrand]?.let { Strand(parseEnum(it.reqString(FlagStrand))) }
    ?: Strand()


/**
 * -strand `<String>`
 *
 * Permissible values:
 * * both
 * * minus
 * * plus
 *
 * Query strand(s) to search against database/subject
 *
 * Default = `both`
 */
@JvmInline
value class Strand(val value: StrandType = StrandType.Both) : BlastField {
  override val isDefault get() = value == StrandType.Both

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagStrand, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagStrand, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagStrand, value.value)
}


////////////////////////////////////////////////////////////////////////////////


private fun parseEnum(value: String): StrandType =
  when (value) {
    "both"  -> StrandType.Both
    "minus" -> StrandType.Minus
    "plus"  -> StrandType.Plus
    else    -> throw IllegalArgumentException("Invalid value for $FlagStrand: $value.")
  }


enum class StrandType {
  Both,
  Minus,
  Plus;

  val value get() = name.lowercase()
}