package org.veupathdb.lib.blast.blastp.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


private const val Key = "-matrix"


internal fun ParseBlastPMatrix(js: ObjectNode) =
  js[Key]?.let { BlastPMatrix(parseMatrix(it.reqString(Key))) }
    ?: BlastPMatrix()


@JvmInline
value class BlastPMatrix(val value: BlastPMatrixType = BlastPMatrixType.None)
  : BlastField
{
  override val isDefault get() = value == BlastPMatrixType.None

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, Key, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value.value)
}


private fun parseMatrix(value: String) =
  when(value.lowercase()) {
    "blosum45" -> BlastPMatrixType.Blosum45
    "blosum50" -> BlastPMatrixType.Blosum50
    "blosum62" -> BlastPMatrixType.Blosum62
    "blosum80" -> BlastPMatrixType.Blosum80
    "blosum90" -> BlastPMatrixType.Blosum90
    "pam30"    -> BlastPMatrixType.Pam30
    "pam70"    -> BlastPMatrixType.Pam70
    "pam250"   -> BlastPMatrixType.Pam250
    "identity" -> BlastPMatrixType.Identity
    "none"     -> BlastPMatrixType.None
    else       -> throw IllegalArgumentException("Invalid value $value for enum BlastPMatrixType")
  }


enum class BlastPMatrixType {
  Blosum45,
  Blosum50,
  Blosum62,
  Blosum80,
  Blosum90,
  Pam30,
  Pam70,
  Pam250,
  Identity,
  None;

  val value get() = name.uppercase()
}