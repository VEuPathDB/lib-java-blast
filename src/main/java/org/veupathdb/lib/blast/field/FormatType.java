package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FormatType
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

  @JsonValue
  public int getValue() {
    return this.ordinal();
  }

  @Override
  public String toString() {
    return String.valueOf(getValue());
  }

  @JsonCreator
  public static FormatType fromIntValue(int value) {
    return FormatType.values()[value];
  }
}
