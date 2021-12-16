package org.veupathdb.lib.blast

import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.util.JSONObjectEncoder
import org.veupathdb.lib.blast.util.JSONObjectDecoder

sealed class BlastWithIPGList(
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
  giList: String? = null,
  sequenceIDList: String? = null,
  negativeGIList: String? = null,
  negativeSequenceIDList: String? = null,
  taxIDs: List<String>? = null,
  negativeTaxIDs: List<String>? = null,
  taxIDList: String? = null,
  negativeTaxIDList: String? = null,
  var ipgList: String? = null,
  var negativeIPGList: String? = null,
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
  giList,
  sequenceIDList,
  negativeGIList,
  negativeSequenceIDList,
  taxIDs,
  negativeTaxIDs,
  taxIDList,
  negativeTaxIDList
) {

  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val out = super.toJSON(includeTool)
    out.encode(Flag.IPGList, ipgList)
    out.encode(Flag.NegativeIPGList, negativeIPGList)
    return out
  }

  override fun decodeJSON(node: JSONObjectDecoder) {
    super.decodeJSON(node)
    node.decodeString(Flag.IPGList) { ipgList = it }
    node.decodeString(Flag.NegativeIPGList) { this.negativeIPGList = it }
  }
}