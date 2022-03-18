package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put

private const val Key = "-template_type"


internal fun ParseTemplateType(js: ObjectNode): TemplateType {
  val tmp = js[Key] ?: return TemplateType()

  if (!tmp.isTextual)
    throw IllegalArgumentException("$Key must be a string value.")

  return TemplateType(parseTemplateTypeType(tmp.textValue()))
}

@JvmInline
value class TemplateType(val value: TemplateTypeType = TemplateTypeType.None)
  : BlastField
{
  override val isDefault get() = value == TemplateTypeType.None

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value.value)
}


private fun parseTemplateTypeType(value: String): TemplateTypeType {
  return when(value) {
    "coding"             -> TemplateTypeType.Coding
    "coding_and_optimal" -> TemplateTypeType.CodingAndOptimal
    "optimal"            -> TemplateTypeType.Optimal
    else                 -> throw IllegalArgumentException("Invalid value $value for $Key")
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
