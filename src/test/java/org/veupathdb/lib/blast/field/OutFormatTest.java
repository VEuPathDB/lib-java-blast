package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("OutFormat")
class OutFormatTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Test
  @DisplayName("format serialization")
  void test1() throws Exception {
    var tgt = new OutFormat();
    assertEquals("{}", json.writeValueAsString(tgt));

    tgt.setType(FormatType.Pairwise);
    assertEquals("{\"type\":0}", json.writeValueAsString(tgt));

    tgt.setDelimiter("@");
    assertEquals("{\"type\":0,\"delimiter\":\"@\"}", json.writeValueAsString(tgt));

    tgt.getFields().add(FormatField.BitScore);
    assertEquals("{\"type\":0,\"delimiter\":\"@\",\"fields\":[\"bitscore\"]}", json.writeValueAsString(tgt));
  }

  @Test
  @DisplayName("format deserialization")
  void test2() throws Exception {
    var raw = "{}";
    var tgt = json.readValue(raw, OutFormat.class);

    assertNull(tgt.getType());
    assertNull(tgt.getDelimiter());
    assertTrue(tgt.getFields().isEmpty());

    raw = "{\"type\":6}";
    tgt = json.readValue(raw, OutFormat.class);

    assertEquals(FormatType.Tabular, tgt.getType());
    assertNull(tgt.getDelimiter());
    assertTrue(tgt.getFields().isEmpty());

    raw = "{\"type\":6,\"delimiter\":\"$\"}";
    tgt = json.readValue(raw, OutFormat.class);

    assertEquals(FormatType.Tabular, tgt.getType());
    assertEquals("$", tgt.getDelimiter());
    assertTrue(tgt.getFields().isEmpty());

    raw = "{\"type\":6,\"delimiter\":\"$\",\"fields\":[\"bitscore\"]}";
    tgt = json.readValue(raw, OutFormat.class);

    assertEquals(FormatType.Tabular, tgt.getType());
    assertEquals("$", tgt.getDelimiter());
    assertEquals(1, tgt.getFields().size());
    assertEquals(FormatField.BitScore, tgt.getFields().get(0));
  }
}