package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagDBFile
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


internal fun ParseDBFile(js: ObjectNode): DBFile {
  val tmp = js[FlagDBFile] ?: return DBFile()

  if (!tmp.isTextual)
    throw IllegalArgumentException("$FlagDBFile must be a text value.")

  return DBFile(tmp.textValue())
}


@JvmInline
value class DBFile(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagDBFile, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagDBFile, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagDBFile, value)
}