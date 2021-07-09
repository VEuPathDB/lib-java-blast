package org.veupathdb.lib.blast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.MTMode;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.field.Strand;
import org.veupathdb.lib.blast.field.ThreadMode;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RPSTBlastN")
class RPSTBlastNTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Nested
  @DisplayName(Flag.QueryGenCode)
  class QueryGenCode1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setQueryGenCode((short) 1285);

      assertEquals("{\"-query_gencode\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-query_gencode\":1285}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertEquals((short) 1285, tgt.getQueryGenCode());
    }
  }

  @Nested
  @DisplayName(Flag.Strand)
  class Strand1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setStrand(Strand.Minus);

      assertEquals("{\"-strand\":\"minus\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-strand\":\"minus\"}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertEquals(Strand.Minus, tgt.getStrand());
    }
  }

  @Nested
  @DisplayName(Flag.CompBasedStats)
  class CompBasedStats1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setCompBasedStats("hi");

      assertEquals("{\"-comp_based_stats\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-comp_based_stats\":\"hi\"}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertEquals("hi", tgt.getCompBasedStats());
    }
  }

  @Nested
  @DisplayName(Flag.Seg)
  class Seg1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setSeg(Seg.yesSeg());

      assertEquals("{\"-seg\":\"yes\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-seg\":\"yes\"}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertTrue(tgt.getSeg().isYes());
    }
  }

  @Nested
  @DisplayName(Flag.SumStats)
  class SumStats1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setSumStats(true);

      assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-sum_stats\":true}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertEquals(true, tgt.getSumStats());
    }
  }

  @Nested
  @DisplayName(Flag.ExtensionDropoffPrelimGapped)
  class ExtensionDropoffPrelimGapped1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setExtensionDropoffPrelimGapped(3.14);

      assertEquals("{\"-xdrop_gap\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-xdrop_gap\":3.14}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertEquals(3.14, tgt.getExtensionDropoffPrelimGapped());
    }
  }

  @Nested
  @DisplayName(Flag.ExtensionDropoffFinalGapped)
  class ExtensionDropoffFinalGapped1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setExtensionDropoffFinalGapped(3.14);

      assertEquals("{\"-xdrop_gap_final\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-xdrop_gap_final\":3.14}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertEquals(3.14, tgt.getExtensionDropoffFinalGapped());
    }
  }

  @Nested
  @DisplayName(Flag.UngappedAlignmentsOnly)
  class UngappedAlignmentsOnly1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setUngappedAlignmentsOnly(true);

      assertEquals("{\"-ungapped\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-ungapped\":true}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertEquals(true, tgt.getUngappedAlignmentsOnly());
    }
  }

  @Nested
  @DisplayName(Flag.NumThreads)
  class NumThreads1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setNumThreads(new ThreadMode(3));

      assertEquals("{\"-num_threads\":3}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-num_threads\":1}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertEquals(ThreadMode.Disable, tgt.getNumThreads());
    }
  }

  @Nested
  @DisplayName(Flag.MTMode)
  class MTMode1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setMTMode(MTMode.SplitByQueries);

      assertEquals("{\"-mt_mode\":1}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-mt_mode\":1}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertEquals(MTMode.SplitByQueries, tgt.getMTMode());
    }
  }

  @Nested
  @DisplayName(Flag.UseSmithWatermanTraceback)
  class UseSmithWatermanTraceback1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new RPSTBlastN();
      tgt.setUseSmithWatermanTraceback(true);

      assertEquals("{\"-use_sw_tback\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-use_sw_tback\":true}";
      var tgt = json.readValue(raw, RPSTBlastN.class);

      assertEquals(true, tgt.getUseSmithWatermanTraceback());
    }
  }

}