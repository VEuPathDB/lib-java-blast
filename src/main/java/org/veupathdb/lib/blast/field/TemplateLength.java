package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.JSONConstructor;
import org.veupathdb.lib.blast.util.JSONValue;

public enum TemplateLength implements JSONValue
{
  Length16(16),
  Length18(18),
  Length21(21);

  private final int value;

  TemplateLength(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newInt(value);
  }

  public static TemplateLength fromIntValue(int value) {
    for (var val : values())
      if (val.getValue() == value)
        return val;

    throw new IllegalArgumentException(
      "Invalid template_length value \"" + value + "\", must be one of 16, 18, or 21."
    );
  }

  public static TemplateLength fromJSON(JsonNode js) {
    return fromIntValue(js.intValue());
  }
}
