package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public enum BlastNTask implements DefaultingJSONValue
{
  BlastN("blastn"),
  BlastNShort("blastn-short"),
  DiscontiguousMegablast("dc-megablast"),
  Megablast("megablast"),
  RMBlastN("rmblastn");

  public static final BlastNTask DefaultTask = Megablast;

  private final String value;

  BlastNTask(String value) {
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
  public JsonNode toJSON() {
    return JSONConstructor.newText(value);
  }

  public static BlastNTask fromString(String value) {
    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException("Unrecognized blastn task \"" + value + "\"");
  }

  public static BlastNTask fromJSON(JsonNode js) {
    return fromString(js.textValue());
  }
}
