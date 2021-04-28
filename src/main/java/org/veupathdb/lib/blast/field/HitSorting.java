package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum HitSorting
{
  ByExpectValue,
  ByBitScore,
  ByTotalScore,
  ByPercentIdentity,
  ByQueryCoverage,
  ;

  @JsonValue
  public int getValue() {
    return this.ordinal();
  }

  @JsonCreator
  public static HitSorting fromIntValue(int value) {
    return values()[value];
  }
}
