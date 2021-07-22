package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;

public record QueryFile(String value) implements DefaultingJSONValue
{
  public static final String DefaultValue = "-";

  @Override
  public boolean isDefault() {
    return value == null || DefaultValue.equals(value);
  }

  @Override
  public JsonNode toJSON() {
    return new TextNode(value);
  }
}
