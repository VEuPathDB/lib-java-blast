package org.veupathdb.lib.blast.common

import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.serial.BlastCommand

/**
 * Fields common to all BLAST+ tools.
 */
interface BlastCLI : BlastCommand {

  val tool: BlastTool

  /**
   * Print USAGE and DESCRIPTION;  ignore all other parameters
   */
  var shortHelp: HelpShort

  /**
   * Print USAGE, DESCRIPTION and ARGUMENTS; ignore all other parameters
   */
  var longHelp: HelpLong

  /**
   * Print version number;  ignore other arguments
   */
  var version: Version

  /**
   * Output file name
   */
  var outFile: OutFile

  /**
   * Formatting options
   */
  var outFormat: OutFormat

  /**
   * Show NCBI GIs in deflines
   */
  var showGIs: ShowGIs

  /**
   * Number of database sequences to show one-line descriptions for
   * Not applicable for outfmt > 4
   */
  var numDescriptions: NumDescriptions

  /**
   * Number of database sequences to show alignments for
   */
  var numAlignments: NumAlignments

  /**
   * Line length for formatting alignments
   * Not applicable for outfmt > 4
   */
  var lineLength: LineLength

  /**
   * Produce HTML output
   */
  var html: HTML

  /**
   * Sorting option for hits
   */
  var sortHits: SortHits

  /**
   * Sorting option for hps
   */
  var sortHSPs: SortHSPs

  /**
   * Maximum number of aligned sequences to keep
   * (value of 5 or more is recommended)
   */
  var maxTargetSeqs: MaxTargetSeqs

  /**
   * Should the query and subject defline(s) be parsed
   */
  var parseDefLines: ParseDefLines
}
