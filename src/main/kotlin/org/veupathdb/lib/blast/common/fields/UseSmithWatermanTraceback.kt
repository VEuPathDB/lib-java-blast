package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagUseSWTBack
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


internal fun ParseUseSWTBack(js: ObjectNode) =
  js[FlagUseSWTBack]?.let {
    UseSmithWatermanTraceback(it.reqBool(FlagUseSWTBack))
  } ?: UseSmithWatermanTraceback()


@JvmInline
value class UseSmithWatermanTraceback(val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagUseSWTBack, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagUseSWTBack)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagUseSWTBack)
}