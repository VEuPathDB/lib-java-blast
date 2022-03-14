package org.veupathdb.lib.blast.blastx.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqUInt

private const val Key = "-word_size"
private const val Def = UInt.MAX_VALUE


internal fun ParseWordSizeX(js: ObjectNode) =
  js[Key]?.let { WordSizeX(it.reqUInt(Key)) } ?: WordSizeX()


@JvmInline
value class WordSizeX(val value: UInt = Def) : BlastField {
  init {
    if (value < 2u)
      throw IllegalArgumentException("$Key must be an int value >= 2")
  }

  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}