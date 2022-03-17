package org.veupathdb.lib.blast.blastp

import org.veupathdb.lib.blast.blastp.field.*
import org.veupathdb.lib.blast.common.BlastQueryWithIPG
import org.veupathdb.lib.blast.common.fields.*

/**
 * Protein-Protein BLAST 2.11.0+
 */
interface BlastP : BlastQueryWithIPG {

  /**
   * -task
   *
   * Task to execute
   *
   * Default = `blastp`
   */
  var task: BlastPTask

  /**
   * -word_size
   *
   * Word size for wordfinder algorithm
   */
  var wordSize: WordSizeP

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
   * -matrix
   *
   * Scoring matrix name (normally BLOSUM62)
   */
  var matrix: BlastPMatrix

  /**
   * -threshold
   *
   * Minimum word score such that the word is added to the BLAST lookup table
   */
  var threshold: Threshold

  /**
   * -comp_based_stats
   *
   * Use composition-based statistics:
   * * D or d: default (equivalent to 2 )
   * * 0 or F or f: No composition-based statistics
   * * 1: Composition-based statistics as in NAR 29:2994-3005, 2001
   * * 2 or T or t : Composition-based score adjustment as in Bioinformatics
   *   21:902-911, 2005, conditioned on sequence properties
   * * 3: Composition-based score adjustment as in Bioinformatics 21:902-911,
   *   2005, unconditionally
   *
   * Default = `2`
   */
  var compBasedStats: CompBasedStatsP

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
   * -seg
   *
   * Filter query sequence with SEG (Format: 'yes', 'window locut hicut', or
   * 'no' to disable)
   *
   * Default = `no`
   */
  var seg: SegP

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
   * -culling_limit
   *
   * If the query range of a hit is enveloped by that of at least this many
   * higher-scoring hits, delete the hit
   */
  var cullingLimit: CullingLimit

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
   * -ungapped
   *
   * Perform ungapped alignment only?
   */
  var ungappedAlignmentsOnly: UngappedAlignmentsOnly

  /**
   * -num_threads
   *
   * Number of threads (CPUs) to use in the BLAST search
   *
   * Default = `1`
   */
  var numCPUCores: NumCPUCores

  /**
   * -use_sw_tback
   *
   * Compute locally optimal Smith-Waterman alignments?
   */
  var useSmithWatermanTraceback: UseSmithWatermanTraceback

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

  var softMasking: SoftMaskingP
}