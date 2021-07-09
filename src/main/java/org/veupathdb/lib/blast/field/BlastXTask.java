package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public enum BlastXTask implements DefaultingJSONValue
{
  BlastX("blastx"),
  BlastXFast("blastx-fast");

  public static final BlastXTask DefaultTask = BlastX;

  private final String value;

  BlastXTask(String value) {
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

  public static BlastXTask fromString(String value) {
    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException("Unrecognized blastx task value \"" + value + "\"");
  }

  @JsonCreator
  public static BlastXTask fromJSON(JsonNode js) {
    return fromString(js.textValue());
  }
}
