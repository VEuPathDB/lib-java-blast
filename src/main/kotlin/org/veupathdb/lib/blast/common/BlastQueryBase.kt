package org.veupathdb.lib.blast.common

import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.field.*


/**
 * Basic fields common to all BLAST+ query tools.
 */
interface BlastQueryBase : BlastCLI {

  /**
   * Input file name
   */
  var queryFile: QueryFile

  /**
   * Location on the query sequence in 1-based offsets (Format: start-stop)
   */
  var queryLocation: QueryLocation

  /**
   * BLAST database name(s)
   */
  var dbFile: DBFile

  /**
   * Expectation value (E) threshold for saving hits
   */
  var expectValue: ExpectValue

  /**
   * Use lower case filtering in query and subject sequence(s)
   */
  var lowercaseMasking: LowercaseMasking

  /**
   * Restrict search with the given Entrez query
   */
  var entrezQuery: EntrezQuery

  /**
   * Set maximum number of HSPs per subject sequence to save for each query
   */
  var maxHSPs: MaxHSPs

  /**
   * Effective length of the database
   */
  var dbSize: DBSize

  /**
   * Effective length of the search space
   */
  var searchSpace: SearchSpace

  /**
   * Search strategy to use
   */
  var importSearchStrategy: ImportSearchStrategy

  /**
   * File name to record the search strategy used
   */
  var exportSearchStrategy: ExportSearchStrategy

  /**
   * X-dropoff value (in bits) for ungapped extensions
   */
  var extensionDropoffUngapped: ExtensionDropoffUngapped

  /**
   * Multiple hits window size, use 0 to specify 1-hit algorithm
   */
  var windowSize: WindowSize

  /**
   * Execute search remotely
   */
  var remote: Remote
}
