package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeySIL  = "-seqidlist"


internal fun ParseSeqIDList(js: ObjectNode) =
  SeqIdList(js[KeySIL]?.textValue() ?: "")


@JvmInline
value class SeqIdList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeySIL, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeySIL).append(" '").append(value).append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeySIL)
      cli.add(value)
    }
  }
}

