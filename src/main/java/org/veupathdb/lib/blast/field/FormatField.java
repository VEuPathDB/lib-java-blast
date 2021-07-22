package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public enum FormatField implements DefaultingJSONValue
{
  QuerySeqID("qseqid"),
  QueryGI("qgi"),
  QueryAccession("qacc"),
  QueryAccessionVersion("qaccver"),
  QuerySequenceLength("qlen"),
  SubjectSeqID("sseqid"),
  AllSubjectSeqIDs("sallseqid"),
  SubjectGI("sgi"),
  AllSubjectGIs("sallgi"),
  SubjectAccession("sacc"),
  SubjectAccessionVersion("saccver"),
  AllSubjectAccessions("sallacc"),
  SubjectSequenceLength("slen"),
  StartOfAlignmentInQuery("qstart"),
  EndOfAlignmentInQuery("qend"),
  StartOfAlignmentInSubject("sstart"),
  EndOfAlignmentInSubject("send"),
  AlignedPartOfQuerySequence("qseq"),
  AlignedPartOfSubjectSequence("sseq"),
  ExpectValue("evalue"),
  BitScore("bitscore"),
  RawScore("score"),
  AlignmentLength("length"),
  PercentageOfIdenticalMatches("pident"),
  NumberOfIdenticalMatches("nident"),
  NumberOfMismatches("mismatch"),
  NumberOfPositiveScoringMatches("positive"),
  NumberOfGapOpenings("gapopen"),
  TotalNumberOfGaps("gaps"),
  PercentageOfPositiveScoringMatches("ppos"),
  QueryAndSubjectFrames("frames"),
  QueryFrame("qframe"),
  SubjectFrame("sframe"),
  BlastTracebackOperations("btop"),
  SubjectTaxonomyID("staxid"),
  SubjectScientificName("ssciname"),
  SubjectCommonName("scomname"),
  SubjectBlastName("sblastname"),
  SubjectSuperKingdom("sskingdom"),
  UniqueSubjectTaxonomyIDs("staxids"),
  UniqueSubjectScientificNames("sscinames"),
  UniqueSubjectCommonNames("scomnames"),
  UniqueSubjectBlastNames("sblastnames"),
  UniqueSubjectSuperKingdoms("sskingdoms"),
  SubjectTitle("stitle"),
  AllSubjectTitles("salltitles"),
  SubjectStrand("sstrand"),
  QueryCoveragePerSubject("qcovs"),
  QueryCoveragePerHSP("qcovhsp"),
  QueryCoveragePerUniqueSubject("qcovus"),
  IncludeSequenceData("SQ"),
  SubjectAsReferenceSeq("SR"),
  StandardFields("std"),
  ;

  private final String value;

  FormatField(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public boolean isDefault() {
    return this == StandardFields;
  }

  @Override
  @JsonValue
  public JsonNode toJSON() {
    return JSONConstructor.newText(value);
  }

  @Override
  public String toString() {
    return getValue();
  }

  public static FormatField fromString(String value) {
    for (var val : values())
      if (val.getValue().equals(value))
        return val;

    throw new IllegalArgumentException();
  }

  @JsonCreator
  public static FormatField fromJSON(JsonNode js) {
    return fromString(js.textValue());
  }
}
