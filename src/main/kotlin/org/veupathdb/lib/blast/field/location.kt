package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField

private const val DefaultLocationStart = 0u
private const val DefaultLocationStop  = 0u
private const val KeyStart = "start"
private const val KeyStop  = "stop"


sealed class Location(
  val key:   String,
  val start: UInt,
  val stop:  UInt
) : BlastField {
  override val isDefault
    get() = start == DefaultLocationStart && stop == DefaultLocationStop

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      with(json.putObject(key)) {
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


private const val KeyQueryLoc = "-query_loc"


internal fun ParseQueryLocation(js: ObjectNode): QueryLocation {
  val obj = js[KeyQueryLoc] ?: return QueryLocation()
  obj.isObject || return QueryLocation()
  obj as ObjectNode

  return QueryLocation(
    obj.get(KeyStart)?.longValue()?.toUInt() ?: DefaultLocationStart,
    obj.get(KeyStop)?.longValue()?.toUInt() ?: DefaultLocationStop
  )
}


class QueryLocation(
  start: UInt = DefaultLocationStart,
  stop:  UInt = DefaultLocationStop,
) : Location(KeyQueryLoc, start, stop)


////////////////////////////////////////////////////////////////////////////////


private const val KeySubjectLoc = "-subject_loc"


internal fun ParseSubjectLocation(js: ObjectNode): SubjectLocation {
  val obj = js[KeySubjectLoc] ?: return SubjectLocation()
  obj.isObject || return SubjectLocation()
  obj as ObjectNode

  return SubjectLocation(
    obj.get(KeyStart)?.longValue()?.toUInt() ?: DefaultLocationStart,
    obj.get(KeyStop)?.longValue()?.toUInt() ?: DefaultLocationStop
  )
}


class SubjectLocation(
  start: UInt = DefaultLocationStart,
  stop:  UInt = DefaultLocationStop,
) : Location(KeySubjectLoc, start, stop)
