package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val DefaultOutFile = "-"
private const val KeyOutFile     = "-out"


internal fun ParseOutFile(js: ObjectNode) =
  OutFile(js[KeyOutFile]?.textValue() ?: DefaultOutFile)

@JvmInline
value class OutFile(val value: String = DefaultOutFile): BlastField {
  override val isDefault get() = value == DefaultOutFile && value.isNotBlank()

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyOutFile, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ')
        .append(KeyOutFile)
        .append(" '")
        .append(value)
        .append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyOutFile)
      cli.add(value)
    }
  }
}