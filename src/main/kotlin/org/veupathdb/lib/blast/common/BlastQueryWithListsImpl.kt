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
  override var negativeSeqIDListFile: NegativeSeqIDList,
  override var taxIdListFile: TaxIdList,
  override var negativeTaxIdListFile: NegativeTaxIdList,
  override var taxIds: TaxIDs,
  override var negativeTaxIds: NegativeTaxIDs,
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

  override fun appendJson(js: ObjectNode) {
    super.appendJson(js)

    giListFile.appendJson(js)
    negativeGIListFile.appendJson(js)
    seqIdListFile.appendJson(js)
    negativeSeqIDListFile.appendJson(js)
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
    negativeSeqIDListFile.appendCliSegment(sb)
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
    negativeSeqIDListFile.appendCliParts(cli)
    taxIdListFile.appendCliParts(cli)
    negativeTaxIdListFile.appendCliParts(cli)
    taxIds.appendCliParts(cli)
    negativeTaxIds.appendCliParts(cli)
  }
}
