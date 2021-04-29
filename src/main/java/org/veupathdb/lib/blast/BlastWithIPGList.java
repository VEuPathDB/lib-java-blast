package org.veupathdb.lib.blast;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;

public class BlastWithIPGList extends BlastWithLists
{
  private String ipgList;
  private String negativeIPGList;

  @JsonGetter(Flag.IPGList)
  public String getIPGList() {
    return ipgList;
  }

  @JsonSetter(Flag.IPGList)
  public void setIPGList(String ipgList) {
    this.ipgList = ipgList;
  }

  @JsonGetter(Flag.NegativeIPGList)
  public String getNegativeIPGList() {
    return negativeIPGList;
  }

  @JsonGetter(Flag.NegativeIPGList)
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
}
