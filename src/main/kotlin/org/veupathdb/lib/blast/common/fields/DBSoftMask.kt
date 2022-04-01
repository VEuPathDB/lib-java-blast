package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagDBSoftMask
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString



internal fun ParseDBSoftMask(js: ObjectNode) =
  js[FlagDBSoftMask]?.let { DBSoftMask(it.reqString(FlagDBSoftMask)) } ?:
    DBSoftMask()


/**
 * -db_soft_mask `<String>`
 *
 * Filtering algorithm ID to apply to the BLAST database as soft masking
 */
@JvmInline
value class DBSoftMask(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagDBSoftMask, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagDBSoftMask, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagDBSoftMask, value)
}

