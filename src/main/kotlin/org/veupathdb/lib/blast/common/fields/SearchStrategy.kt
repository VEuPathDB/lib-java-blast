package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagExportSearchStrategy
import org.veupathdb.lib.blast.common.FlagImportSearchStrategy
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseImportSearchStrategy(js: ObjectNode) =
  js[FlagImportSearchStrategy]?.let {
    ImportSearchStrategy(it.reqString(FlagImportSearchStrategy))
  } ?: ImportSearchStrategy()


@JvmInline
value class ImportSearchStrategy(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagImportSearchStrategy, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagImportSearchStrategy, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagImportSearchStrategy, value)
}


internal fun ParseExportSearchStrategy(js: ObjectNode) =
  js[FlagExportSearchStrategy]?.let {
    ExportSearchStrategy(it.reqString(FlagExportSearchStrategy))
  } ?: ExportSearchStrategy()


@JvmInline
value class ExportSearchStrategy(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagExportSearchStrategy, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagExportSearchStrategy, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagExportSearchStrategy, value)
}