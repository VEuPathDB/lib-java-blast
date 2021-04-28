package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;

public class BlastFormatter extends CLIBase
{
  private String requestID;
  private String archiveFile;

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
}
