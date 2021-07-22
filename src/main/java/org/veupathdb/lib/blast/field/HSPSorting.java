package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.JSONConstructor;
import org.veupathdb.lib.blast.util.JSONValue;

public enum HSPSorting implements JSONValue
{
  ByHSPExpectValue,
  ByHSPScore,
  ByHSPQueryStart,
  ByHSPPercentIdentity,
  ByHSPSubjectStart;

  public int getValue() {
    return this.ordinal();
  }

  public static HSPSorting fromIntValue(int value) {
    return values()[value];
  }

  @JsonCreator
  public static HSPSorting fromJSON(JsonNode js) {
    return fromIntValue(js.intValue());
  }

  @Override
  @JsonValue
  public JsonNode toJSON() {
    return JSONConstructor.newInt(this.ordinal());
  }
}
