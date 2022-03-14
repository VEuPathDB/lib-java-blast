package org.veupathdb.lib.blast.common

import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.common.fields.*

/**
 * List fields common to most BLAST+ query tools.
 */
interface BlastQueryWithLists : BlastQueryBase {

  /**
   * -gilist
   *
   * Restrict search of database to list of GIs
   */
  var giListFile: GIList

  /**
   * -negative_gilist
   *
   * Restrict search of database to everything except the specified GIs
   */
  var negativeGIListFile: NegativeGIList

  /**
   * -seqidlist
   *
   * Restrict search of database to list of SeqIDs
   */
  var seqIdListFile: SeqIdList

  /**
   * -negative_seqidlist
   *
   * Restrict search of database to everything except the specified SeqIDs
   */
  var negativeSeqIdListFile: NegativeSeqIdList

  /**
   * -taxidlist
   *
   * Restrict search of database to include only the specified taxonomy IDs
   */
  var taxIdListFile: TaxIdList

  /**
   * -negative_taxidlist
   *
   * Restrict search of database to everything except the specified taxonomy IDs
   */
  var negativeTaxIdListFile: NegativeTaxIdList

  /**
   * -taxids
   *
   * Restrict search of database to include only the specified taxonomy IDs
   */
  var taxIds: TaxIDs

  /**
   * -negative_taxids
   *
   * Restrict search of database to everything except the specified taxonomy IDs
   */
  var negativeTaxIds: NegativeTaxIDs
}
