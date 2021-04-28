package org.veupathdb.lib.blast.field;

import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Strand
{
  Both,
  Minus,
  Plus;

  @JsonValue
  public String getValue() {
    return name().toLowerCase(Locale.ROOT);
  }

  @JsonCreator
  public static Strand fromString(String value) {
    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException();
  }
}
