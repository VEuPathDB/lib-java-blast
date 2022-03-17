package org.veupathdb.lib.blast.deltablast

import org.veupathdb.lib.blast.common.BlastQueryWithLists
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.deltablast.fields.*

interface DeltaBlast : BlastQueryWithLists {

  var wordSize: WordSizeDelta

  var gapOpen: GapOpen

  var gapExtend: GapExtend

  var matrix: MatrixDeltaType

  var threshold: Threshold

  var compBasedStats: CompBasedStatsDelta

  var subjectFile: SubjectFile

  var subjectLocation: SubjectLocation

  var seg: SegDelta

  var softMasking: SoftMaskingDelta

  var queryCoverageHSPPercent: QueryCoverageHSPPercent

  var cullingLimit: CullingLimit

  var bestHitOverhang: BestHitOverhang

  var bestHitScoreEdge: BestHitScoreEdge

  var subjectBestHit: SubjectBestHit

  var sumStats: SumStats

  var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped

  var extensionDropoffFinalGapped: ExtensionDropoffFinalGapped

  var gapTrigger: GapTrigger

  var numCPUCores: NumCPUCores

  var useSmithWatermanTraceback: UseSmithWatermanTraceback

  var numIterations: NumIterations

  var outPSSMFile: OutPSSMFile

  var outASCIIPSSMFile: OutASCIIPSSMFile

  var savePSSMAfterLastRound: SavePSSMAfterLastRound

  var saveEachPSSM: SaveEachPSSM

  var pseudoCount: PseudoCount

  var domainInclusionEValueThreshold: DomainInclusionEValueThreshold

  var inclusionEValueThreshold: InclusionEValueThreshold

  var rpsDB: RPSDB

  var showDomainHits: ShowDomainHits
}