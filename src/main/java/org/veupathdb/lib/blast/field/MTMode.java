package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MTMode
{
  SplitByDBVolumes,
  SplitByQueries;

  @JsonValue
  public int getValue() {
    return ordinal();
  }

  @JsonCreator
  public static MTMode fromIntValue(int value) {
    for (var val : values())
      if (val.getValue() == value)
        return val;

    throw new IllegalArgumentException();
  }
}
