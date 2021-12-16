package org.veupathdb.lib.blast

import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.util.JSONObjectEncoder
import org.veupathdb.lib.blast.util.JSONObjectDecoder

abstract class BlastWithLists(
  shortHelp:                             Boolean?         = null,
  longHelp:                              Boolean?         = null,
  version:                               Boolean?         = null,
  outFormat:                             OutFormat?       = null,
  showGIs:                               Boolean?         = null,
  numDescriptions:                       NumDescriptions? = null,
  numAlignments:                         NumAlignments?   = null,
  lineLength:                            LineLength?      = null,
  html:                                  Boolean?         = null,
  sortHits:                              HitSorting?      = null,
  sortHSPs:                              HSPSorting?      = null,
  maxTargetSequences:                    MaxTargetSeqs?   = null,
  outFile:                               OutFile?         = null,
  parseDefLines:                         Boolean?         = null,
  queryFile:                             QueryFile?       = null,
  queryLocation:                         Location?        = null,
  dbFile:                                String?          = null,
  expectValue:                           ExpectValue?     = null,
  softMasking:                           Boolean?         = null,
  lowercaseMasking:                      Boolean?         = null,
  entrezQuery:                           String?          = null,
  queryCoverageHSPPercent:               Double?          = null,
  maxHSPs:                               Long?            = null,
  dbSize:                                Byte?            = null,
  searchSpace:                           Short?           = null,
  importSearchStrategy:                  String?          = null,
  exportSearchStrategy:                  String?          = null,
  extensionDropoffUngapped:              Double?          = null,
  windowSize:                            Long?            = null,
  remote:                                Boolean?         = null,
  var giList: String? = null,
  var sequenceIDList: String? = null,
  var negativeGIList: String? = null,
  var negativeSequenceIDList: String? = null,
  var taxIDs: List<String>? = null,
  var negativeTaxIDs: List<String>? = null,
  var taxIDList: String? = null,
  var negativeTaxIDList: String? = null,
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
) {
  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val out = super.toJSON(includeTool)
    out.encode(Flag.GIList, giList)
    out.encode(Flag.SequenceIDList, sequenceIDList)
    out.encode(Flag.NegativeGIList, negativeGIList)
    out.encode(Flag.NegativeSequenceIDList, negativeSequenceIDList)
    out.encode(Flag.TaxIDs, taxIDs)
    out.encode(Flag.NegativeTaxIDs, negativeTaxIDs)
    out.encode(Flag.TaxIDList, taxIDList)
    out.encode(Flag.NegativeTaxIDList, negativeTaxIDList)
    return out
  }

  override fun decodeJSON(node: JSONObjectDecoder) {
    super.decodeJSON(node)
    node.decodeString(Flag.GIList) { giList = it }
    node.decodeString(Flag.SequenceIDList) { sequenceIDList = it }
    node.decodeString(Flag.NegativeGIList) { negativeGIList = it }
    node.decodeString(Flag.NegativeSequenceIDList) { negativeSequenceIDList = it }
    node.decodeStringList(Flag.TaxIDs) { taxIDs = it }
    node.decodeStringList(Flag.NegativeTaxIDs) { negativeTaxIDs = it }
    node.decodeString(Flag.TaxIDList) { taxIDList = it }
    node.decodeString(Flag.NegativeTaxIDList) { negativeTaxIDList = it }
  }
}