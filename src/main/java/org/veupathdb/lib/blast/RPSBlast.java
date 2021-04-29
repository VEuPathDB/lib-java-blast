package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.MTMode;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.field.ThreadMode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RPSBlast extends BlastBase implements BlastConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.RPSBlast;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double bestHitOverhang;

  @JsonGetter(Flag.BestHitOverhang)
  public Double getBestHitOverhang() {
    return bestHitOverhang;
  }

  @JsonSetter(Flag.BestHitOverhang)
  public void setBestHitOverhang(Double bestHitOverhang) {
    this.bestHitOverhang = bestHitOverhang;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double bestHitScoreEdge;

  @JsonGetter(Flag.BestHitScoreEdge)
  public Double getBestHitScoreEdge() {
    return bestHitScoreEdge;
  }

  @JsonSetter(Flag.BestHitScoreEdge)
  public void setBestHitScoreEdge(Double bestHitScoreEdge) {
    this.bestHitScoreEdge = bestHitScoreEdge;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean subjectBestHit;

  @JsonGetter(Flag.SubjectBestHit)
  public Boolean getSubjectBestHit() {
    return subjectBestHit;
  }

  @JsonSetter(Flag.SubjectBestHit)
  public void setSubjectBestHit(Boolean subjectBestHit) {
    this.subjectBestHit = subjectBestHit;
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

  // ------------------------------------------------------------------------------------------ //

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    RPSBlast rpsBlast = (RPSBlast) o;
    return Objects.equals(getBestHitOverhang(), rpsBlast.getBestHitOverhang())
      && Objects.equals(getBestHitScoreEdge(), rpsBlast.getBestHitScoreEdge())
      && Objects.equals(getSubjectBestHit(), rpsBlast.getSubjectBestHit())
      && Objects.equals(getCompBasedStats(), rpsBlast.getCompBasedStats())
      && Objects.equals(getSeg(), rpsBlast.getSeg())
      && Objects.equals(getSumStats(), rpsBlast.getSumStats())
      && Objects.equals(
      getExtensionDropoffPrelimGapped(),
      rpsBlast.getExtensionDropoffPrelimGapped()
    )
      && Objects.equals(
      getExtensionDropoffFinalGapped(),
      rpsBlast.getExtensionDropoffFinalGapped()
    )
      && getNumThreads() == rpsBlast.getNumThreads()
      && mtMode == rpsBlast.mtMode
      && Objects.equals(
      getUseSmithWatermanTraceback(),
      rpsBlast.getUseSmithWatermanTraceback()
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      super.hashCode(),
      getBestHitOverhang(),
      getBestHitScoreEdge(),
      getSubjectBestHit(),
      getCompBasedStats(),
      getSeg(),
      getSumStats(),
      getExtensionDropoffPrelimGapped(),
      getExtensionDropoffFinalGapped(),
      getNumThreads(),
      getMTMode(),
      getUseSmithWatermanTraceback()
    );
  }
}
