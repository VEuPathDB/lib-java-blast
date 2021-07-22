package org.veupathdb.lib.blast;

import org.veupathdb.lib.blast.field.*;

import java.util.Objects;

public abstract class CLIBase implements BlastConfig
{
  private Boolean    shortHelp;
  private Boolean    longHelp;
  private Boolean    version;
  private OutFormat  outFormat;
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

  public Boolean getShortHelp() {
    return shortHelp;
  }

  public void setShortHelp(Boolean shortHelp) {
    this.shortHelp = shortHelp;
  }

  public Boolean getLongHelp() {
    return longHelp;
  }

  public void setLongHelp(Boolean longHelp) {
    this.longHelp = longHelp;
  }

  public Boolean getVersion() {
    return version;
  }

  public void setVersion(Boolean version) {
    this.version = version;
  }

  public OutFile getOutFile() {
    return outFile == null ? null : new OutFile(outFile);
  }

  public void setOutFile(String outFile) {
    this.outFile = outFile;
  }

  public OutFormat getOutFormat() {
    return outFormat;
  }

  public void setOutFormat(OutFormat outFormat) {
    this.outFormat = outFormat;
  }

  public Boolean getShowGIs() {
    return showGIs;
  }

  public void setShowGIs(Boolean showGIs) {
    this.showGIs = showGIs;
  }

  public NumDescriptions getNumDescriptions() {
    return numDescriptions == null ? null : new NumDescriptions(numDescriptions);
  }

  public void setNumDescriptions(Long numDescriptions) {
    this.numDescriptions = numDescriptions;
  }

  public NumAlignments getNumAlignments() {
    return numAlignments == null ? null : new NumAlignments(numAlignments);
  }

  public void setNumAlignments(Long numAlignments) {
    this.numAlignments = numAlignments;
  }

  public LineLength getLineLength() {
    return lineLength == null ? null : new LineLength(lineLength);
  }

  public void setLineLength(Integer lineLength) {
    this.lineLength = lineLength;
  }

  public Boolean getHTML() {
    return html;
  }

  public void setHTML(Boolean html) {
    this.html = html;
  }

  public HitSorting getSortHits() {
    return sortHits;
  }

  public void setSortHits(HitSorting sortHits) {
    this.sortHits = sortHits;
  }

  public HSPSorting getSortHSPs() {
    return sortHSPs;
  }

  public void setSortHSPs(HSPSorting sortHSPs) {
    this.sortHSPs = sortHSPs;
  }

  public MaxTargetSeqs getMaxTargetSequences() {
    return maxTargetSequences == null ? null : new MaxTargetSeqs(maxTargetSequences);
  }

  public void setMaxTargetSequences(Long maxTargetSequences) {
    this.maxTargetSequences = maxTargetSequences;
  }

  public Boolean getParseDefLines() {
    return parseDefLines;
  }

  public void setParseDefLines(Boolean parseDefLines) {
    this.parseDefLines = parseDefLines;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CLIBase cliBase)) return false;
    return Objects.equals(getShortHelp(), cliBase.getShortHelp())
      && Objects.equals(getLongHelp(), cliBase.getLongHelp())
      && Objects.equals(getVersion(), cliBase.getVersion())
      && Objects.equals(getOutFormat(), cliBase.getOutFormat())
      && Objects.equals(getShowGIs(), cliBase.getShowGIs())
      && Objects.equals(getNumDescriptions(), cliBase.getNumDescriptions())
      && Objects.equals(getNumAlignments(), cliBase.getNumAlignments())
      && Objects.equals(getLineLength(), cliBase.getLineLength())
      && Objects.equals(html, cliBase.html)
      && getSortHits() == cliBase.getSortHits()
      && getSortHSPs() == cliBase.getSortHSPs()
      && Objects.equals(getMaxTargetSequences(), cliBase.getMaxTargetSequences())
      && Objects.equals(getOutFile(), cliBase.getOutFile())
      && Objects.equals(getParseDefLines(), cliBase.getParseDefLines());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      getShortHelp(),
      getLongHelp(),
      getVersion(),
      getOutFormat(),
      getShowGIs(),
      getNumDescriptions(),
      getNumAlignments(),
      getLineLength(),
      getHTML(),
      getSortHits(),
      getSortHSPs(),
      getMaxTargetSequences(),
      getOutFile(),
      getParseDefLines()
    );
  }
}
