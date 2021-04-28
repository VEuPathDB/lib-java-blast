package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BlastPTask
{
  BlastP("blastp"),
  BlastPFast("blastp-fast"),
  BlastPShort("blastp-short");

  private final String value;

  BlastPTask(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static BlastPTask fromString(String value) {
    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException();
  }
}
