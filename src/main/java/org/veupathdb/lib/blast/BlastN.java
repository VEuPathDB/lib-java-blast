package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.*;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

import java.util.Objects;

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
  public JSONObjectEncoder toJSON(boolean includeTool) {
    final var out = super.toJSON(includeTool);

    out.encode(Flag.Strand, getStrand());
    out.encode(Flag.Task, getTask());
    out.encode(Flag.WordSize, getWordSize());
    out.encode(Flag.GapOpen, getGapOpen());
    out.encode(Flag.GapExtend, getGapExtend());
    out.encode(Flag.Penalty, getPenalty());
    out.encode(Flag.Reward, getReward());
    out.encode(Flag.UseIndex, getUseIndex());
    out.encode(Flag.IndexName, getIndexName());
    out.encode(Flag.SubjectFile, getSubjectFile());
    out.encode(Flag.SubjectLocation, getSubjectLocation());
    out.encode(Flag.Dust, getDust());
    out.encode(Flag.FilteringDB, getFilteringDB());
    out.encode(Flag.WindowMaskerTaxID, getWindowMaskerTaxID());
    out.encode(Flag.WindowMaskerDB, getWindowMaskerDB());
    out.encode(Flag.DBSoftMask, getDBSoftMask());
    out.encode(Flag.DBHardMask, getDBHardMask());
    out.encode(Flag.PercentIdentity, getPercentIdentity());
    out.encode(Flag.CullingLimit, getCullingLimit());
    out.encode(Flag.TemplateType, getTemplateType());
    out.encode(Flag.TemplateLength, getTemplateLength());
    out.encode(Flag.SumStats, getSumStats());
    out.encode(Flag.ExtensionDropoffPrelimGapped, getExtensionDropoffPrelimGapped());
    out.encode(Flag.ExtensionDropoffFinalGapped, getExtensionDropoffFinalGapped());
    out.encode(Flag.NonGreedy, getNonGreedy());
    out.encode(Flag.MinRawGappedScore, getMinRawGappedScore());
    out.encode(Flag.UngappedAlignmentsOnly, getUngappedAlignmentsOnly());
    out.encode(Flag.OffDiagonalRange, getOffDiagonalRange());
    out.encode(Flag.NumThreads, getNumThreads());
    out.encode(Flag.BestHitOverhang, getBestHitOverhang());
    out.encode(Flag.BestHitScoreEdge, getBestHitScoreEdge());
    out.encode(Flag.SubjectBestHit, getSubjectBestHit());

    return out;
  }

  @Override
  public void decodeJSON(JSONObjectDecoder node) {
    super.decodeJSON(node);

    node.decode(Flag.Strand, this::setStrand, Strand::fromJSON);
    node.decode(Flag.Task, this::setTask, BlastNTask::fromJSON);
    node.decode(Flag.WordSize, this::setWordSize);
    node.decode(Flag.GapOpen, this::setGapOpen);
    node.decode(Flag.GapExtend, this::setGapExtend);
    node.decode(Flag.Penalty, this::setPenalty);
    node.decode(Flag.Reward, this::setReward);
    node.decode(Flag.UseIndex, this::setUseIndex);
    node.decode(Flag.IndexName, this::setIndexName);
    node.decode(Flag.SubjectFile, this::setSubjectFile);
    node.decode(Flag.SubjectLocation, this::setSubjectLocation, Location::fromJSON);
    node.decode(Flag.Dust, this::setDust, Dust::fromJSON);
    node.decode(Flag.FilteringDB, this::setFilteringDB);
    node.decode(Flag.WindowMaskerTaxID, this::setWindowMaskerTaxID);
    node.decode(Flag.WindowMaskerDB, this::setWindowMaskerDB);
    node.decode(Flag.DBSoftMask, this::setDBSoftMask);
    node.decode(Flag.DBHardMask, this::setDBHardMask);
    node.decode(Flag.PercentIdentity, this::setPercentIdentity);
    node.decode(Flag.CullingLimit, this::setCullingLimit);
    node.decode(Flag.TemplateType, this::setTemplateType, TemplateType::fromJSON);
    node.decode(Flag.TemplateLength, this::setTemplateLength, TemplateLength::fromJSON);
    node.decode(Flag.SumStats, this::setSumStats);
    node.decode(Flag.ExtensionDropoffPrelimGapped, this::setExtensionDropoffPrelimGapped);
    node.decode(Flag.ExtensionDropoffFinalGapped, this::setExtensionDropoffFinalGapped);
    node.decode(Flag.NonGreedy, this::setNonGreedy);
    node.decode(Flag.MinRawGappedScore, this::setMinRawGappedScore);
    node.decode(Flag.UngappedAlignmentsOnly, this::setUngappedAlignmentsOnly);
    node.decode(Flag.OffDiagonalRange, this::setOffDiagonalRange);
    node.decode(Flag.NumThreads, this::setNumThreads);
    node.decode(Flag.BestHitOverhang, this::setBestHitOverhang);
    node.decode(Flag.BestHitScoreEdge, this::setBestHitScoreEdge);
    node.decode(Flag.SubjectBestHit, this::setSubjectBestHit);
  }

  @JsonCreator
  public static BlastN fromJSON(JSONObjectDecoder js) {
    var out = new BlastN();
    out.decodeJSON(js);
    return out;
  }
}
