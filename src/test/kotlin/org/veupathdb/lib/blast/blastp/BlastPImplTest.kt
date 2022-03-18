package org.veupathdb.lib.blast.blastp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.veupathdb.lib.blast.common.*

@DisplayName("BlastP")
internal class BlastPImplTest : BlastQueryWithIPGImplTest() {

  override fun getEmptyImpl(): BlastP {
    return BlastPImpl()
  }
}