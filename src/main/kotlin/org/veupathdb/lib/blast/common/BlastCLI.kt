package org.veupathdb.lib.blast.common

import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.serial.BlastCommand

/**
 * Fields common to all BLAST+ tools.
 */
interface BlastCLI : BlastCommand {

  val tool: BlastTool

  /**
   * -h
   */
  var shortHelp: HelpShort

  /**
   * -help
   */
  var longHelp: HelpLong

  /**
   * -version
   */
  var version: Version

  /**
   * -out <File_Out>
   */
  var outFile: OutFile

  /**
   * -outfmt <String>
   */
  var outFormat: OutFormat

  /**
   * -show_gis
   */
  var showGIs: ShowGIs

  /**
   * -num_descriptions <Integer, >=0>
   */
  var numDescriptions: NumDescriptions

  /**
   * -num_alignments <Integer, >=0>
   */
  var numAlignments: NumAlignments

  /**
   * -line_length <Integer, >=1>
   */
  var lineLength: LineLength

  /**
   * -html
   */
  var html: HTML

  /**
   * -sorthits <Integer, (>=0 and =<4)>
   */
  var sortHits: SortHits

  /**
   * -sorthsps <Integer, (>=0 and =<4)>
   */
  var sortHSPs: SortHSPs

  /**
   * -max_target_seqs <Integer, >=1>
   */
  var maxTargetSeqs: MaxTargetSeqs

  /**
   * -parse_deflines
   */
  var parseDefLines: ParseDefLines
}
