package org.veupathdb.lib.blast

import org.veupathdb.lib.blast.util.JSONObjectEncoder
import org.veupathdb.lib.blast.util.JSONObjectDecoder
import com.fasterxml.jackson.annotation.JsonCreator
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.*

class BlastN(
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
  var strand: Strand? = null,
  var task: BlastNTask? = null,
  var wordSize: Long? = null,
  var gapOpen: Int? = null,
  var gapExtend: Int? = null,
  var penalty: Int? = null,
  var reward: Long? = null,
  var useIndex: Boolean? = null,
  var indexName: String? = null,
  var subjectFile: String? = null,
  var subjectLocation: Location? = null,
  var dust: Dust? = null,
  var filteringDB: String? = null,
  var windowMaskerTaxID: Int? = null,
  var windowMaskerDB: String? = null,
  var dbSoftMask: String? = null,
  var dbHardMask: String? = null,
  var percentIdentity: Double? = null,
  var cullingLimit: Long? = null,
  var templateType: TemplateType? = null,
  var templateLength: TemplateLength? = null,
  var sumStats: Boolean? = null,
  var extensionDropoffPrelimGapped: Double? = null,
  var extensionDropoffFinalGapped: Double? = null,
  var nonGreedy: Boolean? = null,
  var minRawGappedScore: Int? = null,
  var ungappedAlignmentsOnly: Boolean? = null,
  var offDiagonalRange: Long? = null,
  var numThreads: Short? = null,
  var bestHitOverhang: Double? = null,
  var bestHitScoreEdge: Double? = null,
  var subjectBestHit: Boolean? = null,
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
  override val tool = BlastTool.BlastN

  @JsonCreator
  constructor(js: JSONObjectDecoder) : this() {
    decodeJSON(js)
  }

  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val out: JSONObjectEncoder = super<BlastWithLists>.toJSON(includeTool)
    out.encode(Flag.Strand, strand)
    out.encode(Flag.Task, task)
    out.encode(Flag.WordSize, wordSize)
    out.encode(Flag.GapOpen, gapOpen)
    out.encode(Flag.GapExtend, gapExtend)
    out.encode(Flag.Penalty, penalty)
    out.encode(Flag.Reward, reward)
    out.encode(Flag.UseIndex, useIndex)
    out.encode(Flag.IndexName, indexName)
    out.encode(Flag.SubjectFile, subjectFile)
    out.encode(Flag.SubjectLocation, subjectLocation)
    out.encode(Flag.Dust, dust)
    out.encode(Flag.FilteringDB, filteringDB)
    out.encode(Flag.WindowMaskerTaxID, windowMaskerTaxID)
    out.encode(Flag.WindowMaskerDB, windowMaskerDB)
    out.encode(Flag.DBSoftMask, dbSoftMask)
    out.encode(Flag.DBHardMask, dbHardMask)
    out.encode(Flag.PercentIdentity, percentIdentity)
    out.encode(Flag.CullingLimit, cullingLimit)
    out.encode(Flag.TemplateType, templateType)
    out.encode(Flag.TemplateLength, templateLength)
    out.encode(Flag.SumStats, sumStats)
    out.encode(Flag.ExtensionDropoffPrelimGapped, extensionDropoffPrelimGapped)
    out.encode(Flag.ExtensionDropoffFinalGapped, extensionDropoffFinalGapped)
    out.encode(Flag.NonGreedy, nonGreedy)
    out.encode(Flag.MinRawGappedScore, minRawGappedScore)
    out.encode(Flag.UngappedAlignmentsOnly, ungappedAlignmentsOnly)
    out.encode(Flag.OffDiagonalRange, offDiagonalRange)
    out.encode(Flag.NumThreads, numThreads)
    out.encode(Flag.BestHitOverhang, bestHitOverhang)
    out.encode(Flag.BestHitScoreEdge, bestHitScoreEdge)
    out.encode(Flag.SubjectBestHit, subjectBestHit)
    return out
  }

  override fun decodeJSON(node: JSONObjectDecoder) {
    super<BlastWithLists>.decodeJSON(node)

    node.decodeJSON(Flag.Strand) { strand = Strand.fromJSON(it) }
    node.decodeJSON(Flag.Task) { task = BlastNTask.fromJSON(it) }
    node.decodeLong(Flag.WordSize) { wordSize = it }
    node.decodeInt(Flag.GapOpen) { gapOpen = it }
    node.decodeInt(Flag.GapExtend) { gapExtend = it }
    node.decodeInt(Flag.Penalty) { penalty = it }
    node.decodeLong(Flag.Reward) { reward = it }
    node.decodeBool(Flag.UseIndex) { useIndex = it }
    node.decodeString(Flag.IndexName) { indexName = it }
    node.decodeString(Flag.SubjectFile) { subjectFile = it }
    node.decodeJSON(Flag.SubjectLocation) { subjectLocation = Location(it) }
    node.decodeJSON(Flag.Dust) { dust = Dust.fromJSON(it) }
    node.decodeString(Flag.FilteringDB) { filteringDB = it }
    node.decodeInt(Flag.WindowMaskerTaxID) { windowMaskerTaxID = it }
    node.decodeString(Flag.WindowMaskerDB) { windowMaskerDB = it }
    node.decodeString(Flag.DBSoftMask) { dbSoftMask = it }
    node.decodeString(Flag.DBHardMask) { dbHardMask = it }
    node.decodeDouble(Flag.PercentIdentity) { percentIdentity = it }
    node.decodeLong(Flag.CullingLimit) { cullingLimit = it }
    node.decodeJSON(Flag.TemplateType) { templateType = TemplateType.fromJSON(it) }
    node.decodeJSON(Flag.TemplateLength) { templateLength = TemplateLength.fromJSON(it) }
    node.decodeBool(Flag.SumStats) { sumStats = it }
    node.decodeDouble(Flag.ExtensionDropoffPrelimGapped) { extensionDropoffPrelimGapped = it }
    node.decodeDouble(Flag.ExtensionDropoffFinalGapped) { extensionDropoffFinalGapped = it }
    node.decodeBool(Flag.NonGreedy) { nonGreedy = it }
    node.decodeInt(Flag.MinRawGappedScore) { minRawGappedScore = it }
    node.decodeBool(Flag.UngappedAlignmentsOnly) { ungappedAlignmentsOnly = it }
    node.decodeLong(Flag.OffDiagonalRange) { offDiagonalRange = it }
    node.decodeShort(Flag.NumThreads) { numThreads = it }
    node.decodeDouble(Flag.BestHitOverhang) { bestHitOverhang = it }
    node.decodeDouble(Flag.BestHitScoreEdge) { bestHitScoreEdge = it }
    node.decodeBool(Flag.SubjectBestHit) { subjectBestHit = it }
  }
}