package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.ScoringMatrix;
import org.veupathdb.lib.blast.field.Seg;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeltaBlast extends BlastWithLists implements BlastConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.DeltaBlast;
  }

  // ------------------------------------------------------------------------------------------ //

  private Long wordSize;

  @JsonGetter(Flag.WordSize)
  public Long getWordSize() {
    return wordSize;
  }

  @JsonSetter(Flag.WordSize)
  public void setWordSize(Long wordSize) {
    this.wordSize = wordSize;
  }

  // ------------------------------------------------------------------------------------------ //

  private Integer gapOpen;

  @JsonGetter(Flag.GapOpen)
  public Integer getGapOpen() {
    return gapOpen;
  }

  @JsonSetter(Flag.GapOpen)
  public void setGapOpen(Integer gapOpen) {
    this.gapOpen = gapOpen;
  }

  // ------------------------------------------------------------------------------------------ //

  private Integer gapExtend;

  @JsonGetter(Flag.GapExtend)
  public Integer getGapExtend() {
    return gapExtend;
  }

  @JsonSetter(Flag.GapExtend)
  public void setGapExtend(Integer gapExtend) {
    this.gapExtend = gapExtend;
  }

  // ------------------------------------------------------------------------------------------ //

  private ScoringMatrix matrix;

  @JsonGetter(Flag.Matrix)
  public ScoringMatrix getMatrix() {
    return matrix;
  }

  @JsonSetter(Flag.Matrix)
  public void setMatrix(ScoringMatrix matrix) {
    this.matrix = matrix;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double threshold;

  @JsonGetter(Flag.Threshold)
  public Double getThreshold() {
    return threshold;
  }

  @JsonSetter(Flag.Threshold)
  public void setThreshold(Double threshold) {
    this.threshold = threshold;
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

  private String subjectFile;

  @JsonGetter(Flag.SubjectFile)
  public String getSubjectFile() {
    return subjectFile;
  }

  @JsonSetter(Flag.SubjectFile)
  public void setSubjectFile(String subjectFile) {
    this.subjectFile = subjectFile;
  }

  // ------------------------------------------------------------------------------------------ //

  private Location subjectLocation;

  @JsonGetter(Flag.SubjectLocation)
  public Location getSubjectLocation() {
    return subjectLocation;
  }

  @JsonSetter(Flag.SubjectLocation)
  public void setSubjectLocation(Location subjectLocation) {
    this.subjectLocation = subjectLocation;
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

  private Long cullingLimit;

  @JsonGetter(Flag.CullingLimit)
  public Long getCullingLimit() {
    return cullingLimit;
  }

  @JsonSetter(Flag.CullingLimit)
  public void setCullingLimit(Long cullingLimit) {
    this.cullingLimit = cullingLimit;
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

  private Double gapTrigger;

  @JsonGetter(Flag.GapTrigger)
  public Double getGapTrigger() {
    return gapTrigger;
  }

  @JsonSetter(Flag.GapTrigger)
  public void setGapTrigger(Double gapTrigger) {
    this.gapTrigger = gapTrigger;
  }

  // ------------------------------------------------------------------------------------------ //

  private Short numThreads;

  @JsonGetter(Flag.NumThreads)
  public Short getNumThreads() {
    return numThreads;
  }

  @JsonSetter(Flag.NumThreads)
  public void setNumThreads(Short numThreads) {
    this.numThreads = numThreads;
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

  private Long numIterations;

  @JsonGetter(Flag.NumIterations)
  public Long getNumIterations() {
    return numIterations;
  }

  @JsonSetter(Flag.NumIterations)
  public void setNumIterations(Long numIterations) {
    this.numIterations = numIterations;
  }

  // ------------------------------------------------------------------------------------------ //

  private String outPSSMFile;

  @JsonGetter(Flag.OutPSSMFile)
  public String getOutPSSMFile() {
    return outPSSMFile;
  }

  @JsonSetter(Flag.OutPSSMFile)
  public void setOutPSSMFile(String outPSSMFile) {
    this.outPSSMFile = outPSSMFile;
  }

  // ------------------------------------------------------------------------------------------ //

  private String outASCIIPSSMFile;

  @JsonGetter(Flag.OutASCIIPSSMFile)
  public String getOutASCIIPSSMFile() {
    return outASCIIPSSMFile;
  }

  @JsonSetter(Flag.OutASCIIPSSMFile)
  public void setOutASCIIPSSMFile(String outASCIIPSSMFile) {
    this.outASCIIPSSMFile = outASCIIPSSMFile;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean savePSSMAfterLastRound;

  @JsonGetter(Flag.SavePSSMAfterLastRound)
  public Boolean getSavePSSMAfterLastRound() {
    return savePSSMAfterLastRound;
  }

  @JsonSetter(Flag.SavePSSMAfterLastRound)
  public void setSavePSSMAfterLastRound(Boolean savePSSMAfterLastRound) {
    this.savePSSMAfterLastRound = savePSSMAfterLastRound;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean saveEachPSSM;

  @JsonGetter(Flag.SaveEachPSSM)
  public Boolean getSaveEachPSSM() {
    return saveEachPSSM;
  }

  @JsonSetter(Flag.SaveEachPSSM)
  public void setSaveEachPSSM(Boolean saveEachPSSM) {
    this.saveEachPSSM = saveEachPSSM;
  }

  // ------------------------------------------------------------------------------------------ //

  private Integer pseudocount;

  @JsonGetter(Flag.Pseudocount)
  public Integer getPseudocount() {
    return pseudocount;
  }

  @JsonSetter(Flag.Pseudocount)
  public void setPseudocount(Integer pseudocount) {
    this.pseudocount = pseudocount;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double domainInclusionEThreshold;

  @JsonGetter(Flag.DomainInclusionEThreshold)
  public Double getDomainInclusionEThreshold() {
    return domainInclusionEThreshold;
  }

  @JsonSetter(Flag.DomainInclusionEThreshold)
  public void setDomainInclusionEThreshold(Double domainInclusionEThreshold) {
    this.domainInclusionEThreshold = domainInclusionEThreshold;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double inclusionEThreshold;

  @JsonGetter(Flag.InclusionEThreshold)
  public Double getInclusionEThreshold() {
    return inclusionEThreshold;
  }

  @JsonSetter(Flag.InclusionEThreshold)
  public void setInclusionEThreshold(Double inclusionEThreshold) {
    this.inclusionEThreshold = inclusionEThreshold;
  }

  // ------------------------------------------------------------------------------------------ //

  private String rpsDBFile;

  @JsonGetter(Flag.RPSDBFile)
  public String getRPSDBFile() {
    return rpsDBFile;
  }

  @JsonSetter(Flag.RPSDBFile)
  public void setRPSDBFile(String rpsDBFile) {
    this.rpsDBFile = rpsDBFile;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean showDomainHits;

  @JsonGetter(Flag.ShowDomainHits)
  public Boolean getShowDomainHits() {
    return showDomainHits;
  }

  @JsonSetter(Flag.ShowDomainHits)
  public void setShowDomainHits(Boolean showDomainHits) {
    this.showDomainHits = showDomainHits;
  }

  // ------------------------------------------------------------------------------------------ //

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    DeltaBlast that = (DeltaBlast) o;
    return Objects.equals(getWordSize(), that.getWordSize())
      && Objects.equals(
      getGapOpen(),
      that.getGapOpen()
    )
      && Objects.equals(getGapExtend(), that.getGapExtend())
      && getMatrix() == that.getMatrix()
      && Objects.equals(getThreshold(), that.getThreshold())
      && Objects.equals(getCompBasedStats(), that.getCompBasedStats())
      && Objects.equals(getSubjectFile(), that.getSubjectFile())
      && Objects.equals(getSubjectLocation(), that.getSubjectLocation())
      && Objects.equals(getSeg(), that.getSeg())
      && Objects.equals(getCullingLimit(), that.getCullingLimit())
      && Objects.equals(getSumStats(), that.getSumStats())
      && Objects.equals(
      getExtensionDropoffPrelimGapped(),
      that.getExtensionDropoffPrelimGapped()
    )
      && Objects.equals(
      getExtensionDropoffFinalGapped(),
      that.getExtensionDropoffFinalGapped()
    )
      && Objects.equals(getGapTrigger(), that.getGapTrigger())
      && Objects.equals(getNumThreads(), that.getNumThreads())
      && Objects.equals(getUseSmithWatermanTraceback(), that.getUseSmithWatermanTraceback())
      && Objects.equals(getBestHitOverhang(), that.getBestHitOverhang())
      && Objects.equals(getBestHitScoreEdge(), that.getBestHitScoreEdge())
      && Objects.equals(getSubjectBestHit(), that.getSubjectBestHit())
      && Objects.equals(getNumIterations(), that.getNumIterations())
      && Objects.equals(getOutPSSMFile(), that.getOutPSSMFile())
      && Objects.equals(getOutASCIIPSSMFile(), that.getOutASCIIPSSMFile())
      && Objects.equals(getSavePSSMAfterLastRound(), that.getSavePSSMAfterLastRound())
      && Objects.equals(getSaveEachPSSM(), that.getSaveEachPSSM())
      && Objects.equals(getPseudocount(), that.getPseudocount())
      && Objects.equals(getDomainInclusionEThreshold(), that.getDomainInclusionEThreshold())
      && Objects.equals(getInclusionEThreshold(), that.getInclusionEThreshold())
      && Objects.equals(rpsDBFile, that.rpsDBFile)
      && Objects.equals(getShowDomainHits(), that.getShowDomainHits());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      super.hashCode(),
      getWordSize(),
      getGapOpen(),
      getGapExtend(),
      getMatrix(),
      getThreshold(),
      getCompBasedStats(),
      getSubjectFile(),
      getSubjectLocation(),
      getSeg(),
      getCullingLimit(),
      getSumStats(),
      getExtensionDropoffPrelimGapped(),
      getExtensionDropoffFinalGapped(),
      getGapTrigger(),
      getNumThreads(),
      getUseSmithWatermanTraceback(),
      getBestHitOverhang(),
      getBestHitScoreEdge(),
      getSubjectBestHit(),
      getNumIterations(),
      getOutPSSMFile(),
      getOutASCIIPSSMFile(),
      getSavePSSMAfterLastRound(),
      getSaveEachPSSM(),
      getPseudocount(),
      getDomainInclusionEThreshold(),
      getInclusionEThreshold(),
      getRPSDBFile(),
      getShowDomainHits()
    );
  }
}
