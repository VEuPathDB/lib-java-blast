package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.MTMode.SplitByQueries
import org.veupathdb.lib.blast.field.Seg.Companion.YesSeg
import org.veupathdb.lib.blast.field.Strand.Minus
import org.veupathdb.lib.blast.field.ThreadMode
import org.veupathdb.lib.blast.field.ThreadMode.Companion.Disable

@DisplayName("RPSTBlastN")
internal class RPSTBlastNTest {
  private val json = ObjectMapper()

  @Nested
  @DisplayName(Flag.QueryGenCode)
  internal inner class QueryGenCode1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSTBlastN()
      tgt.queryGenCode = 1285.toShort()
      Assertions.assertEquals("{\"-query_gencode\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-query_gencode\":1285}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
      Assertions.assertEquals(1285.toShort(), tgt.queryGenCode)
    }
  }

  @Nested
  @DisplayName(Flag.Strand)
  internal inner class Strand1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSTBlastN()
      tgt.strand = Minus
      Assertions.assertEquals("{\"-strand\":\"minus\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-strand\":\"minus\"}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
      Assertions.assertEquals(Minus, tgt.strand)
    }
  }

  @Nested
  @DisplayName(Flag.CompBasedStats)
  internal inner class CompBasedStats1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSTBlastN()
      tgt.compBasedStats = "hi"
      Assertions.assertEquals("{\"-comp_based_stats\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-comp_based_stats\":\"hi\"}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
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
      val tgt = RPSTBlastN()
      tgt.seg = YesSeg
      Assertions.assertEquals("{\"-seg\":\"yes\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-seg\":\"yes\"}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
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
      val tgt = RPSTBlastN()
      tgt.sumStats = true
      Assertions.assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-sum_stats\":true}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
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
      val tgt = RPSTBlastN()
      tgt.extensionDropoffPrelimGapped = 3.14
      Assertions.assertEquals("{\"-xdrop_gap\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-xdrop_gap\":3.14}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
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
      val tgt = RPSTBlastN()
      tgt.extensionDropoffFinalGapped = 3.14
      Assertions.assertEquals("{\"-xdrop_gap_final\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-xdrop_gap_final\":3.14}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
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
      val tgt = RPSTBlastN()
      tgt.ungappedAlignmentsOnly = true
      Assertions.assertEquals("{\"-ungapped\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-ungapped\":true}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
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
      val tgt = RPSTBlastN()
      tgt.numThreads = ThreadMode(3)
      Assertions.assertEquals("{\"-num_threads\":3}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-num_threads\":1}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
      Assertions.assertEquals(Disable, tgt.numThreads!!.value)
    }
  }

  @Nested
  @DisplayName(Flag.MTMode)
  internal inner class MTMode1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = RPSTBlastN()
      tgt.mTMode = SplitByQueries
      Assertions.assertEquals("{\"-mt_mode\":1}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-mt_mode\":1}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
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
      val tgt = RPSTBlastN()
      tgt.useSmithWatermanTraceback = true
      Assertions.assertEquals("{\"-use_sw_tback\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-use_sw_tback\":true}"
      val tgt = json.readValue(raw, RPSTBlastN::class.java)
      Assertions.assertEquals(true, tgt.useSmithWatermanTraceback)
    }
  }
}