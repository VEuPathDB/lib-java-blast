package org.veupathdb.lib.blast

import com.fasterxml.jackson.annotation.JsonCreator

import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.CompBasedStatsShort
import org.veupathdb.lib.blast.field.Location
import org.veupathdb.lib.blast.field.ScoringMatrix
import org.veupathdb.lib.blast.field.Seg
import org.veupathdb.lib.blast.util.JSONObjectEncoder
import org.veupathdb.lib.blast.util.JSONObjectDecoder

class DeltaBlast(
  var wordSize: Long? = null,
  var gapOpen: Int? = null,
  var gapExtend: Int? = null,
  var matrix: ScoringMatrix? = null,
  var threshold: Double? = null,
  var compBasedStats: CompBasedStatsShort? = null,
  var subjectFile: String? = null,
  var subjectLocation: Location? = null,
  var seg: Seg? = null,
  var cullingLimit: Long? = null,
  var sumStats: Boolean? = null,
  var extensionDropoffPrelimGapped: Double? = null,
  var extensionDropoffFinalGapped: Double? = null,
  var gapTrigger: Double? = null,
  var numThreads: Short? = null,
  var useSmithWatermanTraceback: Boolean? = null,
  var bestHitOverhang: Double? = null,
  var bestHitScoreEdge: Double? = null,
  var subjectBestHit: Boolean? = null,
  var numIterations: Long? = null,
  var outPSSMFile: String? = null,
  var outASCIIPSSMFile: String? = null,
  var savePSSMAfterLastRound: Boolean? = null,
  var saveEachPSSM: Boolean? = null,
  var pseudocount: Int? = null,
  var domainInclusionEThreshold: Double? = null,
  var inclusionEThreshold: Double? = null,
  var rPSDBFile: String? = null,
  var showDomainHits: Boolean? = null,
) : BlastWithLists(), BlastQueryConfig {
  override val tool = BlastTool.DeltaBlast

  @JsonCreator
  constructor(js: JSONObjectDecoder) : this() {
    decodeJSON(js)
  }

  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val js: JSONObjectEncoder = super<BlastWithLists>.toJSON(includeTool)
    js.encode(Flag.WordSize, wordSize)
    js.encode(Flag.GapOpen, gapOpen)
    js.encode(Flag.GapExtend, gapExtend)
    js.encode(Flag.Matrix, matrix)
    js.encode(Flag.Threshold, threshold)
    js.encode(Flag.CompBasedStats, compBasedStats)
    js.encode(Flag.SubjectFile, subjectFile)
    js.encode(Flag.SubjectLocation, subjectLocation)
    js.encode(Flag.Seg, seg)
    js.encode(Flag.CullingLimit, cullingLimit)
    js.encode(Flag.SumStats, sumStats)
    js.encode(Flag.ExtensionDropoffPrelimGapped, extensionDropoffPrelimGapped)
    js.encode(Flag.ExtensionDropoffFinalGapped, extensionDropoffFinalGapped)
    js.encode(Flag.GapTrigger, gapTrigger)
    js.encode(Flag.NumThreads, numThreads)
    js.encode(Flag.UseSmithWatermanTraceback, useSmithWatermanTraceback)
    js.encode(Flag.BestHitOverhang, bestHitOverhang)
    js.encode(Flag.BestHitScoreEdge, bestHitScoreEdge)
    js.encode(Flag.SubjectBestHit, subjectBestHit)
    js.encode(Flag.NumIterations, numIterations)
    js.encode(Flag.OutPSSMFile, outPSSMFile)
    js.encode(Flag.OutASCIIPSSMFile, outASCIIPSSMFile)
    js.encode(Flag.SavePSSMAfterLastRound, savePSSMAfterLastRound)
    js.encode(Flag.SaveEachPSSM, saveEachPSSM)
    js.encode(Flag.Pseudocount, pseudocount)
    js.encode(Flag.DomainInclusionEThreshold, domainInclusionEThreshold)
    js.encode(Flag.InclusionEThreshold, inclusionEThreshold)
    js.encode(Flag.RPSDBFile, rPSDBFile)
    js.encode(Flag.ShowDomainHits, showDomainHits)
    return js
  }

  override fun decodeJSON(js: JSONObjectDecoder) {
    super<BlastWithLists>.decodeJSON(js)

    js.decodeLong(Flag.WordSize) { wordSize = it }
    js.decodeInt(Flag.GapOpen) { gapOpen = it }
    js.decodeInt(Flag.GapExtend) { gapExtend = it }
    js.decodeJSON(Flag.Matrix) { matrix = ScoringMatrix.fromJSON(it) }
    js.decodeDouble(Flag.Threshold) { threshold = it }
    js.decodeJSON(Flag.CompBasedStats) { compBasedStats = CompBasedStatsShort.fromJSON(it) }
    js.decodeString(Flag.SubjectFile) { subjectFile = it }
    js.decodeJSON(Flag.SubjectLocation) { subjectLocation = Location(it) }
    js.decodeJSON(Flag.Seg) { seg = Seg.fromJSON(it) }
    js.decodeLong(Flag.CullingLimit) { cullingLimit = it }
    js.decodeBool(Flag.SumStats) { sumStats = it }
    js.decodeDouble(Flag.ExtensionDropoffPrelimGapped) { extensionDropoffPrelimGapped = it }
    js.decodeDouble(Flag.ExtensionDropoffFinalGapped) { extensionDropoffFinalGapped = it }
    js.decodeDouble(Flag.GapTrigger) { gapTrigger = it }
    js.decodeShort(Flag.NumThreads) { numThreads = it }
    js.decodeBool(Flag.UseSmithWatermanTraceback) { useSmithWatermanTraceback = it }
    js.decodeDouble(Flag.BestHitOverhang) { bestHitOverhang = it }
    js.decodeDouble(Flag.BestHitScoreEdge) { bestHitScoreEdge = it }
    js.decodeBool(Flag.SubjectBestHit) { subjectBestHit = it }
    js.decodeLong(Flag.NumIterations) { numIterations = it }
    js.decodeString(Flag.OutPSSMFile) { outPSSMFile = it }
    js.decodeString(Flag.OutASCIIPSSMFile) { outASCIIPSSMFile = it }
    js.decodeBool(Flag.SavePSSMAfterLastRound) { savePSSMAfterLastRound = it }
    js.decodeBool(Flag.SaveEachPSSM) { saveEachPSSM = it }
    js.decodeInt(Flag.Pseudocount) { pseudocount = it }
    js.decodeDouble(Flag.DomainInclusionEThreshold) { domainInclusionEThreshold = it }
    js.decodeDouble(Flag.InclusionEThreshold) { inclusionEThreshold = it }
    js.decodeString(Flag.RPSDBFile) { rPSDBFile = it }
    js.decodeBool(Flag.ShowDomainHits) { showDomainHits = it }
  }
}
