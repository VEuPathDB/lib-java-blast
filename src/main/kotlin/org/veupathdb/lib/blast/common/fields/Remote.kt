package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagRemote
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseRemote(js: ObjectNode) =
  js[FlagRemote]?.let { Remote(it.reqBool(FlagRemote)) } ?: Remote()


/**
 * -remote
 *
 * Execute search remotely?
 */
@JvmInline
value class Remote(val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagRemote, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagRemote)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagRemote)
}