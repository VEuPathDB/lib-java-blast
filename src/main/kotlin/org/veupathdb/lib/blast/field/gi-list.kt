package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyGIList    = "-gilist"
private const val KeyNegGIList = "-negative_gilist"


internal fun ParseGIList(js: ObjectNode) =
  GIList(js[KeyGIList]?.textValue() ?: "")


@JvmInline
value class GIList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyGIList, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyGIList).append(" '").append(value).append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyGIList)
      cli.add(value)
    }
  }
}


internal fun ParseNegGIList(js: ObjectNode) =
  NegativeGIList(js[KeyNegGIList]?.textValue() ?: "")


@JvmInline
value class NegativeGIList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyNegGIList, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ')
        .append(KeyNegGIList)
        .append(" '")
        .append(value)
        .append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyNegGIList)
      cli.add(value)
    }
  }
}