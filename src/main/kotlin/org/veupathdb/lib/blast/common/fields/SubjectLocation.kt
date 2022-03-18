package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagQueryLocation
import org.veupathdb.lib.blast.common.FlagSubjectLocation
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.*
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.requireObject

private const val DefStart = 0u
private const val DefStop  = 0u
private const val KeyStart = "start"
private const val KeyStop  = "stop"



internal fun ParseSubjectLocation(js: ObjectNode): SubjectLocation {
  val obj = js[FlagSubjectLocation]?.requireObject(FlagSubjectLocation)
    ?: return SubjectLocation()

  return SubjectLocation(
    obj[KeyStart]?.reqUInt { "$FlagSubjectLocation.$KeyStart" } ?: DefStart,
    obj[KeyStop]?.reqUInt { "$FlagSubjectLocation.$KeyStop" } ?: DefStop
  )
}


data class SubjectLocation(val start: UInt = DefStart, val stop: UInt = DefStop)
  : BlastField
{
  init {
    if (stop < start)
      throw IllegalArgumentException("$FlagQueryLocation stop cannot be greater than the start.  Given value: $start-$stop")
  }

  override val isDefault get() = start == DefStart && stop == DefStop

  override fun appendJson(js: ObjectNode) {
    if(!isDefault) {
      with(js.putObject(FlagSubjectLocation)) {
        put(KeyStart, start.toLong())
        put(KeyStop, stop.toLong())
      }
    }
  }

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagSubjectLocation) { "$start-$stop" }

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagSubjectLocation) { "$start-$stop" }
}
