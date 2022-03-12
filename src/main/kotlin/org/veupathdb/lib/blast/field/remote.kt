package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val DefaultRemote = false
private const val KeyRemote     = "-remote"


internal fun ParseRemote(js: ObjectNode) =
  Remote(js[KeyRemote]?.booleanValue() ?: DefaultRemote)


@JvmInline
value class Remote(val value: Boolean = DefaultRemote) : BlastField {
  override val isDefault get() = value == DefaultRemote

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyRemote, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyRemote)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault)
      cli.add(KeyRemote)
  }
}