package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

public class BlastWithIPGList extends BlastWithLists
{
  private String ipgList;
  private String negativeIPGList;

  public String getIPGList() {
    return ipgList;
  }

  public void setIPGList(String ipgList) {
    this.ipgList = ipgList;
  }

  public String getNegativeIPGList() {
    return negativeIPGList;
  }

  public void setNegativeIPGList(String negativeIPGList) {
    this.negativeIPGList = negativeIPGList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BlastWithIPGList)) return false;
    if (!super.equals(o)) return false;
    BlastWithIPGList that = (BlastWithIPGList) o;
    return Objects.equals(ipgList, that.ipgList) && Objects.equals(
      getNegativeIPGList(),
      that.getNegativeIPGList()
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), ipgList, getNegativeIPGList());
  }

  @Override
  public BlastWithIPGList copy() {
    var out = new BlastWithIPGList();
    copyInto(out);
    return out;
  }

  @Override
  @JsonValue
  public JSONObjectEncoder toJSON() {
    var out = super.toJSON();

    out.encode(Flag.IPGList, ipgList);
    out.encode(Flag.NegativeIPGList, negativeIPGList);

    return out;
  }

  @JsonCreator
  public static BlastWithIPGList fromJSON(JSONObjectDecoder json) {
    var out = new BlastWithIPGList();
    out.copyInto(json);
    return out;
  }

  protected void copyInto(BlastWithIPGList out) {
    super.copyInto(out);
    out.ipgList         = ipgList;
    out.negativeIPGList = negativeIPGList;
  }

  @Override
  protected void copyInto(JSONObjectDecoder js) {
    super.copyInto(js);

    js.decode(Flag.IPGList, this::setIPGList);
    js.decode(Flag.NegativeIPGList, this::setNegativeIPGList);
  }
}
