package org.veupathdb.lib.blast;

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
      assertEquals("Hello", test.getOutFile());
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
      assertNull(test.getOutFormat());
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
  @DisplayName("-show_gis Flag")
  class ShowGIsFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setShowGIs(null);
      assertNull(test.getShowGIs());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.ShowGIs));

      test.setShowGIs(true);
      assertTrue(test.getShowGIs());
      json = test.toJSON().toJSON();
      assertTrue(json.has(Flag.ShowGIs));
      assertTrue(json.get(Flag.ShowGIs).isBoolean());
      assertTrue(json.get(Flag.ShowGIs).booleanValue());

      test.setShowGIs(false);
      assertFalse(test.getShowGIs());
      json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.ShowGIs));
    }
  }

  @Nested
  @DisplayName("-num_descriptions Flag")
  class NumDescriptions
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setNumDescriptions(null);
      assertNull(test.getNumDescriptions());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.NumDescriptions));

      test.setNumDescriptions(33L);
      assertEquals(33L, test.getNumDescriptions());
      json = test.toJSON().toJSON();
      assertTrue(json.has(Flag.NumDescriptions));
      assertTrue(json.get(Flag.NumDescriptions).isNumber());
      assertEquals(33, json.get(Flag.NumDescriptions).longValue());
    }
  }

  @Nested
  @DisplayName("-num_alignments Flag")
  class NumAlignments
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setNumAlignments(null);
      assertNull(test.getNumAlignments());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.NumAlignments));

      test.setNumAlignments(33L);
      assertEquals(33L, test.getNumAlignments());
      json = test.toJSON().toJSON();
      assertTrue(json.has(Flag.NumAlignments));
      assertTrue(json.get(Flag.NumAlignments).isNumber());
      assertEquals(33, json.get(Flag.NumAlignments).longValue());
    }
  }

  @Nested
  @DisplayName("-line_length Flag")
  class LineLength
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setLineLength(null);
      assertNull(test.getLineLength());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.LineLength));

      test.setLineLength(33);
      assertEquals(33, test.getLineLength());
      json = test.toJSON().toJSON();
      assertTrue(json.has(Flag.LineLength));
      assertTrue(json.get(Flag.LineLength).isNumber());
      assertEquals(33, json.get(Flag.LineLength).intValue());
    }
  }

  @Nested
  @DisplayName("-html Flag")
  class HTMLFlag
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setHTML(null);
      assertNull(test.getHTML());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.HTML));

      test.setHTML(true);
      assertTrue(test.getHTML());
      json = test.toJSON().toJSON();
      assertTrue(json.has(Flag.HTML));
      assertTrue(json.get(Flag.HTML).isBoolean());
      assertTrue(json.get(Flag.HTML).booleanValue());

      test.setHTML(false);
      assertFalse(test.getHTML());
      json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.HTML));
    }
  }

  @Nested
  @DisplayName("-sorthits Flag")
  class SortHits
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setSortHits(null);
      assertNull(test.getSortHits());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.SortHits));

      for (final var hs : HitSorting.values()) {
        test.setSortHits(hs);
        assertEquals(hs, test.getSortHits());
        json = test.toJSON().toJSON();
        assertTrue(json.has(Flag.SortHits));
        assertTrue(json.get(Flag.SortHits).isNumber());
        assertEquals(hs.ordinal(), json.get(Flag.SortHits).intValue());
      }
    }
  }

  @Nested
  @DisplayName("-sorthsps Flag")
  class SortHSPs
  {
    @Test
    @DisplayName("Can be configured")
    void test1() {
      final var test = newConfig();

      test.setSortHSPs(null);
      assertNull(test.getSortHSPs());
      var json = test.toJSON().toJSON();
      assertFalse(json.has(Flag.SortHSPs));

      for (final var hs : HSPSorting.values()) {
        test.setSortHSPs(hs);
        assertEquals(hs, test.getSortHSPs());
        json = test.toJSON().toJSON();
        assertTrue(json.has(Flag.SortHSPs));
        assertTrue(json.get(Flag.SortHSPs).isNumber());
        assertEquals(hs.ordinal(), json.get(Flag.SortHSPs).intValue());
      }
    }
  }

}
