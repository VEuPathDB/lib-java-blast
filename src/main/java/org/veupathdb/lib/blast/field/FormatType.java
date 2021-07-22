package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public enum FormatType implements DefaultingJSONValue
{
  Pairwise,
  QueryAnchoredShowingIdentities,
  QueryAnchoredNoIdentities,
  FlatQueryAnchoredShowingIdentities,
  FlatQueryAnchoredNoIdentities,
  BlastXML,
  Tabular,
  TabularWithCommentLines,
  SeqAlignTextASN1,
  SeqAlignBinaryASN1,
  CommaSeparatedValues,
  BlastArchiveASN1,
  SeqAlignJSON,
  MultipleFileBlastJSON,
  MultipleFileBlastXML2,
  SingleFileBlastJSON,
  SingleFileBlastXML2,
  SequenceAlignmentMap,
  OrganismReport,
  ;

  public int getValue() {
    return this.ordinal();
  }

  @Override
  public boolean isDefault() {
    return this == Pairwise;
  }

  @Override
  public String toString() {
    return String.valueOf(getValue());
  }

  @Override
  @JsonValue
  public JsonNode toJSON() {
    return JSONConstructor.newInt(this.ordinal());
  }

  public static FormatType fromIntValue(int value) {
    return FormatType.values()[value];
  }

  @JsonCreator
  public static FormatType fromJSON(JsonNode js) {
    return fromIntValue(js.intValue());
  }
}
