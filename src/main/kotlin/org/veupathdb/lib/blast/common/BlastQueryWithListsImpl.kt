package org.veupathdb.lib.blast.common

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.field.*

internal abstract class BlastQueryWithListsImpl(
  tool: BlastTool,
  shortHelp: HelpShort,
  longHelp: HelpLong,
  version: Version,
  outFile: OutFile,
  outFormat: OutFormat,
  showGIs: ShowGIs,
  numDescriptions: NumDescriptions,
  numAlignments: NumAlignments,
  lineLength: LineLength,
  html: HTML,
  sortHits: SortHits,
  sortHSPs: SortHSPs,
  maxTargetSeqs: MaxTargetSeqs,
  parseDefLines: ParseDefLines,
  queryFile: QueryFile,
  queryLocation: QueryLocation,
  dbFile: DBFile,
  expectValue: ExpectValue,
  softMasking: SoftMasking,
  lowercaseMasking: LowercaseMasking,
  entrezQuery: EntrezQuery,
  maxHSPs: MaxHSPs,
  dbSize: DBSize,
  searchSpace: SearchSpace,
  importSearchStrategy: ImportSearchStrategy,
  exportSearchStrategy: ExportSearchStrategy,
  extensionDropoffUngapped: ExtensionDropoffUngapped,
  windowSize: WindowSize,
  remote: Remote,

  override var giListFile: GIList,
  override var negativeGIListFile: NegativeGIList,
  override var seqIdListFile: SeqIdList,
  override var negativeSeqIdListFile: NegativeSeqIdList,
  override var taxIdListFile: TaxIdList,
  override var negativeTaxIdListFile: NegativeTaxIdList,
  override var taxIds: TaxIds,
  override var negativeTaxIds: NegativeTaxIds,
) : BlastQueryWithLists, BlastQueryBaseImpl(
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

    giListFile.appendJson(js)
    negativeGIListFile.appendJson(js)
    seqIdListFile.appendJson(js)
    negativeSeqIdListFile.appendJson(js)
    taxIdListFile.appendJson(js)
    negativeTaxIdListFile.appendJson(js)
    taxIds.appendJson(js)
    negativeTaxIds.appendJson(js)
  }

  override fun appendCli(sb: StringBuilder) {
    super.appendCli(sb)

    giListFile.appendCliSegment(sb)
    negativeGIListFile.appendCliSegment(sb)
    seqIdListFile.appendCliSegment(sb)
    negativeSeqIdListFile.appendCliSegment(sb)
    taxIdListFile.appendCliSegment(sb)
    negativeTaxIdListFile.appendCliSegment(sb)
    taxIds.appendCliSegment(sb)
    negativeTaxIds.appendCliSegment(sb)
  }

  override fun appendCli(cli: MutableList<String>) {
    super.appendCli(cli)

    giListFile.appendCliParts(cli)
    negativeGIListFile.appendCliParts(cli)
    seqIdListFile.appendCliParts(cli)
    negativeSeqIdListFile.appendCliParts(cli)
    taxIdListFile.appendCliParts(cli)
    negativeTaxIdListFile.appendCliParts(cli)
    taxIds.appendCliParts(cli)
    negativeTaxIds.appendCliParts(cli)
  }
}
