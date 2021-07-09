package org.veupathdb.lib.blast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.Location;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("BaseBlast")
class BaseBlastTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Nested
  @DisplayName(Flag.QueryFile)
  class QueryFile
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setQueryFile("hi");

      assertEquals("{\"-query\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-query\":\"hi\"}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals("hi", tgt.getQueryFile());
    }
  }

  @Nested
  @DisplayName(Flag.QueryLocation)
  class QueryLocation
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setQueryLocation(new Location(10, 11));

      assertEquals("{\"-query_loc\":{\"start\":10,\"stop\":11}}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-query_loc\":{\"start\":10,\"stop\":11}}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals(10, tgt.getQueryLocation().getStart());
      assertEquals(11, tgt.getQueryLocation().getStop());
    }
  }

  @Nested
  @DisplayName(Flag.DBFile)
  class DBFile
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setDBFile("hi");

      assertEquals("{\"-db\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-db\":\"hi\"}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals("hi", tgt.getDBFile());
    }
  }

  @Nested
  @DisplayName(Flag.ExpectValue)
  class ExpectValue
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setExpectValue("hi");

      assertEquals("{\"-evalue\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-evalue\":\"hi\"}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals("hi", tgt.getExpectValue());
    }
  }

  @Nested
  @DisplayName(Flag.SoftMasking)
  class SoftMasking
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setSoftMasking(true);

      assertEquals("{\"-soft_masking\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-soft_masking\":true}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertTrue(tgt.getSoftMasking());
    }
  }

  @Nested
  @DisplayName(Flag.LowercaseMasking)
  class LowercaseMasking
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setLowercaseMasking(true);

      assertEquals("{\"-lcase_masking\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-lcase_masking\":true}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertTrue(tgt.getLowercaseMasking());
    }
  }

  @Nested
  @DisplayName(Flag.EntrezQuery)
  class EntrezQuery
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setEntrezQuery("hi");

      assertEquals("{\"-entrez_query\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-entrez_query\":\"hi\"}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals("hi", tgt.getEntrezQuery());
    }
  }

  @Nested
  @DisplayName(Flag.QueryCoverageHSPPercent)
  class QueryCoverageHSPPercent
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setQueryCoverageHSPPercent(12.3);

      assertEquals("{\"-qcov_hsp_perc\":12.3}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-qcov_hsp_perc\":12.3}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals(12.3, tgt.getQueryCoverageHSPPercent());
    }
  }

  @Nested
  @DisplayName(Flag.MaxHSPs)
  class MaxHSPs
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setMaxHSPs(12L);

      assertEquals("{\"-max_hsps\":12}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-max_hsps\":12}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals(12, tgt.getMaxHSPs());
    }
  }

  @Nested
  @DisplayName(Flag.DBSize)
  class DBSize
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase();
      tgt.setDBSize((byte) 12);

      assertEquals("{\"-dbsize\":12}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-dbsize\":12}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals((byte) 12, tgt.getDBSize());
    }
  }

  @Nested
  @DisplayName(Flag.SearchSpace)
  class SearchSpace
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setSearchSpace((short) 12);

      assertEquals("{\"-searchsp\":12}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-searchsp\":12}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals((short) 12, tgt.getSearchSpace());
    }
  }

  @Nested
  @DisplayName(Flag.ImportSearchStrategy)
  class ImportSearchStrategy
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setImportSearchStrategy("hi");

      assertEquals("{\"-import_search_strategy\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-import_search_strategy\":\"hi\"}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals("hi", tgt.getImportSearchStrategy());
    }
  }

  @Nested
  @DisplayName(Flag.ExportSearchStrategy)
  class ExportSearchStrategy
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setExportSearchStrategy("hi");

      assertEquals("{\"-export_search_strategy\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-export_search_strategy\":\"hi\"}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals("hi", tgt.getExportSearchStrategy());
    }
  }

  @Nested
  @DisplayName(Flag.ExtensionDropoffUngapped)
  class ExtensionDropoffUngapped
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setExtensionDropoffUngapped(12.3);

      assertEquals("{\"-xdrop_ungap\":12.3}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-xdrop_ungap\":12.3}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals(12.3, tgt.getExtensionDropoffUngapped());
    }
  }

  @Nested
  @DisplayName(Flag.WindowSize)
  class WindowSize
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setWindowSize(12L);

      assertEquals("{\"-window_size\":12}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-window_size\":12}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertEquals(12, tgt.getWindowSize());
    }
  }

  @Nested
  @DisplayName(Flag.Remote)
  class Remote
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastBase(){};
      tgt.setRemote(true);

      assertEquals("{\"-remote\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-remote\":true}";
      var tgt = json.readValue(raw, BlastBase.class);

      assertTrue(tgt.getRemote());
    }
  }
}