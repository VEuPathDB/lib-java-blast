package org.veupathdb.lib.blast

import org.veupathdb.lib.blast.field.*

abstract class BlastBase(
  shortHelp:                             Boolean?         = null,
  longHelp:                              Boolean?         = null,
  version:                               Boolean?         = null,
  outFormat:                             OutFormat?       = null,
  showGIs:                               Boolean?         = null,
  numDescriptions:                       NumDescriptions? = null,
  numAlignments:                         NumAlignments?   = null,
  lineLength:                            LineLength?      = null,
  html:                                  Boolean?         = null,
  sortHits:                              HitSorting?      = null,
  sortHSPs:                              HSPSorting?      = null,
  maxTargetSequences:                    MaxTargetSeqs?   = null,
  outFile:                               OutFile?         = null,
  parseDefLines:                         Boolean?         = null,
  override var queryFile:                QueryFile?       = null,
  override var queryLocation:            Location?        = null,
  override var dbFile:                   String?          = null,
  override var expectValue:              ExpectValue?     = null,
  override var softMasking:              Boolean?         = null,
  override var lowercaseMasking:         Boolean?         = null,
  override var entrezQuery:              String?          = null,
  override var queryCoverageHSPPercent:  Double?          = null,
  override var maxHSPs:                  Long?            = null,
  override var dbSize:                   Byte?            = null,
  override var searchSpace:              Short?           = null,
  override var importSearchStrategy:     String?          = null,
  override var exportSearchStrategy:     String?          = null,
  override var extensionDropoffUngapped: Double?          = null,
  override var windowSize:               Long?            = null,
  override var remote:                   Boolean?         = null,
) : CLIBase(
  shortHelp,
  longHelp,
  version,
  outFormat,
  showGIs,
  numDescriptions,
  numAlignments,
  lineLength,
  html,
  sortHits,
  sortHSPs,
  maxTargetSequences,
  outFile,
  parseDefLines,
), BlastQueryConfig
