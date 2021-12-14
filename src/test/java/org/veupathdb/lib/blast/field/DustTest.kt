package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.field.Dust.Companion.lwlDust
import org.veupathdb.lib.blast.field.Dust.Companion.noDust
import org.veupathdb.lib.blast.field.Dust.Companion.yesDust

@DisplayName("Dust")
internal class DustTest {
  private val json = ObjectMapper()
  @Test
  @DisplayName("\"yes\" dust serialization")
  @Throws(Exception::class)
  fun yesDustOut() {
    val tgt = yesDust()
    Assertions.assertEquals("\"yes\"", json.writeValueAsString(tgt))
  }

  @Test
  @DisplayName("\"yes\" dust deserialization")
  @Throws(Exception::class)
  fun yesDustIn() {
    val raw = "\"yes\""
    val tgt = json.readValue(raw, Dust::class.java)
    Assertions.assertTrue(tgt.isYes)
  }

  @Test
  @DisplayName("\"no\" dust serialization")
  @Throws(Exception::class)
  fun noDustOut() {
    val tgt = noDust()
    Assertions.assertEquals("\"no\"", json.writeValueAsString(tgt))
  }

  @Test
  @DisplayName("\"no\" dust deserialization")
  @Throws(Exception::class)
  fun noDustIn() {
    val raw = "\"no\""
    val tgt = json.readValue(raw, Dust::class.java)
    Assertions.assertTrue(tgt.isNo)
  }

  @Test
  @DisplayName("\"lwl\" dust serialization")
  @Throws(Exception::class)
  fun lwlDustOut() {
    val tgt = lwlDust(10, 12, 14)
    Assertions.assertEquals("{\"level\":10,\"window\":12,\"linker\":14}", json.writeValueAsString(tgt))
  }

  @Test
  @DisplayName("\"lwl\" dust deserialization")
  @Throws(Exception::class)
  fun lwlDustIn() {
    val raw = "{\"level\": 10,\"window\": 12, \"linker\": 14}"
    val tgt = json.readValue(raw, Dust::class.java)
    Assertions.assertEquals(10, tgt.level)
    Assertions.assertEquals(12, tgt.window)
    Assertions.assertEquals(14, tgt.linker)
  }
}