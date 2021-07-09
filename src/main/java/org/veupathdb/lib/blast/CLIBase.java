package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.HSPSorting;
import org.veupathdb.lib.blast.field.HitSorting;
import org.veupathdb.lib.blast.field.OutFormat;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONEncodable;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

public class CLIBase implements JSONEncodable
{
  public static final long   DefaultNumDescriptions = 500;
  public static final long   DefaultNumAlignments   = 250;
  public static final int    DefaultLineLength      = 60;
  public static final long   DefaultMaxTargetSeqs   = 500;
  public static final String DefaultOutFile         = "-";

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

  public String getOutFile() {
    return outFile;
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

  public Long getNumDescriptions() {
    return numDescriptions;
  }

  public void setNumDescriptions(Long numDescriptions) {
    this.numDescriptions = numDescriptions;
  }

  public Long getNumAlignments() {
    return numAlignments;
  }

  public void setNumAlignments(Long numAlignments) {
    this.numAlignments = numAlignments;
  }

  public Integer getLineLength() {
    return lineLength;
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

  public Long getMaxTargetSequences() {
    return maxTargetSequences;
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
    if (!(o instanceof CLIBase)) return false;
    CLIBase cliBase = (CLIBase) o;
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

  public CLIBase copy() {
    var out = new CLIBase();
    copyInto(out);
    return out;
  }

  @Override
  @JsonValue
  public JSONObjectEncoder toJSON() {
    var out = new JSONObjectEncoder();

    out.encode(Flag.ShortHelp, shortHelp);
    out.encode(Flag.LongHelp, longHelp);
    out.encode(Flag.Version, version);
    out.encode(Flag.OutFormat, outFormat);
    out.encode(Flag.ShowGIs, showGIs);
    out.encode(Flag.NumDescriptions, numDescriptions, DefaultNumDescriptions);
    out.encode(Flag.NumAlignments, numAlignments, DefaultNumAlignments);
    out.encode(Flag.LineLength, lineLength, DefaultLineLength);
    out.encode(Flag.HTML, html);
    out.encode(Flag.SortHits, sortHits);
    out.encode(Flag.SortHSPs, sortHSPs);
    out.encode(Flag.MaxTargetSequences, maxTargetSequences, DefaultMaxTargetSeqs);
    out.encode(Flag.OutFile, outFile, DefaultOutFile);
    out.encode(Flag.ParseDefLines, parseDefLines);

    return out;
  }

  @JsonCreator
  public static CLIBase fromJSON(JSONObjectDecoder js) {
    var out = new CLIBase();
    out.copyInto(js);
    return out;
  }

  protected void copyInto(CLIBase out) {
    out.setShortHelp(getShortHelp());
    out.setLongHelp(getLongHelp());
    out.setVersion(getVersion());
    if (outFormat != null)
      out.setOutFormat(getOutFormat().copy());
    out.setShowGIs(getShowGIs());
    out.setNumDescriptions(getNumDescriptions());
    out.setNumAlignments(getNumAlignments());
    out.setLineLength(getLineLength());
    out.setHTML(getHTML());
    out.setSortHits(getSortHits());
    out.setSortHSPs(getSortHSPs());
    out.setMaxTargetSequences(getMaxTargetSequences());
    out.setOutFile(getOutFile());
    out.setParseDefLines(getParseDefLines());
  }

  protected void copyInto(JSONObjectDecoder js) {
    js.decode(Flag.ShortHelp, this::setShortHelp);
    js.decode(Flag.LongHelp, this::setLongHelp);
    js.decode(Flag.Version, this::setVersion);
    js.decode(Flag.OutFormat, this::setOutFormat, OutFormat::fromJSON);
    js.decode(Flag.ShowGIs, this::setShowGIs);
    js.decode(Flag.NumDescriptions, this::setNumDescriptions);
    js.decode(Flag.NumAlignments, this::setNumAlignments);
    js.decode(Flag.LineLength, this::setLineLength);
    js.decode(Flag.HTML, this::setHTML);
    js.decode(Flag.SortHits, this::setSortHits, HitSorting::fromJSON);
    js.decode(Flag.SortHSPs, this::setSortHSPs, HSPSorting::fromJSON);
    js.decode(Flag.MaxTargetSequences, this::setMaxTargetSequences);
    js.decode(Flag.OutFile, this::setOutFile);
    js.decode(Flag.ParseDefLines, this::setParseDefLines);
  }
}
