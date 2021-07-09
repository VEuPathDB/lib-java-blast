package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public enum TBlastNTask implements DefaultingJSONValue
{
  TBlastN("tblastn"),
  TBlastNFast("tblastn-fast");

  public static final TBlastNTask DefaultTask = TBlastN;

  private final String value;

  TBlastNTask(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean isDefault() {
    return this == DefaultTask;
  }

  @Override
  @JsonValue
  public JsonNode toJSON() {
    return JSONConstructor.newText(value);
  }

  public static TBlastNTask fromString(String value) {
    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException("Unrecognized task value \"" + value + "\".");
  }

  @JsonCreator
  public static TBlastNTask fromJSON(JsonNode js) {
    return fromString(js.textValue());
  }
}
