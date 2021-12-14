package org.veupathdb.lib.blast

import com.fasterxml.jackson.annotation.JsonCreator
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.util.JSONObjectDecoder
import org.veupathdb.lib.blast.util.JSONObjectEncoder

class BlastFormatter(
  shortHelp:          Boolean?         = null,
  longHelp:           Boolean?         = null,
  version:            Boolean?         = null,
  outFormat:          OutFormat?       = null,
  showGIs:            Boolean?         = null,
  numDescriptions:    NumDescriptions? = null,
  numAlignments:      NumAlignments?   = null,
  lineLength:         LineLength?      = null,
  html:               Boolean?         = null,
  sortHits:           HitSorting?      = null,
  sortHSPs:           HSPSorting?      = null,
  maxTargetSequences: MaxTargetSeqs?   = null,
  outFile:            OutFile?         = null,
  parseDefLines:      Boolean?         = null,
  var requestID:      String?          = null,
  var archiveFile:    String?          = null,
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
)
{
  override val tool = BlastTool.BlastFormatter

  @JsonCreator
  constructor(js: JSONObjectDecoder) : this() {
    decodeJSON(js)
  }

  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val out = super.toJSON(includeTool)

    out.encode(Flag.RequestID, requestID)
    out.encode(Flag.ArchiveFile, archiveFile)

    return out
  }

  override fun decodeJSON(node: JSONObjectDecoder) {
    super.decodeJSON(node)

    node.decodeString(Flag.RequestID) { requestID = it }
    node.decodeString(Flag.ArchiveFile) { archiveFile = it }
  }
}
