package org.veupathdb.lib.blast

import com.fasterxml.jackson.annotation.JsonCreator
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.util.JSONObjectDecoder
import org.veupathdb.lib.blast.util.JSONObjectEncoder

class PSIBlast(
  shortHelp: Boolean? = null,
  longHelp: Boolean? = null,
  version: Boolean? = null,
  outFormat: OutFormat? = null,
  showGIs: Boolean? = null,
  numDescriptions: NumDescriptions? = null,
  numAlignments: NumAlignments? = null,
  lineLength: LineLength? = null,
  html: Boolean? = null,
  sortHits: HitSorting? = null,
  sortHSPs: HSPSorting? = null,
  maxTargetSequences: MaxTargetSeqs? = null,
  outFile: OutFile? = null,
  parseDefLines: Boolean? = null,
  queryFile: QueryFile? = null,
  queryLocation: Location? = null,
  dbFile: String? = null,
  expectValue: ExpectValue? = null,
  softMasking: Boolean? = null,
  lowercaseMasking: Boolean? = null,
  entrezQuery: String? = null,
  queryCoverageHSPPercent: Double? = null,
  maxHSPs: Long? = null,
  dbSize: Byte? = null,
  searchSpace: Short? = null,
  importSearchStrategy: String? = null,
  exportSearchStrategy: String? = null,
  extensionDropoffUngapped: Double? = null,
  windowSize: Long? = null,
  remote: Boolean? = null,
  gIList: String? = null,
  sequenceIDList: String? = null,
  negativeGIList: String? = null,
  negativeSequenceIDList: String? = null,
  taxIDs: List<String?>? = null,
  negativeTaxIDs: List<String?>? = null,
  taxIDList: String? = null,
  negativeTaxIDList: String? = null,
  ipgList: String? = null,
  negativeIPGList: String? = null,
  var wordSize: Long? = null,
  var gapOpen: Int? = null,
  var gapExtend: Int? = null,
  var matrix: ScoringMatrix? = null,
  var threshold: Double? = null,
  var compBasedStats: CompBasedStatsLong? = null,
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
  var inMSAFile: String? = null,
  var mSAMasterIDX: Long? = null,
  var ignoreMSAMaster: Boolean? = null,
  var inPSSMFile: String? = null,
  var pseudocount: Int? = null,
  var inclusionEThreshold: Double? = null,
  var phiPatternFile: String? = null,
) : BlastWithIPGList(
  shortHelp,
  longHelp,
  version,
  outFormat,
  showGIs,
  numDescriptions,
  numAlignments,
  lineLength,
  html,
  sortHits,
  sortHSPs,
  maxTargetSequences,
  outFile,
  parseDefLines,
  queryFile,
  queryLocation,
  dbFile,
  expectValue,
  softMasking,
  lowercaseMasking,
  entrezQuery,
  queryCoverageHSPPercent,
  maxHSPs,
  dbSize,
  searchSpace,
  importSearchStrategy,
  exportSearchStrategy,
  extensionDropoffUngapped,
  windowSize,
  remote,
  gIList,
  sequenceIDList,
  negativeGIList,
  negativeSequenceIDList,
  taxIDs,
  negativeTaxIDs,
  taxIDList,
  negativeTaxIDList,
  ipgList,
  negativeIPGList
), BlastQueryConfig {
  override val tool = BlastTool.PSIBlast

  @JsonCreator
  constructor(js: JSONObjectDecoder) : this() {
    decodeJSON(js)
  }

  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val js: JSONObjectEncoder = super<BlastWithIPGList>.toJSON(includeTool)
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
    js.encode(Flag.InMSAFile, inMSAFile)
    js.encode(Flag.MSAMasterIDX, mSAMasterIDX)
    js.encode(Flag.IgnoreMSAMaster, ignoreMSAMaster)
    js.encode(Flag.InPSSMFile, inPSSMFile)
    js.encode(Flag.Pseudocount, pseudocount)
    js.encode(Flag.InclusionEThreshold, inclusionEThreshold)
    js.encode(Flag.PhiPatternFile, phiPatternFile)
    return js
  }

  override fun decodeJSON(js: JSONObjectDecoder) {
    super<BlastWithIPGList>.decodeJSON(js)

    js.decodeLong(Flag.WordSize) { wordSize = it }
    js.decodeInt(Flag.GapOpen) { gapOpen = it }
    js.decodeInt(Flag.GapExtend) { gapExtend = it }
    js.decodeJSON(Flag.Matrix) { matrix = ScoringMatrix.fromJSON(it) }
    js.decodeDouble(Flag.Threshold) { threshold = it }
    js.decodeJSON(Flag.CompBasedStats) { compBasedStats = CompBasedStatsLong.fromJSON(it) }
    js.decodeString(Flag.SubjectFile) { subjectFile = it }
    js.decodeJSON(Flag.SubjectLocation) { subjectLocation = Location(it)}
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
    js.decodeString(Flag.InMSAFile) { inMSAFile = it }
    js.decodeLong(Flag.MSAMasterIDX) { mSAMasterIDX = it }
    js.decodeBool(Flag.IgnoreMSAMaster) { ignoreMSAMaster = it }
    js.decodeString(Flag.InPSSMFile) { inPSSMFile = it }
    js.decodeInt(Flag.Pseudocount) { pseudocount = it }
    js.decodeDouble(Flag.InclusionEThreshold) { inclusionEThreshold = it }
    js.decodeString(Flag.PhiPatternFile) { phiPatternFile = it }
  }
}