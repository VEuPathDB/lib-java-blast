package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.ScoringMatrix;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

import java.util.Objects;

public class DeltaBlast extends BlastWithLists implements BlastQueryConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.DeltaBlast;
  }

  // ------------------------------------------------------------------------------------------ //

  private Long wordSize;

  public Long getWordSize() {
    return wordSize;
  }

  public void setWordSize(Long wordSize) {
    this.wordSize = wordSize;
  }

  // ------------------------------------------------------------------------------------------ //

  private Integer gapOpen;

  public Integer getGapOpen() {
    return gapOpen;
  }

  public void setGapOpen(Integer gapOpen) {
    this.gapOpen = gapOpen;
  }

  // ------------------------------------------------------------------------------------------ //

  private Integer gapExtend;

  public Integer getGapExtend() {
    return gapExtend;
  }

  public void setGapExtend(Integer gapExtend) {
    this.gapExtend = gapExtend;
  }

  // ------------------------------------------------------------------------------------------ //

  private ScoringMatrix matrix;

  public ScoringMatrix getMatrix() {
    return matrix;
  }

  public void setMatrix(ScoringMatrix matrix) {
    this.matrix = matrix;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double threshold;

  public Double getThreshold() {
    return threshold;
  }

  public void setThreshold(Double threshold) {
    this.threshold = threshold;
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

  private String subjectFile;

  public String getSubjectFile() {
    return subjectFile;
  }

  public void setSubjectFile(String subjectFile) {
    this.subjectFile = subjectFile;
  }

  // ------------------------------------------------------------------------------------------ //

  private Location subjectLocation;

  public Location getSubjectLocation() {
    return subjectLocation;
  }

  public void setSubjectLocation(Location subjectLocation) {
    this.subjectLocation = subjectLocation;
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

  private Long cullingLimit;

  public Long getCullingLimit() {
    return cullingLimit;
  }

  public void setCullingLimit(Long cullingLimit) {
    this.cullingLimit = cullingLimit;
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

  private Double gapTrigger;

  public Double getGapTrigger() {
    return gapTrigger;
  }

  public void setGapTrigger(Double gapTrigger) {
    this.gapTrigger = gapTrigger;
  }

  // ------------------------------------------------------------------------------------------ //

  private Short numThreads;

  public Short getNumThreads() {
    return numThreads;
  }

  public void setNumThreads(Short numThreads) {
    this.numThreads = numThreads;
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

  private Long numIterations;

  public Long getNumIterations() {
    return numIterations;
  }

  public void setNumIterations(Long numIterations) {
    this.numIterations = numIterations;
  }

  // ------------------------------------------------------------------------------------------ //

  private String outPSSMFile;

  public String getOutPSSMFile() {
    return outPSSMFile;
  }

  public void setOutPSSMFile(String outPSSMFile) {
    this.outPSSMFile = outPSSMFile;
  }

  // ------------------------------------------------------------------------------------------ //

  private String outASCIIPSSMFile;

  public String getOutASCIIPSSMFile() {
    return outASCIIPSSMFile;
  }

  public void setOutASCIIPSSMFile(String outASCIIPSSMFile) {
    this.outASCIIPSSMFile = outASCIIPSSMFile;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean savePSSMAfterLastRound;

  public Boolean getSavePSSMAfterLastRound() {
    return savePSSMAfterLastRound;
  }

  public void setSavePSSMAfterLastRound(Boolean savePSSMAfterLastRound) {
    this.savePSSMAfterLastRound = savePSSMAfterLastRound;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean saveEachPSSM;

  public Boolean getSaveEachPSSM() {
    return saveEachPSSM;
  }

  public void setSaveEachPSSM(Boolean saveEachPSSM) {
    this.saveEachPSSM = saveEachPSSM;
  }

  // ------------------------------------------------------------------------------------------ //

  private Integer pseudocount;

  public Integer getPseudocount() {
    return pseudocount;
  }

  public void setPseudocount(Integer pseudocount) {
    this.pseudocount = pseudocount;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double domainInclusionEThreshold;

  public Double getDomainInclusionEThreshold() {
    return domainInclusionEThreshold;
  }

  public void setDomainInclusionEThreshold(Double domainInclusionEThreshold) {
    this.domainInclusionEThreshold = domainInclusionEThreshold;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double inclusionEThreshold;

  public Double getInclusionEThreshold() {
    return inclusionEThreshold;
  }

  public void setInclusionEThreshold(Double inclusionEThreshold) {
    this.inclusionEThreshold = inclusionEThreshold;
  }

  // ------------------------------------------------------------------------------------------ //

  private String rpsDBFile;

  public String getRPSDBFile() {
    return rpsDBFile;
  }

  public void setRPSDBFile(String rpsDBFile) {
    this.rpsDBFile = rpsDBFile;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean showDomainHits;

  public Boolean getShowDomainHits() {
    return showDomainHits;
  }

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
      getTool(),
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

  @Override
  public JSONObjectEncoder toJSON(boolean includeTool) {
    var js = super.toJSON(includeTool);

    js.encode(Flag.WordSize, wordSize);
    js.encode(Flag.GapOpen, gapOpen);
    js.encode(Flag.GapExtend, gapExtend);
    js.encode(Flag.Matrix, matrix);
    js.encode(Flag.Threshold, threshold);
    js.encode(Flag.CompBasedStats, compBasedStats);
    js.encode(Flag.SubjectFile, subjectFile);
    js.encode(Flag.SubjectLocation, subjectLocation);
    js.encode(Flag.Seg, seg);
    js.encode(Flag.CullingLimit, cullingLimit);
    js.encode(Flag.SumStats, sumStats);
    js.encode(Flag.ExtensionDropoffPrelimGapped, extensionDropoffPrelimGapped);
    js.encode(Flag.ExtensionDropoffFinalGapped, extensionDropoffFinalGapped);
    js.encode(Flag.GapTrigger, gapTrigger);
    js.encode(Flag.NumThreads, numThreads);
    js.encode(Flag.UseSmithWatermanTraceback, useSmithWatermanTraceback);
    js.encode(Flag.BestHitOverhang, bestHitOverhang);
    js.encode(Flag.BestHitScoreEdge, bestHitScoreEdge);
    js.encode(Flag.SubjectBestHit, subjectBestHit);
    js.encode(Flag.NumIterations, numIterations);
    js.encode(Flag.OutPSSMFile, outPSSMFile);
    js.encode(Flag.OutASCIIPSSMFile, outASCIIPSSMFile);
    js.encode(Flag.SavePSSMAfterLastRound, savePSSMAfterLastRound);
    js.encode(Flag.SaveEachPSSM, saveEachPSSM);
    js.encode(Flag.Pseudocount, pseudocount);
    js.encode(Flag.DomainInclusionEThreshold, domainInclusionEThreshold);
    js.encode(Flag.InclusionEThreshold, inclusionEThreshold);
    js.encode(Flag.RPSDBFile, rpsDBFile);
    js.encode(Flag.ShowDomainHits, showDomainHits);

    return js;
  }

  @Override
  public void decodeJSON(JSONObjectDecoder js) {
    super.decodeJSON(js);

    js.decode(Flag.WordSize, this::setWordSize);
    js.decode(Flag.GapOpen, this::setGapOpen);
    js.decode(Flag.GapExtend, this::setGapExtend);
    js.decode(Flag.Matrix, this::setMatrix, ScoringMatrix::fromJSON);
    js.decode(Flag.Threshold, this::setThreshold);
    js.decode(Flag.CompBasedStats, this::setCompBasedStats);
    js.decode(Flag.SubjectFile, this::setSubjectFile);
    js.decode(Flag.SubjectLocation, this::setSubjectLocation, Location::fromJSON);
    js.decode(Flag.Seg, this::setSeg, Seg::fromJSON);
    js.decode(Flag.CullingLimit, this::setCullingLimit);
    js.decode(Flag.SumStats, this::setSumStats);
    js.decode(Flag.ExtensionDropoffPrelimGapped, this::setExtensionDropoffPrelimGapped);
    js.decode(Flag.ExtensionDropoffFinalGapped, this::setExtensionDropoffFinalGapped);
    js.decode(Flag.GapTrigger, this::setGapTrigger);
    js.decode(Flag.NumThreads, this::setNumThreads);
    js.decode(Flag.UseSmithWatermanTraceback, this::setUseSmithWatermanTraceback);
    js.decode(Flag.BestHitOverhang, this::setBestHitOverhang);
    js.decode(Flag.BestHitScoreEdge, this::setBestHitScoreEdge);
    js.decode(Flag.SubjectBestHit, this::setSubjectBestHit);
    js.decode(Flag.NumIterations, this::setNumIterations);
    js.decode(Flag.OutPSSMFile, this::setOutPSSMFile);
    js.decode(Flag.OutASCIIPSSMFile, this::setOutASCIIPSSMFile);
    js.decode(Flag.SavePSSMAfterLastRound, this::setSavePSSMAfterLastRound);
    js.decode(Flag.SaveEachPSSM, this::setSaveEachPSSM);
    js.decode(Flag.Pseudocount, this::setPseudocount);
    js.decode(Flag.DomainInclusionEThreshold, this::setDomainInclusionEThreshold);
    js.decode(Flag.InclusionEThreshold, this::setInclusionEThreshold);
    js.decode(Flag.RPSDBFile, this::setRPSDBFile);
    js.decode(Flag.ShowDomainHits, this::setShowDomainHits);
  }

  @JsonCreator
  public static DeltaBlast fromJSON(JSONObjectDecoder js) {
    var out = new DeltaBlast();
    out.decodeJSON(js);
    return out;
  }
}
