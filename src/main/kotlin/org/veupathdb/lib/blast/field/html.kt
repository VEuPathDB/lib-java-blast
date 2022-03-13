package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val DefaultHTML = false
private const val KeyHTML     = "-html"


internal fun ParseHTML(js: ObjectNode) =
  HTML(js[KeyHTML]?.booleanValue() ?: DefaultHTML)


@JvmInline
value class HTML(val value: Boolean = DefaultHTML) : BlastField {
  override val isDefault get() = value == DefaultHTML

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyHTML, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyHTML)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault)
      cli.add(KeyHTML)
  }
}