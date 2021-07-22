package org.veupathdb.lib.blast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.field.HSPSorting;
import org.veupathdb.lib.blast.field.HitSorting;
import org.veupathdb.lib.blast.field.OutFormat;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BlastConfig")
public abstract class BlastConfigContractTest
{
  abstract BlastConfig newConfig();

  abstract Class<? extends BlastConfig> configClass();

  private static final ObjectMapper JSON = new ObjectMapper();

  @Nested
  @DisplayName("#getTool()")
  class GetTool1
  {
    @Test
    @DisplayName("Does not return null")
    void test1() {
      assertNotNull(newConfig().getTool());
    }
  }

  @Nested
  @DisplayName("-h Flag")
  class ShortHelpFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setShortHelp(null);
      assertNull(test.getShortHelp());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.ShortHelp));

      test.setShortHelp(true);
      assertTrue(test.getShortHelp());
      json = test.toJSON().toJSON();
      assertTrue(json.has(Flag.ShortHelp));
      assertTrue(json.get(Flag.ShortHelp).isBoolean());
      assertTrue(json.get(Flag.ShortHelp).booleanValue());

      test.setShortHelp(false);
      assertFalse(test.getShortHelp());
      json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.ShortHelp));
    }
  }

  @Nested
  @DisplayName("-help Flag")
  class LongHelpFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setLongHelp(null);
      assertNull(test.getLongHelp());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.LongHelp));

      test.setLongHelp(true);
      assertTrue(test.getLongHelp());
      json = test.toJSON().toJSON();
      assertTrue(json.has(Flag.LongHelp));
      assertTrue(json.get(Flag.LongHelp).isBoolean());
      assertTrue(json.get(Flag.LongHelp).booleanValue());

      test.setLongHelp(false);
      assertFalse(test.getLongHelp());
      json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.LongHelp));
    }
  }

  @Nested
  @DisplayName("-version Flag")
  class VersionFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setVersion(null);
      assertNull(test.getVersion());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.Version));

      test.setVersion(true);
      assertTrue(test.getVersion());
      json = test.toJSON().toJSON();
      assertTrue(json.has(Flag.Version));
      assertTrue(json.get(Flag.Version).isBoolean());
      assertTrue(json.get(Flag.Version).booleanValue());

      test.setVersion(false);
      assertFalse(test.getVersion());
      json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.Version));
    }
  }

  @Nested
  @DisplayName("-out Flag")
  class OutFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setOutFile(null);
      assertNull(test.getOutFile());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.OutFile));

      test.setOutFile("Hello");
      assertEquals("Hello", test.getOutFile().value());
      json = test.toJSON().toJSON();
      assertTrue(json.has(Flag.OutFile));
      assertTrue(json.get(Flag.OutFile).isTextual());
      assertEquals("Hello", json.get(Flag.OutFile).textValue());
    }
  }

  @Nested
  @DisplayName("-outfmt Flag")
  class OutFmt
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setOutFormat(null);
      assertNull(test.getOutFormat());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.OutFormat));

      test.setOutFormat(new OutFormat());
      assertNotNull(test.getOutFormat());
      json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.OutFormat));

      test.setOutFormat(new OutFormat().setDelimiter("@"));
      assertNotNull(test.getOutFormat());
      json = test.toJSON().toJSON();
      assertTrue(json.has(Flag.OutFormat));
      assertTrue(json.get(Flag.OutFormat).isObject());
      assertEquals(1, json.get(Flag.OutFormat).size());
      assertTrue(json.get(Flag.OutFormat).has(Key.Delimiter));
      assertTrue(json.get(Flag.OutFormat).get(Key.Delimiter).isTextual());
      assertEquals("@", json.get(Flag.OutFormat).get(Key.Delimiter).textValue());
    }
  }

  @Nested
  @DisplayName(Flag.ShowGIs)
  class ShowGIsFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setShowGIs(null);
      assertNull(test.getShowGIs());

      test.setShowGIs(true);
      assertTrue(test.getShowGIs());

      test.setShowGIs(false);
      assertFalse(test.getShowGIs());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input1 = """
        {
          "-show_gis": true
        }
        """;

      final var test1 = JSON.readValue(input1, configClass());

      assertTrue(test1.getShowGIs());

      final var input2 = """
        {
          "-show_gis": false
        }
        """;

      final var test2 = JSON.readValue(input2, configClass());

      assertFalse(test2.getShowGIs());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var test1 = newConfig();

      assertEquals("{}", JSON.writeValueAsString(test1));

      test1.setShowGIs(true);

      assertEquals("{\"-show_gis\":true}", JSON.writeValueAsString(test1));

      test1.setShowGIs(false);

      assertEquals("{}", JSON.writeValueAsString(test1));
    }
  }

  @Nested
  @DisplayName(Flag.NumDescriptions)
  class NumDescriptionsFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setNumDescriptions(null);
      assertNull(test.getNumDescriptions());

      test.setNumDescriptions(12L);
      assertEquals(12, test.getNumDescriptions().value());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-num_descriptions": 32
        }
        """;

      final var parsed = JSON.readValue(input, configClass());

      assertEquals(32, parsed.getNumDescriptions().value());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setNumDescriptions(69L);

      assertEquals("{\"-num_descriptions\":69}", JSON.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.NumAlignments)
  class NumAlignmentsFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setNumAlignments(null);
      assertNull(test.getNumAlignments());

      test.setNumAlignments(12L);
      assertEquals(12, test.getNumAlignments().value());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-num_alignments": 32
        }
        """;

      final var parsed = JSON.readValue(input, configClass());

      assertEquals(32, parsed.getNumAlignments().value());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setNumAlignments(69L);

      assertEquals("{\"-num_alignments\":69}", JSON.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.LineLength)
  class LineLengthFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setLineLength(null);
      assertNull(test.getLineLength());

      test.setLineLength(12);
      assertEquals(12, test.getLineLength().value());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input = """
        {
          "-line_length": 32
        }
        """;

      final var parsed = JSON.readValue(input, configClass());

      assertEquals(32, parsed.getLineLength().value());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var object = newConfig();

      object.setLineLength(69);

      assertEquals("{\"-line_length\":69}", JSON.writeValueAsString(object));
    }
  }

  @Nested
  @DisplayName(Flag.HTML)
  class HTMLFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setHTML(null);
      assertNull(test.getHTML());

      test.setHTML(true);
      assertTrue(test.getHTML());

      test.setHTML(false);
      assertFalse(test.getHTML());
    }

    @Test
    @DisplayName("Can be deserialized")
    void test2() throws JsonProcessingException {
      final var input1 = """
        {
          "-html": true
        }
        """;

      final var test1 = JSON.readValue(input1, configClass());

      assertTrue(test1.getHTML());

      final var input2 = """
        {
          "-html": false
        }
        """;

      final var test2 = JSON.readValue(input2, configClass());

      assertFalse(test2.getHTML());
    }

    @Test
    @DisplayName("Can be serialized")
    void test3() throws JsonProcessingException {
      final var test1 = newConfig();

      assertEquals("{}", JSON.writeValueAsString(test1));

      test1.setHTML(true);

      assertEquals("{\"-html\":true}", JSON.writeValueAsString(test1));

      test1.setHTML(false);

      assertEquals("{}", JSON.writeValueAsString(test1));
    }
  }

  @Nested
  @DisplayName(Flag.SortHits)
  class SortHits
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setSortHits(null);
      assertNull(test.getSortHits());

      for (final var hs : HitSorting.values()) {
        test.setSortHits(hs);
        assertEquals(hs, test.getSortHits());
      }
    }

    @Test
    @DisplayName("Can be serialized")
    void test2() throws JsonProcessingException {
      final var test = newConfig();

      for (final var val : HitSorting.values()) {
        test.setSortHits(val);

        assertEquals(
          "{\"" + Flag.SortHits + "\":" + val.ordinal() + "}",
          JSON.writeValueAsString(test)
        );
      }
    }

    @Test
    @DisplayName("Can be deserialized")
    void test3() throws JsonProcessingException {
      for (final var val : HitSorting.values()) {
        final var json = "{\""+ Flag.SortHits + "\":" + val.ordinal() + "}";
        final var test = JSON.readValue(json, configClass());

        assertEquals(val, test.getSortHits());
      }
    }
  }

  @Nested
  @DisplayName(Flag.SortHSPs)
  class SortHSPs
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setSortHSPs(null);
      assertNull(test.getSortHSPs());

      for (final var hs : HSPSorting.values()) {
        test.setSortHSPs(hs);
        assertEquals(hs, test.getSortHSPs());
      }
    }

    @Test
    @DisplayName("Can be serialized")
    void test2() throws JsonProcessingException {
      final var test = newConfig();

      for (final var val : HSPSorting.values()) {
        test.setSortHSPs(val);

        assertEquals(
          "{\"" + Flag.SortHSPs + "\":" + val.ordinal() + "}",
          JSON.writeValueAsString(test)
        );
      }
    }

    @Test
    @DisplayName("Can be deserialized")
    void test3() throws JsonProcessingException {
      for (final var val : HSPSorting.values()) {
        final var json = "{\""+ Flag.SortHSPs + "\":" + val.ordinal() + "}";
        final var test = JSON.readValue(json, configClass());

        assertEquals(val, test.getSortHSPs());
      }
    }
  }
}
