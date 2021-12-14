package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Flag
import kotlin.reflect.KClass

@DisplayName("BlastWithIPGList")
internal abstract class BlastWithIPGListContractTest : BlastWithListsContractTest() {
  private val json = ObjectMapper()
  abstract override fun newConfig(): BlastWithIPGList
  abstract override fun configClass(): KClass<out BlastWithIPGList>

  @Nested
  @DisplayName(Flag.IPGList)
  internal inner class IPGList1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = newConfig()
      tgt.ipgList = "hi"
      Assertions.assertEquals("{\"-ipglist\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-ipglist\":\"hi\"}"
      val tgt = json.readValue(raw, configClass().java)
      Assertions.assertEquals("hi", tgt.ipgList)
    }
  }

  @Nested
  @DisplayName(Flag.NegativeIPGList)
  internal inner class NegativeIPGList1 {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = newConfig()
      tgt.negativeIPGList = "hi"
      Assertions.assertEquals("{\"-negative_ipglist\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-negative_ipglist\":\"hi\"}"
      val tgt = json.readValue(raw, configClass().java)
      Assertions.assertEquals("hi", tgt.negativeIPGList)
    }
  }
}