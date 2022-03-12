package org.veupathdb.lib.blast.common

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool


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
  var dbFile: DbFile

  /**
   * Expectation value (E) threshold for saving hits
   */
  var expectValue: ExpectValue

  /**
   * Apply filtering locations as soft masks
   */
  var softMasking: SoftMasking

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


////////////////////////////////////////////////////////////////////////////////


internal open class blastQueryBase(
  tool:            BlastTool,
  shortHelp:       HelpShort,
  longHelp:        HelpLong,
  version:         Version,
  outFile:         OutFile,
  outFormat:       OutFormat,
  showGIs:         ShowGIs,
  numDescriptions: NumDescriptions,
  numAlignments:   NumAlignments,
  lineLength:      LineLength,
  html:            HTML,
  sortHits:        SortHits,
  sortHSPs:        SortHSPs,
  maxTargetSeqs:   MaxTargetSeqs,
  parseDefLines:   ParseDefLines,

  override var queryFile:                QueryFile,
  override var queryLocation:            QueryLocation,
  override var dbFile:                   DbFile,
  override var expectValue:              ExpectValue,
  override var softMasking:              SoftMasking,
  override var lowercaseMasking:         LowercaseMasking,
  override var entrezQuery:              EntrezQuery,
  override var maxHSPs:                  MaxHSPs,
  override var dbSize:                   DBSize,
  override var searchSpace:              SearchSpace,
  override var importSearchStrategy:     ImportSearchStrategy,
  override var exportSearchStrategy:     ExportSearchStrategy,
  override var extensionDropoffUngapped: ExtensionDropoffUngapped,
  override var windowSize:               WindowSize,
  override var remote:                   Remote,
) : BlastQueryBase, blastCLI(
  tool,
  shortHelp,
  longHelp,
  version,
  outFile,
  outFormat,
  showGIs,
  numDescriptions,
  numAlignments,
  lineLength,
  html,
  sortHits,
  sortHSPs,
  maxTargetSeqs,
  parseDefLines,
) {
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
      ParseParseDefLines(js),
      ParseQueryFile(js),
      ParseQueryLocation(js),
      ParseDBFile(js),
      ParseEValue(js),
      ParseSoftMasking(js),
      ParseLowercaseMasking(js),
      ParseEntrezQuery(js),
      ParseMaxHSPs(js),
      ParseDBSize(js),
      ParseSearchSpace(js),
      ParseImportSearchStrategy(js),
      ParseExportSearchStrategy(js),
      ParseXDropUngap(js),
      ParseWindowSize(js),
      ParseRemote(js),
    )

  override fun appendJson(js: ObjectNode) {
    queryFile.appendJson(js)
    queryLocation.appendJson(js)
    dbFile.appendJson(js)
    expectValue.appendJson(js)
    softMasking.appendJson(js)
    lowercaseMasking.appendJson(js)
    entrezQuery.appendJson(js)
    maxHSPs.appendJson(js)
    dbSize.appendJson(js)
    searchSpace.appendJson(js)
    importSearchStrategy.appendJson(js)
    exportSearchStrategy.appendJson(js)
    extensionDropoffUngapped.appendJson(js)
    windowSize.appendJson(js)
    remote.appendJson(js)
  }

  override fun appendCli(sb: StringBuilder) {
    queryFile.appendCliSegment(sb)
    queryLocation.appendCliSegment(sb)
    dbFile.appendCliSegment(sb)
    expectValue.appendCliSegment(sb)
    softMasking.appendCliSegment(sb)
    lowercaseMasking.appendCliSegment(sb)
    entrezQuery.appendCliSegment(sb)
    maxHSPs.appendCliSegment(sb)
    dbSize.appendCliSegment(sb)
    searchSpace.appendCliSegment(sb)
    importSearchStrategy.appendCliSegment(sb)
    exportSearchStrategy.appendCliSegment(sb)
    extensionDropoffUngapped.appendCliSegment(sb)
    windowSize.appendCliSegment(sb)
    remote.appendCliSegment(sb)
  }

  override fun appendCli(cli: MutableList<String>) {
    queryFile.appendCliParts(cli)
    queryLocation.appendCliParts(cli)
    dbFile.appendCliParts(cli)
    expectValue.appendCliParts(cli)
    softMasking.appendCliParts(cli)
    lowercaseMasking.appendCliParts(cli)
    entrezQuery.appendCliParts(cli)
    maxHSPs.appendCliParts(cli)
    dbSize.appendCliParts(cli)
    searchSpace.appendCliParts(cli)
    importSearchStrategy.appendCliParts(cli)
    exportSearchStrategy.appendCliParts(cli)
    extensionDropoffUngapped.appendCliParts(cli)
    windowSize.appendCliParts(cli)
    remote.appendCliParts(cli)
  }
}