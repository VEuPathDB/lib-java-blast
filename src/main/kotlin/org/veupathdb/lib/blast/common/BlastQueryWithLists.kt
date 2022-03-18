package org.veupathdb.lib.blast.common

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
  var seqIDListFile: SeqIDList

  /**
   * -negative_seqidlist
   *
   * Restrict search of database to everything except the specified SeqIDs
   */
  var negativeSeqIDListFile: NegativeSeqIDList

  /**
   * -taxidlist
   *
   * Restrict search of database to include only the specified taxonomy IDs
   */
  var taxIDListFile: TaxIDList

  /**
   * -negative_taxidlist
   *
   * Restrict search of database to everything except the specified taxonomy IDs
   */
  var negativeTaxIDListFile: NegativeTaxIDList

  /**
   * -taxids
   *
   * Restrict search of database to include only the specified taxonomy IDs
   */
  var taxIDs: TaxIDs

  /**
   * -negative_taxids
   *
   * Restrict search of database to everything except the specified taxonomy IDs
   */
  var negativeTaxIDs: NegativeTaxIDs
}
