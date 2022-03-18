package org.veupathdb.lib.blast.deltablast

import org.veupathdb.lib.blast.common.BlastQueryWithLists
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.deltablast.fields.*

interface DeltaBlast : BlastQueryWithLists {

  /**
   * -word_size <Integer, >=2>
   *
   * Word size for wordfinder algorithm
   */
  var wordSize: WordSizeDelta

  /**
   * -gapopen <Integer>
   *
   * Cost to open a gap
   */
  var gapOpen: GapOpen

  /**
   * -gapextend <Integer>
   *
   * Cost to extend a gap
   */
  var gapExtend: GapExtend

  /**
   * -matrix <String>
   *
   * Scoring matrix name (normally BLOSUM62)
   */
  var matrix: MatrixDelta

  /**
   * -threshold <Real, >=0>
   *
   * Minimum word score such that the word is added to the BLAST lookup table
   */
  var threshold: Threshold

  /**
   * -comp_based_stats <String>
   * Use composition-based statistics:
   * * D or d: default (equivalent to 1)
   * * 0 or F or f: No composition-based statistics
   * * 1 or T or t: Composition-based statistics as in NAR 29:2994-3005, 2001
   *
   * Default = `1`
   */
  var compBasedStats: CompBasedStatsDelta

  /**
   * -subject <File_In>
   *
   * Subject sequence(s) to search
   *
   * Incompatible with:
   * * db
   * * gilist
   * * seqidlist
   * * negative_gilist
   * * negative_seqidlist
   * * taxids
   * * taxidlist
   * * negative_taxids
   * * negative_taxidlist
   * * show_domain_hits
   */
  var subjectFile: SubjectFile

  /**
   * -subject_loc <String>
   *
   * Location on the subject sequence in 1-based offsets (Format: start-stop)
   *
   * Incompatible with:
   * * db
   * * gilist
   * * seqidlist
   * * negative_gilist
   * * negative_seqidlist
   * * taxids
   * * taxidlist
   * * negative_taxids
   * * negative_taxidlist
   * * remote
   */
  var subjectLocation: SubjectLocation

  /**
   * -seg <String>
   *
   * Filter query sequence with SEG (Format: 'yes', 'window locut hicut', or
   * 'no' to disable)
   *
   * Default = `no`
   */
  var seg: SegDelta

  /**
   * -soft_masking <Boolean>
   *
   * Apply filtering locations as soft masks
   *
   * Default = `false`
   */
  var softMasking: SoftMaskingDelta

  /**
   * -qcov_hsp_perc <Real, 0..100>
   *
   * Percent query coverage per hsp
   */
  var queryCoverageHSPPercent: QueryCoverageHSPPercent

  /**
   * -culling_limit <Integer, >=0>
   *
   * If the query range of a hit is enveloped by that of at least this many
   * higher-scoring hits, delete the hit
   *
   * Incompatible with:
   * * best_hit_overhang
   * * best_hit_score_edge
   */
  var cullingLimit: CullingLimit

  /**
   * -best_hit_overhang <Real, (>0 and <0.5)>
   *
   * Best Hit algorithm overhang value (recommended value: 0.1)
   *
   * Incompatible with:
   * * culling_limit
   */
  var bestHitOverhang: BestHitOverhang

  /**
   * -best_hit_score_edge <Real, (>0 and <0.5)>
   *
   * Best Hit algorithm score edge value (recommended value: 0.1)
   *
   * Incompatible with:
   * * culling_limit
   */
  var bestHitScoreEdge: BestHitScoreEdge

  /**
   * -subject_besthit
   *
   * Turn on best hit per subject sequence
   */
  var subjectBestHit: SubjectBestHit

  /**
   * -max_target_seqs <Integer, >=1>
   *
   * Maximum number of aligned sequences to keep (value of 5 or more is
   * recommended)
   *
   * Default = `500`
   *
   * Incompatible with:
   * * num_descriptions
   * * num_alignments
   */
  var sumStats: SumStats

  /**
   * -xdrop_gap <Real>
   *
   * X-dropoff value (in bits) for preliminary gapped extensions
   */
  var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped

  /**
   * -xdrop_gap_final <Real>
   *
   * X-dropoff value (in bits) for final gapped alignment
   */
  var extensionDropoffFinalGapped: ExtensionDropoffFinalGapped

  /**
   * -gap_trigger <Real>
   *
   * Number of bits to trigger gapping
   *
   * Default = `22`
   */
  var gapTrigger: GapTrigger

  /**
   * -num_threads <Integer, >=1>
   *
   * Number of threads (CPUs) to use in the BLAST search
   *
   * Default = `1`
   *
   * Incompatible with:
   * * remote
   */
  var numCPUCores: NumCPUCores

  /**
   * -use_sw_tback
   *
   * Compute locally optimal Smith-Waterman alignments?
   */
  var useSmithWatermanTraceback: UseSmithWatermanTraceback

  /**
   * -num_iterations <Integer, >=0>
   *
   * Number of iterations to perform (0 means run until convergence)
   *
   * Default = `1`
   */
  var numIterations: NumIterations

  /**
   * -out_pssm <File_Out>
   *
   * File name to store checkpoint file
   */
  var outPSSMFile: OutPSSMFile

  /**
   * -out_ascii_pssm <File_Out>
   *
   * File name to store ASCII version of PSSM
   */
  var outASCIIPSSMFile: OutASCIIPSSMFile

  /**
   * -save_pssm_after_last_round
   *
   * Save PSSM after the last database search
   */
  var savePSSMAfterLastRound: SavePSSMAfterLastRound

  /**
   * -save_each_pssm
   *
   * Save PSSM after each iteration (file name is given in -save_pssm or
   * -save_ascii_pssm options)
   */
  var saveEachPSSM: SaveEachPSSM

  /**
   * -pseudocount <Integer>
   *
   * Pseudo-count value used when constructing PSSM
   *
   * Default = `0`
   */
  var pseudoCount: PseudoCount

  /**
   * -domain_inclusion_ethresh <Real>
   *
   * E-value inclusion threshold for alignments with conserved domains
   *
   * Default = `0.05`
   */
  var domainInclusionEValueThreshold: DomainInclusionEValueThreshold

  /**
   * -inclusion_ethresh <Real>
   *
   * E-value inclusion threshold for pairwise alignments
   *
   * Default = `0.002`
   */
  var inclusionEValueThreshold: InclusionEValueThreshold

  /**
   * -rpsdb <String>
   *
   * BLAST domain database name
   *
   * Default = `cdd_delta`
   */
  var rpsDB: RPSDB

  /**
   * -show_domain_hits
   *
   * Show domain hits
   *
   * Incompatible with:
   * * remote
   * * subject
   */
  var showDomainHits: ShowDomainHits
}