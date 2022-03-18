package org.veupathdb.lib.blast.blastx

import org.junit.jupiter.api.Assertions.*
import org.veupathdb.lib.blast.common.BlastQueryWithIPG
import org.veupathdb.lib.blast.common.BlastQueryWithIPGImplTest

internal class BlastXImplTest : BlastQueryWithIPGImplTest() {
  override fun getEmptyImpl(): BlastX {
    return BlastXImpl()
  }
}