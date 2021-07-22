package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.field.*;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

public class BlastN extends BlastWithLists implements BlastQueryConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.BlastN;
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

  private BlastNTask task;

  public BlastNTask getTask() {
    return task;
  }

  public void setTask(BlastNTask task) {
    this.task = task;
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

  private Integer penalty;

  public Integer getPenalty() {
    return penalty;
  }

  public void setPenalty(Integer penalty) {
    this.penalty = penalty;
  }

  // ------------------------------------------------------------------------------------------ //

  private Long reward;

  public Long getReward() {
    return reward;
  }

  public void setReward(Long reward) {
    this.reward = reward;
  }

  // ------------------------------------------------------------------------------------------ //

  private Boolean useIndex;

  public Boolean getUseIndex() {
    return useIndex;
  }

  public void setUseIndex(Boolean useIndex) {
    this.useIndex = useIndex;
  }

  // ------------------------------------------------------------------------------------------ //

  private String indexName;

  public String getIndexName() {
    return indexName;
  }

  public void setIndexName(String indexName) {
    this.indexName = indexName;
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

  private Dust dust;

  public Dust getDust() {
    return dust;
  }

  public void setDust(Dust dust) {
    this.dust = dust;
  }

  // ------------------------------------------------------------------------------------------ //

  private String filteringDB;

  public String getFilteringDB() {
    return filteringDB;
  }

  public void setFilteringDB(String filteringDB) {
    this.filteringDB = filteringDB;
  }

  // ------------------------------------------------------------------------------------------ //

  private Integer windowMaskerTaxID;

  public Integer getWindowMaskerTaxID() {
    return windowMaskerTaxID;
  }

  public void setWindowMaskerTaxID(Integer windowMaskerTaxID) {
    this.windowMaskerTaxID = windowMaskerTaxID;
  }

  // ------------------------------------------------------------------------------------------ //

  private String windowMaskerDB;

  public String getWindowMaskerDB() {
    return windowMaskerDB;
  }

  public void setWindowMaskerDB(String windowMaskerDB) {
    this.windowMaskerDB = windowMaskerDB;
  }

  // ------------------------------------------------------------------------------------------ //

  private String dbSoftMask;

  public String getDBSoftMask() {
    return dbSoftMask;
  }

  public void setDBSoftMask(String dbSoftMask) {
    this.dbSoftMask = dbSoftMask;
  }

  // ------------------------------------------------------------------------------------------ //

  private String dbHardMask;

  public String getDBHardMask() {
    return dbHardMask;
  }

  public void setDBHardMask(String dbHardMask) {
    this.dbHardMask = dbHardMask;
  }

  // ------------------------------------------------------------------------------------------ //

  private Double percentIdentity;

  public Double getPercentIdentity() {
    return percentIdentity;
  }

  public void setPercentIdentity(Double percentIdentity) {
    this.percentIdentity = percentIdentity;
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

  private TemplateType templateType;

  public TemplateType getTemplateType() {
    return templateType;
  }

  public void setTemplateType(TemplateType templateType) {
    this.templateType = templateType;
  }

  // ------------------------------------------------------------------------------------------ //

  private TemplateLength templateLength;

  public TemplateLength getTemplateLength() {
    return templateLength;
  }

  public void setTemplateLength(TemplateLength templateLength) {
    this.templateLength = templateLength;
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

  private Boolean nonGreedy;

  public Boolean getNonGreedy() {
    return nonGreedy;
  }

  public void setNonGreedy(Boolean nonGreedy) {
    this.nonGreedy = nonGreedy;
  }

  // ------------------------------------------------------------------------------------------ //

  private Integer minRawGappedScore;

  public Integer getMinRawGappedScore() {
    return minRawGappedScore;
  }

  public void setMinRawGappedScore(Integer minRawGappedScore) {
    this.minRawGappedScore = minRawGappedScore;
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

  private Long offDiagonalRange;

  public Long getOffDiagonalRange() {
    return offDiagonalRange;
  }

  public void setOffDiagonalRange(Long offDiagonalRange) {
    this.offDiagonalRange = offDiagonalRange;
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

  @Override
  @JsonValue
  public JSONObjectEncoder toJSON() {
    var js = super.toJSON();

    js.encode(Key.Tool, getTool().getValue());
    js.encode(Flag.Strand, strand);
    js.encode(Flag.Task, task);
    js.encode(Flag.WordSize, wordSize);
    js.encode(Flag.GapOpen, gapOpen);
    js.encode(Flag.GapExtend, gapExtend);
    js.encode(Flag.Penalty, penalty);
    js.encode(Flag.Reward, reward);
    js.encode(Flag.UseIndex, useIndex);
    js.encode(Flag.IndexName, indexName);
    js.encode(Flag.SubjectFile, subjectFile);
    js.encode(Flag.SubjectLocation, subjectLocation);
    js.encode(Flag.Dust, dust);
    js.encode(Flag.FilteringDB, filteringDB);
    js.encode(Flag.WindowMaskerTaxID, windowMaskerTaxID);
    js.encode(Flag.WindowMaskerDB, windowMaskerDB);
    js.encode(Flag.DBSoftMask, dbSoftMask);
    js.encode(Flag.DBHardMask, dbHardMask);
    js.encode(Flag.PercentIdentity, percentIdentity);
    js.encode(Flag.CullingLimit, cullingLimit);
    js.encode(Flag.TemplateType, templateType);
    js.encode(Flag.TemplateLength, templateLength);
    js.encode(Flag.SumStats, sumStats);
    js.encode(Flag.ExtensionDropoffPrelimGapped, extensionDropoffPrelimGapped);
    js.encode(Flag.ExtensionDropoffFinalGapped, extensionDropoffFinalGapped);
    js.encode(Flag.NonGreedy, nonGreedy);
    js.encode(Flag.MinRawGappedScore, minRawGappedScore);
    js.encode(Flag.UngappedAlignmentsOnly, ungappedAlignmentsOnly);
    js.encode(Flag.OffDiagonalRange, offDiagonalRange);
    js.encode(Flag.NumThreads, numThreads);
    js.encode(Flag.BestHitOverhang, bestHitOverhang);
    js.encode(Flag.BestHitScoreEdge, bestHitScoreEdge);
    js.encode(Flag.SubjectBestHit, subjectBestHit);

    return js;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    BlastN blastN = (BlastN) o;
    return getStrand() == blastN.getStrand()
      && getTask() == blastN.getTask()
      && Objects.equals(getWordSize(), blastN.getWordSize())
      && Objects.equals(getGapOpen(), blastN.getGapOpen())
      && Objects.equals(getGapExtend(), blastN.getGapExtend())
      && Objects.equals(getPenalty(), blastN.getPenalty())
      && Objects.equals(getReward(), blastN.getReward())
      && Objects.equals(getUseIndex(), blastN.getUseIndex())
      && Objects.equals(getIndexName(), blastN.getIndexName())
      && Objects.equals(getSubjectFile(), blastN.getSubjectFile())
      && Objects.equals(getSubjectLocation(), blastN.getSubjectLocation())
      && Objects.equals(getDust(), blastN.getDust())
      && Objects.equals(getFilteringDB(), blastN.getFilteringDB())
      && Objects.equals(getWindowMaskerTaxID(), blastN.getWindowMaskerTaxID())
      && Objects.equals(getWindowMaskerDB(), blastN.getWindowMaskerDB())
      && Objects.equals(dbSoftMask, blastN.dbSoftMask)
      && Objects.equals(dbHardMask, blastN.dbHardMask)
      && Objects.equals(getPercentIdentity(), blastN.getPercentIdentity())
      && Objects.equals(getCullingLimit(), blastN.getCullingLimit())
      && getTemplateType() == blastN.getTemplateType()
      && getTemplateLength() == blastN.getTemplateLength()
      && Objects.equals(getSumStats(), blastN.getSumStats())
      && Objects.equals(
      getExtensionDropoffPrelimGapped(),
      blastN.getExtensionDropoffPrelimGapped()
    )
      && Objects.equals(
      getExtensionDropoffFinalGapped(),
      blastN.getExtensionDropoffFinalGapped()
    )
      && Objects.equals(getNonGreedy(), blastN.getNonGreedy())
      && Objects.equals(getMinRawGappedScore(), blastN.getMinRawGappedScore())
      && Objects.equals(getUngappedAlignmentsOnly(), blastN.getUngappedAlignmentsOnly())
      && Objects.equals(getOffDiagonalRange(), blastN.getOffDiagonalRange())
      && Objects.equals(getNumThreads(), blastN.getNumThreads())
      && Objects.equals(getBestHitOverhang(), blastN.getBestHitOverhang())
      && Objects.equals(getBestHitScoreEdge(), blastN.getBestHitScoreEdge())
      && Objects.equals(getSubjectBestHit(), blastN.getSubjectBestHit());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      super.hashCode(),
      getTool(),
      getStrand(),
      getTask(),
      getWordSize(),
      getGapOpen(),
      getGapExtend(),
      getPenalty(),
      getReward(),
      getUseIndex(),
      getIndexName(),
      getSubjectFile(),
      getSubjectLocation(),
      getDust(),
      getFilteringDB(),
      getWindowMaskerTaxID(),
      getWindowMaskerDB(),
      getDBSoftMask(),
      getDBHardMask(),
      getPercentIdentity(),
      getCullingLimit(),
      getTemplateType(),
      getTemplateLength(),
      getSumStats(),
      getExtensionDropoffPrelimGapped(),
      getExtensionDropoffFinalGapped(),
      getNonGreedy(),
      getMinRawGappedScore(),
      getUngappedAlignmentsOnly(),
      getOffDiagonalRange(),
      getNumThreads(),
      getBestHitOverhang(),
      getBestHitScoreEdge(),
      getSubjectBestHit()
    );
  }

  @Override
  public BlastN copy() {
    var out = new BlastN();
    copyInto(out);
    return out;
  }

  @JsonCreator
  public static BlastN fromJSON(JSONObjectDecoder js) {
    var out = new BlastN();
    out.copyInto(js);
    return out;
  }

  protected void copyInto(BlastN out) {
    super.copyInto(out);
    out.strand = strand;
    out.task = task;
    out.wordSize = wordSize;
    out.gapOpen = gapOpen;
    out.gapExtend = gapExtend;
    out.penalty = penalty;
    out.reward = reward;
    out.useIndex = useIndex;
    out.indexName = indexName;
    out.subjectFile = subjectFile;
    if (subjectLocation != null)
      out.subjectLocation = subjectLocation.copy();
    if (dust != null)
      out.dust = dust.copy();
    out.filteringDB = filteringDB;
    out.windowMaskerTaxID = windowMaskerTaxID;
    out.windowMaskerDB = windowMaskerDB;
    out.dbSoftMask = dbSoftMask;
    out.dbHardMask = dbHardMask;
    out.percentIdentity = percentIdentity;
    out.cullingLimit = cullingLimit;
    out.templateType = templateType;
    out.templateLength = templateLength;
    out.sumStats = sumStats;
    out.extensionDropoffPrelimGapped = extensionDropoffPrelimGapped;
    out.extensionDropoffFinalGapped = extensionDropoffFinalGapped;
    out.nonGreedy = nonGreedy;
    out.minRawGappedScore = minRawGappedScore;
    out.ungappedAlignmentsOnly = ungappedAlignmentsOnly;
    out.offDiagonalRange = offDiagonalRange;
    out.numThreads = numThreads;
    out.bestHitOverhang = bestHitOverhang;
    out.bestHitScoreEdge = bestHitScoreEdge;
    out.subjectBestHit = subjectBestHit;
  }

  @Override
  protected void copyInto(JSONObjectDecoder js) {
    super.copyInto(js);

    js.decode(Flag.Strand, this::setStrand, Strand::fromJSON);
    js.decode(Flag.Task, this::setTask, BlastNTask::fromJSON);
    js.decode(Flag.WordSize, this::setWordSize);
    js.decode(Flag.GapOpen, this::setGapOpen);
    js.decode(Flag.GapExtend, this::setGapExtend);
    js.decode(Flag.Penalty, this::setPenalty);
    js.decode(Flag.Reward, this::setReward);
    js.decode(Flag.UseIndex, this::setUseIndex);
    js.decode(Flag.IndexName, this::setIndexName);
    js.decode(Flag.SubjectFile, this::setSubjectFile);
    js.decode(Flag.SubjectLocation, this::setSubjectLocation, Location::fromJSON);
    js.decode(Flag.Dust, this::setDust, Dust::fromJSON);
    js.decode(Flag.FilteringDB, this::setFilteringDB);
    js.decode(Flag.WindowMaskerTaxID, this::setWindowMaskerTaxID);
    js.decode(Flag.WindowMaskerDB, this::setWindowMaskerDB);
    js.decode(Flag.DBSoftMask, this::setDBSoftMask);
    js.decode(Flag.DBHardMask, this::setDBHardMask);
    js.decode(Flag.PercentIdentity, this::setPercentIdentity);
    js.decode(Flag.CullingLimit, this::setCullingLimit);
    js.decode(Flag.TemplateType, this::setTemplateType, TemplateType::fromJSON);
    js.decode(Flag.TemplateLength, this::setTemplateLength, TemplateLength::fromJSON);
    js.decode(Flag.SumStats, this::setSumStats);
    js.decode(Flag.ExtensionDropoffPrelimGapped, this::setExtensionDropoffPrelimGapped);
    js.decode(Flag.ExtensionDropoffFinalGapped, this::setExtensionDropoffFinalGapped);
    js.decode(Flag.NonGreedy, this::setNonGreedy);
    js.decode(Flag.MinRawGappedScore, this::setMinRawGappedScore);
    js.decode(Flag.UngappedAlignmentsOnly, this::setUngappedAlignmentsOnly);
    js.decode(Flag.OffDiagonalRange, this::setOffDiagonalRange);
    js.decode(Flag.NumThreads, this::setNumThreads);
    js.decode(Flag.BestHitOverhang, this::setBestHitOverhang);
    js.decode(Flag.BestHitScoreEdge, this::setBestHitScoreEdge);
    js.decode(Flag.SubjectBestHit, this::setSubjectBestHit);
  }
}
