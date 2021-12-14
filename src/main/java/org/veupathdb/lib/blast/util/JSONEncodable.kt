package org.veupathdb.lib.blast.util

import com.fasterxml.jackson.annotation.JsonValue

interface JSONEncodable {
  @JsonValue
  fun toJSON(): JSONObjectEncoder
}