package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.consts.Key
import org.veupathdb.lib.blast.util.JSONConstructor
import org.veupathdb.lib.blast.util.JSONValue

data class Location(val start: Int, val stop: Int) : JSONValue {

  @JsonCreator
  constructor(js: JsonNode) : this(js.get(Key.Start).intValue(), js.get(Key.Stop).intValue())

  override fun toString() = "$start-$stop"

  @JsonValue
  override fun toJSON(): JsonNode = JSONConstructor.newObject()
    .set<ObjectNode>(Key.Start, JSONConstructor.newInt(start))
    .set<ObjectNode>(Key.Stop, JSONConstructor.newInt(stop))

  companion object {
    @JvmStatic
    fun fromString(value: String): Location {
      val dashPos = value.indexOf('-')
      if (dashPos < 1)
        throw IllegalArgumentException("Invalid location string")

      val start: Int
      val stop: Int

      try {
        start = Integer.parseInt(value.substring(0, dashPos))
        stop = Integer.parseInt(value.substring(dashPos + 1))
      } catch (e: Exception) {
        throw IllegalArgumentException(e)
      }

      return Location(start, stop)
    }
  }
}
