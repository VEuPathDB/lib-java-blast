package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val DefaultVersion = false
private const val KeyVersion     = "-version"


internal fun ParseVersion(js: ObjectNode) =
  Version(js[KeyVersion]?.booleanValue() ?: DefaultVersion)


/**
 * Print version number;  ignore other arguments
 */
@JvmInline
value class Version(val value: Boolean = DefaultVersion) : BlastField {
  override val isDefault get() = value == DefaultVersion

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      js.put(KeyVersion, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyVersion)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault)
      cli.add(KeyVersion)
  }
}