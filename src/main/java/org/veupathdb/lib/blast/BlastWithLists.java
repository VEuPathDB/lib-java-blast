package org.veupathdb.lib.blast;

import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

import java.util.List;
import java.util.Objects;

public abstract class BlastWithLists extends BlastBase
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
    if (!(o instanceof BlastWithLists that)) return false;
    if (!super.equals(o)) return false;
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
  public JSONObjectEncoder toJSON(boolean includeTool) {
    final var out = super.toJSON(includeTool);

    out.encode(Flag.GIList, getGIList());
    out.encode(Flag.SequenceIDList, getSequenceIDList());
    out.encode(Flag.NegativeGIList, getNegativeGIList());
    out.encode(Flag.NegativeSequenceIDList, getNegativeSequenceIDList());
    out.encode(Flag.TaxIDs, getTaxIDs());
    out.encode(Flag.NegativeTaxIDs, getNegativeTaxIDs());
    out.encode(Flag.TaxIDList, getTaxIDList());
    out.encode(Flag.NegativeTaxIDList, getNegativeTaxIDList());

    return out;
  }

  @Override
  public void decodeJSON(JSONObjectDecoder node) {
    super.decodeJSON(node);

    node.decode(Flag.GIList, this::setGIList);
    node.decode(Flag.SequenceIDList, this::setSequenceIDList);
    node.decode(Flag.NegativeGIList, this::setNegativeGIList);
    node.decode(Flag.NegativeSequenceIDList, this::setNegativeSequenceIDList);
    node.decode(Flag.TaxIDs, this::setTaxIDs);
    node.decode(Flag.NegativeTaxIDs, this::setNegativeTaxIDs);
    node.decode(Flag.TaxIDList, this::setTaxIDList);
    node.decode(Flag.NegativeTaxIDList, this::setNegativeTaxIDList);
  }
}
