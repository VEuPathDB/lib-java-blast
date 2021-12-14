package org.veupathdb.lib.blast

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.util.JSONObjectDecoder
import org.veupathdb.lib.blast.util.JSONObjectEncoder

class BlastP(
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
  var task:                         BlastPTask?         = null,
  var wordSize:                     Long?               = null,
  var gapOpen:                      Int?                = null,
  var gapExtend:                    Int?                = null,
  var matrix:                       ScoringMatrix?      = null,
  var threshold:                    Double?             = null,
  var compBasedStats:               CompBasedStatsLong? = null,
  var subjectFile:                  String?             = null,
  var subjectLocation:              Location?           = null,
  var seg:                          Seg?                = null,
  var dbSoftMask:                   String?             = null,
  var dbHardMask:                   String?             = null,
  var cullingLimit:                 Long?               = null,
  var extensionDropoffPrelimGapped: Double?             = null,
  var extensionDropoffFinalGapped:  Double?             = null,
  var ungappedAlignmentsOnly:       Boolean?            = null,
  var numThreads:                   Short?              = null,
  var useSmithWatermanTraceback:    Boolean?            = null,
  var bestHitOverhang:              Double?             = null,
  var bestHitScoreEdge:             Double?             = null,
  var subjectBestHit:               Boolean?            = null,
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

  override val tool = BlastTool.BlastP

  @JsonCreator
  constructor(js: JSONObjectDecoder) : this() {
    decodeJSON(js)
  }

  @JsonValue
  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val out = super<BlastWithIPGList>.toJSON(includeTool)

    out.encode(Flag.Task, task)
    out.encode(Flag.WordSize, wordSize)
    out.encode(Flag.GapOpen, gapOpen)
    out.encode(Flag.GapExtend, gapExtend)
    out.encode(Flag.Matrix, matrix)
    out.encode(Flag.Threshold, threshold)
    out.encode(Flag.CompBasedStats, compBasedStats)
    out.encode(Flag.SubjectFile, subjectFile)
    out.encode(Flag.SubjectLocation, subjectLocation)
    out.encode(Flag.Seg, seg)
    out.encode(Flag.DBSoftMask, dbSoftMask)
    out.encode(Flag.DBHardMask, dbHardMask)
    out.encode(Flag.CullingLimit, cullingLimit)
    out.encode(Flag.ExtensionDropoffPrelimGapped, extensionDropoffPrelimGapped)
    out.encode(Flag.ExtensionDropoffFinalGapped, extensionDropoffFinalGapped)
    out.encode(Flag.UngappedAlignmentsOnly, ungappedAlignmentsOnly)
    out.encode(Flag.NumThreads, numThreads)
    out.encode(Flag.UseSmithWatermanTraceback, useSmithWatermanTraceback)
    out.encode(Flag.BestHitOverhang, bestHitOverhang)
    out.encode(Flag.BestHitScoreEdge, bestHitScoreEdge)
    out.encode(Flag.SubjectBestHit, subjectBestHit)

    return out
  }

  override fun decodeJSON(node: JSONObjectDecoder) {
    super<BlastWithIPGList>.decodeJSON(node)

    node.decodeJSON(Flag.Task) { task = BlastPTask.fromJSON(it) }
    node.decodeLong(Flag.WordSize) { wordSize = it }
    node.decodeInt(Flag.GapOpen) { gapOpen = it }
    node.decodeInt(Flag.GapExtend) { gapExtend = it }
    node.decodeJSON(Flag.Matrix) { matrix = ScoringMatrix.fromJSON(it) }
    node.decodeDouble(Flag.Threshold) { threshold = it }
    node.decodeJSON(Flag.CompBasedStats) { compBasedStats = CompBasedStatsLong.fromJSON(it) }
    node.decodeString(Flag.SubjectFile) { subjectFile = it }
    node.decodeJSON(Flag.SubjectLocation) { subjectLocation = Location(it) }
    node.decodeJSON(Flag.Seg) { seg = Seg.fromJSON(it) }
    node.decodeString(Flag.DBSoftMask) { dbSoftMask = it }
    node.decodeString(Flag.DBHardMask) { dbHardMask = it }
    node.decodeLong(Flag.CullingLimit) { cullingLimit = it }
    node.decodeDouble(Flag.ExtensionDropoffPrelimGapped) { extensionDropoffPrelimGapped = it }
    node.decodeDouble(Flag.ExtensionDropoffFinalGapped) { extensionDropoffFinalGapped = it }
    node.decodeBool(Flag.UngappedAlignmentsOnly) { ungappedAlignmentsOnly = it }
    node.decodeShort(Flag.NumThreads) { numThreads = it }
    node.decodeBool(Flag.UseSmithWatermanTraceback) { useSmithWatermanTraceback = it }
    node.decodeDouble(Flag.BestHitOverhang) { bestHitOverhang = it }
    node.decodeDouble(Flag.BestHitScoreEdge) { bestHitScoreEdge = it }
    node.decodeBool(Flag.SubjectBestHit) { subjectBestHit = it }
  }
}
