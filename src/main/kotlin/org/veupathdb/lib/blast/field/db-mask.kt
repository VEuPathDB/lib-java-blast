package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val KeyDBSoftMask = "-db_soft_mask"
private const val KeyDBHardMask = "-db_soft_mask"


internal fun ParseDBSoftMask(js: ObjectNode) =
  DBSoftMask(js[KeyDBSoftMask]?.textValue() ?: "")


@JvmInline
value class DBSoftMask(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyDBSoftMask, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyDBSoftMask, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyDBSoftMask, value)
}


internal fun ParseDBHardMask(js: ObjectNode) =
  DBHardMask(js[KeyDBHardMask]?.textValue() ?: "")


@JvmInline
value class DBHardMask(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(json: ObjectNode) =
    json.put(isDefault, KeyDBHardMask, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, KeyDBHardMask, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, KeyDBHardMask, value)
}