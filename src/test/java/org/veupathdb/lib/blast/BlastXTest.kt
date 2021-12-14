package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.BlastXTask.BlastXFast
import org.veupathdb.lib.blast.field.Location
import org.veupathdb.lib.blast.field.ScoringMatrix.Blosum62
import org.veupathdb.lib.blast.field.Seg.Companion.YesSeg
import org.veupathdb.lib.blast.field.Strand.Minus
import org.veupathdb.lib.blast.util.JSONObjectDecoder

@DisplayName("BlastX")
internal class BlastXTest : BlastWithIPGListContractTest() {
  override fun newConfig(): BlastX = BlastX()

  override fun configClass() = BlastX::class

  private val json = ObjectMapper()

  @Nested
  @DisplayName(Flag.Strand)
  internal inner class Strand1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.strand = Minus
      Assertions.assertEquals("{\"-strand\":\"minus\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-strand\":\"minus\"}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(Minus, tgt.strand)
    }
  }

  @Nested
  @DisplayName(Flag.QueryGenCode)
  internal inner class QueryGenCode1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.queryGenCode = 1285.toShort()
      Assertions.assertEquals("{\"-query_gencode\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-query_gencode\":1285}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(1285.toShort(), tgt.queryGenCode)
    }
  }

  @Nested
  @DisplayName(Flag.Task)
  internal inner class Task1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.task = BlastXFast
      Assertions.assertEquals("{\"-task\":\"blastx-fast\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-task\":\"blastx-fast\"}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(BlastXFast, tgt.task)
    }
  }

  @Nested
  @DisplayName(Flag.WordSize)
  internal inner class WordSize1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.wordSize = 1285L
      Assertions.assertEquals("{\"-word_size\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-word_size\":1285}"
      val tgt = json.readValue(raw, BlastX::class.java)
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
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.gapOpen = 1285
      Assertions.assertEquals("{\"-gapopen\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-gapopen\":1285}"
      val tgt = json.readValue(raw, BlastX::class.java)
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
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.gapExtend = 1285
      Assertions.assertEquals("{\"-gapextend\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-gapextend\":1285}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(1285, tgt.gapExtend)
    }
  }

  @Nested
  @DisplayName(Flag.MaxIntronLength)
  internal inner class MaxIntronLength1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.maxIntronLength = 1285L
      Assertions.assertEquals("{\"-max_intron_length\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-max_intron_length\":1285}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(1285, tgt.maxIntronLength)
    }
  }

  @Nested
  @DisplayName(Flag.Matrix)
  internal inner class Matrix1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.matrix = Blosum62
      Assertions.assertEquals("{\"-matrix\":\"BLOSUM62\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-matrix\":\"BLOSUM62\"}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(Blosum62, tgt.matrix)
    }
  }

  @Nested
  @DisplayName(Flag.Threshold)
  internal inner class Threshold1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.threshold = 3.14
      Assertions.assertEquals("{\"-threshold\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-threshold\":3.14}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(3.14, tgt.threshold)
    }
  }

  @Nested
  @DisplayName(Flag.CompBasedStats)
  internal inner class CompBasedStats1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.compBasedStats = "hi"
      Assertions.assertEquals("{\"-comp_based_stats\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-comp_based_stats\":\"hi\"}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals("hi", tgt.compBasedStats)
    }
  }

  @Nested
  @DisplayName(Flag.SubjectFile)
  internal inner class SubjectFile1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.subjectFile = "hi"
      Assertions.assertEquals("{\"-subject\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject\":\"hi\"}"
      val tgt = json.readValue(raw, BlastX::class.java)
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
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.subjectLocation = Location(10, 11)
      Assertions.assertEquals("{\"-subject_loc\":{\"start\":10,\"stop\":11}}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject_loc\":{\"start\":10,\"stop\":11}}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(10, tgt.subjectLocation!!.start)
      Assertions.assertEquals(11, tgt.subjectLocation!!.stop)
    }
  }

  @Nested
  @DisplayName(Flag.Seg)
  internal inner class Seg1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.seg = YesSeg
      Assertions.assertEquals("{\"-seg\":\"yes\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-seg\":\"yes\"}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertTrue(tgt.seg!!.isYes)
    }
  }

  @Nested
  @DisplayName(Flag.DBSoftMask)
  internal inner class DBSoftMask1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.dBSoftMask = "hi"
      Assertions.assertEquals("{\"-db_soft_mask\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-db_soft_mask\":\"hi\"}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals("hi", tgt.dBSoftMask)
    }
  }

  @Nested
  @DisplayName(Flag.DBHardMask)
  internal inner class DBHardMask1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.dBHardMask = "hi"
      Assertions.assertEquals("{\"-db_hard_mask\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-db_hard_mask\":\"hi\"}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals("hi", tgt.dBHardMask)
    }
  }

  @Nested
  @DisplayName(Flag.CullingLimit)
  internal inner class CullingLimit1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.cullingLimit = 123L
      Assertions.assertEquals("{\"-culling_limit\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-culling_limit\":123}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(123, tgt.cullingLimit)
    }
  }

  @Nested
  @DisplayName(Flag.SumStats)
  internal inner class SumStats1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.sumStats = true
      Assertions.assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-sum_stats\":true}"
      val tgt = json.readValue(raw, BlastX::class.java)
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
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.extensionDropoffPrelimGapped = 3.14
      Assertions.assertEquals("{\"-xdrop_gap\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-xdrop_gap\":3.14}"
      val tgt = json.readValue(raw, BlastX::class.java)
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
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.extensionDropoffFinalGapped = 3.14
      Assertions.assertEquals("{\"-xdrop_gap_final\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-xdrop_gap_final\":3.14}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(3.14, tgt.extensionDropoffFinalGapped)
    }
  }

  @Nested
  @DisplayName(Flag.UngappedAlignmentsOnly)
  internal inner class UngappedAlignmentsOnly1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.ungappedAlignmentsOnly = true
      Assertions.assertEquals("{\"-ungapped\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-ungapped\":true}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(true, tgt.ungappedAlignmentsOnly)
    }
  }

  @Nested
  @DisplayName(Flag.NumThreads)
  internal inner class NumThreads1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.numThreads = 123.toShort()
      Assertions.assertEquals("{\"-num_threads\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-num_threads\":123}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(123.toShort(), tgt.numThreads)
    }
  }

  @Nested
  @DisplayName(Flag.UseSmithWatermanTraceback)
  internal inner class UseSmithWatermanTraceback1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.useSmithWatermanTraceback = true
      Assertions.assertEquals("{\"-use_sw_tback\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-use_sw_tback\":true}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(true, tgt.useSmithWatermanTraceback)
    }
  }

  @Nested
  @DisplayName(Flag.BestHitOverhang)
  internal inner class BestHitOverhang1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.bestHitOverhang = 123.0
      Assertions.assertEquals("{\"-best_hit_overhang\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-best_hit_overhang\":123.0}"
      val tgt = json.readValue(raw, BlastX::class.java)
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
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.bestHitScoreEdge = 123.0
      Assertions.assertEquals("{\"-best_hit_score_edge\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-best_hit_score_edge\":123.0}"
      val tgt = json.readValue(raw, BlastX::class.java)
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
      val tgt = BlastX(JSONObjectDecoder(json.createObjectNode()))
      tgt.subjectBestHit = true
      Assertions.assertEquals("{\"-subject_besthit\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject_besthit\":true}"
      val tgt = json.readValue(raw, BlastX::class.java)
      Assertions.assertEquals(true, tgt.subjectBestHit)
    }
  }
}