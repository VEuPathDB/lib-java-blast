package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BlastTool
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

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static BlastTool fromString(String value) {
    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException("Unrecognized blast tool name \"" + value + "\"");
  }
}
