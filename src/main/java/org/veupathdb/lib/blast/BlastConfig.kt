package org.veupathdb.lib.blast

import com.fasterxml.jackson.annotation.JsonValue
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.consts.Key
import org.veupathdb.lib.blast.field.*
import org.veupathdb.lib.blast.util.JSONDecodable
import org.veupathdb.lib.blast.util.JSONEncodable
import org.veupathdb.lib.blast.util.JSONObjectDecoder
import org.veupathdb.lib.blast.util.JSONObjectEncoder

sealed interface BlastConfig : JSONEncodable, JSONDecodable
{
  val tool: BlastTool

  var shortHelp: Boolean?

  var longHelp: Boolean?

  var version: Boolean?

  var outFile: OutFile?

  var outFormat: OutFormat?

  var showGIs: Boolean?

  var numDescriptions: NumDescriptions?

  var numAlignments: NumAlignments?

  var lineLength: LineLength?

  var html: Boolean?

  var sortHits: HitSorting?

  var sortHSPs: HSPSorting?

  var maxTargetSequences: MaxTargetSeqs?

  var parseDefLines: Boolean?

  @JsonValue
  override fun toJSON(): JSONObjectEncoder {
    return toJSON(false)
  }

  fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val out = JSONObjectEncoder()

    if (includeTool)
      out.encode(Key.Tool, tool)

    out.encode(Flag.ShortHelp, shortHelp)
    out.encode(Flag.LongHelp, longHelp)
    out.encode(Flag.Version, version)
    out.encode(Flag.OutFile, outFile)
    out.encode(Flag.OutFormat, outFormat)
    out.encode(Flag.ShowGIs, showGIs)
    out.encode(Flag.NumDescriptions, numDescriptions)
    out.encode(Flag.NumAlignments, numAlignments)
    out.encode(Flag.LineLength, lineLength)
    out.encode(Flag.HTML, html)
    out.encode(Flag.SortHits, sortHits)
    out.encode(Flag.SortHSPs, sortHSPs)
    out.encode(Flag.MaxTargetSequences, maxTargetSequences)
    out.encode(Flag.ParseDefLines, parseDefLines)

    return out
  }

  override fun decodeJSON(node: JSONObjectDecoder) {
    node.decodeBool(Flag.ShortHelp)          { shortHelp          = it                      }
    node.decodeBool(Flag.LongHelp)           { longHelp           = it                      }
    node.decodeBool(Flag.Version)            { version            = it                      }
    node.decodeString(Flag.OutFile)          { outFile            = OutFile(it)             }
    node.decodeJSON(Flag.OutFormat)          { outFormat          = OutFormat.fromJSON(it)  }
    node.decodeBool(Flag.ShowGIs)            { showGIs            = it                      }
    node.decodeLong(Flag.NumDescriptions)    { numDescriptions    = NumDescriptions(it)     }
    node.decodeLong(Flag.NumAlignments)      { numAlignments      = NumAlignments(it)       }
    node.decodeInt(Flag.LineLength)          { lineLength         = LineLength(it)          }
    node.decodeBool(Flag.HTML)               { html               = it                      }
    node.decodeJSON(Flag.SortHits)           { sortHits           = HitSorting.fromJSON(it) }
    node.decodeJSON(Flag.SortHSPs)           { sortHSPs           = HSPSorting.fromJSON(it) }
    node.decodeLong(Flag.MaxTargetSequences) { maxTargetSequences = MaxTargetSeqs(it)       }
    node.decodeBool(Flag.ParseDefLines)      { parseDefLines      = it                      }
  }
}
