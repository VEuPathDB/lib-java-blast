package org.veupathdb.lib.blast.blastx.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagMatrix
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseScoringMatrixX(js: ObjectNode) =
  js[FlagMatrix]?.let { ScoringMatrixX(parseEnum(it.reqString(FlagMatrix))) } ?:
    ScoringMatrixX()


@JvmInline
value class ScoringMatrixX(
  val value: ScoringMatrixXValue = ScoringMatrixXValue.None
): BlastField {
  override val isDefault get() = value == ScoringMatrixXValue.None

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagMatrix, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagMatrix, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagMatrix, value.value)
}


private fun parseEnum(value: String): ScoringMatrixXValue {
  return when (value.uppercase()) {
    "BLOSUM45" -> ScoringMatrixXValue.Blosum45
    "BLOSUM50" -> ScoringMatrixXValue.Blosum50
    "BLOSUM62" -> ScoringMatrixXValue.Blosum62
    "BLOSUM80" -> ScoringMatrixXValue.Blosum80
    "BLOSUM90" -> ScoringMatrixXValue.Blosum90
    "PAM30"    -> ScoringMatrixXValue.Pam30
    "PAM70"    -> ScoringMatrixXValue.Pam70
    "PAM250"   -> ScoringMatrixXValue.Pam250
    else       -> throw IllegalArgumentException("Invalid $FlagMatrix value: $value")
  }
}


enum class ScoringMatrixXValue {
  Blosum45,
  Blosum50,
  Blosum62,
  Blosum80,
  Blosum90,
  Pam30,
  Pam70,
  Pam250,
  None;

  val value
    get() = when (this) {
      Blosum45 -> "BLOSUM45"
      Blosum50 -> "BLOSUM50"
      Blosum62 -> "BLOSUM62"
      Blosum80 -> "BLOSUM80"
      Blosum90 -> "BLOSUM90"
      Pam30    -> "PAM30"
      Pam70    -> "PAM70"
      Pam250   -> "PAM250"
      else     -> throw IllegalStateException()
    }
}