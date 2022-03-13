package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyStrand = "-strand"


internal fun ParseStrand(js: ObjectNode) =
  Strand(js[KeyStrand].parseStrandType())


@JvmInline
value class Strand(val value: StrandType = StrandType.Both) : BlastField {
  override val isDefault get() = value == StrandType.Both

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyStrand, value.value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyStrand).append(' ').append(value.value)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyStrand)
      cli.add(value.value)
    }
  }
}


////////////////////////////////////////////////////////////////////////////////


private fun JsonNode?.parseStrandType() =
  when (val v = this?.textValue()) {
    null    -> StrandType.Both
    "both"  -> StrandType.Both
    "minus" -> StrandType.Minus
    "plus"  -> StrandType.Plus
    else    -> throw IllegalArgumentException("Invalid value $v for enum StrandType.")
  }


enum class StrandType {
  Both,
  Minus,
  Plus;

  val value get() = name.lowercase()
}