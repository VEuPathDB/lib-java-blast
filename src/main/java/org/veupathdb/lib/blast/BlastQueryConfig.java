package org.veupathdb.lib.blast;

import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.ExpectValue;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.QueryFile;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

public interface BlastQueryConfig extends BlastConfig
{
  QueryFile getQueryFile();

  void setQueryFile(String file);

  Location getQueryLocation();

  void setQueryLocation(Location val);

  String getDBFile();

  void setDBFile(String file);

  ExpectValue getExpectValue();

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

  @Override
  default JSONObjectEncoder toJSON(boolean includeTool) {
    final var out = BlastConfig.super.toJSON(includeTool);

    out.encode(Flag.QueryFile, getQueryFile());
    out.encode(Flag.QueryLocation, getQueryLocation());
    out.encode(Flag.DBFile, getDBFile());
    out.encode(Flag.ExpectValue, getExpectValue());
    out.encode(Flag.SoftMasking, getSoftMasking());
    out.encode(Flag.LowercaseMasking, getLowercaseMasking());
    out.encode(Flag.EntrezQuery, );
  }
}
