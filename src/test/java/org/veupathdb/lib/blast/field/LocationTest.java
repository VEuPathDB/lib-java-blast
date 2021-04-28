package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Location")
class LocationTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Test
  @DisplayName("location serialization")
  void test1() throws Exception {
    var tgt = new Location(10, 12);
    assertEquals("{\"start\":10,\"stop\":12}", json.writeValueAsString(tgt));
  }

  @Test
  @DisplayName("location deserialization")
  void test2() throws Exception {
    var raw = "{\"start\":10,\"stop\":12}";
    var tgt = json.readValue(raw, Location.class);
    assertEquals(10, tgt.getStart());
    assertEquals(12, tgt.getStop());
  }
}