package org.veupathdb.lib.blast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.ScoringMatrix;
import org.veupathdb.lib.blast.field.Seg;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PSIBlast")
class PSIBlastTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Nested
  @DisplayName(Flag.WordSize)
  class WordSize1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setWordSize(1285L);

      assertEquals("{\"-word_size\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-word_size\":1285}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setGapOpen(1285);

      assertEquals("{\"-gapopen\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-gapopen\":1285}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setGapExtend(1285);

      assertEquals("{\"-gapextend\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-gapextend\":1285}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(1285, tgt.getGapExtend());
    }
  }

  @Nested
  @DisplayName(Flag.Matrix)
  class Matrix1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setMatrix(ScoringMatrix.Blosum50);

      assertEquals("{\"-matrix\":\"BLOSUM50\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-matrix\":\"BLOSUM50\"}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(ScoringMatrix.Blosum50, tgt.getMatrix());
    }
  }

  @Nested
  @DisplayName(Flag.Threshold)
  class Threshold1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setThreshold(3.14);

      assertEquals("{\"-threshold\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-threshold\":3.14}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setCompBasedStats("hi");

      assertEquals("{\"-comp_based_stats\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-comp_based_stats\":\"hi\"}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setSubjectFile("hi");

      assertEquals("{\"-subject\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject\":\"hi\"}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setSubjectLocation(new Location(10, 11));

      assertEquals("{\"-subject_loc\":{\"start\":10,\"stop\":11}}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject_loc\":{\"start\":10,\"stop\":11}}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setSeg(Seg.yesSeg());

      assertEquals("{\"-seg\":\"yes\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-seg\":\"yes\"}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertTrue(tgt.getSeg().isYes());
    }
  }

  @Nested
  @DisplayName(Flag.CullingLimit)
  class CullingLimit1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setCullingLimit(123L);

      assertEquals("{\"-culling_limit\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-culling_limit\":123}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setSumStats(true);

      assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-sum_stats\":true}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setExtensionDropoffPrelimGapped(3.14);

      assertEquals("{\"-xdrop_gap\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-xdrop_gap\":3.14}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setExtensionDropoffFinalGapped(3.14);

      assertEquals("{\"-xdrop_gap_final\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-xdrop_gap_final\":3.14}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(3.14, tgt.getExtensionDropoffFinalGapped());
    }
  }

  @Nested
  @DisplayName(Flag.GapTrigger)
  class GapTrigger1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setGapTrigger(3.14);

      assertEquals("{\"-gap_trigger\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-gap_trigger\":3.14}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(3.14, tgt.getGapTrigger());
    }
  }

  @Nested
  @DisplayName(Flag.NumThreads)
  class NumThreads1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setNumThreads((short) 123);

      assertEquals("{\"-num_threads\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-num_threads\":123}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setUseSmithWatermanTraceback(true);

      assertEquals("{\"-use_sw_tback\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-use_sw_tback\":true}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setBestHitOverhang(123.0);

      assertEquals("{\"-best_hit_overhang\":123.0}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-best_hit_overhang\":123.0}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setBestHitScoreEdge(123.0);

      assertEquals("{\"-best_hit_score_edge\":123.0}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-best_hit_score_edge\":123.0}";
      var tgt = json.readValue(raw, PSIBlast.class);

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
      var tgt = new PSIBlast();
      tgt.setSubjectBestHit(true);

      assertEquals("{\"-subject_besthit\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject_besthit\":true}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(true, tgt.getSubjectBestHit());
    }
  }

  @Nested
  @DisplayName(Flag.NumIterations)
  class NumIterations1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setNumIterations(1285L);

      assertEquals("{\"-num_iterations\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-num_iterations\":1285}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(1285, tgt.getNumIterations());
    }
  }

  @Nested
  @DisplayName(Flag.OutPSSMFile)
  class OutPSSMFile1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setOutPSSMFile("hi");

      assertEquals("{\"-out_pssm\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-out_pssm\":\"hi\"}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals("hi", tgt.getOutPSSMFile());
    }
  }

  @Nested
  @DisplayName(Flag.OutASCIIPSSMFile)
  class OutASCIIPSSMFile1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setOutASCIIPSSMFile("hi");

      assertEquals("{\"-out_ascii_pssm\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-out_ascii_pssm\":\"hi\"}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals("hi", tgt.getOutASCIIPSSMFile());
    }
  }

  @Nested
  @DisplayName(Flag.SavePSSMAfterLastRound)
  class SavePSSMAfterLastRound1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setSavePSSMAfterLastRound(true);

      assertEquals("{\"-save_pssm_after_last_round\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-save_pssm_after_last_round\":true}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(true, tgt.getSavePSSMAfterLastRound());
    }
  }

  @Nested
  @DisplayName(Flag.SaveEachPSSM)
  class SaveEachPSSM1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setSaveEachPSSM(true);

      assertEquals("{\"-save_each_pssm\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-save_each_pssm\":true}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(true, tgt.getSaveEachPSSM());
    }
  }

  @Nested
  @DisplayName(Flag.InMSAFile)
  class InMSAFile1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setInMSAFile("hi");

      assertEquals("{\"-in_msa\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-in_msa\":\"hi\"}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals("hi", tgt.getInMSAFile());
    }
  }

  @Nested
  @DisplayName(Flag.MSAMasterIDX)
  class MSAMasterIDX1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setMSAMasterIDX(123L);

      assertEquals("{\"-msa_master_idx\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-msa_master_idx\":123}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(123, tgt.getMSAMasterIDX());
    }
  }

  @Nested
  @DisplayName(Flag.IgnoreMSAMaster)
  class IgnoreMSAMaster1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setIgnoreMSAMaster(true);

      assertEquals("{\"-ignore_msa_master\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-ignore_msa_master\":true}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(true, tgt.getIgnoreMSAMaster());
    }
  }

  @Nested
  @DisplayName(Flag.InPSSMFile)
  class InPSSMFile1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setInPSSMFile("hi");

      assertEquals("{\"-in_pssm\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-in_pssm\":\"hi\"}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals("hi", tgt.getInPSSMFile());
    }
  }

  @Nested
  @DisplayName(Flag.Pseudocount)
  class Pseudocount1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setPseudocount(1285);

      assertEquals("{\"-pseudocount\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-pseudocount\":1285}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(1285, tgt.getPseudocount());
    }
  }

  @Nested
  @DisplayName(Flag.InclusionEThreshold)
  class InclusionEThreshold1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setInclusionEThreshold(123.0);

      assertEquals("{\"-inclusion_ethresh\":123.0}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-inclusion_ethresh\":123.0}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals(123, tgt.getInclusionEThreshold());
    }
  }

  @Nested
  @DisplayName(Flag.PhiPatternFile)
  class PhiPatternFile1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new PSIBlast();
      tgt.setPhiPatternFile("hi");

      assertEquals("{\"-phi_pattern\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-phi_pattern\":\"hi\"}";
      var tgt = json.readValue(raw, PSIBlast.class);

      assertEquals("hi", tgt.getPhiPatternFile());
    }
  }
}