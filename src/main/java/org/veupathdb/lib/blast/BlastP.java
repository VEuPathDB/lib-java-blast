package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.BlastPTask;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.ScoringMatrix;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

import java.util.Objects;

public class BlastP extends BlastWithIPGList implements BlastQueryConfig
{
  @Override
  public BlastTool getTool() {
    return BlastTool.BlastP;
  }

  // ------------------------------------------------------------------------------------------ //

  private BlastPTask task;

  public BlastPTask getTask() {
    return task;
  }

  public void setTask(BlastPTask task) {
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
    BlastP blastP = (BlastP) o;
    return getTask() == blastP.getTask()
      && Objects.equals(
      getWordSize(),
      blastP.getWordSize()
    )
      && Objects.equals(getGapOpen(), blastP.getGapOpen())
      && Objects.equals(
      getGapExtend(),
      blastP.getGapExtend()
    )
      && getMatrix() == blastP.getMatrix()
      && Objects.equals(
      getThreshold(),
      blastP.getThreshold()
    )
      && Objects.equals(getCompBasedStats(), blastP.getCompBasedStats())
      && Objects.equals(getSubjectFile(), blastP.getSubjectFile())
      && Objects.equals(getSubjectLocation(), blastP.getSubjectLocation())
      && Objects.equals(getSeg(), blastP.getSeg())
      && Objects.equals(dbSoftMask, blastP.dbSoftMask)
      && Objects.equals(dbHardMask, blastP.dbHardMask)
      && Objects.equals(getCullingLimit(), blastP.getCullingLimit())
      && Objects.equals(
      getExtensionDropoffPrelimGapped(),
      blastP.getExtensionDropoffPrelimGapped()
    )
      && Objects.equals(
      getExtensionDropoffFinalGapped(),
      blastP.getExtensionDropoffFinalGapped()
    )
      && Objects.equals(getUngappedAlignmentsOnly(), blastP.getUngappedAlignmentsOnly())
      && Objects.equals(getNumThreads(), blastP.getNumThreads())
      && Objects.equals(
      getUseSmithWatermanTraceback(),
      blastP.getUseSmithWatermanTraceback()
    )
      && Objects.equals(getBestHitOverhang(), blastP.getBestHitOverhang())
      && Objects.equals(getBestHitScoreEdge(), blastP.getBestHitScoreEdge())
      && Objects.equals(getSubjectBestHit(), blastP.getSubjectBestHit());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      super.hashCode(),
      getTool(),
      getTask(),
      getWordSize(),
      getGapOpen(),
      getGapExtend(),
      getMatrix(),
      getThreshold(),
      getCompBasedStats(),
      getSubjectFile(),
      getSubjectLocation(),
      getSeg(),
      getDBSoftMask(),
      getDBHardMask(),
      getCullingLimit(),
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
  public JSONObjectEncoder toJSON(boolean includeTool) {
    final var out = super.toJSON(includeTool);

    out.encode(Flag.Task, getTask());
    out.encode(Flag.WordSize, getWordSize());
    out.encode(Flag.GapOpen, getGapOpen());
    out.encode(Flag.GapExtend, getGapExtend());
    out.encode(Flag.Matrix, getMatrix());
    out.encode(Flag.Threshold, getThreshold());
    out.encode(Flag.CompBasedStats, getCompBasedStats());
    out.encode(Flag.SubjectFile, getSubjectFile());
    out.encode(Flag.SubjectLocation, getSubjectLocation());
    out.encode(Flag.Seg, getSeg());
    out.encode(Flag.DBSoftMask, getDBSoftMask());
    out.encode(Flag.DBHardMask, getDBHardMask());
    out.encode(Flag.CullingLimit, getCullingLimit());
    out.encode(Flag.ExtensionDropoffPrelimGapped, getExtensionDropoffPrelimGapped());
    out.encode(Flag.ExtensionDropoffFinalGapped, getExtensionDropoffFinalGapped());
    out.encode(Flag.UngappedAlignmentsOnly, getUngappedAlignmentsOnly());
    out.encode(Flag.NumThreads, getNumThreads());
    out.encode(Flag.UseSmithWatermanTraceback, getUseSmithWatermanTraceback());
    out.encode(Flag.BestHitOverhang, getBestHitOverhang());
    out.encode(Flag.BestHitScoreEdge, getBestHitScoreEdge());
    out.encode(Flag.SubjectBestHit, getSubjectBestHit());

    return out;
  }

  @Override
  public void decodeJSON(JSONObjectDecoder node) {
    super.decodeJSON(node);

    node.decode(Flag.Task, this::setTask, BlastPTask::fromJSON);
    node.decode(Flag.WordSize, this::setWordSize);
    node.decode(Flag.GapOpen, this::setGapOpen);
    node.decode(Flag.GapExtend, this::setGapExtend);
    node.decode(Flag.Matrix, this::setMatrix, ScoringMatrix::fromJSON);
    node.decode(Flag.Threshold, this::setThreshold);
    node.decode(Flag.CompBasedStats, this::setCompBasedStats);
    node.decode(Flag.SubjectFile, this::setSubjectFile);
    node.decode(Flag.SubjectLocation, this::setSubjectLocation, Location::fromJSON);
    node.decode(Flag.Seg, this::setSeg, Seg::fromJSON);
    node.decode(Flag.DBSoftMask, this::setDBSoftMask);
    node.decode(Flag.DBHardMask, this::setDBHardMask);
    node.decode(Flag.CullingLimit, this::setCullingLimit);
    node.decode(Flag.ExtensionDropoffPrelimGapped, this::setExtensionDropoffPrelimGapped);
    node.decode(Flag.ExtensionDropoffFinalGapped, this::setExtensionDropoffFinalGapped);
    node.decode(Flag.UngappedAlignmentsOnly, this::setUngappedAlignmentsOnly);
    node.decode(Flag.NumThreads, this::setNumThreads);
    node.decode(Flag.UseSmithWatermanTraceback, this::setUseSmithWatermanTraceback);
    node.decode(Flag.BestHitOverhang, this::setBestHitOverhang);
    node.decode(Flag.BestHitScoreEdge, this::setBestHitScoreEdge);
    node.decode(Flag.SubjectBestHit, this::setSubjectBestHit);
  }

  @JsonCreator
  public static BlastP fromJSON(JSONObjectDecoder js) {
    var out = new BlastP();
    out.decodeJSON(js);
    return out;
  }
}
