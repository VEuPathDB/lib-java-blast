package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.BlastNTask.RMBlastN
import org.veupathdb.lib.blast.field.Dust.Companion.yesDust
import org.veupathdb.lib.blast.field.Location
import org.veupathdb.lib.blast.field.Strand.Minus
import org.veupathdb.lib.blast.field.TemplateLength.Length18
import org.veupathdb.lib.blast.field.TemplateType.Optimal

@DisplayName("BlastN")
internal class BlastNTest : BlastWithListsContractTest() {
  private val json = ObjectMapper()
  override fun newConfig() = BlastN()

  override fun configClass() = BlastN::class

  @Nested
  @DisplayName(Flag.Strand)
  internal inner class Strand1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.strand = Minus
      Assertions.assertEquals("{\"-strand\":\"minus\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-strand\":\"minus\"}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(Minus, tgt.strand)
    }
  }

  @Nested
  @DisplayName(Flag.Task)
  internal inner class Task1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.task = RMBlastN
      Assertions.assertEquals("{\"-task\":\"rmblastn\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-task\":\"rmblastn\"}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(RMBlastN, tgt.task)
    }
  }

  @Nested
  @DisplayName(Flag.WordSize)
  internal inner class WordSize1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.wordSize = 1285L
      Assertions.assertEquals("{\"-word_size\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-word_size\":1285}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(1285, tgt.wordSize)
    }
  }

  @Nested
  @DisplayName(Flag.GapOpen)
  internal inner class GapOpen1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.gapOpen = 1285
      Assertions.assertEquals("{\"-gapopen\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-gapopen\":1285}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(1285, tgt.gapOpen)
    }
  }

  @Nested
  @DisplayName(Flag.GapExtend)
  internal inner class GapExtend1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.gapExtend = 1285
      Assertions.assertEquals("{\"-gapextend\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-gapextend\":1285}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(1285, tgt.gapExtend)
    }
  }

  @Nested
  @DisplayName(Flag.Penalty)
  internal inner class Penalty1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.penalty = 1285
      Assertions.assertEquals("{\"-penalty\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-penalty\":1285}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(1285, tgt.penalty)
    }
  }

  @Nested
  @DisplayName(Flag.Reward)
  internal inner class Reward1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.reward = 1285L
      Assertions.assertEquals("{\"-reward\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-reward\":1285}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(1285, tgt.reward)
    }
  }

  @Nested
  @DisplayName(Flag.UseIndex)
  internal inner class UseIndex1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.useIndex = true
      Assertions.assertEquals("{\"-use_index\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-use_index\":true}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(true, tgt.useIndex)
    }
  }

  @Nested
  @DisplayName(Flag.IndexName)
  internal inner class IndexName1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.indexName = "hi"
      Assertions.assertEquals("{\"-index_name\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-index_name\":\"hi\"}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals("hi", tgt.indexName)
    }
  }

  @Nested
  @DisplayName(Flag.SubjectFile)
  internal inner class SubjectFile1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.subjectFile = "hi"
      Assertions.assertEquals("{\"-subject\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject\":\"hi\"}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals("hi", tgt.subjectFile)
    }
  }

  @Nested
  @DisplayName(Flag.SubjectLocation)
  internal inner class SubjectLocation1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.subjectLocation = Location(10, 11)
      Assertions.assertEquals("{\"-subject_loc\":{\"start\":10,\"stop\":11}}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject_loc\":{\"start\":10,\"stop\":11}}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(10, tgt.subjectLocation!!.start)
      Assertions.assertEquals(11, tgt.subjectLocation!!.stop)
    }
  }

  @Nested
  @DisplayName(Flag.Dust)
  internal inner class Dust1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.dust = yesDust()
      Assertions.assertEquals("{\"-dust\":\"yes\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-dust\":\"yes\"}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertTrue(tgt.dust!!.isYes)
    }
  }

  @Nested
  @DisplayName(Flag.FilteringDB)
  internal inner class FilteringDB1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.filteringDB = "hi"
      Assertions.assertEquals("{\"-filtering_db\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-filtering_db\":\"hi\"}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals("hi", tgt.filteringDB)
    }
  }

  @Nested
  @DisplayName(Flag.WindowMaskerTaxID)
  internal inner class WindowMaskerTaxID1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.windowMaskerTaxID = 123
      Assertions.assertEquals("{\"-window_masker_taxid\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-window_masker_taxid\":123}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(123, tgt.windowMaskerTaxID)
    }
  }

  @Nested
  @DisplayName(Flag.WindowMaskerDB)
  internal inner class WindowMaskerDB1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.windowMaskerDB = "hi"
      Assertions.assertEquals("{\"-window_masker_db\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-window_masker_db\":\"hi\"}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals("hi", tgt.windowMaskerDB)
    }
  }

  @Nested
  @DisplayName(Flag.DBSoftMask)
  internal inner class DBSoftMask1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.dbSoftMask = "hi"
      Assertions.assertEquals("{\"-db_soft_mask\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-db_soft_mask\":\"hi\"}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals("hi", tgt.dbSoftMask)
    }
  }

  @Nested
  @DisplayName(Flag.DBHardMask)
  internal inner class DBHardMask1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.dbHardMask = "hi"
      Assertions.assertEquals("{\"-db_hard_mask\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-db_hard_mask\":\"hi\"}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals("hi", tgt.dbHardMask)
    }
  }

  @Nested
  @DisplayName(Flag.PercentIdentity)
  internal inner class PercentIdentity1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.percentIdentity = 3.14
      Assertions.assertEquals("{\"-perc_identity\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-perc_identity\":3.14}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(3.14, tgt.percentIdentity)
    }
  }

  @Nested
  @DisplayName(Flag.CullingLimit)
  internal inner class CullingLimit1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.cullingLimit = 123L
      Assertions.assertEquals("{\"-culling_limit\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-culling_limit\":123}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(123, tgt.cullingLimit)
    }
  }

  @Nested
  @DisplayName(Flag.TemplateType)
  internal inner class TemplateType1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.templateType = Optimal
      Assertions.assertEquals("{\"-template_type\":\"optimal\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-template_type\":\"optimal\"}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(Optimal, tgt.templateType)
    }
  }

  @Nested
  @DisplayName(Flag.TemplateLength)
  internal inner class TemplateLength1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.templateLength = Length18
      Assertions.assertEquals("{\"-template_length\":18}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-template_length\":18}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(Length18, tgt.templateLength)
    }
  }

  @Nested
  @DisplayName(Flag.SumStats)
  internal inner class SumStats1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.sumStats = true
      Assertions.assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-sum_stats\":true}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(true, tgt.sumStats)
    }
  }

  @Nested
  @DisplayName(Flag.ExtensionDropoffPrelimGapped)
  internal inner class ExtensionDropoffPrelimGapped1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.extensionDropoffPrelimGapped = 3.14
      Assertions.assertEquals("{\"-xdrop_gap\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-xdrop_gap\":3.14}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(3.14, tgt.extensionDropoffPrelimGapped)
    }
  }

  @Nested
  @DisplayName(Flag.ExtensionDropoffFinalGapped)
  internal inner class ExtensionDropoffFinalGapped1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.extensionDropoffFinalGapped = 3.14
      Assertions.assertEquals("{\"-xdrop_gap_final\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-xdrop_gap_final\":3.14}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(3.14, tgt.extensionDropoffFinalGapped)
    }
  }

  @Nested
  @DisplayName(Flag.NonGreedy)
  internal inner class NonGreedy1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.nonGreedy = true
      Assertions.assertEquals("{\"-no_greedy\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-no_greedy\":true}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(true, tgt.nonGreedy)
    }
  }

  @Nested
  @DisplayName(Flag.MinRawGappedScore)
  internal inner class MinRawGappedScore1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.minRawGappedScore = 123
      Assertions.assertEquals("{\"-min_raw_gapped_score\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-min_raw_gapped_score\":123}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(123, tgt.minRawGappedScore)
    }
  }

  @Nested
  @DisplayName(Flag.UngappedAlignmentsOnly)
  internal inner class UngappedAlignmentsOnly1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.ungappedAlignmentsOnly = true
      Assertions.assertEquals("{\"-ungapped\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-ungapped\":true}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(true, tgt.ungappedAlignmentsOnly)
    }
  }

  @Nested
  @DisplayName(Flag.OffDiagonalRange)
  internal inner class OffDiagonalRange1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.offDiagonalRange = 123L
      Assertions.assertEquals("{\"-off_diagonal_range\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-off_diagonal_range\":123}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(123, tgt.offDiagonalRange)
    }
  }

  @Nested
  @DisplayName(Flag.NumThreads)
  internal inner class NumThreads1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.numThreads = 123.toShort()
      Assertions.assertEquals("{\"-num_threads\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-num_threads\":123}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(123.toShort(), tgt.numThreads)
    }
  }

  @Nested
  @DisplayName(Flag.BestHitOverhang)
  internal inner class BestHitOverhang1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.bestHitOverhang = 123.0
      Assertions.assertEquals("{\"-best_hit_overhang\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-best_hit_overhang\":123.0}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(123.0, tgt.bestHitOverhang)
    }
  }

  @Nested
  @DisplayName(Flag.BestHitScoreEdge)
  internal inner class BestHitScoreEdge1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.bestHitScoreEdge = 123.0
      Assertions.assertEquals("{\"-best_hit_score_edge\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-best_hit_score_edge\":123.0}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(123.0, tgt.bestHitScoreEdge)
    }
  }

  @Nested
  @DisplayName(Flag.SubjectBestHit)
  internal inner class SubjectBestHit1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastN()
      tgt.subjectBestHit = true
      Assertions.assertEquals("{\"-subject_besthit\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject_besthit\":true}"
      val tgt = json.readValue(raw, BlastN::class.java)
      Assertions.assertEquals(true, tgt.subjectBestHit)
    }
  }
}