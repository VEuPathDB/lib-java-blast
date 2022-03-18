package org.veupathdb.lib.blast.psiblast

import org.veupathdb.lib.blast.common.BlastQueryWithIPG
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.psiblast.fields.*

/**
 * Position-Specific Iterated BLAST 2.11.0+
 */
interface PSIBlast : BlastQueryWithIPG {

  /**
   *  -word_size <Integer, >=2>
   *
   * Word size for wordfinder algorithm
   */
  var wordSize: WordSizePSI

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
  var matrix: MatrixPSI

  /**
   * -threshold <Real, >=0>
   *
   * Minimum word score such that the word is added to the BLAST lookup table
   */
  var threshold: Threshold

  /**
   * -comp_based_stats <String>
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
  var compBasedStats: CompBasedStatsPSI

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
   * * ipglist
   * * negative_ipglist
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
   * * ipglist
   * * negative_ipglist
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
  var seg: SegPSI

  /**
   * -soft_masking <Boolean>
   *
   * Apply filtering locations as soft masks
   *
   * Default = `false`
   */
  var softMasking: SoftMaskingPSI

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
   * -sum_stats <Boolean>
   *
   * Use sum statistics
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
   *
   * Incompatible with:
   * * remote
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
   * Save PSSM after each iteration (file name is given in `-save_pssm` or
   * `-save_ascii_pssm` options)
   */
  var saveEachPSSM: SaveEachPSSM

  /**
   * -in_msa <File_In>
   *
   * File name of multiple sequence alignment to restart PSI-BLAST
   *
   * Incompatible with:
   * * in_pssm
   * * query
   * * query_loc
   * * phi_pattern
   */
  var inMSAFile: InMSAFile

  /**
   *  -msa_master_idx <Integer, >=1>
   *
   * Ordinal number (1-based index) of the sequence to use as a master in the
   * multiple sequence alignment. If not provided, the first sequence in the
   * multiple sequence alignment will be used
   *
   * Requires:
   * * in_msa
   *
   * Incompatible with:
   * * in_pssm
   * * query
   * * query_loc
   * * phi_pattern,
  ignore_msa_master
   */
  var msaMasterIndex: MSAMasterIndex

  /**
   * -ignore_msa_master
   *
   * Ignore the master sequence when creating PSSM
   *
   * Requires:
   * * in_msa
   *
   * Incompatible with:
   * * msa_master_idx
   * * in_pssm
   * * query
   * * query_loc
   * * phi_pattern
   */
  var ignoreMSAMaster: IgnoreMSAMaster

  /**
   * -in_pssm <File_In>
   *
   * PSI-BLAST checkpoint file
   *
   * Incompatible with:
   * * in_msa
   * * msa_master_idx
   * * ignore_msa_master
   * * query
   * * query_loc
   * * phi_pattern
   */
  var inPSSMFile: InPSSMFile

  /**
   * -pseudocount <Integer>
   *
   * Pseudo-count value used when constructing PSSM
   *
   * Default = `0`
   */
  var pseudoCount: PseudoCount

  /**
   * -inclusion_ethresh <Real>
   *
   * E-value inclusion threshold for pairwise alignments
   *
   * Default = `0.002`
   */
  var inclusionEValueThreshold: InclusionEValueThreshold

  /**
   * -phi_pattern <File_In>
   *
   * File name containing pattern to search
   *
   * Incompatible with:
   * * in_msa
   * * msa_master_idx
   * * ignore_msa_master
   * * in_pssm
   */
  var phiPatternFile: PhiPatternFile
}