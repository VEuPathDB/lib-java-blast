package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val DefaultParseDefLines = false
private const val KeyParseDefLines = "-parse_deflines"


internal fun ParseParseDefLines(js: ObjectNode) =
  ParseDefLines(js[KeyParseDefLines]?.booleanValue() ?: DefaultParseDefLines)


@JvmInline
value class ParseDefLines(val value: Boolean = DefaultParseDefLines) : BlastField {
  override val isDefault get() = value == DefaultParseDefLines

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyParseDefLines, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyParseDefLines)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyParseDefLines)
    }
  }
}