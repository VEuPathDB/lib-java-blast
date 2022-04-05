package org.veupathdb.lib.blast.common.fields

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.veupathdb.lib.blast.common.FlagDBFile
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.jackson.Json

@DisplayName(FlagDBFile)
internal class DBFileTest : BlastFieldImplTest() {

  override fun blank() = DBFile()
  override fun populated() = DBFile("yo-yo")
  override val jsonString = """{"$FlagDBFile":"yo-yo"}"""
  override val cliString = "$FlagDBFile 'yo-yo'"
  override val argList = listOf(FlagDBFile, "yo-yo")

  @Nested
  @DisplayName("ParseDBFile()")
  inner class Parse {

    @Nested
    @DisplayName("when given a JSON object containing a non-text value")
    inner class NonString {

      @Test
      @DisplayName("throws an exception")
      fun t1() {
        assertThrows<IllegalArgumentException> {
          ParseDBFile(Json.new { put(FlagDBFile, 40) })
        }
      }
    }

    @Nested
    @DisplayName("when given a JSON object with no db file value")
    inner class Absent {

      @Test
      @DisplayName("returns a defaulted DBFile instance")
      fun t1() {
        assertTrue(ParseDBFile(Json.new {}).isDefault)
      }
    }

    @Nested
    @DisplayName("when given a JSON object containing a text value")
    inner class Present {

      @Test
      @DisplayName("returns a DBFile instance wrapping")
      fun t1() {
        val inp = Json.newObject { put(FlagDBFile, "bunny") }
        assertEquals("bunny", ParseDBFile(inp).file)
      }
    }
  }
}