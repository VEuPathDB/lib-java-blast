package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.reqBool


private const val Def = false
private const val Key = "-non_greedy"


internal fun ParseNonGreedy(js: ObjectNode) =
  js[Key]?.let { NonGreedy(it.reqBool(Key)) } ?: NonGreedy()


@JvmInline
value class NonGreedy(val value: Boolean = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(Key, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(Key)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault)
      cli.add(Key)
  }
}