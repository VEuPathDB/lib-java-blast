package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.JSONConstructor;
import org.veupathdb.lib.blast.util.JSONValue;

public enum TemplateType implements JSONValue
{
  Coding("coding"),
  CodingAndOptimal("coding_and_optimal"),
  Optimal("optimal");

  private final String value;

  TemplateType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newText(value);
  }

  public static TemplateType fromString(String value) {
    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException("Unrecognized template_type value \"" + value + "\".");
  }

  public static TemplateType fromJSON(JsonNode js) {
    return fromString(js.textValue());
  }
}
