package org.veupathdb.lib.blast;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;

public class BlastWithLists extends BlastBase
{
  private String       giList;
  private String       sequenceIDList;
  private String       negativeGIList;
  private String       negativeSequenceIDList;
  private List<String> taxIDs;
  private List<String> negativeTaxIDs;
  private String       taxIDList;
  private String       negativeTaxIDList;

  @JsonGetter(Flag.GIList)
  public String getGIList() {
    return giList;
  }

  @JsonSetter(Flag.GIList)
  public void setGIList(String giList) {
    this.giList = giList;
  }

  @JsonGetter(Flag.SequenceIDList)
  public String getSequenceIDList() {
    return sequenceIDList;
  }

  @JsonSetter(Flag.SequenceIDList)
  public void setSequenceIDList(String sequenceIDList) {
    this.sequenceIDList = sequenceIDList;
  }

  @JsonGetter(Flag.NegativeGIList)
  public String getNegativeGIList() {
    return negativeGIList;
  }

  @JsonSetter(Flag.NegativeGIList)
  public void setNegativeGIList(String negativeGIList) {
    this.negativeGIList = negativeGIList;
  }

  @JsonGetter(Flag.NegativeSequenceIDList)
  public String getNegativeSequenceIDList() {
    return negativeSequenceIDList;
  }

  @JsonSetter(Flag.NegativeSequenceIDList)
  public void setNegativeSequenceIDList(String negativeSequenceIDList) {
    this.negativeSequenceIDList = negativeSequenceIDList;
  }

  @JsonGetter(Flag.TaxIDs)
  public List<String> getTaxIDs() {
    return taxIDs;
  }

  @JsonSetter(Flag.TaxIDs)
  public void setTaxIDs(List<String> taxIDs) {
    this.taxIDs = taxIDs;
  }

  @JsonGetter(Flag.NegativeTaxIDs)
  public List<String> getNegativeTaxIDs() {
    return negativeTaxIDs;
  }

  @JsonSetter(Flag.NegativeTaxIDs)
  public void setNegativeTaxIDs(List<String> negativeTaxIDs) {
    this.negativeTaxIDs = negativeTaxIDs;
  }

  @JsonGetter(Flag.TaxIDList)
  public String getTaxIDList() {
    return taxIDList;
  }

  @JsonSetter(Flag.TaxIDList)
  public void setTaxIDList(String taxIDList) {
    this.taxIDList = taxIDList;
  }

  @JsonGetter(Flag.NegativeTaxIDList)
  public String getNegativeTaxIDList() {
    return negativeTaxIDList;
  }

  @JsonSetter(Flag.NegativeTaxIDList)
  public void setNegativeTaxIDList(String negativeTaxIDList) {
    this.negativeTaxIDList = negativeTaxIDList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BlastWithLists)) return false;
    if (!super.equals(o)) return false;
    BlastWithLists that = (BlastWithLists) o;
    return Objects.equals(giList, that.giList)
      && Objects.equals(getSequenceIDList(), that.getSequenceIDList())
      && Objects.equals(getNegativeGIList(), that.getNegativeGIList())
      && Objects.equals(getNegativeSequenceIDList(), that.getNegativeSequenceIDList())
      && Objects.equals(getTaxIDs(), that.getTaxIDs())
      && Objects.equals(getNegativeTaxIDs(), that.getNegativeTaxIDs())
      && Objects.equals(getTaxIDList(), that.getTaxIDList())
      && Objects.equals(getNegativeTaxIDList(), that.getNegativeTaxIDList());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      super.hashCode(),
      getGIList(),
      getSequenceIDList(),
      getNegativeGIList(),
      getNegativeSequenceIDList(),
      getTaxIDs(),
      getNegativeTaxIDs(),
      getTaxIDList(),
      getNegativeTaxIDList()
    );
  }
}
