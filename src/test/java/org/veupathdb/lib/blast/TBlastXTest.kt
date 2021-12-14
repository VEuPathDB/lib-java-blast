package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.Location
import org.veupathdb.lib.blast.field.ScoringMatrix.Blosum50
import org.veupathdb.lib.blast.field.Seg.Companion.YesSeg
import org.veupathdb.lib.blast.field.Strand.Minus

@DisplayName("TBlastX")
internal class TBlastXTest {
  private val json = ObjectMapper()

  @Nested
  @DisplayName(Flag.Strand)
  internal inner class Strand1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = TBlastX()
      tgt.strand = Minus
      Assertions.assertEquals("{\"-strand\":\"minus\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-strand\":\"minus\"}"
      val tgt = json.readValue(raw, TBlastX::class.java)
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
      val tgt = TBlastX()
      tgt.queryGenCode = 1285.toShort()
      Assertions.assertEquals("{\"-query_gencode\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-query_gencode\":1285}"
      val tgt = json.readValue(raw, TBlastX::class.java)
      Assertions.assertEquals(1285.toShort(), tgt.queryGenCode)
    }
  }

  @Nested
  @DisplayName(Flag.WordSize)
  internal inner class WordSize1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = TBlastX()
      tgt.wordSize = 1285L
      Assertions.assertEquals("{\"-word_size\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-word_size\":1285}"
      val tgt = json.readValue(raw, TBlastX::class.java)
      Assertions.assertEquals(1285, tgt.wordSize)
    }
  }

  @Nested
  @DisplayName(Flag.MaxIntronLength)
  internal inner class MaxIntronLength1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = TBlastX()
      tgt.maxIntronLength = 1285L
      Assertions.assertEquals("{\"-max_intron_length\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-max_intron_length\":1285}"
      val tgt = json.readValue(raw, TBlastX::class.java)
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
      val tgt = TBlastX()
      tgt.matrix = Blosum50
      Assertions.assertEquals("{\"-matrix\":\"BLOSUM50\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-matrix\":\"BLOSUM50\"}"
      val tgt = json.readValue(raw, TBlastX::class.java)
      Assertions.assertEquals(Blosum50, tgt.matrix)
    }
  }

  @Nested
  @DisplayName(Flag.Threshold)
  internal inner class Threshold1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = TBlastX()
      tgt.threshold = 3.14
      Assertions.assertEquals("{\"-threshold\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-threshold\":3.14}"
      val tgt = json.readValue(raw, TBlastX::class.java)
      Assertions.assertEquals(3.14, tgt.threshold)
    }
  }

  @Nested
  @DisplayName(Flag.DBGenCode)
  internal inner class DBGenCode1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = TBlastX()
      tgt.dbGenCode = 1285.toShort()
      Assertions.assertEquals("{\"-db_gencode\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-db_gencode\":1285}"
      val tgt = json.readValue(raw, TBlastX::class.java)
      Assertions.assertEquals(1285.toShort(), tgt.dbGenCode)
    }
  }

  @Nested
  @DisplayName(Flag.SubjectFile)
  internal inner class SubjectFile1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = TBlastX()
      tgt.subjectFile = "hi"
      Assertions.assertEquals("{\"-subject\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject\":\"hi\"}"
      val tgt = json.readValue(raw, TBlastX::class.java)
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
      val tgt = TBlastX()
      tgt.subjectLocation = Location(10, 11)
      Assertions.assertEquals("{\"-subject_loc\":{\"start\":10,\"stop\":11}}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject_loc\":{\"start\":10,\"stop\":11}}"
      val tgt = json.readValue(raw, TBlastX::class.java)
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
      val tgt = TBlastX()
      tgt.seg = YesSeg
      Assertions.assertEquals("{\"-seg\":\"yes\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-seg\":\"yes\"}"
      val tgt = json.readValue(raw, TBlastX::class.java)
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
      val tgt = TBlastX()
      tgt.dbSoftMask = "hi"
      Assertions.assertEquals("{\"-db_soft_mask\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-db_soft_mask\":\"hi\"}"
      val tgt = json.readValue(raw, TBlastX::class.java)
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
      val tgt = TBlastX()
      tgt.dbHardMask = "hi"
      Assertions.assertEquals("{\"-db_hard_mask\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-db_hard_mask\":\"hi\"}"
      val tgt = json.readValue(raw, TBlastX::class.java)
      Assertions.assertEquals("hi", tgt.dbHardMask)
    }
  }

  @Nested
  @DisplayName(Flag.CullingLimit)
  internal inner class CullingLimit1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = TBlastX()
      tgt.cullingLimit = 123L
      Assertions.assertEquals("{\"-culling_limit\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-culling_limit\":123}"
      val tgt = json.readValue(raw, TBlastX::class.java)
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
      val tgt = TBlastX()
      tgt.sumStats = true
      Assertions.assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-sum_stats\":true}"
      val tgt = json.readValue(raw, TBlastX::class.java)
      Assertions.assertEquals(true, tgt.sumStats)
    }
  }

  @Nested
  @DisplayName(Flag.NumThreads)
  internal inner class NumThreads1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = TBlastX()
      tgt.numThreads = 123.toShort()
      Assertions.assertEquals("{\"-num_threads\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-num_threads\":123}"
      val tgt = json.readValue(raw, TBlastX::class.java)
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
      val tgt = TBlastX()
      tgt.bestHitOverhang = 123.0
      Assertions.assertEquals("{\"-best_hit_overhang\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-best_hit_overhang\":123.0}"
      val tgt = json.readValue(raw, TBlastX::class.java)
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
      val tgt = TBlastX()
      tgt.bestHitScoreEdge = 123.0
      Assertions.assertEquals("{\"-best_hit_score_edge\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-best_hit_score_edge\":123.0}"
      val tgt = json.readValue(raw, TBlastX::class.java)
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
      val tgt = TBlastX()
      tgt.subjectBestHit = true
      Assertions.assertEquals("{\"-subject_besthit\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject_besthit\":true}"
      val tgt = json.readValue(raw, TBlastX::class.java)
      Assertions.assertEquals(true, tgt.subjectBestHit)
    }
  }
}