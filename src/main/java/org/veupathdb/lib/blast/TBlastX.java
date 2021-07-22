package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.ScoringMatrix;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.field.Strand;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

public class TBlastX extends BlastWithLists implements BlastQueryConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.TBlastX;
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

  private Short queryGenCode;

  public Short getQueryGenCode() {
    return queryGenCode;
  }

  public void setQueryGenCode(Short queryGenCode) {
    this.queryGenCode = queryGenCode;
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

  private Long maxIntronLength;

  public Long getMaxIntronLength() {
    return maxIntronLength;
  }

  public void setMaxIntronLength(Long maxIntronLength) {
    this.maxIntronLength = maxIntronLength;
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

  private Short dbGenCode;

  public Short getDBGenCode() {
    return dbGenCode;
  }

  public void setDBGenCode(Short dbGenCode) {
    this.dbGenCode = dbGenCode;
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
      getTool(),
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

  @Override
  public TBlastX copy() {
    var out = new TBlastX();
    copyInto(out);
    return out;
  }

  @Override
  @JsonValue
  public JSONObjectEncoder toJSON() {
    var js = super.toJSON();

    js.encode(Key.Tool, getTool().getValue());
    js.encode(Flag.Strand, strand);
    js.encode(Flag.QueryGenCode, queryGenCode);
    js.encode(Flag.WordSize, wordSize);
    js.encode(Flag.MaxIntronLength, maxIntronLength);
    js.encode(Flag.Matrix, matrix);
    js.encode(Flag.Threshold, threshold);
    js.encode(Flag.DBGenCode, dbGenCode);
    js.encode(Flag.SubjectFile, subjectFile);
    js.encode(Flag.SubjectLocation, subjectLocation);
    js.encode(Flag.Seg, seg);
    js.encode(Flag.DBSoftMask, dbSoftMask);
    js.encode(Flag.DBHardMask, dbHardMask);
    js.encode(Flag.CullingLimit, cullingLimit);
    js.encode(Flag.SumStats, sumStats);
    js.encode(Flag.NumThreads, numThreads);
    js.encode(Flag.BestHitOverhang, bestHitOverhang);
    js.encode(Flag.BestHitScoreEdge, bestHitScoreEdge);
    js.encode(Flag.SubjectBestHit, subjectBestHit);

    return js;
  }

  @JsonCreator
  public static TBlastX fromJSON(JSONObjectDecoder js) {
    var out = new TBlastX();
    out.copyInto(js);
    return out;
  }

  protected void copyInto(TBlastX out) {
    super.copyInto(out);

    out.strand          = strand;
    out.queryGenCode    = queryGenCode;
    out.wordSize        = wordSize;
    out.maxIntronLength = maxIntronLength;
    out.matrix          = matrix;
    out.threshold       = threshold;
    out.dbGenCode       = dbGenCode;
    out.subjectFile     = subjectFile;

    if (subjectLocation != null)
      out.subjectLocation = subjectLocation.copy();
    if (seg != null)
      out.seg = seg.copy();

    out.dbSoftMask       = dbSoftMask;
    out.dbHardMask       = dbHardMask;
    out.cullingLimit     = cullingLimit;
    out.sumStats         = sumStats;
    out.numThreads       = numThreads;
    out.bestHitOverhang  = bestHitOverhang;
    out.bestHitScoreEdge = bestHitScoreEdge;
    out.subjectBestHit   = subjectBestHit;
  }

  @Override
  protected void copyInto(JSONObjectDecoder js) {
    super.copyInto(js);

    js.decode(Flag.Strand, this::setStrand, Strand::fromJSON);
    js.decode(Flag.QueryGenCode, this::setQueryGenCode);
    js.decode(Flag.WordSize, this::setWordSize);
    js.decode(Flag.MaxIntronLength, this::setMaxIntronLength);
    js.decode(Flag.Matrix, this::setMatrix, ScoringMatrix::fromJSON);
    js.decode(Flag.Threshold, this::setThreshold);
    js.decode(Flag.DBGenCode, this::setDBGenCode);
    js.decode(Flag.SubjectFile, this::setSubjectFile);
    js.decode(Flag.SubjectLocation, this::setSubjectLocation, Location::fromJSON);
    js.decode(Flag.Seg, this::setSeg, Seg::fromJSON);
    js.decode(Flag.DBSoftMask, this::setDBSoftMask);
    js.decode(Flag.DBHardMask, this::setDBHardMask);
    js.decode(Flag.CullingLimit, this::setCullingLimit);
    js.decode(Flag.SumStats, this::setSumStats);
    js.decode(Flag.NumThreads, this::setNumThreads);
    js.decode(Flag.BestHitOverhang, this::setBestHitOverhang);
    js.decode(Flag.BestHitScoreEdge, this::setBestHitScoreEdge);
    js.decode(Flag.SubjectBestHit, this::setSubjectBestHit);
  }
}
