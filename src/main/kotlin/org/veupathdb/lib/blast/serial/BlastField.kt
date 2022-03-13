package org.veupathdb.lib.blast.serial

import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.jackson.Json

interface BlastField {

  val isDefault: Boolean

  @JsonValue
  fun toJson() = Json.new(this::appendJson)

  fun appendJson(js: ObjectNode)

  fun appendCliSegment(cli: StringBuilder)

  fun appendCliParts(cli: MutableList<String>)
}