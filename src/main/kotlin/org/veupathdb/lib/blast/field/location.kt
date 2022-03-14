package org.veupathdb.lib.blast.field

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


sealed class Location(
  val key:   String,
  val start: UInt,
  val stop:  UInt
) : BlastField {
  override val isDefault
    get() = start == DefStart && stop == DefStop

  override fun appendJson(js: ObjectNode) {
    if (!isDefault)
      with(js.putObject(key)) {
        put(KeyStart, start.toLong())
        put(KeyStop, stop.toLong())
      }
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ')
        .append(key)
        .append(" '")
        .append(start.toLong())
        .append('-')
        .append(stop.toLong())
        .append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(key)
      cli.add("$start-$stop")
    }
  }
}


////////////////////////////////////////////////////////////////////////////////




////////////////////////////////////////////////////////////////////////////////


internal fun ParseSubjectLocation(js: ObjectNode): SubjectLocation {
  val obj = js[FlagSubjectLocation] ?: return SubjectLocation()
  obj.isObject || return SubjectLocation()
  obj as ObjectNode

  return SubjectLocation(
    obj.get(KeyStart)?.longValue()?.toUInt() ?: DefStart,
    obj.get(KeyStop)?.longValue()?.toUInt() ?: DefStop
  )
}


class SubjectLocation(
  start: UInt = DefStart,
  stop:  UInt = DefStop,
) : Location(FlagSubjectLocation, start, stop)
