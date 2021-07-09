package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

public class BlastFormatter extends CLIBase implements BlastConfig
{
  private String requestID;
  private String archiveFile;

  @Override
  public BlastTool getTool() {
    return BlastTool.BlastFormatter;
  }

  public String getRequestID() {
    return requestID;
  }

  public void setRequestID(String requestID) {
    this.requestID = requestID;
  }

  public String getArchiveFile() {
    return archiveFile;
  }

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

  @Override
  @JsonValue
  public JSONObjectEncoder toJSON() {
    var js = super.toJSON();

    js.encode(Flag.RequestID, requestID);
    js.encode(Flag.ArchiveFile, archiveFile);

    return js;
  }

  @Override
  public BlastFormatter copy() {
    var out = new BlastFormatter();
    copyInto(out);
    return out;
  }

  @JsonCreator
  public static BlastFormatter fromJSON(JSONObjectDecoder js) {
    var out = new BlastFormatter();
    out.copyInto(js);
    return out;
  }

  protected void copyInto(BlastFormatter out) {
    super.copyInto(out);
    out.requestID = requestID;
    out.archiveFile = archiveFile;
  }

  protected void copyInto(JSONObjectDecoder js) {
    super.copyInto(js);

    js.decode(Flag.RequestID, this::setRequestID);
    js.decode(Flag.ArchiveFile, this::setArchiveFile);
  }
}
