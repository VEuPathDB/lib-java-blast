package org.veupathdb.lib.blast

import org.veupathdb.lib.blast.field.*

sealed class CLIBase(
  override var shortHelp:          Boolean?         = null,
  override var longHelp:           Boolean?         = null,
  override var version:            Boolean?         = null,
  override var outFormat:          OutFormat?       = null,
  override var showGIs:            Boolean?         = null,
  override var numDescriptions:    NumDescriptions? = null,
  override var numAlignments:      NumAlignments?   = null,
  override var lineLength:         LineLength?      = null,
  override var html:               Boolean?         = null,
  override var sortHits:           HitSorting?      = null,
  override var sortHSPs:           HSPSorting?      = null,
  override var maxTargetSequences: MaxTargetSeqs?   = null,
  override var outFile:            OutFile?         = null,
  override var parseDefLines:      Boolean?         = null,
) : BlastConfig
