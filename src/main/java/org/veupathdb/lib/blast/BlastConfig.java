package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.HSPSorting;
import org.veupathdb.lib.blast.field.HitSorting;
import org.veupathdb.lib.blast.field.OutFormat;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface BlastConfig
{
  @JsonIgnore
  BlastTool getTool();

  @JsonGetter(Flag.ShortHelp)
  Boolean getShortHelp();

  @JsonSetter(Flag.ShortHelp)
  void setShortHelp(Boolean val);

  @JsonGetter(Flag.LongHelp)
  Boolean getLongHelp();

  @JsonSetter(Flag.LongHelp)
  void setLongHelp(Boolean val);

  @JsonGetter(Flag.Version)
  Boolean getVersion();

  @JsonSetter(Flag.Version)
  void setVersion(Boolean val);

  @JsonGetter(Flag.OutFile)
  String getOutFile();

  @JsonSetter(Flag.OutFile)
  void setOutFile(String file);

  @JsonGetter(Flag.OutFormat)
  OutFormat getOutFormat();

  @JsonSetter(Flag.OutFormat)
  void setOutFormat(OutFormat fmt);

  @JsonGetter(Flag.ShowGIs)
  Boolean getShowGIs();

  @JsonSetter(Flag.ShowGIs)
  void setShowGIs(Boolean val);

  @JsonGetter(Flag.NumDescriptions)
  Long getNumDescriptions();

  @JsonSetter(Flag.NumDescriptions)
  void setNumDescriptions(Long val);

  @JsonGetter(Flag.NumAlignments)
  Long getNumAlignments();

  @JsonSetter(Flag.NumAlignments)
  void setNumAlignments(Long val);

  @JsonGetter(Flag.LineLength)
  Integer getLineLength();

  @JsonSetter(Flag.LineLength)
  void setLineLength(Integer val);

  @JsonGetter(Flag.HTML)
  Boolean getHTML();

  @JsonSetter(Flag.HTML)
  void setHTML(Boolean val);

  @JsonGetter(Flag.SortHits)
  HitSorting getSortHits();

  @JsonSetter(Flag.SortHits)
  void setSortHits(HitSorting val);

  @JsonGetter(Flag.SortHSPs)
  HSPSorting getSortHSPs();

  @JsonSetter(Flag.SortHSPs)
  void setSortHSPs(HSPSorting val);

  @JsonGetter(Flag.MaxTargetSequences)
  Long getMaxTargetSequences();

  @JsonSetter(Flag.MaxTargetSequences)
  void setMaxTargetSequences(Long val);

  @JsonGetter(Flag.ParseDefLines)
  Boolean getParseDefLines();

  @JsonSetter(Flag.ParseDefLines)
  void setParseDefLines(Boolean val);
}
