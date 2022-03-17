package org.veupathdb.lib.blast.blastx

import org.veupathdb.lib.blast.blastx.field.*
import org.veupathdb.lib.blast.common.BlastQueryWithIPG
import org.veupathdb.lib.blast.common.fields.*

/**
 * Translated Query-Protein Subject BLAST 2.11.0+
 */
interface BlastX : BlastQueryWithIPG {

  var strand: Strand

  var queryGenCode: QueryGenCode

  var task: BlastXTask

  var wordSize: WordSizeX

  var gapOpen: GapOpen

  var gapExtend: GapExtend

  var maxIntronLength: MaxIntronLength

  var matrix: ScoringMatrixX

  var threshold: Threshold

  var compBasedStats: CompBasedStatsX

  var subjectFile: SubjectFile

  var subjectLocation: SubjectLocation

  var seg: SegX

  var dbSoftMask: DBSoftMask

  var dbHardMask: DBHardMask

  var cullingLimit: CullingLimit

  var sumStats: SumStats

  var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped

  var extensionDropoffFinalGapped: ExtensionDropoffFinalGapped

  var ungappedAlignmentsOnly: UngappedAlignmentsOnly

  var numCPUCores: NumCPUCores

  var useSmithWatermanTraceback: UseSmithWatermanTraceback

  var bestHitOverhang: BestHitOverhang

  var bestHitScoreEdge: BestHitScoreEdge

  var subjectBestHit: SubjectBestHit

  var softMasking: SoftMaskingX
}