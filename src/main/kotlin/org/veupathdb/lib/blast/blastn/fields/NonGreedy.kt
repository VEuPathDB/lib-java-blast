package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagNonGreedy
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.reqBool


private const val Def = false


internal fun ParseNonGreedy(js: ObjectNode) =
  js[FlagNonGreedy]?.let { NonGreedy(it.reqBool(FlagNonGreedy)) }
    ?: NonGreedy()


/**
 * -no_greedy
 *
 * Use non-greedy dynamic programming extension
 */
@JvmInline
value class NonGreedy(val value: Boolean = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(FlagNonGreedy, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(FlagNonGreedy)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault)
      cli.add(FlagNonGreedy)
  }
}