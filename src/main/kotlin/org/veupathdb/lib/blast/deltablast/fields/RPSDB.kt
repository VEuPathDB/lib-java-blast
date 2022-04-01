package org.veupathdb.lib.blast.deltablast.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagRPSDB
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseRPSDB(js: ObjectNode) =
  js[FlagRPSDB]?.let { RPSDB(it.reqString(FlagRPSDB)) } ?: RPSDB()


/**
 * -rpsdb `<String>`
 *
 * BLAST domain database name
 *
 * Default = `cdd_delta`
 */
@JvmInline
value class RPSDB(val value: String = "cdd_delta") : BlastField {
  override val isDefault get() = value == "cdd_delta"

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagRPSDB, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagRPSDB, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagRPSDB, value)
}