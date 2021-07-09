package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

public class BlastBase extends CLIBase
{
  public static final String DefaultQueryFile   = "-";
  public static final String DefaultExpectValue = "10";

  private String     queryFile;
  private Location   queryLocation;
  private String     dbFile;
  private String     expectValue;
  private Boolean    softMasking;
  private Boolean    lowercaseMasking;
  private String     entrezQuery;
  private Double     queryCoverageHSPPercent;
  private Long       maxHSPs;
  private Byte       dbSize;
  private Short      searchSpace;
  private String     importSearchStrategy;
  private String     exportSearchStrategy;
  private Double     extensionDropoffUngapped;
  private Long       windowSize;
  private Boolean    remote;

  public String getQueryFile() {
    return queryFile;
  }

  public void setQueryFile(String queryFile) {
    this.queryFile = queryFile;
  }

  public Location getQueryLocation() {
    return queryLocation;
  }

  public void setQueryLocation(Location queryLocation) {
    this.queryLocation = queryLocation;
  }

  public String getDBFile() {
    return dbFile;
  }

  public void setDBFile(String dbFile) {
    this.dbFile = dbFile;
  }

  public String getExpectValue() {
    return expectValue;
  }

  public void setExpectValue(String expectValue) {
    this.expectValue = expectValue;
  }

  public Boolean getSoftMasking() {
    return softMasking;
  }

  public void setSoftMasking(Boolean softMasking) {
    this.softMasking = softMasking;
  }

  public Boolean getLowercaseMasking() {
    return lowercaseMasking;
  }

  public void setLowercaseMasking(Boolean lowercaseMasking) {
    this.lowercaseMasking = lowercaseMasking;
  }

  public String getEntrezQuery() {
    return entrezQuery;
  }

  public void setEntrezQuery(String entrezQuery) {
    this.entrezQuery = entrezQuery;
  }

  public Double getQueryCoverageHSPPercent() {
    return queryCoverageHSPPercent;
  }

  public void setQueryCoverageHSPPercent(Double queryCoverageHSPPercent) {
    this.queryCoverageHSPPercent = queryCoverageHSPPercent;
  }

  public Long getMaxHSPs() {
    return maxHSPs;
  }

  public void setMaxHSPs(Long maxHSPs) {
    this.maxHSPs = maxHSPs;
  }

  public Byte getDBSize() {
    return dbSize;
  }

  public void setDBSize(Byte dbSize) {
    System.out.println(dbSize);
    this.dbSize = dbSize;
  }

  public Short getSearchSpace() {
    return searchSpace;
  }

  public void setSearchSpace(Short searchSpace) {
    this.searchSpace = searchSpace;
  }

  public String getImportSearchStrategy() {
    return importSearchStrategy;
  }

  public void setImportSearchStrategy(String importSearchStrategy) {
    this.importSearchStrategy = importSearchStrategy;
  }

  public String getExportSearchStrategy() {
    return exportSearchStrategy;
  }

  public void setExportSearchStrategy(String exportSearchStrategy) {
    this.exportSearchStrategy = exportSearchStrategy;
  }

  public Double getExtensionDropoffUngapped() {
    return extensionDropoffUngapped;
  }

  public void setExtensionDropoffUngapped(Double extensionDropoffUngapped) {
    this.extensionDropoffUngapped = extensionDropoffUngapped;
  }

  public Long getWindowSize() {
    return windowSize;
  }

  public void setWindowSize(Long windowSize) {
    this.windowSize = windowSize;
  }

  public Boolean getRemote() {
    return remote;
  }

  public void setRemote(Boolean remote) {
    this.remote = remote;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BlastBase)) return false;
    if (!super.equals(o)) return false;
    BlastBase blastBase = (BlastBase) o;
    return Objects.equals(getQueryFile(), blastBase.getQueryFile())
      && Objects.equals(getQueryLocation(), blastBase.getQueryLocation())
      && Objects.equals(dbFile, blastBase.dbFile)
      && Objects.equals(getExpectValue(), blastBase.getExpectValue())
      && Objects.equals(getSoftMasking(), blastBase.getSoftMasking())
      && Objects.equals(getLowercaseMasking(), blastBase.getLowercaseMasking())
      && Objects.equals(getEntrezQuery(), blastBase.getEntrezQuery())
      && Objects.equals(
      getQueryCoverageHSPPercent(),
      blastBase.getQueryCoverageHSPPercent()
    )
      && Objects.equals(getMaxHSPs(), blastBase.getMaxHSPs())
      && Objects.equals(dbSize, blastBase.dbSize)
      && Objects.equals(getSearchSpace(), blastBase.getSearchSpace())
      && Objects.equals(getImportSearchStrategy(), blastBase.getImportSearchStrategy())
      && Objects.equals(getExportSearchStrategy(), blastBase.getExportSearchStrategy())
      && Objects.equals(
      getExtensionDropoffUngapped(),
      blastBase.getExtensionDropoffUngapped()
    )
      && Objects.equals(getWindowSize(), blastBase.getWindowSize())
      && Objects.equals(getRemote(), blastBase.getRemote());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      super.hashCode(),
      getQueryFile(),
      getQueryLocation(),
      getDBFile(),
      getExpectValue(),
      getSoftMasking(),
      getLowercaseMasking(),
      getEntrezQuery(),
      getQueryCoverageHSPPercent(),
      getMaxHSPs(),
      getDBSize(),
      getSearchSpace(),
      getImportSearchStrategy(),
      getExportSearchStrategy(),
      getExtensionDropoffUngapped(),
      getWindowSize(),
      getRemote()
    );
  }

  @Override
  @JsonValue
  public JSONObjectEncoder toJSON() {
    var out = super.toJSON();

    out.encode(Flag.QueryFile, queryFile, DefaultQueryFile);
    out.encode(Flag.QueryLocation, queryLocation);
    out.encode(Flag.DBFile, dbFile);
    out.encode(Flag.ExpectValue, expectValue, DefaultExpectValue);
    out.encode(Flag.SoftMasking, softMasking);
    out.encode(Flag.LowercaseMasking, lowercaseMasking);
    out.encode(Flag.EntrezQuery, entrezQuery);
    out.encode(Flag.QueryCoverageHSPPercent, queryCoverageHSPPercent);
    out.encode(Flag.MaxHSPs, maxHSPs);
    out.encode(Flag.DBSize, dbSize);
    out.encode(Flag.SearchSpace, searchSpace);
    out.encode(Flag.ImportSearchStrategy, importSearchStrategy);
    out.encode(Flag.ExportSearchStrategy, exportSearchStrategy);
    out.encode(Flag.ExtensionDropoffUngapped, extensionDropoffUngapped);
    out.encode(Flag.WindowSize, windowSize);
    out.encode(Flag.Remote, remote);

    return out;
  }

  @Override
  public BlastBase copy() {
    var out = new BlastBase();
    copyInto(out);
    return out;
  }

  @JsonCreator
  public static BlastBase fromJSON(JSONObjectDecoder js) {
    var out = new BlastBase();
    out.copyInto(js);
    return out;
  }

  protected void copyInto(BlastBase out) {
    super.copyInto(out);
    out.setQueryFile(getQueryFile());
    if (queryLocation != null)
      out.setQueryLocation(getQueryLocation().copy());
    out.setDBFile(getDBFile());
    out.setExpectValue(getExpectValue());
    out.setSoftMasking(getSoftMasking());
    out.setLowercaseMasking(getLowercaseMasking());
    out.setEntrezQuery(getEntrezQuery());
    out.setQueryCoverageHSPPercent(getQueryCoverageHSPPercent());
    out.setMaxHSPs(getMaxHSPs());
    out.setDBSize(getDBSize());
    out.setSearchSpace(getSearchSpace());
    out.setImportSearchStrategy(getImportSearchStrategy());
    out.setExportSearchStrategy(getExportSearchStrategy());
    out.setExtensionDropoffUngapped(getExtensionDropoffUngapped());
    out.setWindowSize(getWindowSize());
    out.setRemote(getRemote());
  }

  @Override
  protected void copyInto(JSONObjectDecoder js) {
    super.copyInto(js);

    js.decode(Flag.QueryFile, this::setQueryFile);
    js.decode(Flag.QueryLocation, this::setQueryLocation, Location::fromJSON);
    js.decode(Flag.DBFile, this::setDBFile);
    js.decode(Flag.ExpectValue, this::setExpectValue);
    js.decode(Flag.SoftMasking, this::setSoftMasking);
    js.decode(Flag.LowercaseMasking, this::setLowercaseMasking);
    js.decode(Flag.EntrezQuery, this::setEntrezQuery);
    js.decode(Flag.QueryCoverageHSPPercent, this::setQueryCoverageHSPPercent);
    js.decode(Flag.MaxHSPs, this::setMaxHSPs);
    js.decode(Flag.DBSize, this::setDBSize);
    js.decode(Flag.SearchSpace, this::setSearchSpace);
    js.decode(Flag.ImportSearchStrategy, this::setImportSearchStrategy);
    js.decode(Flag.ExportSearchStrategy, this::setExportSearchStrategy);
    js.decode(Flag.ExtensionDropoffUngapped, this::setExtensionDropoffUngapped);
    js.decode(Flag.WindowSize, this::setWindowSize);
    js.decode(Flag.Remote, this::setRemote);
  }
}
