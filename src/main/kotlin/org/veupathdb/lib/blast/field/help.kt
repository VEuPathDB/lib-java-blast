package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField

private const val HelpDefault  = false
private const val KeyHelpShort = "-h"
private const val KeyHelpLong  = "--help"

internal fun ParseHelpShort(json: ObjectNode) =
  HelpShort(json.get(KeyHelpShort)?.booleanValue() ?: HelpDefault)


/**
 * Print USAGE and DESCRIPTION;  ignore all other parameters
 */
@JvmInline
value class HelpShort(private val value: Boolean = HelpDefault) : BlastField {
  override val isDefault get() = value == HelpDefault

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyHelpShort, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyHelpShort)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyHelpShort)
    }
  }
}


////////////////////////////////////////////////////////////////////////////////


internal fun ParseHelpLong(json: ObjectNode) =
  HelpLong(json.get(KeyHelpLong)?.booleanValue() ?: HelpDefault)


/**
 * Print USAGE, DESCRIPTION and ARGUMENTS; ignore all other parameters
 */
@JvmInline
value class HelpLong(val value: Boolean = HelpDefault) : BlastField {
  override val isDefault get() = value == HelpDefault

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyHelpLong, value)
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ').append(KeyHelpLong)
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault)
      cli.add(KeyHelpLong)
  }
}