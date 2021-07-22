package org.veupathdb.lib.blast;

import org.veupathdb.lib.blast.field.ExpectValue;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.QueryFile;

import java.util.Objects;

public abstract class BlastBase extends CLIBase implements BlastQueryConfig
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

  public QueryFile getQueryFile() {
    return queryFile == null ? null : new QueryFile(queryFile);
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

  public ExpectValue getExpectValue() {
    return expectValue == null ? null : new ExpectValue(expectValue);
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
    if (!(o instanceof BlastBase blastBase)) return false;
    if (!super.equals(o)) return false;
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
}
