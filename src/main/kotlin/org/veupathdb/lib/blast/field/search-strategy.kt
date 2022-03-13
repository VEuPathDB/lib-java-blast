package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyISS = "-import_search_strategy"
private const val KeyESS = "-export_search_strategy"


internal fun ParseImportSearchStrategy(js: ObjectNode) =
  ImportSearchStrategy(js[KeyISS]?.textValue() ?: "")


@JvmInline
value class ImportSearchStrategy(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyISS, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyISS).append(" '").append(value).append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyISS)
      cli.add(value)
    }
  }
}


internal fun ParseExportSearchStrategy(js: ObjectNode) =
  ExportSearchStrategy(js[KeyESS]?.textValue() ?: "")


@JvmInline
value class ExportSearchStrategy(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyESS, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyESS).append(" '").append(value).append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyESS)
      cli.add(value)
    }
  }
}