package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.field.MTMode;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.field.Strand;
import org.veupathdb.lib.blast.field.ThreadMode;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

import java.util.Objects;

public class RPSTBlastN extends BlastBase implements BlastQueryConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.RPSTBlastN;
  }

  // ------------------------------------------------------------------------------------------ //

  private Short queryGenCode;

  public Short getQueryGenCode() {
    return queryGenCode;
  }

  public void setQueryGenCode(Short queryGenCode) {
    this.queryGenCode = queryGenCode;
  }

  // ------------------------------------------------------------------------------------------ //

  private Strand strand;

  public Strand getStrand() {
    return strand;
  }

  public void setStrand(Strand strand) {
    this.strand = strand;
  }

  // ------------------------------------------------------------------------------------------ //

  private String compBasedStats;

  public String getCompBasedStats() {
    return compBasedStats;
  }

  public void setCompBasedStats(String compBasedStats) {
    this.compBasedStats = compBasedStats;
  }

  // ------------------------------------------------------------------------------------------ //

  private Seg seg;

  public Seg getSeg() {
    return seg;
  }

  public void setSeg(Seg seg) {
    this.seg = seg;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean sumStats;

  public Boolean getSumStats() {
    return sumStats;
  }

  public void setSumStats(Boolean sumStats) {
    this.sumStats = sumStats;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double extensionDropoffPrelimGapped;

  public Double getExtensionDropoffPrelimGapped() {
    return extensionDropoffPrelimGapped;
  }

  public void setExtensionDropoffPrelimGapped(Double extensionDropoffPrelimGapped) {
    this.extensionDropoffPrelimGapped = extensionDropoffPrelimGapped;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double extensionDropoffFinalGapped;

  public Double getExtensionDropoffFinalGapped() {
    return extensionDropoffFinalGapped;
  }

  public void setExtensionDropoffFinalGapped(Double extensionDropoffFinalGapped) {
    this.extensionDropoffFinalGapped = extensionDropoffFinalGapped;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean ungappedAlignmentsOnly;

  public Boolean getUngappedAlignmentsOnly() {
    return ungappedAlignmentsOnly;
  }

  public void setUngappedAlignmentsOnly(Boolean ungappedAlignmentsOnly) {
    this.ungappedAlignmentsOnly = ungappedAlignmentsOnly;
  }

  // ------------------------------------------------------------------------------------------ //

  private ThreadMode numThreads;

  public ThreadMode getNumThreads() {
    return numThreads;
  }

  public void setNumThreads(ThreadMode numThreads) {
    this.numThreads = numThreads;
  }

  // ------------------------------------------------------------------------------------------ //

  private MTMode mtMode;

  public MTMode getMTMode() {
    return mtMode;
  }

  public void setMTMode(MTMode mtMode) {
    this.mtMode = mtMode;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean useSmithWatermanTraceback;

  public Boolean getUseSmithWatermanTraceback() {
    return useSmithWatermanTraceback;
  }

  public void setUseSmithWatermanTraceback(Boolean useSmithWatermanTraceback) {
    this.useSmithWatermanTraceback = useSmithWatermanTraceback;
  }

  // ------------------------------------------------------------------------------------------ //

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    RPSTBlastN that = (RPSTBlastN) o;
    return Objects.equals(getQueryGenCode(), that.getQueryGenCode())
      && getStrand() == that.getStrand()
      && Objects.equals(getCompBasedStats(), that.getCompBasedStats())
      && Objects.equals(getSeg(), that.getSeg())
      && Objects.equals(getSumStats(), that.getSumStats())
      && Objects.equals(
      getExtensionDropoffPrelimGapped(),
      that.getExtensionDropoffPrelimGapped()
    )
      && Objects.equals(
      getExtensionDropoffFinalGapped(),
      that.getExtensionDropoffFinalGapped()
    )
      && Objects.equals(getUngappedAlignmentsOnly(), that.getUngappedAlignmentsOnly())
      && getNumThreads() == that.getNumThreads()
      && mtMode == that.mtMode
      && Objects.equals(
      getUseSmithWatermanTraceback(),
      that.getUseSmithWatermanTraceback()
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      super.hashCode(),
      getTool(),
      getQueryGenCode(),
      getStrand(),
      getCompBasedStats(),
      getSeg(),
      getSumStats(),
      getExtensionDropoffPrelimGapped(),
      getExtensionDropoffFinalGapped(),
      getUngappedAlignmentsOnly(),
      getNumThreads(),
      getMTMode(),
      getUseSmithWatermanTraceback()
    );
  }

  @Override
  public JSONObjectEncoder toJSON(boolean includeTool) {
    var js = super.toJSON(includeTool);

    js.encode(Flag.QueryGenCode, queryGenCode);
    js.encode(Flag.Strand, strand);
    js.encode(Flag.CompBasedStats, compBasedStats);
    js.encode(Flag.Seg, seg);
    js.encode(Flag.SumStats, sumStats);
    js.encode(Flag.ExtensionDropoffPrelimGapped, extensionDropoffPrelimGapped);
    js.encode(Flag.ExtensionDropoffFinalGapped, extensionDropoffFinalGapped);
    js.encode(Flag.UngappedAlignmentsOnly, ungappedAlignmentsOnly);
    js.encode(Flag.NumThreads, numThreads);
    js.encode(Flag.MTMode, mtMode);
    js.encode(Flag.UseSmithWatermanTraceback, useSmithWatermanTraceback);

    return js;
  }

  @Override
  public void decodeJSON(JSONObjectDecoder js) {
    super.decodeJSON(js);

    js.decode(Flag.QueryGenCode, this::setQueryGenCode);
    js.decode(Flag.Strand, this::setStrand, Strand::fromJSON);
    js.decode(Flag.CompBasedStats, this::setCompBasedStats);
    js.decode(Flag.Seg, this::setSeg, Seg::fromJSON);
    js.decode(Flag.SumStats, this::setSumStats);
    js.decode(Flag.ExtensionDropoffPrelimGapped, this::setExtensionDropoffPrelimGapped);
    js.decode(Flag.ExtensionDropoffFinalGapped, this::setExtensionDropoffFinalGapped);
    js.decode(Flag.UngappedAlignmentsOnly, this::setUngappedAlignmentsOnly);
    js.decode(Flag.NumThreads, this::setNumThreads, ThreadMode::fromJSON);
    js.decode(Flag.MTMode, this::setMTMode, MTMode::fromJSON);
    js.decode(Flag.UseSmithWatermanTraceback, this::setUseSmithWatermanTraceback);
  }

  @JsonCreator
  public static RPSTBlastN fromJSON(JSONObjectDecoder js) {
    var out = new RPSTBlastN();
    out.decodeJSON(js);
    return out;
  }
}
