package org.veupathdb.lib.blast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BlastFormatter")
class BlastFormatterTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Nested
  @DisplayName(Flag.RequestID)
  class RequestID
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastFormatter();
      tgt.setRequestID("hi");

      assertEquals("{\"-rid\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-rid\":\"hi\"}";
      var tgt = json.readValue(raw, BlastFormatter.class);

      assertEquals("hi", tgt.getRequestID());
    }
  }

  @Nested
  @DisplayName(Flag.ArchiveFile)
  class ArchiveFile
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastFormatter();
      tgt.setArchiveFile("hi");

      assertEquals("{\"-archive\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-archive\":\"hi\"}";
      var tgt = json.readValue(raw, BlastFormatter.class);

      assertEquals("hi", tgt.getArchiveFile());
    }
  }
}