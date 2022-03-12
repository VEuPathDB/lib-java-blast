package org.veupathdb.lib.blast.blastn

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val DefaultNonGreedy = false
private const val KeyNonGreedy     = "-non_greedy"


internal fun ParseNonGreedy(js: ObjectNode) =
  NonGreedy(js[KeyNonGreedy]?.booleanValue() ?: DefaultNonGreedy)


@JvmInline
value class NonGreedy(val value: Boolean = DefaultNonGreedy) : BlastField {
  override val isDefault get() = value == DefaultNonGreedy

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyNonGreedy, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyNonGreedy)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault)
      cli.add(KeyNonGreedy)
  }
}