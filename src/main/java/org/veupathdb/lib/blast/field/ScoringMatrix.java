package org.veupathdb.lib.blast.field;

import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ScoringMatrix
{
  Blosum45,
  Blosum50,
  Blosum62,
  Blosum80,
  Blosum90,
  Pam30,
  Pam70,
  Pam250,
  Identity;

  @JsonValue
  public String getValue() {
    return name().toUpperCase(Locale.ROOT);
  }

  @JsonCreator
  public static ScoringMatrix fromString(String value) {
    value = value.toUpperCase(Locale.ROOT);

    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException();
  }
}
