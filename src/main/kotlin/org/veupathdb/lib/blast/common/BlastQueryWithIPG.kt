package org.veupathdb.lib.blast.common

import org.veupathdb.lib.blast.common.fields.IPGList
import org.veupathdb.lib.blast.common.fields.NegativeIPGList

interface BlastQueryWithIPG : BlastQueryWithLists {

  /**
   * -ipglist
   *
   * Restrict search of database to list of IPGs
   */
  var ipgListFile: IPGList

  /**
   * -negative_ipglist
   *
   * Restrict search of database to everything except the specified IPGs
   */
  var negativeIPGListFile: NegativeIPGList
}