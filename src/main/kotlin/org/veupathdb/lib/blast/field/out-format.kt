package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyOutFormat = "-outfmt"


internal fun ParseOutFormat(js: ObjectNode): OutFormat {
  val obj = js[KeyOutFormat] ?: return OutFormat()
  obj.isObject || return OutFormat()
  obj as ObjectNode

  return OutFormat(
    parseFormatType(obj),
    parseFormatDelimiter(obj),
    parseFormatFields(obj)
  )
}


data class OutFormat(
  var type:      FormatType      = DefaultFormatType,
  var delimiter: FormatDelimiter = FormatDelimiter(),
  val fields:    FormatFields    = FormatFields()
) : BlastField {
  override val isDefault: Boolean
    get() = type.isDefault && delimiter.isDefault && fields.isDefault

  override fun appendJson(json: ObjectNode) {
    if (!isDefault)
      with(json.putObject(KeyOutFormat)) {
        type.appendJson(this)
        delimiter.appendJson(this)
        fields.appendJson(this)
      }
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (isDefault)
      return

    // Always insert the format type if we are adding this flag to the CLI call.
    cli.append(' ')
      .append(KeyOutFormat)
      .append(" '")
      .append(type.value)

    delimiter.appendCliSegment(cli)
    fields.appendCliSegment(cli)

    cli.append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyOutFormat)

      val tmp = StringBuilder(256)

      tmp.append(type.value)
      delimiter.appendCliSegment(tmp)
      fields.appendCliSegment(tmp)

      cli.add(tmp.toString())
    }
  }
}


////////////////////////////////////////////////////////////////////////////////


private const val DefaultDelimiter = ""

private const val KeyDelimiter = "delimiter"


private fun parseFormatDelimiter(js: ObjectNode) =
  FormatDelimiter(js[KeyDelimiter]?.textValue() ?: DefaultDelimiter)


@JvmInline
value class FormatDelimiter(val value: String = DefaultDelimiter) {
  val isDefault get() = value == DefaultDelimiter

  fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyDelimiter, value)
  }

  fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(" delim=").append(value)
  }
}


////////////////////////////////////////////////////////////////////////////////


private const val KeyFormatFields = "fields"


private fun parseFormatFields(js: ObjectNode): FormatFields {
  val arr = js[KeyFormatFields] ?: return FormatFields()
  arr.isArray || return FormatFields()
  arr as ArrayNode

  val tmp = ArrayList<FormatField>(arr.size())

  arr.forEach {
    tmp.add(FormatField.fromString(it.textValue()))
  }

  return FormatFields(tmp)
}


@JvmInline
value class FormatFields(
  val value: List<FormatField> = listOf(DefaultFormatField)
) {
  val isDefault
    get() = value.isEmpty() || (value.size == 1 && value[0].isDefault)

  fun appendJson(json: ObjectNode) {
    if (!isDefault)
      with(json.putArray(KeyFormatFields)) {
        value.forEach {
          add(it.value)
        }
      }
  }

  fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      value.forEach { cli.append(' ').append(it.value) }
  }
}


////////////////////////////////////////////////////////////////////////////////


private val DefaultFormatType = FormatType.Pairwise

private const val KeyFormatType = "type"


private fun parseFormatType(js: ObjectNode) =
  js[KeyFormatType]?.run { FormatType.fromIntValue(intValue()) } ?: DefaultFormatType


enum class FormatType {
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
  OrganismReport;

  val value = ordinal

  val isDefault get() = this == DefaultFormatType

  fun appendJson(json: ObjectNode) {
    if (!isDefault)
      json.put(KeyFormatType, value)
  }

  fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(value)
  }

  override fun toString() = value.toString()

  companion object {
    @JvmStatic
    @JsonCreator
    fun fromIntValue(value: Int): FormatType {
      return values()[value]
    }
  }
}


////////////////////////////////////////////////////////////////////////////////


private val DefaultFormatField = FormatField.StandardFields


enum class FormatField(val value: String) {
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
  StandardFields("std");

  val isDefault: Boolean get() = this == DefaultFormatField

  override fun toString() = value

  companion object {
    @JvmStatic
    @JsonCreator
    fun fromString(value: String): FormatField {
      for (`val` in values()) if (`val`.value == value) return `val`
      throw IllegalArgumentException()
    }
  }
}
