package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagTemplateType
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseTemplateType(js: ObjectNode) =
  js[FlagTemplateType]?.let {
    TemplateType(parseEnum(it.reqString(FlagTemplateType)))
  } ?: TemplateType()


@JvmInline
value class TemplateType(val value: TemplateTypeType = TemplateTypeType.None)
  : BlastField
{
  override val isDefault get() = value == TemplateTypeType.None

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagTemplateType, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagTemplateType, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagTemplateType, value.value)
}


private fun parseEnum(value: String): TemplateTypeType {
  return when(value) {
    "coding"             -> TemplateTypeType.Coding
    "coding_and_optimal" -> TemplateTypeType.CodingAndOptimal
    "optimal"            -> TemplateTypeType.Optimal
    else                 -> throw IllegalArgumentException("Invalid $FlagTemplateType value: $value")
  }
}


enum class TemplateTypeType {
  Coding,
  CodingAndOptimal,
  Optimal,
  None;

  val value get() = when(this) {
    Coding           -> "coding"
    CodingAndOptimal -> "coding_and_optimal"
    Optimal          -> "optimal"
    None             -> "none"
  }
}
