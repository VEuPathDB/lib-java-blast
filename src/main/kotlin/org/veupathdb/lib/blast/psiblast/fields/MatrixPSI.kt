package org.veupathdb.lib.blast.psiblast.fields

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagMatrix
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseMatrixPSI(js: ObjectNode) =
  js[FlagMatrix]?.let { MatrixPSI(parseEnum(it)) } ?: MatrixPSI()


@JvmInline
value class MatrixPSI(val value: MatrixPSIType = MatrixPSIType.None)
  : BlastField
{
  override val isDefault get() = value == MatrixPSIType.None

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagMatrix, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagMatrix, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagMatrix, value.value)
}


@Suppress("NOTHING_TO_INLINE")
private inline fun parseEnum(js: JsonNode): MatrixPSIType {
  val tmp = js.reqString(FlagMatrix).uppercase()

  for (v in MatrixPSIType.values())
    if (tmp == v.value)
      return v

  throw IllegalArgumentException("Invalid $FlagMatrix value: $tmp")
}


enum class MatrixPSIType {
  Blosum45,
  Blosum50,
  Blosum62,
  Blosum80,
  Blosum90,
  Pam30,
  Pam70,
  Pam250,
  None;

  val value = name.uppercase()
}