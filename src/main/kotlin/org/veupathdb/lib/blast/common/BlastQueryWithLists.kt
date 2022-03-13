package org.veupathdb.lib.blast.common

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.common.fields.DBFile
import org.veupathdb.lib.blast.common.fields.ParseDBFile
import org.veupathdb.lib.blast.field.*

/**
 * List fields common to most BLAST+ query tools.
 */
interface BlastQueryWithLists : BlastQueryBase {

  /**
   * -gilist
   *
   * Restrict search of database to list of GIs
   */
  var giList: GIList

  /**
   * -negative_gilist
   *
   * Restrict search of database to everything except the specified GIs
   */
  var negativeGIList: NegativeGIList

  /**
   * -seqidlist
   *
   * Restrict search of database to list of SeqIDs
   */
  var seqIdList: SeqIdList

  /**
   * -negative_seqidlist
   *
   * Restrict search of database to everything except the specified SeqIDs
   */
  var negativeSeqIdList: NegativeSeqIdList

  /**
   * -taxidlist
   *
   * Restrict search of database to include only the specified taxonomy IDs
   */
  var taxIdList: TaxIdList

  /**
   * -negative_taxidlist
   *
   * Restrict search of database to everything except the specified taxonomy IDs
   */
  var negativeTaxIdList: NegativeTaxIdList

  /**
   * -taxids
   *
   * Restrict search of database to include only the specified taxonomy IDs
   */
  var taxIds: TaxIds

  /**
   * -negative_taxids
   *
   * Restrict search of database to everything except the specified taxonomy IDs
   */
  var negativeTaxIds: NegativeTaxIds
}
