package org.veupathdb.lib.blast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BlastWithIPGList")
abstract class BlastWithIPGListContractTest extends BlastWithListsContractTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Override
  abstract BlastWithIPGList newConfig();

  @Override
  abstract Class<? extends BlastWithIPGList> configClass();

  @Nested
  @DisplayName(Flag.IPGList)
  class IPGList1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = newConfig();
      tgt.setIPGList("hi");

      assertEquals("{\"-ipglist\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-ipglist\":\"hi\"}";
      var tgt = json.readValue(raw, configClass());

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
      var tgt = newConfig();
      tgt.setNegativeIPGList("hi");

      assertEquals("{\"-negative_ipglist\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-negative_ipglist\":\"hi\"}";
      var tgt = json.readValue(raw, configClass());

      assertEquals("hi", tgt.getNegativeIPGList());
    }
  }
}