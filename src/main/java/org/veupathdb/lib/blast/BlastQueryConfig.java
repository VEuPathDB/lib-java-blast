package org.veupathdb.lib.blast;

import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.ExpectValue;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.QueryFile;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
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
  default void decodeJSON(JSONObjectDecoder node) {
    BlastConfig.super.decodeJSON(node);

    node.decode(Flag.QueryFile, this::setQueryFile);
    node.decode(Flag.QueryLocation, this::setQueryLocation, Location::fromJSON);
    node.decode(Flag.DBFile, this::setDBFile);
    node.decode(Flag.ExpectValue, this::setExpectValue);
    node.decode(Flag.SoftMasking, this::setSoftMasking);
    node.decode(Flag.LowercaseMasking, this::setLowercaseMasking);
    node.decode(Flag.EntrezQuery, this::setEntrezQuery);
    node.decode(Flag.QueryCoverageHSPPercent, this::setQueryCoverageHSPPercent);
    node.decode(Flag.MaxHSPs, this::setMaxHSPs);
    node.decode(Flag.DBSize, this::setDBSize);
    node.decode(Flag.SearchSpace, this::setSearchSpace);
    node.decode(Flag.ImportSearchStrategy, this::setImportSearchStrategy);
    node.decode(Flag.ExportSearchStrategy, this::setExportSearchStrategy);
    node.decode(Flag.ExtensionDropoffUngapped, this::setExtensionDropoffUngapped);
    node.decode(Flag.WindowSize, this::setWindowSize);
    node.decode(Flag.Remote, this::setRemote);
  }

  @Override
  default JSONObjectEncoder toJSON(boolean includeTool) {
    final var out = BlastConfig.super.toJSON(includeTool);

    out.encode(Flag.QueryFile, getQueryFile());
    out.encode(Flag.QueryLocation, getQueryLocation());
    out.encode(Flag.DBFile, getDBFile());
    out.encode(Flag.ExpectValue, getExpectValue());
    out.encode(Flag.SoftMasking, getSoftMasking());
    out.encode(Flag.LowercaseMasking, getLowercaseMasking());
    out.encode(Flag.EntrezQuery, getEntrezQuery());
    out.encode(Flag.QueryCoverageHSPPercent, getQueryCoverageHSPPercent());
    out.encode(Flag.MaxHSPs, getMaxHSPs());
    out.encode(Flag.DBSize, getDBSize());
    out.encode(Flag.SearchSpace, getSearchSpace());
    out.encode(Flag.ImportSearchStrategy, getImportSearchStrategy());
    out.encode(Flag.ExportSearchStrategy, getExportSearchStrategy());
    out.encode(Flag.ExtensionDropoffUngapped, getExtensionDropoffUngapped());
    out.encode(Flag.WindowSize, getWindowSize());
    out.encode(Flag.Remote, getRemote());

    return out;
  }
}
