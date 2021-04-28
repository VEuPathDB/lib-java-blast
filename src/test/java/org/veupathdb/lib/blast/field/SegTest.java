package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Seg")
class SegTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Test
  @DisplayName("\"yes\" seg serialization")
  void yesDustOut() throws Exception {
    var tgt = Seg.yesSeg();
    assertEquals("\"yes\"", json.writeValueAsString(tgt));
  }

  @Test
  @DisplayName("\"yes\" seg deserialization")
  void yesDustIn() throws Exception {
    var raw = "\"yes\"";
    var tgt = json.readValue(raw, Seg.class);
    assertTrue(tgt.isYes());
  }

  @Test
  @DisplayName("\"no\" seg serialization")
  void noDustOut() throws Exception {
    var tgt = Seg.noSeg();
    assertEquals("\"no\"", json.writeValueAsString(tgt));
  }

  @Test
  @DisplayName("\"no\" seg deserialization")
  void noDustIn() throws Exception {
    var raw = "\"no\"";
    var tgt = json.readValue(raw, Seg.class);
    assertTrue(tgt.isNo());
  }

  @Test
  @DisplayName("\"wlh\" seg serialization")
  void wlhDustOut() throws Exception {
    var tgt = Seg.wlhSeg(10, 12, 14);
    assertEquals("{\"window\":10,\"locut\":12.0,\"hicut\":14.0}", json.writeValueAsString(tgt));
  }

  @Test
  @DisplayName("\"wlh\" seg deserialization")
  void wlhDustIn() throws Exception {
    var raw = "{\"window\":10,\"locut\":12,\"hicut\":14}";
    var tgt = json.readValue(raw, Seg.class);
    assertEquals(10, tgt.getWindow());
    assertEquals(12, tgt.getLocut());
    assertEquals(14, tgt.getHicut());
  }

  @Nested
  @DisplayName("::fromJSON(JsonNode)")
  class FromJSON1
  {
    @Test
    @DisplayName("invalid string value")
    void test1() {
      assertThrows(
        IllegalArgumentException.class,
        () -> Seg.fromJSON(TextNode.valueOf("hi"))
      );
    }

    @Test
    @DisplayName("invalid object value")
    void test2() {
      assertThrows(
        IllegalArgumentException.class,
        () -> Seg.fromJSON(json.createObjectNode())
      );
    }

    @Test
    @DisplayName("invalid array value")
    void test3() {
      assertThrows(
        IllegalArgumentException.class,
        () -> Seg.fromJSON(json.createArrayNode())
      );
    }
  }
}