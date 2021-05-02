package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.Location;

public interface BlastQueryConfig extends BlastConfig
{
  @JsonGetter(Flag.QueryFile)
  String getQueryFile();

  @JsonSetter(Flag.QueryFile)
  void setQueryFile(String file);

  @JsonGetter(Flag.QueryLocation)
  Location getQueryLocation();

  @JsonSetter(Flag.QueryLocation)
  void setQueryLocation(Location val);

  @JsonGetter(Flag.DBFile)
  String getDBFile();

  @JsonSetter(Flag.DBFile)
  void setDBFile(String file);

  @JsonGetter(Flag.ExpectValue)
  String getExpectValue();

  @JsonSetter(Flag.ExpectValue)
  void setExpectValue(String val);

  @JsonGetter(Flag.SoftMasking)
  Boolean getSoftMasking();

  @JsonSetter(Flag.SoftMasking)
  void setSoftMasking(Boolean val);

  @JsonGetter(Flag.LowercaseMasking)
  Boolean getLowercaseMasking();

  @JsonSetter(Flag.LowercaseMasking)
  void setLowercaseMasking(Boolean val);

  @JsonGetter(Flag.EntrezQuery)
  String getEntrezQuery();

  @JsonSetter(Flag.EntrezQuery)
  void setEntrezQuery(String val);

  @JsonGetter(Flag.QueryCoverageHSPPercent)
  Double getQueryCoverageHSPPercent();

  @JsonSetter(Flag.QueryCoverageHSPPercent)
  void setQueryCoverageHSPPercent(Double val);

  @JsonGetter(Flag.MaxHSPs)
  Long getMaxHSPs();

  @JsonSetter(Flag.MaxHSPs)
  void setMaxHSPs(Long val);

  @JsonGetter(Flag.DBSize)
  Byte getDBSize();

  @JsonSetter(Flag.DBSize)
  void setDBSize(Byte val);

  @JsonGetter(Flag.SearchSpace)
  Short getSearchSpace();

  @JsonSetter(Flag.SearchSpace)
  void setSearchSpace(Short val);

  @JsonGetter(Flag.ImportSearchStrategy)
  String getImportSearchStrategy();

  @JsonSetter(Flag.ImportSearchStrategy)
  void setImportSearchStrategy(String file);

  @JsonGetter(Flag.ExportSearchStrategy)
  String getExportSearchStrategy();

  @JsonSetter(Flag.ExportSearchStrategy)
  void setExportSearchStrategy(String file);

  @JsonGetter(Flag.ExtensionDropoffUngapped)
  Double getExtensionDropoffUngapped();

  @JsonSetter(Flag.ExtensionDropoffUngapped)
  void setExtensionDropoffUngapped(Double val);

  @JsonGetter(Flag.WindowSize)
  Long getWindowSize();

  @JsonSetter(Flag.WindowSize)
  void setWindowSize(Long val);

  @JsonGetter(Flag.Remote)
  Boolean getRemote();

  @JsonSetter(Flag.Remote)
  void setRemote(Boolean val);
}
