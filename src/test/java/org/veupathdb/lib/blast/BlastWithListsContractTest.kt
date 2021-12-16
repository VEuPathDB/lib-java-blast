package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Flag
import kotlin.reflect.KClass

@DisplayName("BlastWithLists")
internal abstract class BlastWithListsContractTest : BlastQueryConfigContractTest() {
  abstract override fun newConfig(): BlastWithLists
  abstract override fun configClass(): KClass<out BlastWithLists>
  private val json = ObjectMapper()

  @Nested
  @DisplayName(Flag.GIList)
  internal inner class GIList1 {
    @Test
    @DisplayName("serialization")
    fun test1() {
      val tgt = newConfig()
      tgt.giList = "hi"
      Assertions.assertEquals("{\"-gilist\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    fun test2() {
      val raw = "{\"-gilist\":\"hi\"}"
      val tgt = json.readValue(raw, configClass().java)
      Assertions.assertEquals("hi", tgt.giList)
    }
  }

  @Nested
  @DisplayName(Flag.SequenceIDList)
  internal inner class SequenceIDList1 {
    @Test
    @DisplayName("serialization")
    fun test1() {
      val tgt = newConfig()
      tgt.sequenceIDList = "hi"
      Assertions.assertEquals("{\"-seqidlist\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    fun test2() {
      val raw = "{\"-seqidlist\":\"hi\"}"
      val tgt = json.readValue(raw, configClass().java)
      Assertions.assertEquals("hi", tgt.sequenceIDList)
    }
  }

  @Nested
  @DisplayName(Flag.NegativeGIList)
  internal inner class NegativeGIList1 {
    @Test
    @DisplayName("serialization")
    fun test1() {
      val tgt = newConfig()
      tgt.negativeGIList = "hi"
      Assertions.assertEquals("{\"-negative_gilist\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    fun test2() {
      val raw = "{\"-negative_gilist\":\"hi\"}"
      val tgt = json.readValue(raw, configClass().java)
      Assertions.assertEquals("hi", tgt.negativeGIList)
    }
  }

  @Nested
  @DisplayName(Flag.NegativeSequenceIDList)
  internal inner class NegativeSequenceIDList1 {
    @Test
    @DisplayName("serialization")
    fun test1() {
      val tgt = newConfig()
      tgt.negativeSequenceIDList = "hi"
      Assertions.assertEquals("{\"-negative_seqidlist\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    fun test2() {
      val raw = "{\"-negative_seqidlist\":\"hi\"}"
      val tgt = json.readValue(raw, configClass().java)
      Assertions.assertEquals("hi", tgt.negativeSequenceIDList)
    }
  }

  @Nested
  @DisplayName(Flag.TaxIDs)
  internal inner class TaxIDs1 {
    @Test
    @DisplayName("serialization")
    fun test1() {
      val tgt = newConfig()
      val list = ArrayList<String>()
      list.add("hi")
      tgt.taxIDs = list
      Assertions.assertEquals("{\"-taxids\":[\"hi\"]}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    fun test2() {
      val raw = "{\"-taxids\":[\"hi\"]}"
      val tgt = json.readValue(raw, configClass().java)
      Assertions.assertNotNull(tgt.taxIDs)
      Assertions.assertEquals(1, tgt.taxIDs!!.size)
      Assertions.assertEquals("hi", tgt.taxIDs!![0])
    }
  }

  @Nested
  @DisplayName(Flag.NegativeTaxIDs)
  internal inner class NegativeTaxIDs1 {
    @Test
    @DisplayName("serialization")
    fun test1() {
      val tgt = newConfig()
      val list = ArrayList<String>()
      list.add("hi")
      tgt.negativeTaxIDs = list
      Assertions.assertEquals("{\"-negative_taxids\":[\"hi\"]}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    fun test2() {
      val raw = "{\"-negative_taxids\":[\"hi\"]}"
      val tgt = json.readValue(raw, configClass().java)
      Assertions.assertNotNull(tgt.negativeTaxIDs)
      Assertions.assertEquals(1, tgt.negativeTaxIDs!!.size)
      Assertions.assertEquals("hi", tgt.negativeTaxIDs!![0])
    }
  }

  @Nested
  @DisplayName(Flag.TaxIDList)
  internal inner class TaxIDList1 {
    @Test
    @DisplayName("serialization")
    fun test1() {
      val tgt = newConfig()
      tgt.taxIDList = "hi"
      Assertions.assertEquals("{\"-taxidlist\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    fun test2() {
      val raw = "{\"-taxidlist\":\"hi\"}"
      val tgt = json.readValue(raw, configClass().java)
      Assertions.assertEquals("hi", tgt.taxIDList)
    }
  }

  @Nested
  @DisplayName(Flag.NegativeTaxIDList)
  internal inner class NegativeTaxIDList1 {
    @Test
    @DisplayName("serialization")
    fun test1() {
      val tgt = newConfig()
      tgt.negativeTaxIDList = "hi"
      Assertions.assertEquals("{\"-negative_taxidlist\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    fun test2() {
      val raw = "{\"-negative_taxidlist\":\"hi\"}"
      val tgt = json.readValue(raw, configClass().java)
      Assertions.assertEquals("hi", tgt.negativeTaxIDList)
    }
  }
}