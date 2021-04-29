package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.ScoringMatrix;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.field.Strand;

public class TBlastX extends BlastWithLists implements BlastConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.TBlastX;
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

  // ------------------------------------------------------------------------------------------ //

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    TBlastX tBlastX = (TBlastX) o;
    return getStrand() == tBlastX.getStrand()
      && Objects.equals(
      getQueryGenCode(),
      tBlastX.getQueryGenCode()
    )
      && Objects.equals(getWordSize(), tBlastX.getWordSize())
      && Objects.equals(
      getMaxIntronLength(),
      tBlastX.getMaxIntronLength()
    )
      && getMatrix() == tBlastX.getMatrix()
      && Objects.equals(
      getThreshold(),
      tBlastX.getThreshold()
    )
      && Objects.equals(dbGenCode, tBlastX.dbGenCode)
      && Objects.equals(
      getSubjectFile(),
      tBlastX.getSubjectFile()
    )
      && Objects.equals(getSubjectLocation(), tBlastX.getSubjectLocation())
      && Objects.equals(getSeg(), tBlastX.getSeg())
      && Objects.equals(dbSoftMask, tBlastX.dbSoftMask)
      && Objects.equals(dbHardMask, tBlastX.dbHardMask)
      && Objects.equals(getCullingLimit(), tBlastX.getCullingLimit())
      && Objects.equals(getSumStats(), tBlastX.getSumStats())
      && Objects.equals(getNumThreads(), tBlastX.getNumThreads())
      && Objects.equals(getBestHitOverhang(), tBlastX.getBestHitOverhang())
      && Objects.equals(getBestHitScoreEdge(), tBlastX.getBestHitScoreEdge())
      && Objects.equals(getSubjectBestHit(), tBlastX.getSubjectBestHit());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      super.hashCode(),
      getStrand(),
      getQueryGenCode(),
      getWordSize(),
      getMaxIntronLength(),
      getMatrix(),
      getThreshold(),
      getDBGenCode(),
      getSubjectFile(),
      getSubjectLocation(),
      getSeg(),
      getDBSoftMask(),
      getDBHardMask(),
      getCullingLimit(),
      getSumStats(),
      getNumThreads(),
      getBestHitOverhang(),
      getBestHitScoreEdge(),
      getSubjectBestHit()
    );
  }
}
