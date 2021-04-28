package org.veupathdb.lib.blast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("IPGListBlast")
class IPGListBlastTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Nested
  @DisplayName(Flag.IPGList)
  class IPGList1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new IPGListBlast();
      tgt.setIPGList("hi");

      assertEquals("{\"-ipglist\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-ipglist\":\"hi\"}";
      var tgt = json.readValue(raw, IPGListBlast.class);

      assertEquals("hi", tgt.getIPGList());
    }
  }

  @Nested
  @DisplayName(Flag.NegativeIPGList)
  class NegativeIPGList1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new IPGListBlast();
      tgt.setNegativeIPGList("hi");

      assertEquals("{\"-negative_ipglist\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-negative_ipglist\":\"hi\"}";
      var tgt = json.readValue(raw, IPGListBlast.class);

      assertEquals("hi", tgt.getNegativeIPGList());
    }
  }
}