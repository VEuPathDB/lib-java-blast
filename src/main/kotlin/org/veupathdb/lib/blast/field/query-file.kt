package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val DefaultQueryFile = "-"
private const val KeyQueryFile = "-query"


internal fun ParseQueryFile(js: ObjectNode) =
  QueryFile(js[KeyQueryFile]?.textValue() ?: DefaultQueryFile)


@JvmInline
value class QueryFile(val value: String = DefaultQueryFile) : BlastField {
  override val isDefault get() = value == DefaultQueryFile

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyQueryFile, DefaultQueryFile)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ')
        .append(KeyQueryFile)
        .append(" '")
        .append(value)
        .append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyQueryFile)
      cli.add(value)
    }
  }
}