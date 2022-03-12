package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField

private const val Key = "-db"
private const val Def = ""


internal fun ParseDBFile(js: ObjectNode): DBFile {
  val tmp = js[Key] ?: return DBFile()

  if (!tmp.isTextual)
    throw IllegalArgumentException("$Key must be a text value.")

  return DBFile(tmp.textValue())
}


@JvmInline
value class DBFile(val value: String = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(Key, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault) {
      cli.append(' ')
        .append(Key)
        .append(" '")
        .append(value)
        .append('\'')
    }
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (isDefault) {
      cli.add(Key)
      cli.add(value)
    }
  }
}