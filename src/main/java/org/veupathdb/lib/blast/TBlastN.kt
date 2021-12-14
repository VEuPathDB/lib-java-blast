package org.veupathdb.lib.blast

import com.fasterxml.jackson.annotation.JsonCreator
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.util.JSONObjectDecoder
import org.veupathdb.lib.blast.util.JSONObjectEncoder

class TBlastN constructor(
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
  var task: TBlastNTask? = null,
  var wordSize: Long? = null,
  var gapOpen: Int? = null,
  var gapExtend: Int? = null,
  var dBGenCode: Short? = null,
  var maxIntronLength: Long? = null,
  var matrix: ScoringMatrix? = null,
  var threshold: Double? = null,
  var compBasedStats: CompBasedStatsLong? = null,
  var subjectFile: String? = null,
  var subjectLocation: Location? = null,
  var seg: Seg? = null,
  var dBSoftMask: String? = null,
  var dBHardMask: String? = null,
  var cullingLimit: Long? = null,
  var sumStats: Boolean? = null,
  var extensionDropoffPrelimGapped: Double? = null,
  var extensionDropoffFinalGapped: Double? = null,
  var ungappedAlignmentsOnly: Boolean? = null,
  var numThreads: Short? = null,
  var useSmithWatermanTraceback: Boolean? = null,
  var bestHitOverhang: Double? = null,
  var bestHitScoreEdge: Double? = null,
  var subjectBestHit: Boolean? = null,
  var inPSSMFile: String? = null,
) : BlastWithLists(
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
  negativeTaxIDList
), BlastQueryConfig {
  override val tool = BlastTool.TBlastN

  @JsonCreator
  constructor(js: JSONObjectDecoder) : this() {
    decodeJSON(js)
  }

  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val js: JSONObjectEncoder = super<BlastWithLists>.toJSON(includeTool)

    js.encode(Flag.Task, task)
    js.encode(Flag.WordSize, wordSize)
    js.encode(Flag.GapOpen, gapOpen)
    js.encode(Flag.GapExtend, gapExtend)
    js.encode(Flag.DBGenCode, dBGenCode)
    js.encode(Flag.MaxIntronLength, maxIntronLength)
    js.encode(Flag.Matrix, matrix)
    js.encode(Flag.Threshold, threshold)
    js.encode(Flag.CompBasedStats, compBasedStats)
    js.encode(Flag.SubjectFile, subjectFile)
    js.encode(Flag.SubjectLocation, subjectLocation)
    js.encode(Flag.Seg, seg)
    js.encode(Flag.DBSoftMask, dBSoftMask)
    js.encode(Flag.DBHardMask, dBHardMask)
    js.encode(Flag.CullingLimit, cullingLimit)
    js.encode(Flag.SumStats, sumStats)
    js.encode(Flag.ExtensionDropoffPrelimGapped, extensionDropoffPrelimGapped)
    js.encode(Flag.ExtensionDropoffFinalGapped, extensionDropoffFinalGapped)
    js.encode(Flag.UngappedAlignmentsOnly, ungappedAlignmentsOnly)
    js.encode(Flag.NumThreads, numThreads)
    js.encode(Flag.UseSmithWatermanTraceback, useSmithWatermanTraceback)
    js.encode(Flag.BestHitOverhang, bestHitOverhang)
    js.encode(Flag.BestHitScoreEdge, bestHitScoreEdge)
    js.encode(Flag.SubjectBestHit, subjectBestHit)
    js.encode(Flag.InPSSMFile, inPSSMFile)

    return js
  }

  override fun decodeJSON(js: JSONObjectDecoder) {
    super<BlastWithLists>.decodeJSON(js)

    js.decodeJSON(Flag.Task) { task = TBlastNTask.fromJSON(it) }
    js.decodeLong(Flag.WordSize) { wordSize = it }
    js.decodeInt(Flag.GapOpen) { gapOpen = it }
    js.decodeInt(Flag.GapExtend) { gapExtend = it }
    js.decodeShort(Flag.DBGenCode) { dBGenCode = it }
    js.decodeLong(Flag.MaxIntronLength) { maxIntronLength = it }
    js.decodeJSON(Flag.Matrix) { matrix = ScoringMatrix.fromJSON(it) }
    js.decodeDouble(Flag.Threshold) { threshold = it }
    js.decodeJSON(Flag.CompBasedStats) { compBasedStats = CompBasedStatsLong.fromJSON(it) }
    js.decodeString(Flag.SubjectFile) { subjectFile = it }
    js.decodeJSON(Flag.SubjectLocation) { subjectLocation = Location(it) }
    js.decodeJSON(Flag.Seg) { seg = Seg.fromJSON(it) }
    js.decodeString(Flag.DBSoftMask) { dBSoftMask = it }
    js.decodeString(Flag.DBHardMask) { dBHardMask = it }
    js.decodeLong(Flag.CullingLimit) { cullingLimit = it }
    js.decodeBool(Flag.SumStats) { sumStats = it }
    js.decodeDouble(Flag.ExtensionDropoffPrelimGapped) { extensionDropoffPrelimGapped = it }
    js.decodeDouble(Flag.ExtensionDropoffFinalGapped) { extensionDropoffFinalGapped = it }
    js.decodeBool(Flag.UngappedAlignmentsOnly) { ungappedAlignmentsOnly = it }
    js.decodeShort(Flag.NumThreads) { numThreads = it }
    js.decodeBool(Flag.UseSmithWatermanTraceback) { useSmithWatermanTraceback = it }
    js.decodeDouble(Flag.BestHitOverhang) { bestHitOverhang = it }
    js.decodeDouble(Flag.BestHitScoreEdge) { bestHitScoreEdge = it }
    js.decodeBool(Flag.SubjectBestHit) { subjectBestHit = it }
    js.decodeString(Flag.InPSSMFile) { inPSSMFile = it }
  }
}