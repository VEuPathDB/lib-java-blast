package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField

private const val KeyDbFile = "-db"
private const val DefaultDbFile = ""


internal fun ParseDBFile(js: ObjectNode) =
  DbFile(js[KeyDbFile]?.textValue() ?: DefaultDbFile)


@JvmInline
value class DbFile(val value: String = DefaultDbFile) : BlastField {
  override val isDefault get() = value == DefaultDbFile

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyDbFile, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault) {
      cli.append(' ')
        .append(KeyDbFile)
        .append(" '")
        .append(value)
        .append('\'')
    }
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (isDefault) {
      cli.add(KeyDbFile)
      cli.add(value)
    }
  }
}