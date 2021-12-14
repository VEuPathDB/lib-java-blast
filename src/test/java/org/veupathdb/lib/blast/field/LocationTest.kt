package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.Exception
import kotlin.Throws

@DisplayName("Location")
internal class LocationTest {
  private val json = ObjectMapper()
  @Test
  @DisplayName("location serialization")
  @Throws(Exception::class)
  fun test1() {
    val tgt = Location(10, 12)
    Assertions.assertEquals("{\"start\":10,\"stop\":12}", json.writeValueAsString(tgt))
  }

  @Test
  @DisplayName("location deserialization")
  @Throws(Exception::class)
  fun test2() {
    val raw = "{\"start\":10,\"stop\":12}"
    val (start, stop) = json.readValue(raw, Location::class.java)
    Assertions.assertEquals(10, start)
    Assertions.assertEquals(12, stop)
  }
}