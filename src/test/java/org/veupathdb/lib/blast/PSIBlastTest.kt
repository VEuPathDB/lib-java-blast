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

@DisplayName("PSIBlast")
internal class PSIBlastTest : BlastWithIPGListContractTest() {
  private val json = ObjectMapper()
  override fun newConfig(): PSIBlast {
    return PSIBlast()
  }

  override fun configClass() = PSIBlast::class

  @Nested
  @DisplayName(Flag.WordSize)
  internal inner class WordSize1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.wordSize = 1285L
      Assertions.assertEquals("{\"-word_size\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-word_size\":1285}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.gapOpen = 1285
      Assertions.assertEquals("{\"-gapopen\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-gapopen\":1285}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.gapExtend = 1285
      Assertions.assertEquals("{\"-gapextend\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-gapextend\":1285}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(1285, tgt.gapExtend)
    }
  }

  @Nested
  @DisplayName(Flag.Matrix)
  internal inner class Matrix1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.matrix = Blosum50
      Assertions.assertEquals("{\"-matrix\":\"BLOSUM50\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-matrix\":\"BLOSUM50\"}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.threshold = 3.14
      Assertions.assertEquals("{\"-threshold\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-threshold\":3.14}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.compBasedStats = "hi"
      Assertions.assertEquals("{\"-comp_based_stats\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-comp_based_stats\":\"hi\"}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.subjectFile = "hi"
      Assertions.assertEquals("{\"-subject\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject\":\"hi\"}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.subjectLocation = Location(10, 11)
      Assertions.assertEquals("{\"-subject_loc\":{\"start\":10,\"stop\":11}}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject_loc\":{\"start\":10,\"stop\":11}}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.seg = YesSeg
      Assertions.assertEquals("{\"-seg\":\"yes\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-seg\":\"yes\"}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertTrue(tgt.seg!!.isYes)
    }
  }

  @Nested
  @DisplayName(Flag.CullingLimit)
  internal inner class CullingLimit1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.cullingLimit = 123L
      Assertions.assertEquals("{\"-culling_limit\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-culling_limit\":123}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.sumStats = true
      Assertions.assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-sum_stats\":true}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.extensionDropoffPrelimGapped = 3.14
      Assertions.assertEquals("{\"-xdrop_gap\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-xdrop_gap\":3.14}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.extensionDropoffFinalGapped = 3.14
      Assertions.assertEquals("{\"-xdrop_gap_final\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-xdrop_gap_final\":3.14}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(3.14, tgt.extensionDropoffFinalGapped)
    }
  }

  @Nested
  @DisplayName(Flag.GapTrigger)
  internal inner class GapTrigger1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.gapTrigger = 3.14
      Assertions.assertEquals("{\"-gap_trigger\":3.14}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-gap_trigger\":3.14}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(3.14, tgt.gapTrigger)
    }
  }

  @Nested
  @DisplayName(Flag.NumThreads)
  internal inner class NumThreads1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.numThreads = 123.toShort()
      Assertions.assertEquals("{\"-num_threads\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-num_threads\":123}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.useSmithWatermanTraceback = true
      Assertions.assertEquals("{\"-use_sw_tback\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-use_sw_tback\":true}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.bestHitOverhang = 123.0
      Assertions.assertEquals("{\"-best_hit_overhang\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-best_hit_overhang\":123.0}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.bestHitScoreEdge = 123.0
      Assertions.assertEquals("{\"-best_hit_score_edge\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-best_hit_score_edge\":123.0}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
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
      val tgt = PSIBlast()
      tgt.subjectBestHit = true
      Assertions.assertEquals("{\"-subject_besthit\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-subject_besthit\":true}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(true, tgt.subjectBestHit)
    }
  }

  @Nested
  @DisplayName(Flag.NumIterations)
  internal inner class NumIterations1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.numIterations = 1285L
      Assertions.assertEquals("{\"-num_iterations\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-num_iterations\":1285}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(1285, tgt.numIterations)
    }
  }

  @Nested
  @DisplayName(Flag.OutPSSMFile)
  internal inner class OutPSSMFile1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.outPSSMFile = "hi"
      Assertions.assertEquals("{\"-out_pssm\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-out_pssm\":\"hi\"}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals("hi", tgt.outPSSMFile)
    }
  }

  @Nested
  @DisplayName(Flag.OutASCIIPSSMFile)
  internal inner class OutASCIIPSSMFile1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.outASCIIPSSMFile = "hi"
      Assertions.assertEquals("{\"-out_ascii_pssm\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-out_ascii_pssm\":\"hi\"}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals("hi", tgt.outASCIIPSSMFile)
    }
  }

  @Nested
  @DisplayName(Flag.SavePSSMAfterLastRound)
  internal inner class SavePSSMAfterLastRound1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.savePSSMAfterLastRound = true
      Assertions.assertEquals("{\"-save_pssm_after_last_round\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-save_pssm_after_last_round\":true}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(true, tgt.savePSSMAfterLastRound)
    }
  }

  @Nested
  @DisplayName(Flag.SaveEachPSSM)
  internal inner class SaveEachPSSM1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.saveEachPSSM = true
      Assertions.assertEquals("{\"-save_each_pssm\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-save_each_pssm\":true}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(true, tgt.saveEachPSSM)
    }
  }

  @Nested
  @DisplayName(Flag.InMSAFile)
  internal inner class InMSAFile1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.inMSAFile = "hi"
      Assertions.assertEquals("{\"-in_msa\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-in_msa\":\"hi\"}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals("hi", tgt.inMSAFile)
    }
  }

  @Nested
  @DisplayName(Flag.MSAMasterIDX)
  internal inner class MSAMasterIDX1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.mSAMasterIDX = 123L
      Assertions.assertEquals("{\"-msa_master_idx\":123}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-msa_master_idx\":123}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(123, tgt.mSAMasterIDX)
    }
  }

  @Nested
  @DisplayName(Flag.IgnoreMSAMaster)
  internal inner class IgnoreMSAMaster1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.ignoreMSAMaster = true
      Assertions.assertEquals("{\"-ignore_msa_master\":true}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-ignore_msa_master\":true}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(true, tgt.ignoreMSAMaster)
    }
  }

  @Nested
  @DisplayName(Flag.InPSSMFile)
  internal inner class InPSSMFile1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.inPSSMFile = "hi"
      Assertions.assertEquals("{\"-in_pssm\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-in_pssm\":\"hi\"}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals("hi", tgt.inPSSMFile)
    }
  }

  @Nested
  @DisplayName(Flag.Pseudocount)
  internal inner class Pseudocount1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.pseudocount = 1285
      Assertions.assertEquals("{\"-pseudocount\":1285}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-pseudocount\":1285}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(1285, tgt.pseudocount)
    }
  }

  @Nested
  @DisplayName(Flag.InclusionEThreshold)
  internal inner class InclusionEThreshold1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.inclusionEThreshold = 123.0
      Assertions.assertEquals("{\"-inclusion_ethresh\":123.0}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-inclusion_ethresh\":123.0}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals(123.0, tgt.inclusionEThreshold)
    }
  }

  @Nested
  @DisplayName(Flag.PhiPatternFile)
  internal inner class PhiPatternFile1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = PSIBlast()
      tgt.phiPatternFile = "hi"
      Assertions.assertEquals("{\"-phi_pattern\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-phi_pattern\":\"hi\"}"
      val tgt = json.readValue(raw, PSIBlast::class.java)
      Assertions.assertEquals("hi", tgt.phiPatternFile)
    }
  }
}