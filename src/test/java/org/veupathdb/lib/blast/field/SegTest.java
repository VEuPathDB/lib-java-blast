package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.util.JSONConstructor;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Seg")
class SegTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Nested
  @DisplayName("#isYes()")
  class IsYes1
  {
    @Test
    @DisplayName("Returns true for \"yes\" seg values")
    void test1() {
      assertTrue(Seg.newYesSeg().isYes());
    }

    @Test
    @DisplayName("Returns false for \"no\" seg values")
    void test2() {
      assertFalse(Seg.newNoSeg().isYes());
    }

    @Test
    @DisplayName("Returns false for wlh seg values")
    void test3() {
      assertFalse(Seg.newWLHSeg(0, 0, 0).isYes());
    }
  }

  @Nested
  @DisplayName("#isNo()")
  class IsNo1
  {
    @Test
    @DisplayName("Returns false for \"yes\" seg values")
    void test1() {
      assertFalse(Seg.newYesSeg().isNo());
    }

    @Test
    @DisplayName("Returns true for \"no\" seg values")
    void test2() {
      assertTrue(Seg.newNoSeg().isNo());
    }

    @Test
    @DisplayName("Returns false for wlh seg values")
    void test3() {
      assertFalse(Seg.newWLHSeg(0, 0, 0).isNo());
    }
  }

  @Nested
  @DisplayName("#isWLH()")
  class IsWLH1
  {
    @Test
    @DisplayName("Returns false for \"yes\" seg values")
    void test1() {
      assertFalse(Seg.newYesSeg().isWLH());
    }

    @Test
    @DisplayName("Returns false for \"no\" seg values")
    void test2() {
      assertFalse(Seg.newNoSeg().isWLH());
    }

    @Test
    @DisplayName("Returns true for wlh seg values")
    void test3() {
      assertTrue(Seg.newWLHSeg(0, 0, 0).isWLH());
    }
  }

  @Nested
  @DisplayName("#getWindow()")
  class GetWindow1
  {
    @Test
    @DisplayName("Throws exception when called on \"yes\" seg values")
    void test1() {
      assertThrows(UnsupportedOperationException.class, Seg.newYesSeg()::getWindow);
    }

    @Test
    @DisplayName("Throws exception when called on \"no\" seg values")
    void test2() {
      assertThrows(UnsupportedOperationException.class, Seg.newNoSeg()::getWindow);
    }

    @Test
    @DisplayName("Returns the set window value on wlh seg values")
    void test3() {
      assertEquals(10, Seg.newWLHSeg(10, 0, 0).getWindow());
    }
  }

  @Nested
  @DisplayName("#getLocut()")
  class GetLocut1
  {
    @Test
    @DisplayName("Throws exception when called on \"yes\" seg values")
    void test1() {
      assertThrows(UnsupportedOperationException.class, Seg.newYesSeg()::getLocut);
    }

    @Test
    @DisplayName("Throws exception when called on \"no\" seg values")
    void test2() {
      assertThrows(UnsupportedOperationException.class, Seg.newNoSeg()::getLocut);
    }

    @Test
    @DisplayName("Returns the set locut value on wlh seg values")
    void test3() {
      assertEquals(22.22, Seg.newWLHSeg(10, 22.22, 0).getLocut());
    }
  }

  @Nested
  @DisplayName("#getHicut()")
  class GetHicut1
  {
    @Test
    @DisplayName("Throws exception when called on \"yes\" seg values")
    void test1() {
      assertThrows(UnsupportedOperationException.class, Seg.newYesSeg()::getHicut);
    }

    @Test
    @DisplayName("Throws exception when called on \"no\" seg values")
    void test2() {
      assertThrows(UnsupportedOperationException.class, Seg.newNoSeg()::getHicut);
    }

    @Test
    @DisplayName("Returns the set hicut value on wlh seg values")
    void test3() {
      assertEquals(33.33, Seg.newWLHSeg(10, 22.22, 33.33).getHicut());
    }
  }

  @Nested
  @DisplayName("#isDefault()")
  class IsDefault1
  {
    @Test
    @DisplayName("Returns false for \"yes\" seg values")
    void test1() {
      assertFalse(Seg.newYesSeg().isDefault());
    }

    @Test
    @DisplayName("Returns true for \"no\" seg values")
    void test2() {
      assertTrue(Seg.newNoSeg().isDefault());
    }

    @Test
    @DisplayName("Returns false for wlh seg values")
    void test3() {
      assertFalse(Seg.newWLHSeg(0, 0, 0).isDefault());
    }
  }

  @Nested
  @DisplayName("::fromJSON(JsonNode)")
  class FromJSON1
  {
    @Test
    @DisplayName("Returns a \"yes\" seg instance when the input value is \"yes\"")
    void test1() {
      assertTrue(Seg.fromJSON(JSONConstructor.newText("yes")).isYes());
    }

    @Test
    @DisplayName("Returns a \"no\" seg instance when the input value is \"no\"")
    void test2() {
      assertTrue(Seg.fromJSON(JSONConstructor.newText("no")).isNo());
    }

    @Test
    @DisplayName("Returns a wlh seg instance when the input value is an object")
    void test3() {
      final var input = JSONConstructor.newObject()
        .put(Key.Window, 10)
        .put(Key.Locut, 11)
        .put(Key.Hicut, 12);
      final var test = Seg.fromJSON(input);
      assertTrue(test.isWLH());
      assertEquals(10, test.getWindow());
      assertEquals(11, test.getLocut());
      assertEquals(12, test.getHicut());
    }
  }
}