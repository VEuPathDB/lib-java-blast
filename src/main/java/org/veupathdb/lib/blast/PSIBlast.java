package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.ScoringMatrix;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

public class PSIBlast extends BlastWithIPGList implements BlastQueryConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.PSIBlast;
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

  private String inMSAFile;

  public String getInMSAFile() {
    return inMSAFile;
  }

  public void setInMSAFile(String inMSAFile) {
    this.inMSAFile = inMSAFile;
  }

  // ------------------------------------------------------------------------------------------ //

  private Long msaMasterIDX;

  public Long getMSAMasterIDX() {
    return msaMasterIDX;
  }

  public void setMSAMasterIDX(Long msaMasterIDX) {
    this.msaMasterIDX = msaMasterIDX;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean ignoreMSAMaster;

  public Boolean getIgnoreMSAMaster() {
    return ignoreMSAMaster;
  }

  public void setIgnoreMSAMaster(Boolean ignoreMSAMaster) {
    this.ignoreMSAMaster = ignoreMSAMaster;
  }

  // ------------------------------------------------------------------------------------------ //

  private String inPSSMFile;

  public String getInPSSMFile() {
    return inPSSMFile;
  }

  public void setInPSSMFile(String inPSSMFile) {
    this.inPSSMFile = inPSSMFile;
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

  private Double inclusionEThreshold;

  public Double getInclusionEThreshold() {
    return inclusionEThreshold;
  }

  public void setInclusionEThreshold(Double inclusionEThreshold) {
    this.inclusionEThreshold = inclusionEThreshold;
  }

  // ------------------------------------------------------------------------------------------ //

  private String phiPatternFile;

  public String getPhiPatternFile() {
    return phiPatternFile;
  }

  public void setPhiPatternFile(String phiPatternFile) {
    this.phiPatternFile = phiPatternFile;
  }

  // ------------------------------------------------------------------------------------------ //

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    PSIBlast psiBlast = (PSIBlast) o;
    return Objects.equals(getWordSize(), psiBlast.getWordSize())
      && Objects.equals(getGapOpen(), psiBlast.getGapOpen())
      && Objects.equals(getGapExtend(), psiBlast.getGapExtend())
      && getMatrix() == psiBlast.getMatrix()
      && Objects.equals(getThreshold(), psiBlast.getThreshold())
      && Objects.equals(getCompBasedStats(), psiBlast.getCompBasedStats())
      && Objects.equals(getSubjectFile(), psiBlast.getSubjectFile())
      && Objects.equals(getSubjectLocation(), psiBlast.getSubjectLocation())
      && Objects.equals(getSeg(), psiBlast.getSeg())
      && Objects.equals(getCullingLimit(), psiBlast.getCullingLimit())
      && Objects.equals(getSumStats(), psiBlast.getSumStats())
      && Objects.equals(
      getExtensionDropoffPrelimGapped(),
      psiBlast.getExtensionDropoffPrelimGapped()
    )
      && Objects.equals(
      getExtensionDropoffFinalGapped(),
      psiBlast.getExtensionDropoffFinalGapped()
    )
      && Objects.equals(getGapTrigger(), psiBlast.getGapTrigger())
      && Objects.equals(getNumThreads(), psiBlast.getNumThreads())
      && Objects.equals(
      getUseSmithWatermanTraceback(),
      psiBlast.getUseSmithWatermanTraceback()
    )
      && Objects.equals(getBestHitOverhang(), psiBlast.getBestHitOverhang())
      && Objects.equals(getBestHitScoreEdge(), psiBlast.getBestHitScoreEdge())
      && Objects.equals(getSubjectBestHit(), psiBlast.getSubjectBestHit())
      && Objects.equals(getNumIterations(), psiBlast.getNumIterations())
      && Objects.equals(getOutPSSMFile(), psiBlast.getOutPSSMFile())
      && Objects.equals(getOutASCIIPSSMFile(), psiBlast.getOutASCIIPSSMFile())
      && Objects.equals(getSavePSSMAfterLastRound(), psiBlast.getSavePSSMAfterLastRound())
      && Objects.equals(getSaveEachPSSM(), psiBlast.getSaveEachPSSM())
      && Objects.equals(getInMSAFile(), psiBlast.getInMSAFile())
      && Objects.equals(msaMasterIDX, psiBlast.msaMasterIDX)
      && Objects.equals(getIgnoreMSAMaster(), psiBlast.getIgnoreMSAMaster())
      && Objects.equals(getInPSSMFile(), psiBlast.getInPSSMFile())
      && Objects.equals(getPseudocount(), psiBlast.getPseudocount())
      && Objects.equals(getInclusionEThreshold(), psiBlast.getInclusionEThreshold())
      && Objects.equals(getPhiPatternFile(), psiBlast.getPhiPatternFile());
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
      getInMSAFile(),
      getMSAMasterIDX(),
      getIgnoreMSAMaster(),
      getInPSSMFile(),
      getPseudocount(),
      getInclusionEThreshold(),
      getPhiPatternFile()
    );
  }

  @Override
  public PSIBlast copy() {
    var out = new PSIBlast();
    copyInto(out);
    return out;
  }

  @Override
  @JsonValue
  public JSONObjectEncoder toJSON() {
    var js = super.toJSON();

    js.encode(Key.Tool, getTool().getValue());
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
    js.encode(Flag.InMSAFile, inMSAFile);
    js.encode(Flag.MSAMasterIDX, msaMasterIDX);
    js.encode(Flag.IgnoreMSAMaster, ignoreMSAMaster);
    js.encode(Flag.InPSSMFile, inPSSMFile);
    js.encode(Flag.Pseudocount, pseudocount);
    js.encode(Flag.InclusionEThreshold, inclusionEThreshold);
    js.encode(Flag.PhiPatternFile, phiPatternFile);

    return js;
  }

  @JsonCreator
  public static PSIBlast fromJSON(JSONObjectDecoder js) {
    var out = new PSIBlast();
    out.copyInto(js);
    return out;
  }

  protected void copyInto(PSIBlast out) {
    super.copyInto(out);
    out.wordSize       = wordSize;
    out.gapOpen        = gapOpen;
    out.gapExtend      = gapExtend;
    out.matrix         = matrix;
    out.threshold      = threshold;
    out.compBasedStats = compBasedStats;
    out.subjectFile    = subjectFile;
    if (subjectLocation != null)
      out.subjectLocation = subjectLocation.copy();
    if (seg != null)
      out.seg = seg.copy();
    out.cullingLimit                 = cullingLimit;
    out.sumStats                     = sumStats;
    out.extensionDropoffPrelimGapped = extensionDropoffPrelimGapped;
    out.extensionDropoffFinalGapped  = extensionDropoffFinalGapped;
    out.gapTrigger                   = gapTrigger;
    out.numThreads                   = numThreads;
    out.useSmithWatermanTraceback    = useSmithWatermanTraceback;
    out.bestHitOverhang              = bestHitOverhang;
    out.bestHitScoreEdge             = bestHitScoreEdge;
    out.subjectBestHit               = subjectBestHit;
    out.numIterations                = numIterations;
    out.outPSSMFile                  = outPSSMFile;
    out.outASCIIPSSMFile             = outASCIIPSSMFile;
    out.savePSSMAfterLastRound       = savePSSMAfterLastRound;
    out.saveEachPSSM                 = saveEachPSSM;
    out.inMSAFile                    = inMSAFile;
    out.msaMasterIDX                 = msaMasterIDX;
    out.ignoreMSAMaster              = ignoreMSAMaster;
    out.inPSSMFile                   = inPSSMFile;
    out.pseudocount                  = pseudocount;
    out.inclusionEThreshold          = inclusionEThreshold;
    out.phiPatternFile               = phiPatternFile;
  }

  @Override
  protected void copyInto(JSONObjectDecoder js) {
    super.copyInto(js);

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
    js.decode(Flag.InMSAFile, this::setInMSAFile);
    js.decode(Flag.MSAMasterIDX, this::setMSAMasterIDX);
    js.decode(Flag.IgnoreMSAMaster, this::setIgnoreMSAMaster);
    js.decode(Flag.InPSSMFile, this::setInPSSMFile);
    js.decode(Flag.Pseudocount, this::setPseudocount);
    js.decode(Flag.InclusionEThreshold, this::setInclusionEThreshold);
    js.decode(Flag.PhiPatternFile, this::setPhiPatternFile);
  }
}
