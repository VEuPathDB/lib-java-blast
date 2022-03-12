package org.veupathdb.lib.blast.common

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.serial.BlastCommand
import org.veupathdb.lib.jackson.Json
import java.util.LinkedList

const val KeyTool = "tool"

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


////////////////////////////////////////////////////////////////////////////////


internal abstract class blastCLI(
  override val tool:            BlastTool,
  override var shortHelp:       HelpShort,
  override var longHelp:        HelpLong,
  override var version:         Version,
  override var outFile:         OutFile,
  override var outFormat:       OutFormat,
  override var showGIs:         ShowGIs,
  override var numDescriptions: NumDescriptions,
  override var numAlignments:   NumAlignments,
  override var lineLength:      LineLength,
  override var html:            HTML,
  override var sortHits:        SortHits,
  override var sortHSPs:        SortHSPs,
  override var maxTargetSeqs:   MaxTargetSeqs,
  override var parseDefLines:   ParseDefLines
) :  BlastCLI {

  constructor(tool: BlastTool, js: ObjectNode) :
    this(
      tool,
      ParseHelpShort(js),
      ParseHelpLong(js),
      ParseVersion(js),
      ParseOutFile(js),
      ParseOutFormat(js),
      ParseShowGIs(js),
      ParseNumDescriptions(js),
      ParseNumAlignments(js),
      ParseLineLength(js),
      ParseHTML(js),
      ParseSortHits(js),
      ParseSortHSPs(js),
      ParseMaxTargetSeqs(js),
      ParseParseDefLines(js)
    )

  override fun toJson() = Json.new<ObjectNode> {
    put(KeyTool, tool.value)

    shortHelp.appendJson(this)
    longHelp.appendJson(this)
    version.appendJson(this)
    outFile.appendJson(this)
    outFormat.appendJson(this)
    showGIs.appendJson(this)
    numDescriptions.appendJson(this)
    numAlignments.appendJson(this)
    lineLength.appendJson(this)
    html.appendJson(this)
    sortHits.appendJson(this)
    sortHSPs.appendJson(this)
    maxTargetSeqs.appendJson(this)
    parseDefLines.appendJson(this)

    appendJson(this)
  }

  protected abstract fun appendJson(js: ObjectNode)

  override fun toCliString(): String {
    val out = StringBuilder(8192)

    out.append(tool.value)

    shortHelp.appendCliSegment(out)
    longHelp.appendCliSegment(out)
    version.appendCliSegment(out)
    outFile.appendCliSegment(out)
    outFormat.appendCliSegment(out)
    showGIs.appendCliSegment(out)
    numDescriptions.appendCliSegment(out)
    numAlignments.appendCliSegment(out)
    lineLength.appendCliSegment(out)
    html.appendCliSegment(out)
    sortHits.appendCliSegment(out)
    sortHSPs.appendCliSegment(out)
    maxTargetSeqs.appendCliSegment(out)
    parseDefLines.appendCliSegment(out)

    appendCli(out)

    return out.toString()
  }

  protected abstract fun appendCli(sb: StringBuilder)

  override fun toCliArray(): Array<String> {
    val out = LinkedList<String>()

    out.add(tool.value)

    shortHelp.appendCliParts(out)
    longHelp.appendCliParts(out)
    version.appendCliParts(out)
    outFile.appendCliParts(out)
    outFormat.appendCliParts(out)
    showGIs.appendCliParts(out)
    numDescriptions.appendCliParts(out)
    numAlignments.appendCliParts(out)
    lineLength.appendCliParts(out)
    html.appendCliParts(out)
    sortHits.appendCliParts(out)
    sortHSPs.appendCliParts(out)
    maxTargetSeqs.appendCliParts(out)
    parseDefLines.appendCliParts(out)

    appendCli(out)

    return out.toTypedArray()
  }

  protected abstract fun appendCli(cli: MutableList<String>)
}