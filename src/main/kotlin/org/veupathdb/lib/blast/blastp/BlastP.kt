package org.veupathdb.lib.blast.blastp

import org.veupathdb.lib.blast.blastp.field.BlastPMatrix
import org.veupathdb.lib.blast.blastp.field.BlastPTask
import org.veupathdb.lib.blast.common.BlastQueryWithIPG
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.field.*

/**
 * Protein-Protein BLAST 2.11.0+
 */
interface BlastP : BlastQueryWithIPG {

  var task: BlastPTask

  var wordSize: WordSize

  var gapOpen: GapOpen

  var gapExtend: GapExtend

  var matrix: BlastPMatrix

  var threshold: Threshold

  var compBasedStats: CompBasedStats

  var subjectFile: SubjectFile

  var subjectLocation: SubjectLocation

  var seg: Seg

  var dbSoftMask: DBSoftMask

  var dbHardMask: DBHardMask

  var cullingLimit: CullingLimit

  var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped

  var extensionDropoffFinalGapped: ExtensionDropoffFinalGapped

  var ungappedAlignmentsOnly: UngappedAlignmentsOnly

  var numCPUCores: NumCPUCores

  var useSmithWatermanTraceback: UseSmithWatermanTraceback

  var bestHitOverhang: BestHitOverhang

  var bestHitScoreEdge: BestHitScoreEdge

  var subjectBestHit: SubjectBestHit
}