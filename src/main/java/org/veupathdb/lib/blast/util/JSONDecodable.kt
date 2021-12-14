package org.veupathdb.lib.blast.util

interface JSONDecodable {
  fun decodeJSON(node: JSONObjectDecoder)
}