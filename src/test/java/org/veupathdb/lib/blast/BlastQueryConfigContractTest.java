package org.veupathdb.lib.blast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.ExpectValue;
import org.veupathdb.lib.blast.field.Location;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("BlastQueryConfig")
public abstract class BlastQueryConfigContractTest extends BlastConfigContractTest
{
  private static final ObjectMapper json = new ObjectMapper();

  @Override
  abstract BlastQueryConfig newConfig();

  @Override
  abstract Class<? extends BlastQueryConfig> configClass();

  @Nested
  @DisplayName(Flag.QueryFile)
  class QueryFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setQueryFile(null);
      assertNull(test.getQueryFile());

      test.setQueryFile("hello");
      assertEquals("hello", test.getQueryFile().value());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-query": "hello"
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals("hello", parsed.getQueryFile().value());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setQueryFile("goodbye");

      assertEquals("{\"-query\":\"goodbye\"}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.QueryLocation)
  class QueryLocationFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setQueryLocation(null);
      assertNull(test.getQueryLocation());

      test.setQueryLocation(new Location(10, 12));
      assertEquals(new Location(10, 12), test.getQueryLocation());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-query_loc": {
            "start": 10,
            "stop": 12
          }
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals(new Location(10, 12), parsed.getQueryLocation());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setQueryLocation(new Location(10, 12));

      assertEquals("{\"-query_loc\":{\"start\":10,\"stop\":12}}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.DBFile)
  class DBFileFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setDBFile(null);
      assertNull(test.getDBFile());

      test.setDBFile("yelp");
      assertEquals("yelp", test.getDBFile());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-db": "yellow"
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals("yellow", parsed.getDBFile());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setDBFile("harps");

      assertEquals("{\"-db\":\"harps\"}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.ExpectValue)
  class ExpectValueFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setExpectValue(null);
      assertNull(test.getExpectValue());

      test.setExpectValue("yelp");
      assertEquals(new ExpectValue("yelp"), test.getExpectValue());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-evalue": "yellow"
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals("yellow", parsed.getExpectValue().value());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setExpectValue("harps");

      assertEquals("{\"-evalue\":\"harps\"}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.SoftMasking)
  class SoftMaskingFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setSoftMasking(null);
      assertNull(test.getSoftMasking());

      test.setSoftMasking(true);
      assertTrue(test.getSoftMasking());

      test.setSoftMasking(false);
      assertFalse(test.getSoftMasking());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input1 = """
        {
          "-soft_masking": true
        }
        """;

      final var test1 = json.readValue(input1, configClass());

      assertTrue(test1.getSoftMasking());

      final var input2 = """
        {
          "-soft_masking": false
        }
        """;

      final var test2 = json.readValue(input2, configClass());

      assertFalse(test2.getSoftMasking());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var test1 = newConfig();

      assertEquals("{}", json.writeValueAsString(test1));

      test1.setSoftMasking(true);

      assertEquals("{\"-soft_masking\":true}", json.writeValueAsString(test1));

      test1.setSoftMasking(false);

      assertEquals("{}", json.writeValueAsString(test1));
    }
  }

  @Nested
  @DisplayName(Flag.LowercaseMasking)
  class LowercaseMaskingFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setLowercaseMasking(null);
      assertNull(test.getLowercaseMasking());

      test.setLowercaseMasking(true);
      assertTrue(test.getLowercaseMasking());

      test.setLowercaseMasking(false);
      assertFalse(test.getLowercaseMasking());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input1 = """
        {
          "-lcase_masking": true
        }
        """;

      final var test1 = json.readValue(input1, configClass());

      assertTrue(test1.getLowercaseMasking());

      final var input2 = """
        {
          "-lcase_masking": false
        }
        """;

      final var test2 = json.readValue(input2, configClass());

      assertFalse(test2.getLowercaseMasking());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var test1 = newConfig();

      assertEquals("{}", json.writeValueAsString(test1));

      test1.setLowercaseMasking(true);

      assertEquals("{\"-lcase_masking\":true}", json.writeValueAsString(test1));

      test1.setLowercaseMasking(false);

      assertEquals("{}", json.writeValueAsString(test1));
    }
  }

  @Nested
  @DisplayName(Flag.EntrezQuery)
  class EntrezQueryFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setEntrezQuery(null);
      assertNull(test.getEntrezQuery());

      test.setEntrezQuery("yelp");
      assertEquals("yelp", test.getEntrezQuery());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-entrez_query": "yellow"
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals("yellow", parsed.getEntrezQuery());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setEntrezQuery("harps");

      assertEquals("{\"-entrez_query\":\"harps\"}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.QueryCoverageHSPPercent)
  class QueryCoverageHSPPercentFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setQueryCoverageHSPPercent(null);
      assertNull(test.getQueryCoverageHSPPercent());

      test.setQueryCoverageHSPPercent(12.34);
      assertEquals(12.34, test.getQueryCoverageHSPPercent());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-qcov_hsp_perc": 32.12
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals(32.12, parsed.getQueryCoverageHSPPercent());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setQueryCoverageHSPPercent(69.69);

      assertEquals("{\"-qcov_hsp_perc\":69.69}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.MaxHSPs)
  class MaxHSPsFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setMaxHSPs(null);
      assertNull(test.getMaxHSPs());

      test.setMaxHSPs(12L);
      assertEquals(12, test.getMaxHSPs());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-max_hsps": 32
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals(32, parsed.getMaxHSPs());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setMaxHSPs(69L);

      assertEquals("{\"-max_hsps\":69}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.DBSize)
  class DBSizeFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setDBSize(null);
      assertNull(test.getDBSize());

      test.setDBSize((byte) 12);
      assertEquals((byte) 12, test.getDBSize());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-dbsize": 32
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals((byte) 32, parsed.getDBSize());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setDBSize((byte) 69);

      assertEquals("{\"-dbsize\":69}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.SearchSpace)
  class SearchSpaceFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setSearchSpace(null);
      assertNull(test.getSearchSpace());

      test.setSearchSpace((short) 12);
      assertEquals((short) 12, test.getSearchSpace());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-searchsp": 32
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals((short) 32, parsed.getSearchSpace());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setSearchSpace((short) 69);

      assertEquals("{\"-searchsp\":69}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.ImportSearchStrategy)
  class ImportSearchStrategyFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setImportSearchStrategy(null);
      assertNull(test.getImportSearchStrategy());

      test.setImportSearchStrategy("yelp");
      assertEquals("yelp", test.getImportSearchStrategy());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-import_search_strategy": "yellow"
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals("yellow", parsed.getImportSearchStrategy());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setImportSearchStrategy("harps");

      assertEquals("{\"-import_search_strategy\":\"harps\"}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.ExportSearchStrategy)
  class ExportSearchStrategyFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setExportSearchStrategy(null);
      assertNull(test.getExportSearchStrategy());

      test.setExportSearchStrategy("yelp");
      assertEquals("yelp", test.getExportSearchStrategy());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-export_search_strategy": "yellow"
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals("yellow", parsed.getExportSearchStrategy());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setExportSearchStrategy("harps");

      assertEquals("{\"-export_search_strategy\":\"harps\"}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.ExtensionDropoffUngapped)
  class ExtensionDropoffUngappedFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setExtensionDropoffUngapped(null);
      assertNull(test.getExtensionDropoffUngapped());

      test.setExtensionDropoffUngapped(12.34);
      assertEquals(12.34, test.getExtensionDropoffUngapped());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-xdrop_ungap": 32.12
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals(32.12, parsed.getExtensionDropoffUngapped());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setExtensionDropoffUngapped(69.69);

      assertEquals("{\"-xdrop_ungap\":69.69}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.WindowSize)
  class WindowSizeFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setWindowSize(null);
      assertNull(test.getWindowSize());

      test.setWindowSize(12L);
      assertEquals(12, test.getWindowSize());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-window_size": 32
        }
        """;

      final var parsed = json.readValue(input, configClass());

      assertEquals(32, parsed.getWindowSize());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setWindowSize(69L);

      assertEquals("{\"-window_size\":69}", json.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.Remote)
  class RemoteFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setRemote(null);
      assertNull(test.getRemote());

      test.setRemote(true);
      assertTrue(test.getRemote());

      test.setRemote(false);
      assertFalse(test.getRemote());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input1 = """
        {
          "-remote": true
        }
        """;

      final var test1 = json.readValue(input1, configClass());

      assertTrue(test1.getRemote());

      final var input2 = """
        {
          "-remote": false
        }
        """;

      final var test2 = json.readValue(input2, configClass());

      assertFalse(test2.getRemote());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var test1 = newConfig();

      assertEquals("{}", json.writeValueAsString(test1));

      test1.setRemote(true);

      assertEquals("{\"-remote\":true}", json.writeValueAsString(test1));

      test1.setRemote(false);

      assertEquals("{}", json.writeValueAsString(test1));
    }
  }
}
