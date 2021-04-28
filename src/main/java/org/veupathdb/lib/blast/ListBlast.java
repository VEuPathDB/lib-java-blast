package org.veupathdb.lib.blast;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;

class ListBlast extends BaseBlast
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
}
