package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.field.*;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

public class BlastX extends BlastWithIPGList implements BlastQueryConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.BlastX;
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

  private BlastXTask task;

  public BlastXTask getTask() {
    return task;
  }

  public void setTask(BlastXTask task) {
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

  private Boolean ungappedAlignmentsOnly;

  public Boolean getUngappedAlignmentsOnly() {
    return ungappedAlignmentsOnly;
  }

  public void setUngappedAlignmentsOnly(Boolean ungappedAlignmentsOnly) {
    this.ungappedAlignmentsOnly = ungappedAlignmentsOnly;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    BlastX blastX = (BlastX) o;
    return getStrand() == blastX.getStrand()
      && Objects.equals(
      getQueryGenCode(),
      blastX.getQueryGenCode()
    )
      && getTask() == blastX.getTask()
      && Objects.equals(
      getWordSize(),
      blastX.getWordSize()
    )
      && Objects.equals(getGapOpen(), blastX.getGapOpen())
      && Objects.equals(
      getGapExtend(),
      blastX.getGapExtend()
    )
      && Objects.equals(getMaxIntronLength(), blastX.getMaxIntronLength())
      && getMatrix() == blastX.getMatrix()
      && Objects.equals(getThreshold(), blastX.getThreshold())
      && Objects.equals(getCompBasedStats(), blastX.getCompBasedStats())
      && Objects.equals(getSubjectFile(), blastX.getSubjectFile())
      && Objects.equals(getSubjectLocation(), blastX.getSubjectLocation())
      && Objects.equals(getSeg(), blastX.getSeg())
      && Objects.equals(dbSoftMask, blastX.dbSoftMask)
      && Objects.equals(dbHardMask, blastX.dbHardMask)
      && Objects.equals(getCullingLimit(), blastX.getCullingLimit())
      && Objects.equals(getSumStats(), blastX.getSumStats())
      && Objects.equals(
      getExtensionDropoffPrelimGapped(),
      blastX.getExtensionDropoffPrelimGapped()
    )
      && Objects.equals(
      getExtensionDropoffFinalGapped(),
      blastX.getExtensionDropoffFinalGapped()
    )
      && Objects.equals(getUngappedAlignmentsOnly(), blastX.getUngappedAlignmentsOnly())
      && Objects.equals(getNumThreads(), blastX.getNumThreads())
      && Objects.equals(
      getUseSmithWatermanTraceback(),
      blastX.getUseSmithWatermanTraceback()
    )
      && Objects.equals(getBestHitOverhang(), blastX.getBestHitOverhang())
      && Objects.equals(getBestHitScoreEdge(), blastX.getBestHitScoreEdge())
      && Objects.equals(getSubjectBestHit(), blastX.getSubjectBestHit());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      super.hashCode(),
      getTool(),
      getStrand(),
      getQueryGenCode(),
      getTask(),
      getWordSize(),
      getGapOpen(),
      getGapExtend(),
      getMaxIntronLength(),
      getMatrix(),
      getThreshold(),
      getCompBasedStats(),
      getSubjectFile(),
      getSubjectLocation(),
      getSeg(),
      getDBSoftMask(),
      getDBHardMask(),
      getCullingLimit(),
      getSumStats(),
      getExtensionDropoffPrelimGapped(),
      getExtensionDropoffFinalGapped(),
      getUngappedAlignmentsOnly(),
      getNumThreads(),
      getUseSmithWatermanTraceback(),
      getBestHitOverhang(),
      getBestHitScoreEdge(),
      getSubjectBestHit()
    );
  }

  @Override
  public BlastX copy() {
    var out = new BlastX();
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
    js.encode(Flag.Task, task);
    js.encode(Flag.WordSize, wordSize);
    js.encode(Flag.GapOpen, gapOpen);
    js.encode(Flag.GapExtend, gapExtend);
    js.encode(Flag.MaxIntronLength, maxIntronLength);
    js.encode(Flag.Matrix, matrix);
    js.encode(Flag.Threshold, threshold);
    js.encode(Flag.CompBasedStats, compBasedStats);
    js.encode(Flag.SubjectFile, subjectFile);
    js.encode(Flag.SubjectLocation, subjectLocation);
    js.encode(Flag.Seg, seg);
    js.encode(Flag.DBSoftMask, dbSoftMask);
    js.encode(Flag.DBHardMask, dbHardMask);
    js.encode(Flag.CullingLimit, cullingLimit);
    js.encode(Flag.SumStats, sumStats);
    js.encode(Flag.ExtensionDropoffPrelimGapped, extensionDropoffPrelimGapped);
    js.encode(Flag.ExtensionDropoffFinalGapped, extensionDropoffFinalGapped);
    js.encode(Flag.UngappedAlignmentsOnly, ungappedAlignmentsOnly);
    js.encode(Flag.NumThreads, numThreads);
    js.encode(Flag.UseSmithWatermanTraceback, useSmithWatermanTraceback);
    js.encode(Flag.BestHitOverhang, bestHitOverhang);
    js.encode(Flag.BestHitScoreEdge, bestHitScoreEdge);
    js.encode(Flag.SubjectBestHit, subjectBestHit);

    return js;
  }

  @JsonCreator
  public static BlastX fromJSON(JSONObjectDecoder js) {
    var out = new BlastX();
    out.copyInto(js);
    return out;
  }

  protected void copyInto(BlastX out) {
    super.copyInto(out);
    out.strand = strand;
    out.queryGenCode = queryGenCode;
    out.task = task;
    out.wordSize = wordSize;
    out.gapOpen = gapOpen;
    out.gapExtend = gapExtend;
    out.maxIntronLength = maxIntronLength;
    out.matrix = matrix;
    out.threshold = threshold;
    out.compBasedStats = compBasedStats;
    out.subjectFile = subjectFile;
    if (subjectLocation != null)
      out.subjectLocation = subjectLocation.copy();
    if (seg != null)
      out.seg = seg.copy();
    out.dbSoftMask = dbSoftMask;
    out.dbHardMask = dbHardMask;
    out.cullingLimit = cullingLimit;
    out.sumStats = sumStats;
    out.extensionDropoffPrelimGapped = extensionDropoffPrelimGapped;
    out.extensionDropoffFinalGapped = extensionDropoffFinalGapped;
    out.ungappedAlignmentsOnly = ungappedAlignmentsOnly;
    out.numThreads = numThreads;
    out.useSmithWatermanTraceback = useSmithWatermanTraceback;
    out.bestHitOverhang = bestHitOverhang;
    out.bestHitScoreEdge = bestHitScoreEdge;
    out.subjectBestHit = subjectBestHit;
  }

  @Override
  protected void copyInto(JSONObjectDecoder js) {
    super.copyInto(js);

    js.decode(Flag.Strand, this::setStrand, Strand::fromJSON);
    js.decode(Flag.QueryGenCode, this::setQueryGenCode);
    js.decode(Flag.Task, this::setTask, BlastXTask::fromJSON);
    js.decode(Flag.WordSize, this::setWordSize);
    js.decode(Flag.GapOpen, this::setGapOpen);
    js.decode(Flag.GapExtend, this::setGapExtend);
    js.decode(Flag.MaxIntronLength, this::setMaxIntronLength);
    js.decode(Flag.Matrix, this::setMatrix, ScoringMatrix::fromJSON);
    js.decode(Flag.Threshold, this::setThreshold);
    js.decode(Flag.CompBasedStats, this::setCompBasedStats);
    js.decode(Flag.SubjectFile, this::setSubjectFile);
    js.decode(Flag.SubjectLocation, this::setSubjectLocation, Location::fromJSON);
    js.decode(Flag.Seg, this::setSeg, Seg::fromJSON);
    js.decode(Flag.DBSoftMask, this::setDBSoftMask);
    js.decode(Flag.DBHardMask, this::setDBHardMask);
    js.decode(Flag.CullingLimit, this::setCullingLimit);
    js.decode(Flag.SumStats, this::setSumStats);
    js.decode(Flag.ExtensionDropoffPrelimGapped, this::setExtensionDropoffPrelimGapped);
    js.decode(Flag.ExtensionDropoffFinalGapped, this::setExtensionDropoffFinalGapped);
    js.decode(Flag.UngappedAlignmentsOnly, this::setUngappedAlignmentsOnly);
    js.decode(Flag.NumThreads, this::setNumThreads);
    js.decode(Flag.UseSmithWatermanTraceback, this::setUseSmithWatermanTraceback);
    js.decode(Flag.BestHitOverhang, this::setBestHitOverhang);
    js.decode(Flag.BestHitScoreEdge, this::setBestHitScoreEdge);
    js.decode(Flag.SubjectBestHit, this::setSubjectBestHit);
  }
}
