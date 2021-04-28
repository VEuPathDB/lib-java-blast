package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlastN extends ListBlast
{
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

  private BlastNTask task;

  @JsonGetter(Flag.Task)
  public BlastNTask getTask() {
    return task;
  }

  @JsonSetter(Flag.Task)
  public void setTask(BlastNTask task) {
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

  private Integer penalty;

  @JsonGetter(Flag.Penalty)
  public Integer getPenalty() {
    return penalty;
  }

  @JsonSetter(Flag.Penalty)
  public void setPenalty(Integer penalty) {
    this.penalty = penalty;
  }

  // ------------------------------------------------------------------------------------------ //

  private Long reward;

  @JsonGetter(Flag.Reward)
  public Long getReward() {
    return reward;
  }

  @JsonSetter(Flag.Reward)
  public void setReward(Long reward) {
    this.reward = reward;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean useIndex;

  @JsonGetter(Flag.UseIndex)
  public Boolean getUseIndex() {
    return useIndex;
  }

  @JsonSetter(Flag.UseIndex)
  public void setUseIndex(Boolean useIndex) {
    this.useIndex = useIndex;
  }

  // ------------------------------------------------------------------------------------------ //

  private String indexName;

  @JsonGetter(Flag.IndexName)
  public String getIndexName() {
    return indexName;
  }

  @JsonSetter(Flag.IndexName)
  public void setIndexName(String indexName) {
    this.indexName = indexName;
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

  private Dust dust;

  @JsonGetter(Flag.Dust)
  public Dust getDust() {
    return dust;
  }

  @JsonSetter(Flag.Dust)
  public void setDust(Dust dust) {
    this.dust = dust;
  }

  // ------------------------------------------------------------------------------------------ //

  private String filteringDB;

  @JsonGetter(Flag.FilteringDB)
  public String getFilteringDB() {
    return filteringDB;
  }

  @JsonSetter(Flag.FilteringDB)
  public void setFilteringDB(String filteringDB) {
    this.filteringDB = filteringDB;
  }

  // ------------------------------------------------------------------------------------------ //

  private Integer windowMaskerTaxID;

  @JsonGetter(Flag.WindowMaskerTaxID)
  public Integer getWindowMaskerTaxID() {
    return windowMaskerTaxID;
  }

  @JsonSetter(Flag.WindowMaskerTaxID)
  public void setWindowMaskerTaxID(Integer windowMaskerTaxID) {
    this.windowMaskerTaxID = windowMaskerTaxID;
  }

  // ------------------------------------------------------------------------------------------ //

  private String windowMaskerDB;

  @JsonGetter(Flag.WindowMaskerDB)
  public String getWindowMaskerDB() {
    return windowMaskerDB;
  }

  @JsonSetter(Flag.WindowMaskerDB)
  public void setWindowMaskerDB(String windowMaskerDB) {
    this.windowMaskerDB = windowMaskerDB;
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

  private Double percentIdentity;

  @JsonGetter(Flag.PercentIdentity)
  public Double getPercentIdentity() {
    return percentIdentity;
  }

  @JsonSetter(Flag.PercentIdentity)
  public void setPercentIdentity(Double percentIdentity) {
    this.percentIdentity = percentIdentity;
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

  private TemplateType templateType;

  @JsonGetter(Flag.TemplateType)
  public TemplateType getTemplateType() {
    return templateType;
  }

  @JsonSetter(Flag.TemplateType)
  public void setTemplateType(TemplateType templateType) {
    this.templateType = templateType;
  }

  // ------------------------------------------------------------------------------------------ //

  private TemplateLength templateLength;

  @JsonGetter(Flag.TemplateLength)
  public TemplateLength getTemplateLength() {
    return templateLength;
  }

  @JsonSetter(Flag.TemplateLength)
  public void setTemplateLength(TemplateLength templateLength) {
    this.templateLength = templateLength;
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

  private Boolean nonGreedy;

  @JsonGetter(Flag.NonGreedy)
  public Boolean getNonGreedy() {
    return nonGreedy;
  }

  @JsonSetter(Flag.NonGreedy)
  public void setNonGreedy(Boolean nonGreedy) {
    this.nonGreedy = nonGreedy;
  }

  // ------------------------------------------------------------------------------------------ //

  private Integer minRawGappedScore;

  @JsonGetter(Flag.MinRawGappedScore)
  public Integer getMinRawGappedScore() {
    return minRawGappedScore;
  }

  @JsonSetter(Flag.MinRawGappedScore)
  public void setMinRawGappedScore(Integer minRawGappedScore) {
    this.minRawGappedScore = minRawGappedScore;
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

  private Long offDiagonalRange;

  @JsonGetter(Flag.OffDiagonalRange)
  public Long getOffDiagonalRange() {
    return offDiagonalRange;
  }

  @JsonSetter(Flag.OffDiagonalRange)
  public void setOffDiagonalRange(Long offDiagonalRange) {
    this.offDiagonalRange = offDiagonalRange;
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
}
