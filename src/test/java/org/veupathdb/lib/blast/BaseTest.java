package org.veupathdb.lib.blast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.HSPSorting;
import org.veupathdb.lib.blast.field.HitSorting;
import org.veupathdb.lib.blast.field.OutFormat;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Base")
class BaseTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Nested
  @DisplayName(Flag.ShortHelp)
  class ShortHelp
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setShortHelp(true);

      assertEquals("{\"-h\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-h\":true}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertTrue(tgt.getShortHelp());
    }
  }

  @Nested
  @DisplayName(Flag.LongHelp)
  class LongHelp
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setLongHelp(true);

      assertEquals("{\"-help\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-help\":true}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(true, tgt.getLongHelp());
    }
  }

  @Nested
  @DisplayName(Flag.Version)
  class Version
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setVersion(true);

      assertEquals("{\"-version\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-version\":true}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(true, tgt.getVersion());
    }
  }

  @Nested
  @DisplayName(Flag.OutFormat)
  class OutFormat1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setOutFormat(new OutFormat().setDelimiter("="));

      assertEquals("{\"-outfmt\":{\"delimiter\":\"=\"}}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-outfmt\":{\"delimiter\":\"=\"}}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals("=", tgt.getOutFormat().getDelimiter());
    }
  }

  @Nested
  @DisplayName(Flag.ShowGIs)
  class ShowGIs
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setShowGIs(true);

      assertEquals("{\"-show_gis\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-show_gis\":true}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(true, tgt.getShowGIs());
    }
  }

  @Nested
  @DisplayName(Flag.NumDescriptions)
  class NumDescriptions
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setNumDescriptions(34L);

      assertEquals("{\"-num_descriptions\":34}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-num_descriptions\":34}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(34, tgt.getNumDescriptions());
    }
  }

  @Nested
  @DisplayName(Flag.NumAlignments)
  class NumAlignments
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setNumAlignments(34L);

      assertEquals("{\"-num_alignments\":34}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-num_alignments\":34}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(34, tgt.getNumAlignments());
    }
  }


  @Nested
  @DisplayName(Flag.LineLength)
  class LineLength
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setLineLength(34);

      assertEquals("{\"-line_length\":34}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-line_length\":34}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(34, tgt.getLineLength());
    }
  }

  @Nested
  @DisplayName(Flag.HTML)
  class HTML
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setHTML(true);

      assertEquals("{\"-html\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-html\":true}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(true, tgt.getHTML());
    }
  }

  @Nested
  @DisplayName(Flag.SortHits)
  class SortHits
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setSortHits(HitSorting.ByQueryCoverage);

      assertEquals("{\"-sorthits\":4}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-sorthits\":4}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(HitSorting.ByQueryCoverage, tgt.getSortHits());
    }
  }

  @Nested
  @DisplayName(Flag.SortHSPs)
  class SortHSPs
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setSortHSPs(HSPSorting.ByHSPSubjectStart);

      assertEquals("{\"-sorthsps\":4}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-sorthsps\":4}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(HSPSorting.ByHSPSubjectStart, tgt.getSortHSPs());
    }
  }

  @Nested
  @DisplayName(Flag.MaxTargetSequences)
  class MaxTargetSequences
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setMaxTargetSequences(34L);

      assertEquals("{\"-max_target_seqs\":34}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-max_target_seqs\":34}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(34, tgt.getMaxTargetSequences());
    }
  }

  @Nested
  @DisplayName(Flag.OutFile)
  class OutFile
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setOutFile("hi");

      assertEquals("{\"-out\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-out\":\"hi\"}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals("hi", tgt.getOutFile());
    }
  }

  @Nested
  @DisplayName(Flag.ParseDefLines)
  class ParseDefLines
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new CLIBase(){};
      tgt.setParseDefLines(true);

      assertEquals("{\"-parse_deflines\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-parse_deflines\":true}";
      var tgt = json.readValue(raw, CLIBase.class);

      assertEquals(true, tgt.getParseDefLines());
    }
  }
}