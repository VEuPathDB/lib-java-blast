package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.MTMode;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.field.Strand;
import org.veupathdb.lib.blast.field.ThreadMode;

public class RPSTBlastN extends BaseBlast
{
  private Short queryGenCode;

  @JsonGetter(Flag.QueryGenCode)
  public Short getQueryGenCode() {
    return queryGenCode;
  }

  @JsonSetter(Flag.QueryGenCode)
  public void setQueryGenCode(Short queryGenCode) {
    this.queryGenCode = queryGenCode;
  }

  // ------------------------------------------------------------------------------------------ //

  private Strand strand;

  @JsonGetter(Flag.Strand)
  public Strand getStrand() {
    return strand;
  }

  @JsonSetter(Flag.Strand)
  public void setStrand(Strand strand) {
    this.strand = strand;
  }

  // ------------------------------------------------------------------------------------------ //

  private String compBasedStats;

  @JsonGetter(Flag.CompBasedStats)
  public String getCompBasedStats() {
    return compBasedStats;
  }

  @JsonSetter(Flag.CompBasedStats)
  public void setCompBasedStats(String compBasedStats) {
    this.compBasedStats = compBasedStats;
  }

  // ------------------------------------------------------------------------------------------ //

  private Seg seg;

  @JsonGetter(Flag.Seg)
  public Seg getSeg() {
    return seg;
  }

  @JsonSetter(Flag.Seg)
  public void setSeg(Seg seg) {
    this.seg = seg;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean sumStats;

  @JsonGetter(Flag.SumStats)
  public Boolean getSumStats() {
    return sumStats;
  }

  @JsonSetter(Flag.SumStats)
  public void setSumStats(Boolean sumStats) {
    this.sumStats = sumStats;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double extensionDropoffPrelimGapped;

  @JsonGetter(Flag.ExtensionDropoffPrelimGapped)
  public Double getExtensionDropoffPrelimGapped() {
    return extensionDropoffPrelimGapped;
  }

  @JsonSetter(Flag.ExtensionDropoffPrelimGapped)
  public void setExtensionDropoffPrelimGapped(Double extensionDropoffPrelimGapped) {
    this.extensionDropoffPrelimGapped = extensionDropoffPrelimGapped;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double extensionDropoffFinalGapped;

  @JsonGetter(Flag.ExtensionDropoffFinalGapped)
  public Double getExtensionDropoffFinalGapped() {
    return extensionDropoffFinalGapped;
  }

  @JsonSetter(Flag.ExtensionDropoffFinalGapped)
  public void setExtensionDropoffFinalGapped(Double extensionDropoffFinalGapped) {
    this.extensionDropoffFinalGapped = extensionDropoffFinalGapped;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean ungappedAlignmentsOnly;

  @JsonGetter(Flag.UngappedAlignmentsOnly)
  public Boolean getUngappedAlignmentsOnly() {
    return ungappedAlignmentsOnly;
  }

  @JsonSetter(Flag.UngappedAlignmentsOnly)
  public void setUngappedAlignmentsOnly(Boolean ungappedAlignmentsOnly) {
    this.ungappedAlignmentsOnly = ungappedAlignmentsOnly;
  }

  // ------------------------------------------------------------------------------------------ //

  private ThreadMode numThreads;

  @JsonGetter(Flag.NumThreads)
  public ThreadMode getNumThreads() {
    return numThreads;
  }

  @JsonSetter(Flag.NumThreads)
  public void setNumThreads(ThreadMode numThreads) {
    this.numThreads = numThreads;
  }

  // ------------------------------------------------------------------------------------------ //

  private MTMode mtMode;

  @JsonGetter(Flag.MTMode)
  public MTMode getMTMode() {
    return mtMode;
  }

  @JsonSetter(Flag.MTMode)
  public void setMTMode(MTMode mtMode) {
    this.mtMode = mtMode;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean useSmithWatermanTraceback;

  @JsonGetter(Flag.UseSmithWatermanTraceback)
  public Boolean getUseSmithWatermanTraceback() {
    return useSmithWatermanTraceback;
  }

  @JsonSetter(Flag.UseSmithWatermanTraceback)
  public void setUseSmithWatermanTraceback(Boolean useSmithWatermanTraceback) {
    this.useSmithWatermanTraceback = useSmithWatermanTraceback;
  }
}
