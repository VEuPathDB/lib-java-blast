package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.util.DefaultingJSONValue
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.JSONConstructor
import com.fasterxml.jackson.annotation.JsonCreator

enum class FormatType : DefaultingJSONValue {
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

  override val isDefault
    get() = this == Pairwise

  override fun toString() = value.toString()

  @JsonValue
  override fun toJSON(): JsonNode = JSONConstructor.newInt(ordinal)

  companion object {
    @JvmStatic
    fun fromIntValue(value: Int): FormatType {
      return values()[value]
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): FormatType {
      return fromIntValue(js.intValue())
    }
  }
}