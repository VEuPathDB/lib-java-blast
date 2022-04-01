package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagVersion
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


private const val DefaultVersion = false


internal fun ParseVersion(js: ObjectNode) =
  js[FlagVersion]?.let { Version(it.reqBool(FlagVersion)) } ?: Version()


/**
 * -version
 *
 * Print version number;  ignore other arguments
 */
@JvmInline
value class Version(val value: Boolean = DefaultVersion) : BlastField {
  override val isDefault get() = value == DefaultVersion

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagVersion, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagVersion)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagVersion)
}