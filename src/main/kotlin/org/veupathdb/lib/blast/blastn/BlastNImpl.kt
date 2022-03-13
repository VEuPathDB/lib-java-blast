package org.veupathdb.lib.blast.blastn

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.blastn.fields.*
import org.veupathdb.lib.blast.common.blastWithLists
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.field.*

internal class BlastNImpl(
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
  giList: GIList,
  negativeGIList: NegativeGIList,
  seqIdList: SeqIdList,
  negativeSeqIdList: NegativeSeqIdList,
  taxIdList: TaxIdList,
  negativeTaxIdList: NegativeTaxIdList,
  taxIds: TaxIds,
  negativeTaxIds: NegativeTaxIds,

  override var strand: Strand,
  override var task: BlastNTask,
  override var gapOpen: GapOpen,
  override var gapExtend: GapExtend,
  override var penalty: Penalty,
  override var reward: Reward,
  override var useIndex: UseIndex,
  override var indexName: IndexName,
  override var subjectFile: SubjectFile,
  override var subjectLocation: SubjectLocation,
  override var dust: Dust,
  override var filteringDB: FilteringDB,
  override var windowMaskerTaxID: WindowMaskerTaxID,
  override var windowMaskerDB: WindowMaskerDB,
  override var dbSoftMask: DBSoftMask,
  override var dbHardMask: DBHardMask,
  override var percentIdentity: PercentIdentity,
  override var cullingLimit: CullingLimit,
  override var templateType: TemplateType,
  override var templateLength: TemplateLength,
  override var sumStats: SumStats,
  override var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped,
  override var extensionDropoffFinalGapped: ExtensionDropoffFinalGapped,
  override var nonGreedy: NonGreedy,
  override var minRawGappedScore: MinRawGappedScore,
  override var ungappedAlignmentsOnly: UngappedAlignmentsOnly,
  override var offDiagonalRange: OffDiagonalRange,
  override var numCpuCores: NumCPUCores,
  override var bestHitOverhang: BestHitOverhang,
  override var bestHitScoreEdge: BestHitScoreEdge,
  override var subjectBestHit: SubjectBestHit,
) : BlastN, blastWithLists(
  BlastTool.BlastN,
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
  giList,
  negativeGIList,
  seqIdList,
  negativeSeqIdList,
  taxIdList,
  negativeTaxIdList,
  taxIds,
  negativeTaxIds,
) {
  constructor(js: ObjectNode) : this(
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
    ParseStrand(js),
    ParseBlastNTask(js),
    ParseGapOpen(js),
    ParseGapExtend(js),
    ParsePenalty(js),
    ParseReward(js),
    ParseUseIndex(js),
    ParseIndexName(js),
    ParseSubjectFile(js),
    ParseSubjectLocation(js),
    ParseDust(js),
    ParseFilteringDB(js),
    ParseWindowMaskerTaxID(js),
    ParseWindowMaskerDB(js),
    ParseDBSoftMask(js),
    ParseDBHardMask(js),
    ParsePercentIdentity(js),
    ParseCullingLimit(js),
    ParseTemplateType(js),
    ParseTemplateLength(js),
    ParseSumStats(js),
    ParseXDropGap(js),
    ParseXDropGapFinal(js),
    ParseNonGreedy(js),
    ParseMinRawGappedScore(js),
    ParseUngappedAlignmentsOnly(js),
    ParseOffDiagonalRange(js),
    ParseNumCPUCores(js),
    ParseBestHitOverhang(js),
    ParseBestHitScoreEdge(js),
    ParseSubjectBestHit(js)
  )

  override fun appendJson(js: ObjectNode) {
    super.appendJson(js)

    strand.appendJson(js)
    task.appendJson(js)
    gapOpen.appendJson(js)
    gapExtend.appendJson(js)
    penalty.appendJson(js)
    reward.appendJson(js)
    useIndex.appendJson(js)
    indexName.appendJson(js)
    subjectFile.appendJson(js)
    subjectLocation.appendJson(js)
    dust.appendJson(js)
    filteringDB.appendJson(js)
    windowMaskerTaxID.appendJson(js)
    windowMaskerDB.appendJson(js)
    dbSoftMask.appendJson(js)
    dbHardMask.appendJson(js)
    percentIdentity.appendJson(js)
    cullingLimit.appendJson(js)
    templateType.appendJson(js)
    templateLength.appendJson(js)
    sumStats.appendJson(js)
    extensionDropoffPrelimGapped.appendJson(js)
    extensionDropoffFinalGapped.appendJson(js)
    nonGreedy.appendJson(js)
    minRawGappedScore.appendJson(js)
    ungappedAlignmentsOnly.appendJson(js)
    offDiagonalRange.appendJson(js)
    numCpuCores.appendJson(js)
    bestHitOverhang.appendJson(js)
    bestHitScoreEdge.appendJson(js)
    subjectBestHit.appendJson(js)
  }

  override fun appendCli(sb: StringBuilder) {
    super.appendCli(sb)

    strand.appendCliSegment(sb)
    task.appendCliSegment(sb)
    gapOpen.appendCliSegment(sb)
    gapExtend.appendCliSegment(sb)
    penalty.appendCliSegment(sb)
    reward.appendCliSegment(sb)
    useIndex.appendCliSegment(sb)
    indexName.appendCliSegment(sb)
    subjectFile.appendCliSegment(sb)
    subjectLocation.appendCliSegment(sb)
    dust.appendCliSegment(sb)
    filteringDB.appendCliSegment(sb)
    windowMaskerTaxID.appendCliSegment(sb)
    windowMaskerDB.appendCliSegment(sb)
    dbSoftMask.appendCliSegment(sb)
    dbHardMask.appendCliSegment(sb)
    percentIdentity.appendCliSegment(sb)
    cullingLimit.appendCliSegment(sb)
    templateType.appendCliSegment(sb)
    templateLength.appendCliSegment(sb)
    sumStats.appendCliSegment(sb)
    extensionDropoffPrelimGapped.appendCliSegment(sb)
    extensionDropoffFinalGapped.appendCliSegment(sb)
    nonGreedy.appendCliSegment(sb)
    minRawGappedScore.appendCliSegment(sb)
    ungappedAlignmentsOnly.appendCliSegment(sb)
    offDiagonalRange.appendCliSegment(sb)
    numCpuCores.appendCliSegment(sb)
    bestHitOverhang.appendCliSegment(sb)
    bestHitScoreEdge.appendCliSegment(sb)
    subjectBestHit.appendCliSegment(sb)
  }

  override fun appendCli(cli: MutableList<String>) {
    super.appendCli(cli)

    strand.appendCliParts(cli)
    task.appendCliParts(cli)
    gapOpen.appendCliParts(cli)
    gapExtend.appendCliParts(cli)
    penalty.appendCliParts(cli)
    reward.appendCliParts(cli)
    useIndex.appendCliParts(cli)
    indexName.appendCliParts(cli)
    subjectFile.appendCliParts(cli)
    subjectLocation.appendCliParts(cli)
    dust.appendCliParts(cli)
    filteringDB.appendCliParts(cli)
    windowMaskerTaxID.appendCliParts(cli)
    windowMaskerDB.appendCliParts(cli)
    dbSoftMask.appendCliParts(cli)
    dbHardMask.appendCliParts(cli)
    percentIdentity.appendCliParts(cli)
    cullingLimit.appendCliParts(cli)
    templateType.appendCliParts(cli)
    templateLength.appendCliParts(cli)
    sumStats.appendCliParts(cli)
    extensionDropoffPrelimGapped.appendCliParts(cli)
    extensionDropoffFinalGapped.appendCliParts(cli)
    nonGreedy.appendCliParts(cli)
    minRawGappedScore.appendCliParts(cli)
    ungappedAlignmentsOnly.appendCliParts(cli)
    offDiagonalRange.appendCliParts(cli)
    numCpuCores.appendCliParts(cli)
    bestHitOverhang.appendCliParts(cli)
    bestHitScoreEdge.appendCliParts(cli)
    subjectBestHit.appendCliParts(cli)
  }
}
