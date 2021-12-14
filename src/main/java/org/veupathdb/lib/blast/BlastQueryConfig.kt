package org.veupathdb.lib.blast

import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.QueryFile
import org.veupathdb.lib.blast.field.ExpectValue
import org.veupathdb.lib.blast.field.Location
import org.veupathdb.lib.blast.util.JSONObjectDecoder
import org.veupathdb.lib.blast.util.JSONObjectEncoder

interface BlastQueryConfig : BlastConfig {
  var queryFile: QueryFile?
  var queryLocation: Location?
  var dbFile: String?
  var expectValue: ExpectValue?
  var softMasking: Boolean?
  var lowercaseMasking: Boolean?
  var entrezQuery: String?
  var queryCoverageHSPPercent: Double?
  var maxHSPs: Long?
  var dbSize: Byte?
  var searchSpace: Short?
  var importSearchStrategy: String?
  var exportSearchStrategy: String?
  var extensionDropoffUngapped: Double?
  var windowSize: Long?
  var remote: Boolean?

  override fun decodeJSON(node: JSONObjectDecoder) {
    super.decodeJSON(node)
    node.decodeString(Flag.QueryFile)                { queryFile = QueryFile(it)     }
    node.decodeJSON(Flag.QueryLocation)              { Location(it)                  }
    node.decodeString(Flag.DBFile)                   { dbFile = it                   }
    node.decodeString(Flag.ExpectValue)              { expectValue = ExpectValue(it) }
    node.decodeBool(Flag.SoftMasking)                { softMasking = it              }
    node.decodeBool(Flag.LowercaseMasking)           { lowercaseMasking = it         }
    node.decodeString(Flag.EntrezQuery)              { entrezQuery = it              }
    node.decodeDouble(Flag.QueryCoverageHSPPercent)  { queryCoverageHSPPercent = it  }
    node.decodeLong(Flag.MaxHSPs)                    { maxHSPs = it                  }
    node.decodeByte(Flag.DBSize)                     { dbSize = it                   }
    node.decodeShort(Flag.SearchSpace)               { searchSpace = it              }
    node.decodeString(Flag.ImportSearchStrategy)     { importSearchStrategy = it     }
    node.decodeString(Flag.ExportSearchStrategy)     { exportSearchStrategy = it     }
    node.decodeDouble(Flag.ExtensionDropoffUngapped) { extensionDropoffUngapped = it }
    node.decodeLong(Flag.WindowSize)                 { windowSize = it               }
    node.decodeBool(Flag.Remote)                     { remote = it                   }
  }

  override fun toJSON(includeTool: Boolean): JSONObjectEncoder {
    val out: JSONObjectEncoder = super.toJSON(includeTool)
    out.encode(Flag.QueryFile, queryFile)
    out.encode(Flag.QueryLocation, queryLocation)
    out.encode(Flag.DBFile, dbFile)
    out.encode(Flag.ExpectValue, expectValue)
    out.encode(Flag.SoftMasking, softMasking)
    out.encode(Flag.LowercaseMasking, lowercaseMasking)
    out.encode(Flag.EntrezQuery, entrezQuery)
    out.encode(Flag.QueryCoverageHSPPercent, queryCoverageHSPPercent)
    out.encode(Flag.MaxHSPs, maxHSPs)
    out.encode(Flag.DBSize, dbSize)
    out.encode(Flag.SearchSpace, searchSpace)
    out.encode(Flag.ImportSearchStrategy, importSearchStrategy)
    out.encode(Flag.ExportSearchStrategy, exportSearchStrategy)
    out.encode(Flag.ExtensionDropoffUngapped, extensionDropoffUngapped)
    out.encode(Flag.WindowSize, windowSize)
    out.encode(Flag.Remote, remote)
    return out
  }
}