package org.veupathdb.lib.blast;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Flag;

class IPGListBlast extends ListBlast
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
}
