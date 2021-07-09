package org.veupathdb.lib.blast;

import org.veupathdb.lib.blast.field.HSPSorting;
import org.veupathdb.lib.blast.field.HitSorting;
import org.veupathdb.lib.blast.field.OutFormat;
import org.veupathdb.lib.blast.util.JSONEncodable;

public interface BlastConfig extends JSONEncodable
{
  BlastTool getTool();

  Boolean getShortHelp();

  void setShortHelp(Boolean val);

  Boolean getLongHelp();

  void setLongHelp(Boolean val);

  Boolean getVersion();

  void setVersion(Boolean val);

  String getOutFile();

  void setOutFile(String file);

  OutFormat getOutFormat();

  void setOutFormat(OutFormat fmt);

  Boolean getShowGIs();

  void setShowGIs(Boolean val);

  Long getNumDescriptions();

  void setNumDescriptions(Long val);

  Long getNumAlignments();

  void setNumAlignments(Long val);

  Integer getLineLength();

  void setLineLength(Integer val);

  Boolean getHTML();

  void setHTML(Boolean val);

  HitSorting getSortHits();

  void setSortHits(HitSorting val);

  HSPSorting getSortHSPs();

  void setSortHSPs(HSPSorting val);

  Long getMaxTargetSequences();

  void setMaxTargetSequences(Long val);

  Boolean getParseDefLines();

  void setParseDefLines(Boolean val);
}
