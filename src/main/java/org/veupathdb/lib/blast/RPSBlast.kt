package org.veupathdb.lib.blast

import com.fasterxml.jackson.annotation.JsonCreator
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.util.JSONObjectDecoder
import org.veupathdb.lib.blast.util.JSONObjectEncoder

open class RPSBlast(
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
  var bestHitOverhang: Double? = null,
  var bestHitScoreEdge: Double? = null,
  var subjectBestHit: Boolean? = null,
  var compBasedStats: CompBasedStatsShort? = null,
  var seg: Seg? = null,
  var sumStats: Boolean? = null,
  var extensionDropoffPrelimGapped: Double? = null,
  var extensionDropoffFinalGapped: Double? = null,
  var numThreads: ThreadMode? = null,
  var mTMode: MTMode? = null,
  var useSmithWatermanTraceback: Boolean? = null,
) : BlastBase(
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
  remote
), BlastQueryConfig {

  @JsonCreator
  constructor(js: JSONObjectDecoder) : this() {
    decodeJSON(js)
  }

  override val tool = BlastTool.RPSBlast

  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val js: JSONObjectEncoder = super<BlastBase>.toJSON(includeTool)
    js.encode(Flag.BestHitOverhang, bestHitOverhang)
    js.encode(Flag.BestHitScoreEdge, bestHitScoreEdge)
    js.encode(Flag.SubjectBestHit, subjectBestHit)
    js.encode(Flag.CompBasedStats, compBasedStats)
    js.encode(Flag.Seg, seg)
    js.encode(Flag.SumStats, sumStats)
    js.encode(Flag.ExtensionDropoffPrelimGapped, extensionDropoffPrelimGapped)
    js.encode(Flag.ExtensionDropoffFinalGapped, extensionDropoffFinalGapped)
    js.encode(Flag.NumThreads, numThreads)
    js.encode(Flag.MTMode, mTMode)
    js.encode(Flag.UseSmithWatermanTraceback, useSmithWatermanTraceback)
    return js
  }

  override fun decodeJSON(node: JSONObjectDecoder) {
    super<BlastBase>.decodeJSON(node)

    node.decodeDouble(Flag.BestHitOverhang) { bestHitOverhang = it }
    node.decodeDouble(Flag.BestHitScoreEdge) { bestHitScoreEdge = it }
    node.decodeBool(Flag.SubjectBestHit) { subjectBestHit = it }
    node.decodeJSON(Flag.CompBasedStats) { compBasedStats = CompBasedStatsShort.fromJSON(it) }
    node.decodeJSON(Flag.Seg) { seg = Seg.fromJSON(it) }
    node.decodeBool(Flag.SumStats) { sumStats = it }
    node.decodeDouble(Flag.ExtensionDropoffPrelimGapped) { extensionDropoffPrelimGapped = it }
    node.decodeDouble(Flag.ExtensionDropoffFinalGapped) { extensionDropoffFinalGapped = it }
    node.decodeJSON(Flag.NumThreads) { numThreads = ThreadMode.fromJSON(it) }
    node.decodeJSON(Flag.MTMode) { mTMode = MTMode.fromJSON(it) }
    node.decodeBool(Flag.UseSmithWatermanTraceback) { useSmithWatermanTraceback = it }
  }
}