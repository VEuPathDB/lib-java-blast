package org.veupathdb.lib.blast;

import org.veupathdb.lib.blast.field.Location;

public interface BlastQueryConfig extends BlastConfig
{
  String getQueryFile();

  void setQueryFile(String file);

  Location getQueryLocation();

  void setQueryLocation(Location val);

  String getDBFile();

  void setDBFile(String file);

  String getExpectValue();

  void setExpectValue(String val);

  Boolean getSoftMasking();

  void setSoftMasking(Boolean val);

  Boolean getLowercaseMasking();

  void setLowercaseMasking(Boolean val);

  String getEntrezQuery();

  void setEntrezQuery(String val);

  Double getQueryCoverageHSPPercent();

  void setQueryCoverageHSPPercent(Double val);

  Long getMaxHSPs();

  void setMaxHSPs(Long val);

  Byte getDBSize();

  void setDBSize(Byte val);

  Short getSearchSpace();

  void setSearchSpace(Short val);

  String getImportSearchStrategy();

  void setImportSearchStrategy(String file);

  String getExportSearchStrategy();

  void setExportSearchStrategy(String file);

  Double getExtensionDropoffUngapped();

  void setExtensionDropoffUngapped(Double val);

  Long getWindowSize();

  void setWindowSize(Long val);

  Boolean getRemote();

  void setRemote(Boolean val);
}
