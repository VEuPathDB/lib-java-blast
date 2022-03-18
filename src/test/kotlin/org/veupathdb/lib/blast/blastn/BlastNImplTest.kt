package org.veupathdb.lib.blast.blastn

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.common.*

@DisplayName("BlastN")
internal class BlastNImplTest : BlastQueryWithListsImplTest() {

  override fun getEmptyImpl(): BlastQueryWithLists {
    return BlastNImpl()
  }

}