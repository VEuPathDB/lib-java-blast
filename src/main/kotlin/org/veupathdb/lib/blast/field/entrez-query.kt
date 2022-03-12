package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyEntrezQuery = "-entrez_query"
private const val DefaultEntrezQuery = ""


internal fun ParseEntrezQuery(js: ObjectNode) =
  EntrezQuery(js.get(KeyEntrezQuery)?.textValue() ?: DefaultEntrezQuery)


@JvmInline
value class EntrezQuery(val value: String = DefaultEntrezQuery) : BlastField {
  override val isDefault get() = value == DefaultEntrezQuery

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyEntrezQuery, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ')
        .append(KeyEntrezQuery)
        .append(" '")
        .append(value)
        .append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyEntrezQuery)
      cli.add(value)
    }
  }
}