package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface BlastConfig
{
  @JsonIgnore
  BlastTool getTool();
}
