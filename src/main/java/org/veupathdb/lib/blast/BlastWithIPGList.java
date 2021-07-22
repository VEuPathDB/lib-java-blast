package org.veupathdb.lib.blast;

import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

import java.util.Objects;

public abstract class BlastWithIPGList extends BlastWithLists
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
    if (!(o instanceof BlastWithIPGList that)) return false;
    if (!super.equals(o)) return false;
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
  public JSONObjectEncoder toJSON(boolean includeTool) {
    final var out = super.toJSON(includeTool);

    out.encode(Flag.IPGList, getIPGList());
    out.encode(Flag.NegativeIPGList, getNegativeIPGList());

    return out;
  }

  @Override
  public void decodeJSON(JSONObjectDecoder node) {
    super.decodeJSON(node);

    node.decode(Flag.IPGList, this::setIPGList);
    node.decode(Flag.NegativeIPGList, this::setNegativeIPGList);
  }
}
