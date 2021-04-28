package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TemplateLength
{
  Length16(16),
  Length18(18),
  Length21(21);

  private final int value;

  TemplateLength(int value) {
    this.value = value;
  }

  @JsonValue
  public int getValue() {
    return value;
  }

  @JsonCreator
  public static TemplateLength fromIntValue(int value) {
    for (var val : values())
      if (val.getValue() == value)
        return val;

    throw new IllegalArgumentException();
  }
}
