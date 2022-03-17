package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagSavePSSMAfterLastRound
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseSavePSSMAfterLastRound(js: ObjectNode) =
  js[FlagSavePSSMAfterLastRound]?.let {
    SavePSSMAfterLastRound(it.reqBool(FlagSavePSSMAfterLastRound))
  } ?: SavePSSMAfterLastRound()


@JvmInline
value class SavePSSMAfterLastRound(val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagSavePSSMAfterLastRound, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagSavePSSMAfterLastRound)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagSavePSSMAfterLastRound)
}