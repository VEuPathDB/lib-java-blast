package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.JSONConstructor;
import org.veupathdb.lib.blast.util.JSONValue;

public enum BlastTool implements JSONValue
{
  BlastN("blastn"),
  BlastP("blastp"),
  BlastX("blastx"),
  DeltaBlast("deltablast"),
  PSIBlast("psiblast"),
  RPSBlast("rpsblast"),
  RPSTBlastN("rpstblastn"),
  TBlastN("tblastn"),
  TBlastX("tblastx"),
  BlastFormatter("blast_formatter");

  private final String value;

  BlastTool(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  @JsonValue
  public JsonNode toJSON() {
    return JSONConstructor.newText(value);
  }

  @JsonCreator
  public static BlastTool fromJSON(JsonNode val) {
    if (!val.isTextual())
      throw new IllegalArgumentException("Cannot convert the value " + val + " to an instance of BlastTool");

    return fromString(val.textValue());
  }

  public static BlastTool fromString(String value) {
    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException("Unrecognized blast tool name \"" + value + "\"");
  }
}
