package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;

public class BlastFormatter extends CLIBase implements BlastConfig
{
  private String requestID;
  private String archiveFile;

  @Override
  public BlastTool getTool() {
    return BlastTool.BlastFormatter;
  }

  @JsonGetter(Flag.RequestID)
  public String getRequestID() {
    return requestID;
  }

  @JsonSetter(Flag.RequestID)
  public void setRequestID(String requestID) {
    this.requestID = requestID;
  }

  @JsonGetter(Flag.ArchiveFile)
  public String getArchiveFile() {
    return archiveFile;
  }

  @JsonSetter(Flag.ArchiveFile)
  public void setArchiveFile(String archiveFile) {
    this.archiveFile = archiveFile;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    BlastFormatter that = (BlastFormatter) o;
    return Objects.equals(getRequestID(), that.getRequestID()) && Objects.equals(
      getArchiveFile(),
      that.getArchiveFile()
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getRequestID(), getArchiveFile());
  }

  public BlastFormatter copy() {
    var out = new BlastFormatter();
    copyInto(out);
    return out;
  }

  protected void copyInto(BlastFormatter out) {
    super.copyInto(out);
    out.requestID = requestID;
    out.archiveFile = archiveFile;
  }
}
