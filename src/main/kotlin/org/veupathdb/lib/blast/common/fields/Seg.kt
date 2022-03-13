package org.veupathdb.lib.blast.common.fields

import org.veupathdb.lib.blast.serial.BlastField

interface Seg : BlastField {
  val isYes: Boolean

  val isNo: Boolean

  val window: Int

  val locut: Double

  val hicut: Double
}