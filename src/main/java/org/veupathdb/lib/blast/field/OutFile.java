package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public record OutFile(String value) implements DefaultingJSONValue
{
  public static final String DefaultValue = "-";

  @Override
  public boolean isDefault() {
    return value == null || DefaultValue.equals(value);
  }

  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newText(value);
  }
}
