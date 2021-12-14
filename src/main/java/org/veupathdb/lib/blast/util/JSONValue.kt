package org.veupathdb.lib.blast.util

import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode

interface JSONValue {
  @JsonValue
  fun toJSON(): JsonNode
}