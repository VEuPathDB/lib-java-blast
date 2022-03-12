package org.veupathdb.lib.blast.blastn

import org.veupathdb.lib.blast.common.BlastQueryWithLists
import org.veupathdb.lib.blast.field.*

interface BlastN : BlastQueryWithLists {
  var strand: Strand

  var task: BlastNTask

  var gapOpen: GapOpen

  var gapExtend: GapExtend

  var penalty: Penalty

  var reward: Reward

  var useIndex: UseIndex

  var indexName: IndexName

  var subjectFile: SubjectFile

  var subjectLocation: SubjectLocation

  var dust: Dust

  var filteringDB: FilteringDB
}