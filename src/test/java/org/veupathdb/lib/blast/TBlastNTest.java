package org.veupathdb.lib.blast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.field.TBlastNTask;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TBlastN")
class TBlastNTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Nested
  @DisplayName(Flag.Task)
  class Task1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setTask(TBlastNTask.TBlastNFast);

      assertEquals("{\"-task\":\"tblastn-fast\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-task\":\"tblastn-fast\"}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(TBlastNTask.TBlastNFast, tgt.getTask());
    }
  }

  @Nested
  @DisplayName(Flag.WordSize)
  class WordSize1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setWordSize(1285L);

      assertEquals("{\"-word_size\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-word_size\":1285}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(1285, tgt.getWordSize());
    }
  }

  @Nested
  @DisplayName(Flag.GapOpen)
  class GapOpen1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setGapOpen(1285);

      assertEquals("{\"-gapopen\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-gapopen\":1285}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(1285, tgt.getGapOpen());
    }
  }

  @Nested
  @DisplayName(Flag.GapExtend)
  class GapExtend1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setGapExtend(1285);

      assertEquals("{\"-gapextend\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-gapextend\":1285}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(1285, tgt.getGapExtend());
    }
  }

  @Nested
  @DisplayName(Flag.DBGenCode)
  class DBGenCode1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setDBGenCode((short) 1285);

      assertEquals("{\"-db_gencode\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-db_gencode\":1285}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals((short) 1285, tgt.getDBGenCode());
    }
  }

  @Nested
  @DisplayName(Flag.MaxIntronLength)
  class MaxIntronLength1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setMaxIntronLength(1285L);

      assertEquals("{\"-max_intron_length\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-max_intron_length\":1285}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(1285, tgt.getMaxIntronLength());
    }
  }

  @Nested
  @DisplayName(Flag.Matrix)
  class Matrix1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setMatrix("hi");

      assertEquals("{\"-matrix\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-matrix\":\"hi\"}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals("hi", tgt.getMatrix());
    }
  }

  @Nested
  @DisplayName(Flag.Threshold)
  class Threshold1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setThreshold(3.14);

      assertEquals("{\"-threshold\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-threshold\":3.14}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(3.14, tgt.getThreshold());
    }
  }

  @Nested
  @DisplayName(Flag.CompBasedStats)
  class CompBasedStats1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setCompBasedStats("hi");

      assertEquals("{\"-comp_based_stats\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-comp_based_stats\":\"hi\"}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals("hi", tgt.getCompBasedStats());
    }
  }

  @Nested
  @DisplayName(Flag.SubjectFile)
  class SubjectFile1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setSubjectFile("hi");

      assertEquals("{\"-subject\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject\":\"hi\"}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals("hi", tgt.getSubjectFile());
    }
  }

  @Nested
  @DisplayName(Flag.SubjectLocation)
  class SubjectLocation1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setSubjectLocation(new Location(10, 11));

      assertEquals("{\"-subject_loc\":{\"start\":10,\"stop\":11}}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject_loc\":{\"start\":10,\"stop\":11}}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(10, tgt.getSubjectLocation().getStart());
      assertEquals(11, tgt.getSubjectLocation().getStop());
    }
  }

  @Nested
  @DisplayName(Flag.Seg)
  class Seg1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setSeg(Seg.yesSeg());

      assertEquals("{\"-seg\":\"yes\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-seg\":\"yes\"}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertTrue(tgt.getSeg().isYes());
    }
  }

  @Nested
  @DisplayName(Flag.DBSoftMask)
  class DBSoftMask1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setDBSoftMask("hi");

      assertEquals("{\"-db_soft_mask\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-db_soft_mask\":\"hi\"}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals("hi", tgt.getDBSoftMask());
    }
  }

  @Nested
  @DisplayName(Flag.DBHardMask)
  class DBHardMask1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setDBHardMask("hi");

      assertEquals("{\"-db_hard_mask\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-db_hard_mask\":\"hi\"}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals("hi", tgt.getDBHardMask());
    }
  }

  @Nested
  @DisplayName(Flag.CullingLimit)
  class CullingLimit1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setCullingLimit(123L);

      assertEquals("{\"-culling_limit\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-culling_limit\":123}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(123, tgt.getCullingLimit());
    }
  }

  @Nested
  @DisplayName(Flag.SumStats)
  class SumStats1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setSumStats(true);

      assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-sum_stats\":true}";
      var tgt = json.readValue(raw, TBlastN.class);

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
      var tgt = new TBlastN();
      tgt.setExtensionDropoffPrelimGapped(3.14);

      assertEquals("{\"-xdrop_gap\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-xdrop_gap\":3.14}";
      var tgt = json.readValue(raw, TBlastN.class);

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
      var tgt = new TBlastN();
      tgt.setExtensionDropoffFinalGapped(3.14);

      assertEquals("{\"-xdrop_gap_final\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-xdrop_gap_final\":3.14}";
      var tgt = json.readValue(raw, TBlastN.class);

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
      var tgt = new TBlastN();
      tgt.setUngappedAlignmentsOnly(true);

      assertEquals("{\"-ungapped\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-ungapped\":true}";
      var tgt = json.readValue(raw, TBlastN.class);

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
      var tgt = new TBlastN();
      tgt.setNumThreads((short) 123);

      assertEquals("{\"-num_threads\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-num_threads\":123}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals((short) 123, tgt.getNumThreads());
    }
  }

  @Nested
  @DisplayName(Flag.UseSmithWatermanTraceback)
  class UseSmithWatermanTraceback1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setUseSmithWatermanTraceback(true);

      assertEquals("{\"-use_sw_tback\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-use_sw_tback\":true}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(true, tgt.getUseSmithWatermanTraceback());
    }
  }

  @Nested
  @DisplayName(Flag.BestHitOverhang)
  class BestHitOverhang1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setBestHitOverhang(123.0);

      assertEquals("{\"-best_hit_overhang\":123.0}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-best_hit_overhang\":123.0}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(123, tgt.getBestHitOverhang());
    }
  }

  @Nested
  @DisplayName(Flag.BestHitScoreEdge)
  class BestHitScoreEdge1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setBestHitScoreEdge(123.0);

      assertEquals("{\"-best_hit_score_edge\":123.0}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-best_hit_score_edge\":123.0}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(123, tgt.getBestHitScoreEdge());
    }
  }

  @Nested
  @DisplayName(Flag.SubjectBestHit)
  class SubjectBestHit1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setSubjectBestHit(true);

      assertEquals("{\"-subject_besthit\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject_besthit\":true}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals(true, tgt.getSubjectBestHit());
    }
  }

  @Nested
  @DisplayName(Flag.InPSSMFile)
  class InPSSMFile1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastN();
      tgt.setInPSSMFile("hi");

      assertEquals("{\"-in_pssm\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-in_pssm\":\"hi\"}";
      var tgt = json.readValue(raw, TBlastN.class);

      assertEquals("hi", tgt.getInPSSMFile());
    }
  }

}