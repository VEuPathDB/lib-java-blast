package org.veupathdb.lib.blast;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ListBlast")
class ListBlastTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Nested
  @DisplayName(Flag.GIList)
  class GIList1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastWithLists();
      tgt.setGIList("hi");

      assertEquals("{\"-gilist\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-gilist\":\"hi\"}";
      var tgt = json.readValue(raw, BlastWithLists.class);

      assertEquals("hi", tgt.getGIList());
    }
  }

  @Nested
  @DisplayName(Flag.SequenceIDList)
  class SequenceIDList1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastWithLists();
      tgt.setSequenceIDList("hi");

      assertEquals("{\"-seqidlist\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-seqidlist\":\"hi\"}";
      var tgt = json.readValue(raw, BlastWithLists.class);

      assertEquals("hi", tgt.getSequenceIDList());
    }
  }

  @Nested
  @DisplayName(Flag.NegativeGIList)
  class NegativeGIList1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastWithLists();
      tgt.setNegativeGIList("hi");

      assertEquals("{\"-negative_gilist\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-negative_gilist\":\"hi\"}";
      var tgt = json.readValue(raw, BlastWithLists.class);

      assertEquals("hi", tgt.getNegativeGIList());
    }
  }

  @Nested
  @DisplayName(Flag.NegativeSequenceIDList)
  class NegativeSequenceIDList1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastWithLists();
      tgt.setNegativeSequenceIDList("hi");

      assertEquals("{\"-negative_seqidlist\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-negative_seqidlist\":\"hi\"}";
      var tgt = json.readValue(raw, BlastWithLists.class);

      assertEquals("hi", tgt.getNegativeSequenceIDList());
    }
  }

  @Nested
  @DisplayName(Flag.TaxIDs)
  class TaxIDs1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt  = new BlastWithLists();
      var list = new ArrayList<String>();
      list.add("hi");
      tgt.setTaxIDs(list);

      assertEquals("{\"-taxids\":[\"hi\"]}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-taxids\":[\"hi\"]}";
      var tgt = json.readValue(raw, BlastWithLists.class);

      assertNotNull(tgt.getTaxIDs());
      assertEquals(1, tgt.getTaxIDs().size());
      assertEquals("hi", tgt.getTaxIDs().get(0));
    }
  }

  @Nested
  @DisplayName(Flag.NegativeTaxIDs)
  class NegativeTaxIDs1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt  = new BlastWithLists();
      var list = new ArrayList<String>();
      list.add("hi");
      tgt.setNegativeTaxIDs(list);

      assertEquals("{\"-negative_taxids\":[\"hi\"]}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-negative_taxids\":[\"hi\"]}";
      var tgt = json.readValue(raw, BlastWithLists.class);

      assertNotNull(tgt.getNegativeTaxIDs());
      assertEquals(1, tgt.getNegativeTaxIDs().size());
      assertEquals("hi", tgt.getNegativeTaxIDs().get(0));
    }
  }

  @Nested
  @DisplayName(Flag.TaxIDList)
  class TaxIDList1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastWithLists();
      tgt.setTaxIDList("hi");

      assertEquals("{\"-taxidlist\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-taxidlist\":\"hi\"}";
      var tgt = json.readValue(raw, BlastWithLists.class);

      assertEquals("hi", tgt.getTaxIDList());
    }
  }

  @Nested
  @DisplayName(Flag.NegativeTaxIDList)
  class NegativeTaxIDList1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastWithLists();
      tgt.setNegativeTaxIDList("hi");

      assertEquals("{\"-negative_taxidlist\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-negative_taxidlist\":\"hi\"}";
      var tgt = json.readValue(raw, BlastWithLists.class);

      assertEquals("hi", tgt.getNegativeTaxIDList());
    }
  }
}