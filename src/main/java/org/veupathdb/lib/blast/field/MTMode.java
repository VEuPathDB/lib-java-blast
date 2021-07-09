package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public enum MTMode implements DefaultingJSONValue
{
  SplitByDBVolumes,
  SplitByQueries;

  public static final MTMode DefaultMTMode = SplitByDBVolumes;

  public int getValue() {
    return ordinal();
  }

  @Override
  public boolean isDefault() {
    return this == DefaultMTMode;
  }

  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newInt(ordinal());
  }

  public static MTMode fromIntValue(int value) {
    for (var val : values())
      if (val.getValue() == value)
        return val;

    throw new IllegalArgumentException(
      "Illegal mt_mode value \"" + value + "\", must be one of 0 or 1"
    );
  }

  public static MTMode fromJSON(JsonNode js) {
    return fromIntValue(js.intValue());
  }
}
