package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public record NumAlignments(long value) implements DefaultingJSONValue
{
  public static final long DefaultValue = 250;

  @Override
  public boolean isDefault() {
    return value == DefaultValue;
  }

  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newLong(value);
  }
}
