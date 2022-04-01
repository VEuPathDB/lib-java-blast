package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagSaveEachPSSM
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseSaveEachPSSM(js: ObjectNode) =
  js[FlagSaveEachPSSM]?.let { SaveEachPSSM(it.reqBool(FlagSaveEachPSSM)) }
    ?: SaveEachPSSM()


/**
 * -save_each_pssm
 *
 * Save PSSM after each iteration (file name is given in -save_pssm or
 * -save_ascii_pssm options)
 */
@JvmInline
value class SaveEachPSSM(val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagSaveEachPSSM, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagSaveEachPSSM)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagSaveEachPSSM)
}