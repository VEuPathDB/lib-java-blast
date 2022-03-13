package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqBool


private const val Key = "-use_sw_traceback"


internal fun ParseUseSWTBack(js: ObjectNode) =
  js[Key]?.let { UseSmithWatermanTraceback(it.reqBool(Key)) }
    ?: UseSmithWatermanTraceback()


@JvmInline
value class UseSmithWatermanTraceback(val value: Boolean = false) : BlastField {
  override val isDefault get() = !value

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key)
}