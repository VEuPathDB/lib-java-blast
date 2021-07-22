package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public record LineLength(int value) implements DefaultingJSONValue
{
  public static final int DefaultValue = 60;

  @Override
  public boolean isDefault() {
    return value == DefaultValue;
  }

  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newInt(value);
  }
}
