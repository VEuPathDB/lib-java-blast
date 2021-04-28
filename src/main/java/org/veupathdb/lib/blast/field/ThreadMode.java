package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ThreadMode
{
  Auto,
  Disable;

  @JsonValue
  public int getValue() {
    return ordinal();
  }

  @JsonCreator
  public static ThreadMode fromIntValue(int value) {
    for (var val : values())
      if (val.getValue() == value)
        return val;

    throw new IllegalArgumentException();
  }
}
