package org.veupathdb.lib.blast.field

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Key
import org.veupathdb.lib.blast.util.JSONConstructor

@DisplayName("Seg")
class SegTest
{
  @Nested
  @DisplayName("#isYes")
  inner class IsYes1
  {
    @Test
    @DisplayName("Returns true for \"yes\" seg values")
    fun test1() {
      assertTrue(Seg.YesSeg.isYes)
    }

    @Test
    @DisplayName("Returns false for \"no\" seg values")
    fun test2() {
      assertFalse(Seg.NoSeg.isYes)
    }

    @Test
    @DisplayName("Returns false for wlh seg values")
    fun test3() {
      assertFalse(Seg.newWLHSeg(0, 0.0, 0.0).isYes)
    }
  }

  @Nested
  @DisplayName("#isNo")
  inner class IsNo1
  {
    @Test
    @DisplayName("Returns false for \"yes\" seg values")
    fun test1() {
      assertFalse(Seg.YesSeg.isNo)
    }

    @Test
    @DisplayName("Returns true for \"no\" seg values")
    fun test2() {
      assertTrue(Seg.NoSeg.isNo)
    }

    @Test
    @DisplayName("Returns false for wlh seg values")
    fun test3() {
      assertFalse(Seg.newWLHSeg(0, 0.0, 0.0).isNo)
    }
  }

  @Nested
  @DisplayName("#isWLH")
  inner class IsWLH1
  {
    @Test
    @DisplayName("Returns false for \"yes\" seg values")
    fun test1() {
      assertFalse(Seg.YesSeg.isWLH)
    }

    @Test
    @DisplayName("Returns false for \"no\" seg values")
    fun test2() {
      assertFalse(Seg.NoSeg.isWLH)
    }

    @Test
    @DisplayName("Returns true for wlh seg values")
    fun test3() {
      assertTrue(Seg.newWLHSeg(0, 0.0, 0.0).isWLH)
    }
  }

  @Nested
  @DisplayName("#getWindow()")
  inner class GetWindow1
  {
    @Test
    @DisplayName("Throws exception when called on \"yes\" seg values")
    fun test1() {
      assertThrows(UnsupportedOperationException::class.java) { Seg.YesSeg.window }
    }

    @Test
    @DisplayName("Throws exception when called on \"no\" seg values")
    fun test2() {
      assertThrows(UnsupportedOperationException::class.java) { Seg.NoSeg.window }
    }

    @Test
    @DisplayName("Returns the set window value on wlh seg values")
    fun test3() {
      assertEquals(10, Seg.newWLHSeg(10, 0.0, 0.0).window)
    }
  }

  @Nested
  @DisplayName("#getLocut()")
  inner class GetLocut1
  {
    @Test
    @DisplayName("Throws exception when called on \"yes\" seg values")
    fun test1() {
      assertThrows(UnsupportedOperationException::class.java) { Seg.YesSeg.locut }
    }

    @Test
    @DisplayName("Throws exception when called on \"no\" seg values")
    fun test2() {
      assertThrows(UnsupportedOperationException::class.java) { Seg.NoSeg.locut }
    }

    @Test
    @DisplayName("Returns the set locut value on wlh seg values")
    fun test3() {
      assertEquals(22.22, Seg.newWLHSeg(10, 22.22, 0.0).locut)
    }
  }

  @Nested
  @DisplayName("#getHicut()")
  inner class GetHicut1
  {
    @Test
    @DisplayName("Throws exception when called on \"yes\" seg values")
    fun test1() {
      assertThrows(UnsupportedOperationException::class.java) { Seg.YesSeg.hicut }
    }

    @Test
    @DisplayName("Throws exception when called on \"no\" seg values")
    fun test2() {
      assertThrows(UnsupportedOperationException::class.java) { Seg.NoSeg.hicut }
    }

    @Test
    @DisplayName("Returns the set hicut value on wlh seg values")
    fun test3() {
      assertEquals(33.33, Seg.newWLHSeg(10, 22.22, 33.33).hicut)
    }
  }

  @Nested
  @DisplayName("#isDefault()")
  inner class IsDefault1
  {
    @Test
    @DisplayName("Returns false for \"yes\" seg values")
    fun test1() {
      assertFalse(Seg.YesSeg.isDefault)
    }

    @Test
    @DisplayName("Returns true for \"no\" seg values")
    fun test2() {
      assertTrue(Seg.NoSeg.isDefault)
    }

    @Test
    @DisplayName("Returns false for wlh seg values")
    fun test3() {
      assertFalse(Seg.newWLHSeg(0, 0.0, 0.0).isDefault)
    }
  }

  @Nested
  @DisplayName("::fromJSON(JsonNode)")
  inner class FromJSON1
  {
    @Test
    @DisplayName("Returns a \"yes\" seg instance when the input value is \"yes\"")
    fun test1() {
      assertTrue(Seg.fromJSON(JSONConstructor.newText("yes")).isYes)
    }

    @Test
    @DisplayName("Returns a \"no\" seg instance when the input value is \"no\"")
    fun test2() {
      assertTrue(Seg.fromJSON(JSONConstructor.newText("no")).isNo)
    }

    @Test
    @DisplayName("Returns a wlh seg instance when the input value is an object")
    fun test3() {
      val input = JSONConstructor.newObject()
        .put(Key.Window, 10)
        .put(Key.Locut, 11)
        .put(Key.Hicut, 12)
      val test = Seg.fromJSON(input)
      assertTrue(test.isWLH)
      assertEquals(10, test.window)
      assertEquals(11.0, test.locut)
      assertEquals(12.0, test.hicut)
    }
  }
}