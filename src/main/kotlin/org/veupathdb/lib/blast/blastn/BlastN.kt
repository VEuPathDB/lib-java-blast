package org.veupathdb.lib.blast.blastn

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.blastn.fields.*
import org.veupathdb.lib.blast.blastn.fields.ParseMinRawGappedScore
import org.veupathdb.lib.blast.blastn.fields.ParseOffDiagonalRange
import org.veupathdb.lib.blast.blastn.fields.ParseTemplateType
import org.veupathdb.lib.blast.common.BlastQueryWithLists
import org.veupathdb.lib.blast.common.blastWithLists
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.field.*

/**
 * Nucleotide-Nucleotide BLAST 2.11.0+
 */
interface BlastN : BlastQueryWithLists {

  /**
   * -strand
   *
   * Query strand(s) to search against database/subject
   *
   * Default = `both`
   */
  var strand: Strand

  /**
   * -task
   *
   * Task to execute
   *
   * Default = `megablast`
   */
  var task: BlastNTask

  /**
   * -gapopen
   *
   * Cost to open a gap
   */
  var gapOpen: GapOpen

  /**
   * -gapextend
   *
   * Cost to extend a gap
   */
  var gapExtend: GapExtend

  /**
   * -penalty
   *
   * Penalty for a nucleotide mismatch
   */
  var penalty: Penalty

  /**
   * -reward
   *
   * Reward for a nucleotide match
   */
  var reward: Reward

  /**
   * -use_index
   *
   * Use MegaBLAST database index
   *
   * Default = `false`
   */
  var useIndex: UseIndex

  /**
   * -index_name
   *
   * MegaBLAST database index name (deprecated; use only for old style indices)
   */
  var indexName: IndexName

  /**
   * -subject
   *
   * Subject sequence(s) to search
   */
  var subjectFile: SubjectFile

  /**
   * -subject_loc
   *
   * Location on the subject sequence in 1-based offsets (Format: start-stop)
   */
  var subjectLocation: SubjectLocation

  /**
   * -dust
   *
   * Filter query sequence with DUST (Format: 'yes', 'level window linker', or
   * 'no' to disable)
   *
   * Default = `20 64 1`
   */
  var dust: Dust

  /**
   * -filtering_db
   *
   * BLAST database containing filtering elements (i.e.: repeats)
   */
  var filteringDB: FilteringDB

  /**
   * -window_masker_taxid
   *
   * Enable WindowMasker filtering using a Taxonomic ID
   */
  var windowMaskerTaxID: WindowMaskerTaxID

  /**
   * -window_masker_db
   *
   * Enable WindowMasker filtering using this repeats database.
   */
  var windowMaskerDB: WindowMaskerDB

  /**
   * -db_soft_mask
   *
   * Filtering algorithm ID to apply to the BLAST database as soft masking
   */
  var dbSoftMask: DBSoftMask

  /**
   * -db_hard_mask
   *
   * Filtering algorithm ID to apply to the BLAST database as hard masking
   */
  var dbHardMask: DBHardMask

  /**
   * -perc_identity
   *
   * Percent identity
   */
  var percentIdentity: PercentIdentity

  /**
   * -culling_limit
   *
   * If the query range of a hit is enveloped by that of at least this many
   * higher-scoring hits, delete the hit
   */
  var cullingLimit: CullingLimit

  /**
   * -template_type
   *
   * Discontiguous MegaBLAST template type
   *
   * Requires:
   * * template_length
   */
  var templateType: TemplateType

  /**
   * -template_length
   *
   * Discontiguous MegaBLAST template length
   *
   * Requires:
   * * template_type
   */
  var templateLength: TemplateLength

  /**
   * -sum_stats
   *
   * Use sum statistics
   */
  var sumStats: SumStats

  /**
   * -xdrop_gap
   *
   * X-dropoff value (in bits) for preliminary gapped extensions
   */
  var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped

  /**
   * -xdrop_gap_final
   *
   * X-dropoff value (in bits) for final gapped alignment
   */
  var extensionDropoffFinalGapped: ExtensionDropoffFinalGapped

  /**
   * -no_greedy
   *
   * Use non-greedy dynamic programming extension
   */
  var nonGreedy: NonGreedy

  /**
   * -min_raw_gapped_score
   *
   * Minimum raw gapped score to keep an alignment in the preliminary gapped and
   * traceback stages
   */
  var minRawGappedScore: MinRawGappedScore

  /**
   * -ungapped
   *
   * Perform ungapped alignment only?
   */
  var ungappedAlignmentsOnly: UngappedAlignmentsOnly

  /**
   * -off_diagonal_range
   *
   * Number of off-diagonals to search for the 2nd hit, use 0 to turn off
   *
   * Default = `0`
   */
  var offDiagonalRange: OffDiagonalRange

  /**
   * -num_threads
   *
   * Number of threads (CPUs) to use in the BLAST search
   *
   * Default = `1`
   */
  var numCpuCores: NumCPUCores

  /**
   * -best_hit_overhang
   *
   * Best Hit algorithm overhang value (recommended value: 0.1)
   */
  var bestHitOverhang: BestHitOverhang

  /**
   * -best_hit_score_edge
   *
   * Best Hit algorithm score edge value (recommended value: 0.1)
   */
  var bestHitScoreEdge: BestHitScoreEdge

  /**
   * -subject_besthit
   *
   * Turn on best hit per subject sequence
   */
  var subjectBestHit: SubjectBestHit
}


////////////////////////////////////////////////////////////////////////////////


internal class BlastNImpl(
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
  dbFile:                   DBFile,
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
  giList:                   GIList,
  negativeGIList:           NegativeGIList,
  seqIdList:                SeqIdList,
  negativeSeqIdList:        NegativeSeqIdList,
  taxIdList:                TaxIdList,
  negativeTaxIdList:        NegativeTaxIdList,
  taxIds:                   TaxIds,
  negativeTaxIds:           NegativeTaxIds,

  override var strand:                       Strand,
  override var task:                         BlastNTask,
  override var gapOpen:                      GapOpen,
  override var gapExtend:                    GapExtend,
  override var penalty:                      Penalty,
  override var reward:                       Reward,
  override var useIndex:                     UseIndex,
  override var indexName:                    IndexName,
  override var subjectFile:                  SubjectFile,
  override var subjectLocation:              SubjectLocation,
  override var dust:                         Dust,
  override var filteringDB:                  FilteringDB,
  override var windowMaskerTaxID:            WindowMaskerTaxID,
  override var windowMaskerDB:               WindowMaskerDB,
  override var dbSoftMask:                   DBSoftMask,
  override var dbHardMask:                   DBHardMask,
  override var percentIdentity:              PercentIdentity,
  override var cullingLimit:                 CullingLimit,
  override var templateType:                 TemplateType,
  override var templateLength:               TemplateLength,
  override var sumStats:                     SumStats,
  override var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped,
  override var extensionDropoffFinalGapped:  ExtensionDropoffFinalGapped,
  override var nonGreedy:                    NonGreedy,
  override var minRawGappedScore:            MinRawGappedScore,
  override var ungappedAlignmentsOnly:       UngappedAlignmentsOnly,
  override var offDiagonalRange:             OffDiagonalRange,
  override var numCpuCores:                  NumCPUCores,
  override var bestHitOverhang:              BestHitOverhang,
  override var bestHitScoreEdge:             BestHitScoreEdge,
  override var subjectBestHit:               SubjectBestHit
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
  constructor(js: ObjectNode): this (
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