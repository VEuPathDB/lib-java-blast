package org.veupathdb.lib.blast.blastn

import org.veupathdb.lib.blast.blastn.fields.*
import org.veupathdb.lib.blast.common.BlastQueryWithLists
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


