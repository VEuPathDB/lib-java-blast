package org.veupathdb.lib.blast.util

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.*

import java.math.BigDecimal
import java.math.BigInteger

object JSONConstructor {
  val Mapper: ObjectMapper = ObjectMapper()

  fun newObject(): ObjectNode {
    return Mapper.createObjectNode()
  }

  fun newArray(): ArrayNode {
    return Mapper.createArrayNode()
  }

  fun newArray(value: Collection<*>): ArrayNode {
    val out = Mapper.createArrayNode()

    for (tmp in value) {
      when (tmp) {
        null          -> out.add(newNull())
        is JsonNode   -> out.add(tmp)
        is String     -> out.add(newText(tmp))
        is Int        -> out.add(newInt(tmp))
        is Double     -> out.add(newDouble(tmp))
        is Long       -> out.add(newLong(tmp))
        is Boolean    -> out.add(newBool(tmp))
        is Float      -> out.add(newFloat(tmp))
        is BigDecimal -> out.add(newBigDecimal(tmp))
        is BigInteger -> out.add(newBigInt(tmp))
        is Short      -> out.add(newShort(tmp))
        is ByteArray  -> out.add(newBinary(tmp))
        else          -> out.add(newPOJO(tmp))
      }
    }

    return out
  }

  fun newNull(): JsonNode {
    return Mapper.nullNode()
  }

  fun newText(value: String): JsonNode {
    return TextNode(value)
  }

  fun newInt(value: Int): JsonNode {
    return IntNode(value)
  }

  fun newDouble(value: Double): JsonNode {
    return DoubleNode(value)
  }

  fun newLong(value: Long): JsonNode {
    return LongNode(value)
  }

  fun newBool(value: Boolean): JsonNode {
    return if (value) BooleanNode.getTrue() else BooleanNode.getFalse()
  }

  fun newFloat(value: Float): JsonNode {
    return FloatNode(value)
  }

  fun newBigDecimal(value: BigDecimal): JsonNode {
    return DecimalNode(value)
  }

  fun newBigInt(value: BigInteger): JsonNode {
    return BigIntegerNode(value)
  }

  fun newShort(value: Short): JsonNode {
    return ShortNode(value)
  }

  fun newBinary(value: ByteArray): JsonNode
  {
    return BinaryNode(value)
  }

  fun newPOJO(value: Any): JsonNode {
    return POJONode(value)
  }
}
