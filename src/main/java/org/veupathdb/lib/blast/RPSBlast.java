package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.field.MTMode;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.field.ThreadMode;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

import java.util.Objects;

public class RPSBlast extends BlastBase implements BlastQueryConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.RPSBlast;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double bestHitOverhang;

  public Double getBestHitOverhang() {
    return bestHitOverhang;
  }

  public void setBestHitOverhang(Double bestHitOverhang) {
    this.bestHitOverhang = bestHitOverhang;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double bestHitScoreEdge;

  public Double getBestHitScoreEdge() {
    return bestHitScoreEdge;
  }

  public void setBestHitScoreEdge(Double bestHitScoreEdge) {
    this.bestHitScoreEdge = bestHitScoreEdge;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean subjectBestHit;

  public Boolean getSubjectBestHit() {
    return subjectBestHit;
  }

  public void setSubjectBestHit(Boolean subjectBestHit) {
    this.subjectBestHit = subjectBestHit;
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
      getTool(),
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

  @Override
  public JSONObjectEncoder toJSON(boolean includeTool) {
    var js = super.toJSON(includeTool);

    js.encode(Flag.BestHitOverhang, bestHitOverhang);
    js.encode(Flag.BestHitScoreEdge, bestHitScoreEdge);
    js.encode(Flag.SubjectBestHit, subjectBestHit);
    js.encode(Flag.CompBasedStats, compBasedStats);
    js.encode(Flag.Seg, seg);
    js.encode(Flag.SumStats, sumStats);
    js.encode(Flag.ExtensionDropoffPrelimGapped, extensionDropoffPrelimGapped);
    js.encode(Flag.ExtensionDropoffFinalGapped, extensionDropoffFinalGapped);
    js.encode(Flag.NumThreads, numThreads);
    js.encode(Flag.MTMode, mtMode);
    js.encode(Flag.UseSmithWatermanTraceback, useSmithWatermanTraceback);

    return js;
  }

  @Override
  public void decodeJSON(JSONObjectDecoder js) {
    super.decodeJSON(js);

    js.decode(Flag.BestHitOverhang, this::setBestHitOverhang);
    js.decode(Flag.BestHitScoreEdge, this::setBestHitScoreEdge);
    js.decode(Flag.SubjectBestHit, this::setSubjectBestHit);
    js.decode(Flag.CompBasedStats, this::setCompBasedStats);
    js.decode(Flag.Seg, this::setSeg, Seg::fromJSON);
    js.decode(Flag.SumStats, this::setSumStats);
    js.decode(Flag.ExtensionDropoffPrelimGapped, this::setExtensionDropoffPrelimGapped);
    js.decode(Flag.ExtensionDropoffFinalGapped, this::setExtensionDropoffFinalGapped);
    js.decode(Flag.NumThreads, this::setNumThreads, ThreadMode::fromJSON);
    js.decode(Flag.MTMode, this::setMTMode, MTMode::fromJSON);
    js.decode(Flag.UseSmithWatermanTraceback, this::setUseSmithWatermanTraceback);
  }

  @JsonCreator
  public static RPSBlast fromJSON(JSONObjectDecoder js) {
    var out = new RPSBlast();
    out.decodeJSON(js);
    return out;
  }
}
