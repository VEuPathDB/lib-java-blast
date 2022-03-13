package org.veupathdb.lib.blast.common

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.common.fields.DBFile
import org.veupathdb.lib.blast.common.fields.IPGList
import org.veupathdb.lib.blast.common.fields.NegativeIPGList
import org.veupathdb.lib.blast.field.*

internal abstract class BlastQueryWithIPGImpl(
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
  giListFile: GIList,
  negativeGIListFile: NegativeGIList,
  seqIdListFile: SeqIdList,
  negativeSeqIdListFile: NegativeSeqIdList,
  taxIdListFile: TaxIdList,
  negativeTaxIdListFile: NegativeTaxIdList,
  taxIds: TaxIds,
  negativeTaxIds: NegativeTaxIds,

  override var ipgListFile: IPGList,
  override var negativeIPGListFile: NegativeIPGList,
) : BlastQueryWithIPG, BlastQueryWithListsImpl(
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
  giListFile,
  negativeGIListFile,
  seqIdListFile,
  negativeSeqIdListFile,
  taxIdListFile,
  negativeTaxIdListFile,
  taxIds,
  negativeTaxIds,
) {
  override fun appendJson(js: ObjectNode) {
    super.appendJson(js)

    ipgListFile.appendJson(js)
    negativeIPGListFile.appendJson(js)
  }

  override fun appendCli(sb: StringBuilder) {
    super.appendCli(sb)

    ipgListFile.appendCliSegment(sb)
    negativeIPGListFile.appendCliSegment(sb)
  }

  override fun appendCli(cli: MutableList<String>) {
    super.appendCli(cli)

    ipgListFile.appendCliParts(cli)
    negativeIPGListFile.appendCliParts(cli)
  }
}