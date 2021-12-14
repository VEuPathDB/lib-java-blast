package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.MTMode.SplitByQueries
import org.veupathdb.lib.blast.field.Seg.Companion.YesSeg
import org.veupathdb.lib.blast.field.ThreadMode

@DisplayName("RPSBlast")
internal class RPSBlastTest {
  private val json = ObjectMapper()

  @Nested
  @DisplayName(Flag.BestHitOverhang)
  internal inner class BestHitOverhang1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSBlast()
      tgt.bestHitOverhang = 123.0
      Assertions.assertEquals("{\"-best_hit_overhang\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-best_hit_overhang\":123.0}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
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
      val tgt = RPSBlast()
      tgt.bestHitScoreEdge = 123.0
      Assertions.assertEquals("{\"-best_hit_score_edge\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-best_hit_score_edge\":123.0}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
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
      val tgt = RPSBlast()
      tgt.subjectBestHit = true
      Assertions.assertEquals("{\"-subject_besthit\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject_besthit\":true}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
      Assertions.assertEquals(true, tgt.subjectBestHit)
    }
  }

  @Nested
  @DisplayName(Flag.CompBasedStats)
  internal inner class CompBasedStats1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSBlast()
      tgt.compBasedStats = "hi"
      Assertions.assertEquals("{\"-comp_based_stats\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-comp_based_stats\":\"hi\"}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
      Assertions.assertEquals("hi", tgt.compBasedStats)
    }
  }

  @Nested
  @DisplayName(Flag.Seg)
  internal inner class Seg1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSBlast()
      tgt.seg = YesSeg
      Assertions.assertEquals("{\"-seg\":\"yes\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-seg\":\"yes\"}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
      Assertions.assertTrue(tgt.seg!!.isYes)
    }
  }

  @Nested
  @DisplayName(Flag.SumStats)
  internal inner class SumStats1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSBlast()
      tgt.sumStats = true
      Assertions.assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-sum_stats\":true}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
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
      val tgt = RPSBlast()
      tgt.extensionDropoffPrelimGapped = 3.14
      Assertions.assertEquals("{\"-xdrop_gap\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-xdrop_gap\":3.14}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
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
      val tgt = RPSBlast()
      tgt.extensionDropoffFinalGapped = 3.14
      Assertions.assertEquals("{\"-xdrop_gap_final\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-xdrop_gap_final\":3.14}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
      Assertions.assertEquals(3.14, tgt.extensionDropoffFinalGapped)
    }
  }

  @Nested
  @DisplayName(Flag.NumThreads)
  internal inner class NumThreads1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSBlast()
      tgt.numThreads = ThreadMode(3)
      Assertions.assertEquals("{\"-num_threads\":3}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-num_threads\":3}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
      Assertions.assertEquals(ThreadMode(3), tgt.numThreads)
    }
  }

  @Nested
  @DisplayName(Flag.MTMode)
  internal inner class MTMode1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSBlast()
      tgt.mTMode = SplitByQueries
      Assertions.assertEquals("{\"-mt_mode\":1}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-mt_mode\":1}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
      Assertions.assertEquals(SplitByQueries, tgt.mTMode)
    }
  }

  @Nested
  @DisplayName(Flag.UseSmithWatermanTraceback)
  internal inner class UseSmithWatermanTraceback1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSBlast()
      tgt.useSmithWatermanTraceback = true
      Assertions.assertEquals("{\"-use_sw_tback\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-use_sw_tback\":true}"
      val tgt = json.readValue(raw, RPSBlast::class.java)
      Assertions.assertEquals(true, tgt.useSmithWatermanTraceback)
    }
  }
}