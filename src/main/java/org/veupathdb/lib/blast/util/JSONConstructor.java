package org.veupathdb.lib.blast.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.*;

public class JSONConstructor
{
  public static final ObjectMapper Mapper = new ObjectMapper();

  public static ObjectNode newObject() {
    return Mapper.createObjectNode();
  }

  public static ArrayNode newArray() {
    return Mapper.createArrayNode();
  }

  public static ArrayNode newArray(Collection<?> value) {
    var out = Mapper.createArrayNode();

    for (var val : value) {
      if (val == null)
        out.add(newNull());
      else if (val instanceof JsonNode js)
        out.add(js);
      else if (val instanceof String s)
        out.add(newText(s));
      else if (val instanceof Integer i)
        out.add(newInt(i));
      else if (val instanceof Double d)
        out.add(newDouble(d));
      else if (val instanceof Long l)
        out.add(newLong(l));
      else if (val instanceof Boolean b)
        out.add(newBool(b));
      else if (val instanceof Float f)
        out.add(newFloat(f));
      else if (val instanceof BigDecimal b)
        out.add(newBigDecimal(b));
      else if (val instanceof BigInteger b)
        out.add(newBigInt(b));
      else if (val instanceof Short s)
        out.add(newShort(s));
      else if (val instanceof byte[] b)
        out.add(newBinary(b));
      else
        out.add(newPOJO(val));
    }

    return out;
  }

  public static JsonNode newNull() {
    return Mapper.nullNode();
  }

  public static JsonNode newText(String value) {
    return new TextNode(value);
  }

  public static JsonNode newInt(int value) {
    return new IntNode(value);
  }

  public static JsonNode newDouble(double value) {
    return new DoubleNode(value);
  }

  public static JsonNode newLong(long value) {
    return new LongNode(value);
  }

  public static JsonNode newBool(boolean value) {
    return value ? BooleanNode.getTrue() : BooleanNode.getFalse();
  }

  public static JsonNode newFloat(float value) {
    return new FloatNode(value);
  }

  public static JsonNode newBigDecimal(BigDecimal value) {
    return new DecimalNode(value);
  }

  public static JsonNode newBigInt(BigInteger value) {
    return new BigIntegerNode(value);
  }

  public static JsonNode newShort(short value) {
    return new ShortNode(value);
  }

  public static JsonNode newBinary(byte[] value) {
    return new BinaryNode(value);
  }

  public static JsonNode newPOJO(Object value) {
    return new POJONode(value);
  }

  ////////////////////////////////////////////////////////////////////////////////////////////////
  //                                                                                            //
  //    JSON Builder Methods                                                                    //
  //                                                                                            //
  ////////////////////////////////////////////////////////////////////////////////////////////////


  ////////////////////////////////////////////////////////////////////////////////////////////////
  //                                                                                            //
  //    JSON Decoding Methods                                                                   //
  //                                                                                            //
  ////////////////////////////////////////////////////////////////////////////////////////////////

}
