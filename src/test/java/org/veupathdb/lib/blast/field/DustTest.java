package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dust")
class DustTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Test
  @DisplayName("\"yes\" dust serialization")
  void yesDustOut() throws Exception {
    var tgt = Dust.yesDust();
    assertEquals("\"yes\"", json.writeValueAsString(tgt));
  }

  @Test
  @DisplayName("\"yes\" dust deserialization")
  void yesDustIn() throws Exception {
    var raw = "\"yes\"";
    var tgt = json.readValue(raw, Dust.class);
    assertTrue(tgt.isYes());
  }

  @Test
  @DisplayName("\"no\" dust serialization")
  void noDustOut() throws Exception {
    var tgt = Dust.noDust();
    assertEquals("\"no\"", json.writeValueAsString(tgt));
  }

  @Test
  @DisplayName("\"no\" dust deserialization")
  void noDustIn() throws Exception {
    var raw = "\"no\"";
    var tgt = json.readValue(raw, Dust.class);
    assertTrue(tgt.isNo());
  }

  @Test
  @DisplayName("\"lwl\" dust serialization")
  void lwlDustOut() throws Exception {
    var tgt = Dust.lwlDust(10, 12, 14);
    assertEquals("{\"level\":10,\"window\":12,\"linker\":14}", json.writeValueAsString(tgt));
  }

  @Test
  @DisplayName("\"lwl\" dust deserialization")
  void lwlDustIn() throws Exception {
    var raw = "{\"level\": 10,\"window\": 12, \"linker\": 14}";
    var tgt = json.readValue(raw, Dust.class);
    assertEquals(10, tgt.getLevel());
    assertEquals(12, tgt.getWindow());
    assertEquals(14, tgt.getLinker());
  }
}