package org.veupathdb.lib.blast.common

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool

/**
 * List fields common to most BLAST+ query tools.
 */
interface BlastQueryWithLists : BlastQueryBase {
  /**
   * Restrict search of database to list of GIs
   */
  var giList: GIList

  /**
   * Restrict search of database to everything except the specified GIs
   */
  var negativeGIList: NegativeGIList

  /**
   * Restrict search of database to list of SeqIDs
   */
  var seqIdList: SeqIdList

  /**
   * Restrict search of database to everything except the specified SeqIDs
   */
  var negativeSeqIdList: NegativeSeqIdList

  /**
   * Restrict search of database to include only the specified taxonomy IDs
   */
  var taxIdList: TaxIdList

  /**
   * Restrict search of database to everything except the specified taxonomy IDs
   */
  var negativeTaxIdList: NegativeTaxIdList

  /**
   * Restrict search of database to include only the specified taxonomy IDs
   * (multiple IDs delimited by ',')
   */
  var taxIds: TaxIds

  /**
   * Restrict search of database to everything except the specified taxonomy IDs
   * (multiple IDs delimited by ',')
   */
  var negativeTaxIds: NegativeTaxIds
}


////////////////////////////////////////////////////////////////////////////////


internal open class blastWithLists(
  tool:                     BlastTool,
  shortHelp:                HelpShort,
  longHelp:                 HelpLong,
  version:                  Version,
  outFile:                  OutFile,
  outFormat:                OutFormat,
  showGIs:                  ShowGIs,
  numDescriptions:          NumDescriptions,
  numAlignments:            NumAlignments,
  lineLength:               LineLength,
  html:                     HTML,
  sortHits:                 SortHits,
  sortHSPs:                 SortHSPs,
  maxTargetSeqs:            MaxTargetSeqs,
  parseDefLines:            ParseDefLines,
  queryFile:                QueryFile,
  queryLocation:            QueryLocation,
  dbFile:                   DbFile,
  expectValue:              ExpectValue,
  softMasking:              SoftMasking,
  lowercaseMasking:         LowercaseMasking,
  entrezQuery:              EntrezQuery,
  maxHSPs:                  MaxHSPs,
  dbSize:                   DBSize,
  searchSpace:              SearchSpace,
  importSearchStrategy:     ImportSearchStrategy,
  exportSearchStrategy:     ExportSearchStrategy,
  extensionDropoffUngapped: ExtensionDropoffUngapped,
  windowSize:               WindowSize,
  remote:                   Remote,

  override var giList:            GIList,
  override var negativeGIList:    NegativeGIList,
  override var seqIdList:         SeqIdList,
  override var negativeSeqIdList: NegativeSeqIdList,
  override var taxIdList:         TaxIdList,
  override var negativeTaxIdList: NegativeTaxIdList,
  override var taxIds:            TaxIds,
  override var negativeTaxIds:    NegativeTaxIds,
) : BlastQueryWithLists, blastQueryBase(
  tool,
  shortHelp,
  longHelp,
  version,
  outFile,
  outFormat,
  showGIs,
  numDescriptions,
  numAlignments,
  lineLength,
  html,
  sortHits,
  sortHSPs,
  maxTargetSeqs,
  parseDefLines,
  queryFile,
  queryLocation,
  dbFile,
  expectValue,
  softMasking,
  lowercaseMasking,
  entrezQuery,
  maxHSPs,
  dbSize,
  searchSpace,
  importSearchStrategy,
  exportSearchStrategy,
  extensionDropoffUngapped,
  windowSize,
  remote,
) {

  constructor(tool: BlastTool, js: ObjectNode): this(
    tool,
    ParseHelpShort(js),
    ParseHelpLong(js),
    ParseVersion(js),
    ParseOutFile(js),
    ParseOutFormat(js),
    ParseShowGIs(js),
    ParseNumDescriptions(js),
    ParseNumAlignments(js),
    ParseLineLength(js),
    ParseHTML(js),
    ParseSortHits(js),
    ParseSortHSPs(js),
    ParseMaxTargetSeqs(js),
    ParseParseDefLines(js),
    ParseQueryFile(js),
    ParseQueryLocation(js),
    ParseDBFile(js),
    ParseEValue(js),
    ParseSoftMasking(js),
    ParseLowercaseMasking(js),
    ParseEntrezQuery(js),
    ParseMaxHSPs(js),
    ParseDBSize(js),
    ParseSearchSpace(js),
    ParseImportSearchStrategy(js),
    ParseExportSearchStrategy(js),
    ParseXDropUngap(js),
    ParseWindowSize(js),
    ParseRemote(js),
    ParseGIList(js),
    ParseNegGIList(js),
    ParseSeqIdList(js),
    ParseNegSeqIdList(js),
    ParseTaxIdList(js),
    ParseNegTaxIdList(js),
    ParseTaxIds(js),
    ParseNegTaxIds(js),
  )

  override fun appendJson(js: ObjectNode) {
    super.appendJson(js)

    giList.appendJson(js)
    negativeGIList.appendJson(js)
    seqIdList.appendJson(js)
    negativeSeqIdList.appendJson(js)
    taxIdList.appendJson(js)
    negativeTaxIdList.appendJson(js)
    taxIds.appendJson(js)
    negativeTaxIds.appendJson(js)
  }

  override fun appendCli(sb: StringBuilder) {
    super.appendCli(sb)

    giList.appendCliSegment(sb)
    negativeGIList.appendCliSegment(sb)
    seqIdList.appendCliSegment(sb)
    negativeSeqIdList.appendCliSegment(sb)
    taxIdList.appendCliSegment(sb)
    negativeTaxIdList.appendCliSegment(sb)
    taxIds.appendCliSegment(sb)
    negativeTaxIds.appendCliSegment(sb)
  }

  override fun appendCli(cli: MutableList<String>) {
    super.appendCli(cli)

    giList.appendCliParts(cli)
    negativeGIList.appendCliParts(cli)
    seqIdList.appendCliParts(cli)
    negativeSeqIdList.appendCliParts(cli)
    taxIdList.appendCliParts(cli)
    negativeTaxIdList.appendCliParts(cli)
    taxIds.appendCliParts(cli)
    negativeTaxIds.appendCliParts(cli)
  }
}