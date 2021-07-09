package org.veupathdb.lib.blast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

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

  public String getGIList() {
    return giList;
  }

  public void setGIList(String giList) {
    this.giList = giList;
  }

  public String getSequenceIDList() {
    return sequenceIDList;
  }

  public void setSequenceIDList(String sequenceIDList) {
    this.sequenceIDList = sequenceIDList;
  }

  public String getNegativeGIList() {
    return negativeGIList;
  }

  public void setNegativeGIList(String negativeGIList) {
    this.negativeGIList = negativeGIList;
  }

  public String getNegativeSequenceIDList() {
    return negativeSequenceIDList;
  }

  public void setNegativeSequenceIDList(String negativeSequenceIDList) {
    this.negativeSequenceIDList = negativeSequenceIDList;
  }

  public List<String> getTaxIDs() {
    return taxIDs;
  }

  public void setTaxIDs(List<String> taxIDs) {
    this.taxIDs = taxIDs;
  }

  public List<String> getNegativeTaxIDs() {
    return negativeTaxIDs;
  }

  public void setNegativeTaxIDs(List<String> negativeTaxIDs) {
    this.negativeTaxIDs = negativeTaxIDs;
  }

  public String getTaxIDList() {
    return taxIDList;
  }

  public void setTaxIDList(String taxIDList) {
    this.taxIDList = taxIDList;
  }

  public String getNegativeTaxIDList() {
    return negativeTaxIDList;
  }

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

  @Override
  public BlastWithLists copy() {
    var out = new BlastWithLists();
    copyInto(out);
    return out;
  }

  @Override
  @JsonValue
  public JSONObjectEncoder toJSON() {
    var out = super.toJSON();

    out.encode(Flag.GIList, giList);
    out.encode(Flag.SequenceIDList, sequenceIDList);
    out.encode(Flag.NegativeGIList, negativeGIList);
    out.encode(Flag.NegativeSequenceIDList, negativeSequenceIDList);
    out.encode(Flag.TaxIDs, taxIDs);
    out.encode(Flag.NegativeTaxIDs, negativeTaxIDs);
    out.encode(Flag.TaxIDList, taxIDList);
    out.encode(Flag.NegativeTaxIDList, negativeTaxIDList);

    return out;
  }

  @JsonCreator
  public static BlastWithLists fromJSON(JSONObjectDecoder js) {
    var out = new BlastWithLists();
    out.copyInto(js);
    return out;
  }

  protected void copyInto(BlastWithLists out) {
    super.copyInto(out);
    out.giList = giList;
    out.sequenceIDList = sequenceIDList;
    out.negativeGIList = negativeGIList;
    out.negativeSequenceIDList = negativeSequenceIDList;
    if (taxIDs != null)
      out.taxIDs = new ArrayList<>(taxIDs);
    if (negativeTaxIDs != null)
      out.negativeTaxIDs = new ArrayList<>(negativeTaxIDs);
    out.taxIDList = taxIDList;
    out.negativeTaxIDList = negativeTaxIDList;
  }

  @Override
  protected void copyInto(JSONObjectDecoder js) {
    super.copyInto(js);

    js.decode(Flag.GIList, this::setGIList);
    js.decode(Flag.SequenceIDList, this::setSequenceIDList);
    js.decode(Flag.NegativeGIList, this::setNegativeGIList);
    js.decode(Flag.NegativeSequenceIDList, this::setNegativeSequenceIDList);
    js.decode(Flag.TaxIDs, this::setTaxIDs);
    js.decode(Flag.NegativeTaxIDs, this::setNegativeTaxIDs);
    js.decode(Flag.TaxIDList, this::setTaxIDList);
    js.decode(Flag.NegativeTaxIDList, this::setNegativeTaxIDList);
  }
}
