package org.veupathdb.lib.blast.common.fields

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.veupathdb.lib.blast.common.FlagMaxHSPs
import org.veupathdb.lib.jackson.Json

@DisplayName(FlagMaxHSPs)
internal class MaxHSPsTest {

  @Nested
  @DisplayName("ParseMaxHSPs()")
  inner class Parse {

    @Nested
    @DisplayName("when given a JSON object containing an int value greater than or equal to 1")
    inner class InRange {

      @Test
      @DisplayName("returns a new MaxHSPs instance wrapping that value")
      fun t1() {
        for (i in 1u .. 10u) {
          val inp = Json.newObject { put(FlagMaxHSPs, i.toInt()) }
          assertEquals(i, ParseMaxHSPs(inp).value)
        }
      }
    }

    @Nested
    @DisplayName("when given a JSON object containing an int value less than 1")
    inner class OutOfRange {

      @Test
      @DisplayName("throws an exception")
      fun t1() {
        assertThrows<IllegalArgumentException> {
          ParseMaxHSPs(Json.new { put(FlagMaxHSPs, 0) })
        }
      }
    }

    @Nested
    @DisplayName("when given a JSON object that does not contain this flag")
    inner class Absent {

      @Test
      @DisplayName("returns a defaulted MaxHSPs instance")
      fun t1() {
        assertTrue(ParseMaxHSPs(Json.new {}).isDefault)
      }
    }

    @Nested
    @DisplayName("when given a JSON object containing a non-integral value")
    inner class BadType {

      @Test
      @DisplayName("throws an exception")
      fun t1() {
        assertThrows<IllegalArgumentException> {
          ParseMaxHSPs(Json.new { put(FlagMaxHSPs, "nope") })
        }
      }
    }
  }

  @Nested
  @DisplayName("MaxHSPs()")
  inner class Type {

    @Nested
    @DisplayName("when constructed with no arguments")
    inner class NoArg {

      @Test
      @DisplayName("isDefault == true")
      fun t1() {
        assertTrue(MaxHSPs().isDefault)
      }

      @Test
      @DisplayName("appendJson() does nothing")
      fun t2() {
        val inp = Json.newObject()
        MaxHSPs().appendJson(inp)
        assertEquals(0, inp.size())
      }

      @Test
      @DisplayName("appendCliSegment() does nothing")
      fun t3() {
        val inp = StringBuilder(0)
        MaxHSPs().appendCliSegment(inp)
        assertEquals(0, inp.length)
      }

      @Test
      @DisplayName("appendCliParts() does nothing")
      fun t4() {
        val inp = ArrayList<String>(0)
        MaxHSPs().appendCliParts(inp)
        assertEquals(0, inp.size)
      }
    }

    @Nested
    @DisplayName("when constructed with an argument")
    inner class Arg {

      @Test
      @DisplayName("isDefault == false")
      fun t1() {
        assertFalse(MaxHSPs(1u).isDefault)
      }

      @Test
      @DisplayName("appendJson() appends the value to the input JSON object")
      fun t2() {
        val inp = Json.newObject()
        MaxHSPs(1u).appendJson(inp)
        assertEquals("{\"$FlagMaxHSPs\":1}", inp.toString())
      }

      @Test
      @DisplayName("appendCliSegment() appends the value to the input StringBuilder")
      fun t3() {
        val inp = StringBuilder(32)
        MaxHSPs(1u).appendCliSegment(inp)
        assertEquals(" $FlagMaxHSPs 1", inp.toString())
      }

      @Test
      @DisplayName("appendCliParts() appends the value to the input list")
      fun t4() {
        val inp = ArrayList<String>(2)
        MaxHSPs(1u).appendCliParts(inp)
        assertEquals(2, inp.size)
        assertEquals(FlagMaxHSPs, inp[0])
        assertEquals("1", inp[1])
      }
    }
  }
}