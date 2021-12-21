package org.veupathdb.lib.blast.util

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.node.ObjectNode

class JSONObjectDecoderDeserializer(vc: Class<*>?) : StdDeserializer<JSONObjectDecoder>(vc) {
  constructor() : this(null)

  override fun deserialize(p: JsonParser, ctxt: DeserializationContext) =
    JSONObjectDecoder(p.readValueAs(ObjectNode::class.java))
}