package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.Location;

@JsonInclude(JsonInclude.Include.NON_NULL)
class BaseBlast extends Base
{
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

  @JsonGetter(Flag.QueryFile)
  public String getQueryFile() {
    return queryFile;
  }

  @JsonSetter(Flag.QueryFile)
  public void setQueryFile(String queryFile) {
    this.queryFile = queryFile;
  }

  @JsonGetter(Flag.QueryLocation)
  public Location getQueryLocation() {
    return queryLocation;
  }

  @JsonSetter(Flag.QueryLocation)
  public void setQueryLocation(Location queryLocation) {
    this.queryLocation = queryLocation;
  }

  @JsonGetter(Flag.DBFile)
  public String getDBFile() {
    return dbFile;
  }

  @JsonSetter(Flag.DBFile)
  public void setDBFile(String dbFile) {
    this.dbFile = dbFile;
  }

  @JsonGetter(Flag.ExpectValue)
  public String getExpectValue() {
    return expectValue;
  }

  @JsonSetter(Flag.ExpectValue)
  public void setExpectValue(String expectValue) {
    this.expectValue = expectValue;
  }

  @JsonGetter(Flag.SoftMasking)
  public Boolean getSoftMasking() {
    return softMasking;
  }

  @JsonSetter(Flag.SoftMasking)
  public void setSoftMasking(Boolean softMasking) {
    this.softMasking = softMasking;
  }

  @JsonGetter(Flag.LowercaseMasking)
  public Boolean getLowercaseMasking() {
    return lowercaseMasking;
  }

  @JsonSetter(Flag.LowercaseMasking)
  public void setLowercaseMasking(Boolean lowercaseMasking) {
    this.lowercaseMasking = lowercaseMasking;
  }

  @JsonGetter(Flag.EntrezQuery)
  public String getEntrezQuery() {
    return entrezQuery;
  }

  @JsonSetter(Flag.EntrezQuery)
  public void setEntrezQuery(String entrezQuery) {
    this.entrezQuery = entrezQuery;
  }

  @JsonGetter(Flag.QueryCoverageHSPPercent)
  public Double getQueryCoverageHSPPercent() {
    return queryCoverageHSPPercent;
  }

  @JsonSetter(Flag.QueryCoverageHSPPercent)
  public void setQueryCoverageHSPPercent(Double queryCoverageHSPPercent) {
    this.queryCoverageHSPPercent = queryCoverageHSPPercent;
  }

  @JsonGetter(Flag.MaxHSPs)
  public Long getMaxHSPs() {
    return maxHSPs;
  }

  @JsonSetter(Flag.MaxHSPs)
  public void setMaxHSPs(Long maxHSPs) {
    this.maxHSPs = maxHSPs;
  }

  @JsonGetter(Flag.DBSize)
  public Byte getDBSize() {
    return dbSize;
  }

  @JsonSetter(Flag.DBSize)
  public void setDBSize(Byte dbSize) {
    this.dbSize = dbSize;
  }

  @JsonGetter(Flag.SearchSpace)
  public Short getSearchSpace() {
    return searchSpace;
  }

  @JsonSetter(Flag.SearchSpace)
  public void setSearchSpace(Short searchSpace) {
    this.searchSpace = searchSpace;
  }

  @JsonGetter(Flag.ImportSearchStrategy)
  public String getImportSearchStrategy() {
    return importSearchStrategy;
  }

  @JsonSetter(Flag.ImportSearchStrategy)
  public void setImportSearchStrategy(String importSearchStrategy) {
    this.importSearchStrategy = importSearchStrategy;
  }

  @JsonGetter(Flag.ExportSearchStrategy)
  public String getExportSearchStrategy() {
    return exportSearchStrategy;
  }

  @JsonSetter(Flag.ExportSearchStrategy)
  public void setExportSearchStrategy(String exportSearchStrategy) {
    this.exportSearchStrategy = exportSearchStrategy;
  }

  @JsonGetter(Flag.ExtensionDropoffUngapped)
  public Double getExtensionDropoffUngapped() {
    return extensionDropoffUngapped;
  }

  @JsonSetter(Flag.ExtensionDropoffUngapped)
  public void setExtensionDropoffUngapped(Double extensionDropoffUngapped) {
    this.extensionDropoffUngapped = extensionDropoffUngapped;
  }

  @JsonGetter(Flag.WindowSize)
  public Long getWindowSize() {
    return windowSize;
  }

  @JsonSetter(Flag.WindowSize)
  public void setWindowSize(Long windowSize) {
    this.windowSize = windowSize;
  }

  @JsonGetter(Flag.Remote)
  public Boolean getRemote() {
    return remote;
  }

  @JsonSetter(Flag.Remote)
  public void setRemote(Boolean remote) {
    this.remote = remote;
  }
}
