package org.veupathdb.lib.blast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BlastN")
class BlastNTest extends BlastQueryConfigContractTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Override
  BlastQueryConfig newConfig() {
    return new BlastN();
  }

  @Nested
  @DisplayName(Flag.Strand)
  class Strand1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setStrand(Strand.Minus);

      assertEquals("{\"-strand\":\"minus\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-strand\":\"minus\"}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(Strand.Minus, tgt.getStrand());
    }
  }

  @Nested
  @DisplayName(Flag.Task)
  class Task1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setTask(BlastNTask.RMBlastN);

      assertEquals("{\"-task\":\"rmblastn\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-task\":\"rmblastn\"}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(BlastNTask.RMBlastN, tgt.getTask());
    }
  }

  @Nested
  @DisplayName(Flag.WordSize)
  class WordSize1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setWordSize(1285L);

      assertEquals("{\"-word_size\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-word_size\":1285}";
      var tgt = json.readValue(raw, BlastN.class);

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
      var tgt = new BlastN();
      tgt.setGapOpen(1285);

      assertEquals("{\"-gapopen\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-gapopen\":1285}";
      var tgt = json.readValue(raw, BlastN.class);

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
      var tgt = new BlastN();
      tgt.setGapExtend(1285);

      assertEquals("{\"-gapextend\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-gapextend\":1285}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(1285, tgt.getGapExtend());
    }
  }

  @Nested
  @DisplayName(Flag.Penalty)
  class Penalty1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setPenalty(1285);

      assertEquals("{\"-penalty\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-penalty\":1285}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(1285, tgt.getPenalty());
    }
  }

  @Nested
  @DisplayName(Flag.Reward)
  class Reward1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setReward(1285L);

      assertEquals("{\"-reward\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-reward\":1285}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(1285, tgt.getReward());
    }
  }

  @Nested
  @DisplayName(Flag.UseIndex)
  class UseIndex1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setUseIndex(true);

      assertEquals("{\"-use_index\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-use_index\":true}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(true, tgt.getUseIndex());
    }
  }

  @Nested
  @DisplayName(Flag.IndexName)
  class IndexName1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setIndexName("hi");

      assertEquals("{\"-index_name\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-index_name\":\"hi\"}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals("hi", tgt.getIndexName());
    }
  }

  @Nested
  @DisplayName(Flag.SubjectFile)
  class SubjectFile1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setSubjectFile("hi");

      assertEquals("{\"-subject\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject\":\"hi\"}";
      var tgt = json.readValue(raw, BlastN.class);

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
      var tgt = new BlastN();
      tgt.setSubjectLocation(new Location(10, 11));

      assertEquals("{\"-subject_loc\":{\"start\":10,\"stop\":11}}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject_loc\":{\"start\":10,\"stop\":11}}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(10, tgt.getSubjectLocation().getStart());
      assertEquals(11, tgt.getSubjectLocation().getStop());
    }
  }

  @Nested
  @DisplayName(Flag.Dust)
  class Dust1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setDust(Dust.yesDust());

      assertEquals("{\"-dust\":\"yes\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-dust\":\"yes\"}";
      var tgt = json.readValue(raw, BlastN.class);

      assertTrue(tgt.getDust().isYes());
    }
  }

  @Nested
  @DisplayName(Flag.FilteringDB)
  class FilteringDB1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setFilteringDB("hi");

      assertEquals("{\"-filtering_db\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-filtering_db\":\"hi\"}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals("hi", tgt.getFilteringDB());
    }
  }

  @Nested
  @DisplayName(Flag.WindowMaskerTaxID)
  class WindowMaskerTaxID1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setWindowMaskerTaxID(123);

      assertEquals("{\"-window_masker_taxid\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-window_masker_taxid\":123}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(123, tgt.getWindowMaskerTaxID());
    }
  }

  @Nested
  @DisplayName(Flag.WindowMaskerDB)
  class WindowMaskerDB1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setWindowMaskerDB("hi");

      assertEquals("{\"-window_masker_db\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-window_masker_db\":\"hi\"}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals("hi", tgt.getWindowMaskerDB());
    }
  }

  @Nested
  @DisplayName(Flag.DBSoftMask)
  class DBSoftMask1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setDBSoftMask("hi");

      assertEquals("{\"-db_soft_mask\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-db_soft_mask\":\"hi\"}";
      var tgt = json.readValue(raw, BlastN.class);

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
      var tgt = new BlastN();
      tgt.setDBHardMask("hi");

      assertEquals("{\"-db_hard_mask\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-db_hard_mask\":\"hi\"}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals("hi", tgt.getDBHardMask());
    }
  }

  @Nested
  @DisplayName(Flag.PercentIdentity)
  class PercentIdentity1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setPercentIdentity(3.14);

      assertEquals("{\"-perc_identity\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-perc_identity\":3.14}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(3.14, tgt.getPercentIdentity());
    }
  }

  @Nested
  @DisplayName(Flag.CullingLimit)
  class CullingLimit1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setCullingLimit(123L);

      assertEquals("{\"-culling_limit\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-culling_limit\":123}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(123, tgt.getCullingLimit());
    }
  }

  @Nested
  @DisplayName(Flag.TemplateType)
  class TemplateType1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setTemplateType(TemplateType.Optimal);

      assertEquals("{\"-template_type\":\"optimal\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-template_type\":\"optimal\"}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(TemplateType.Optimal, tgt.getTemplateType());
    }
  }

  @Nested
  @DisplayName(Flag.TemplateLength)
  class TemplateLength1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setTemplateLength(TemplateLength.Length18);

      assertEquals("{\"-template_length\":18}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-template_length\":18}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(TemplateLength.Length18, tgt.getTemplateLength());
    }
  }

  @Nested
  @DisplayName(Flag.SumStats)
  class SumStats1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setSumStats(true);

      assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-sum_stats\":true}";
      var tgt = json.readValue(raw, BlastN.class);

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
      var tgt = new BlastN();
      tgt.setExtensionDropoffPrelimGapped(3.14);

      assertEquals("{\"-xdrop_gap\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-xdrop_gap\":3.14}";
      var tgt = json.readValue(raw, BlastN.class);

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
      var tgt = new BlastN();
      tgt.setExtensionDropoffFinalGapped(3.14);

      assertEquals("{\"-xdrop_gap_final\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-xdrop_gap_final\":3.14}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(3.14, tgt.getExtensionDropoffFinalGapped());
    }
  }

  @Nested
  @DisplayName(Flag.NonGreedy)
  class NonGreedy1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setNonGreedy(true);

      assertEquals("{\"-no_greedy\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-no_greedy\":true}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(true, tgt.getNonGreedy());
    }
  }

  @Nested
  @DisplayName(Flag.MinRawGappedScore)
  class MinRawGappedScore1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setMinRawGappedScore(123);

      assertEquals("{\"-min_raw_gapped_score\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-min_raw_gapped_score\":123}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(123, tgt.getMinRawGappedScore());
    }
  }

  @Nested
  @DisplayName(Flag.UngappedAlignmentsOnly)
  class UngappedAlignmentsOnly1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setUngappedAlignmentsOnly(true);

      assertEquals("{\"-ungapped\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-ungapped\":true}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(true, tgt.getUngappedAlignmentsOnly());
    }
  }

  @Nested
  @DisplayName(Flag.OffDiagonalRange)
  class OffDiagonalRange1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setOffDiagonalRange(123L);

      assertEquals("{\"-off_diagonal_range\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-off_diagonal_range\":123}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(123, tgt.getOffDiagonalRange());
    }
  }

  @Nested
  @DisplayName(Flag.NumThreads)
  class NumThreads1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setNumThreads((short) 123);

      assertEquals("{\"-num_threads\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-num_threads\":123}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals((short) 123, tgt.getNumThreads());
    }
  }

  @Nested
  @DisplayName(Flag.BestHitOverhang)
  class BestHitOverhang1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new BlastN();
      tgt.setBestHitOverhang(123.0);

      assertEquals("{\"-best_hit_overhang\":123.0}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-best_hit_overhang\":123.0}";
      var tgt = json.readValue(raw, BlastN.class);

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
      var tgt = new BlastN();
      tgt.setBestHitScoreEdge(123.0);

      assertEquals("{\"-best_hit_score_edge\":123.0}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-best_hit_score_edge\":123.0}";
      var tgt = json.readValue(raw, BlastN.class);

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
      var tgt = new BlastN();
      tgt.setSubjectBestHit(true);

      assertEquals("{\"-subject_besthit\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject_besthit\":true}";
      var tgt = json.readValue(raw, BlastN.class);

      assertEquals(true, tgt.getSubjectBestHit());
    }
  }
}