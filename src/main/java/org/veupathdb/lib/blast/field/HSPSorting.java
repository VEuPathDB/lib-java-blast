package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum HSPSorting
{
  ByHSPExpectValue,
  ByHSPScore,
  ByHSPQueryStart,
  ByHSPPercentIdentity,
  ByHSPSubjectStart;

  @JsonValue
  public int getValue() {
    return this.ordinal();
  }

  @JsonCreator
  public static HSPSorting fromIntValue(int value) {
    return values()[value];
  }
}
