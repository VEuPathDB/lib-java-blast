package org.veupathdb.lib.blast

import com.fasterxml.jackson.annotation.JsonCreator
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.util.JSONObjectDecoder
import org.veupathdb.lib.blast.util.JSONObjectEncoder

class TBlastX(
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
  var queryGenCode: Short? = null,
  var wordSize: Long? = null,
  var maxIntronLength: Long? = null,
  var matrix: ScoringMatrix? = null,
  var threshold: Double? = null,
  var dBGenCode: Short? = null,
  var subjectFile: String? = null,
  var subjectLocation: Location? = null,
  var seg: Seg? = null,
  var dBSoftMask: String? = null,
  var dBHardMask: String? = null,
  var cullingLimit: Long? = null,
  var sumStats: Boolean? = null,
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
  override val tool = BlastTool.TBlastX

  @JsonCreator
  constructor(js: JSONObjectDecoder): this() {
    decodeJSON(js)
  }


  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val js: JSONObjectEncoder = super<BlastWithLists>.toJSON(includeTool)

    js.encode(Flag.Strand, strand)
    js.encode(Flag.QueryGenCode, queryGenCode)
    js.encode(Flag.WordSize, wordSize)
    js.encode(Flag.MaxIntronLength, maxIntronLength)
    js.encode(Flag.Matrix, matrix)
    js.encode(Flag.Threshold, threshold)
    js.encode(Flag.DBGenCode, dBGenCode)
    js.encode(Flag.SubjectFile, subjectFile)
    js.encode(Flag.SubjectLocation, subjectLocation)
    js.encode(Flag.Seg, seg)
    js.encode(Flag.DBSoftMask, dBSoftMask)
    js.encode(Flag.DBHardMask, dBHardMask)
    js.encode(Flag.CullingLimit, cullingLimit)
    js.encode(Flag.SumStats, sumStats)
    js.encode(Flag.NumThreads, numThreads)
    js.encode(Flag.BestHitOverhang, bestHitOverhang)
    js.encode(Flag.BestHitScoreEdge, bestHitScoreEdge)
    js.encode(Flag.SubjectBestHit, subjectBestHit)

    return js
  }

  override fun decodeJSON(node: JSONObjectDecoder) {
    super<BlastWithLists>.decodeJSON(node)

    node.decodeJSON(Flag.Strand) { this.strand = Strand.fromJSON(it) }
    node.decodeShort(Flag.QueryGenCode) { this.queryGenCode = it }
    node.decodeLong(Flag.WordSize) { this.wordSize = it }
    node.decodeLong(Flag.MaxIntronLength) { this.maxIntronLength = it }
    node.decodeJSON(Flag.Matrix) { this.matrix = ScoringMatrix.fromJSON(it) }
    node.decodeDouble(Flag.Threshold) { this.threshold = it }
    node.decodeShort(Flag.DBGenCode) { dBGenCode = it }
    node.decodeString(Flag.SubjectFile) { this.subjectFile = it }
    node.decodeJSON(Flag.SubjectLocation) { this.subjectLocation = Location(it) }
    node.decodeJSON(Flag.Seg) { this.seg = Seg.fromJSON(it) }
    node.decodeString(Flag.DBSoftMask) { dBSoftMask = it }
    node.decodeString(Flag.DBHardMask) { dBHardMask = it }
    node.decodeLong(Flag.CullingLimit) { this.cullingLimit = it }
    node.decodeBool(Flag.SumStats) { this.sumStats = it }
    node.decodeShort(Flag.NumThreads) { this.numThreads = it }
    node.decodeDouble(Flag.BestHitOverhang) { this.bestHitOverhang = it }
    node.decodeDouble(Flag.BestHitScoreEdge) { this.bestHitScoreEdge = it }
    node.decodeBool(Flag.SubjectBestHit) { this.subjectBestHit = it }
  }
}