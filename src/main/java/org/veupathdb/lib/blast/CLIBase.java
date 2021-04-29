package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.HSPSorting;
import org.veupathdb.lib.blast.field.HitSorting;
import org.veupathdb.lib.blast.field.OutFormat;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CLIBase
{
  private Boolean   shortHelp;
  private Boolean   longHelp;
  private Boolean   version;
  private OutFormat outFormat;
  private Boolean    showGIs;
  private Long       numDescriptions;
  private Long       numAlignments;
  private Integer    lineLength;
  private Boolean    html;
  private HitSorting sortHits;
  private HSPSorting sortHSPs;
  private Long       maxTargetSequences;
  private String     outFile;
  private Boolean    parseDefLines;

  @JsonGetter(Flag.ShortHelp)
  public Boolean getShortHelp() {
    return shortHelp;
  }

  @JsonSetter(Flag.ShortHelp)
  public void setShortHelp(Boolean shortHelp) {
    this.shortHelp = shortHelp;
  }

  @JsonGetter(Flag.LongHelp)
  public Boolean getLongHelp() {
    return longHelp;
  }

  @JsonSetter(Flag.LongHelp)
  public void setLongHelp(Boolean longHelp) {
    this.longHelp = longHelp;
  }

  @JsonGetter(Flag.Version)
  public Boolean getVersion() {
    return version;
  }

  @JsonSetter(Flag.Version)
  public void setVersion(Boolean version) {
    this.version = version;
  }

  @JsonGetter(Flag.OutFile)
  public String getOutFile() {
    return outFile;
  }

  @JsonSetter(Flag.OutFile)
  public void setOutFile(String outFile) {
    this.outFile = outFile;
  }

  @JsonGetter(Flag.OutFormat)
  public OutFormat getOutFormat() {
    return outFormat;
  }

  @JsonSetter(Flag.OutFormat)
  public void setOutFormat(OutFormat outFormat) {
    this.outFormat = outFormat;
  }

  @JsonGetter(Flag.ShowGIs)
  public Boolean getShowGIs() {
    return showGIs;
  }

  @JsonSetter(Flag.ShowGIs)
  public void setShowGIs(Boolean showGIs) {
    this.showGIs = showGIs;
  }

  @JsonGetter(Flag.NumDescriptions)
  public Long getNumDescriptions() {
    return numDescriptions;
  }

  @JsonSetter(Flag.NumDescriptions)
  public void setNumDescriptions(Long numDescriptions) {
    this.numDescriptions = numDescriptions;
  }

  @JsonGetter(Flag.NumAlignments)
  public Long getNumAlignments() {
    return numAlignments;
  }

  @JsonSetter(Flag.NumAlignments)
  public void setNumAlignments(Long numAlignments) {
    this.numAlignments = numAlignments;
  }

  @JsonGetter(Flag.LineLength)
  public Integer getLineLength() {
    return lineLength;
  }

  @JsonSetter(Flag.LineLength)
  public void setLineLength(Integer lineLength) {
    this.lineLength = lineLength;
  }

  @JsonGetter(Flag.HTML)
  public Boolean getHTML() {
    return html;
  }

  @JsonSetter(Flag.HTML)
  public void setHTML(Boolean html) {
    this.html = html;
  }

  @JsonGetter(Flag.SortHits)
  public HitSorting getSortHits() {
    return sortHits;
  }

  @JsonSetter(Flag.SortHits)
  public void setSortHits(HitSorting sortHits) {
    this.sortHits = sortHits;
  }

  @JsonGetter(Flag.SortHSPs)
  public HSPSorting getSortHSPs() {
    return sortHSPs;
  }

  @JsonSetter(Flag.SortHSPs)
  public void setSortHSPs(HSPSorting sortHSPs) {
    this.sortHSPs = sortHSPs;
  }

  @JsonGetter(Flag.MaxTargetSequences)
  public Long getMaxTargetSequences() {
    return maxTargetSequences;
  }

  @JsonSetter(Flag.MaxTargetSequences)
  public void setMaxTargetSequences(Long maxTargetSequences) {
    this.maxTargetSequences = maxTargetSequences;
  }

  @JsonGetter(Flag.ParseDefLines)
  public Boolean getParseDefLines() {
    return parseDefLines;
  }

  @JsonSetter(Flag.ParseDefLines)
  public void setParseDefLines(Boolean parseDefLines) {
    this.parseDefLines = parseDefLines;
  }
}
