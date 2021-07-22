package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public enum BlastPTask implements DefaultingJSONValue
{
  BlastP("blastp"),
  BlastPFast("blastp-fast"),
  BlastPShort("blastp-short");

  public static final BlastPTask DefaultTask = BlastP;

  private final String value;

  BlastPTask(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean isDefault() {
    return this == DefaultTask;
  }

  @JsonValue
  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newText(value);
  }

  public static BlastPTask fromString(String value) {
    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException();
  }

  @JsonCreator
  public static BlastPTask fromJSON(JsonNode js) {
    return fromString(js.textValue());
  }
}
