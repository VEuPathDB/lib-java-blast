package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.field.TBlastNTask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TBlastN extends BlastWithLists
{
  private TBlastNTask task;

  @JsonGetter(Flag.Task)
  public TBlastNTask getTask() {
    return task;
  }

  @JsonSetter(Flag.Task)
  public void setTask(TBlastNTask task) {
    this.task = task;
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

  private Short dbGenCode;

  @JsonGetter(Flag.DBGenCode)
  public Short getDBGenCode() {
    return dbGenCode;
  }

  @JsonSetter(Flag.DBGenCode)
  public void setDBGenCode(Short dbGenCode) {
    this.dbGenCode = dbGenCode;
  }

  // ------------------------------------------------------------------------------------------ //

  private Long maxIntronLength;

  @JsonGetter(Flag.MaxIntronLength)
  public Long getMaxIntronLength() {
    return maxIntronLength;
  }

  @JsonSetter(Flag.MaxIntronLength)
  public void setMaxIntronLength(Long maxIntronLength) {
    this.maxIntronLength = maxIntronLength;
  }

  // ------------------------------------------------------------------------------------------ //

  private String matrix;

  @JsonGetter(Flag.Matrix)
  public String getMatrix() {
    return matrix;
  }

  @JsonSetter(Flag.Matrix)
  public void setMatrix(String matrix) {
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

  private String dbSoftMask;

  @JsonGetter(Flag.DBSoftMask)
  public String getDBSoftMask() {
    return dbSoftMask;
  }

  @JsonSetter(Flag.DBSoftMask)
  public void setDBSoftMask(String dbSoftMask) {
    this.dbSoftMask = dbSoftMask;
  }

  // ------------------------------------------------------------------------------------------ //

  private String dbHardMask;

  @JsonGetter(Flag.DBHardMask)
  public String getDBHardMask() {
    return dbHardMask;
  }

  @JsonSetter(Flag.DBHardMask)
  public void setDBHardMask(String dbHardMask) {
    this.dbHardMask = dbHardMask;
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

  private String inPSSMFile;

  @JsonGetter(Flag.InPSSMFile)
  public String getInPSSMFile() {
    return inPSSMFile;
  }

  @JsonSetter(Flag.InPSSMFile)
  public void setInPSSMFile(String inPSSMFile) {
    this.inPSSMFile = inPSSMFile;
  }
}
