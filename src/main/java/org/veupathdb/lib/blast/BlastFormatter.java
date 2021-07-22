package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

import java.util.Objects;

public class BlastFormatter extends CLIBase
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

  @JsonCreator
  public static BlastFormatter fromJSON(JSONObjectDecoder js) {
    var out = new BlastFormatter();
    out.decodeJSON(js);
    return out;
  }

  @Override
  public JSONObjectEncoder toJSON(boolean includeTool) {
    final var out = super.toJSON(includeTool);

    out.encode(Flag.RequestID, getRequestID());
    out.encode(Flag.ArchiveFile, getArchiveFile());

    return out;
  }

  @Override
  public void decodeJSON(JSONObjectDecoder node) {
    super.decodeJSON(node);

    node.decode(Flag.RequestID, this::setRequestID);
    node.decode(Flag.ArchiveFile, this::setArchiveFile);
  }
}
