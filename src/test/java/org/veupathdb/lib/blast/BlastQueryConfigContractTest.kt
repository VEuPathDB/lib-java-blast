package org.veupathdb.lib.blast

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.field.ExpectValue
import org.veupathdb.lib.blast.field.Location
import org.veupathdb.lib.blast.field.QueryFile
import kotlin.reflect.KClass

@DisplayName("BlastQueryConfig")
abstract class BlastQueryConfigContractTest : BlastConfigContractTest() {
  abstract override fun newConfig(): BlastQueryConfig
  abstract override fun configClass(): KClass<out BlastQueryConfig>

  @Nested
  @DisplayName(Flag.QueryFile)
  internal inner class QueryFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.queryFile = null
      Assertions.assertNull(test.queryFile)
      test.queryFile = QueryFile("hello")
      Assertions.assertEquals("hello", test.queryFile)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-query\": \"hello\"}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals("hello", parsed.queryFile)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.queryFile = QueryFile("goodbye")
      Assertions.assertEquals("{\"-query\":\"goodbye\"}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.QueryLocation)
  internal inner class QueryLocationFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.queryLocation = null
      Assertions.assertNull(test.queryLocation)
      test.queryLocation = Location(10, 12)
      Assertions.assertEquals(Location(10, 12), test.queryLocation)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-query_loc\": {\"start\": 10,\"stop\": 12}}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals(Location(10, 12), parsed.queryLocation)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.queryLocation = Location(10, 12)
      Assertions.assertEquals("{\"-query_loc\":{\"start\":10,\"stop\":12}}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.DBFile)
  internal inner class DBFileFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.dbFile = null
      Assertions.assertNull(test.dbFile)
      test.dbFile = "yelp"
      Assertions.assertEquals("yelp", test.dbFile)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-db\": \"yellow\"}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals("yellow", parsed.dbFile)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.dbFile = "harps"
      Assertions.assertEquals("{\"-db\":\"harps\"}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.ExpectValue)
  internal inner class ExpectValueFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.expectValue = null
      Assertions.assertNull(test.expectValue)
      test.expectValue = ExpectValue("yelp")
      Assertions.assertEquals(ExpectValue("yelp"), test.expectValue)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-evalue\": \"yellow\"}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals("yellow", parsed.expectValue)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.expectValue = ExpectValue("harps")
      Assertions.assertEquals("{\"-evalue\":\"harps\"}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.SoftMasking)
  internal inner class SoftMaskingFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.softMasking = null
      Assertions.assertNull(test.softMasking)
      test.softMasking = true
      Assertions.assertTrue(test.softMasking!!)
      test.softMasking = false
      Assertions.assertFalse(test.softMasking!!)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input1 = "{\"-soft_masking\": true}"
      val test1 = json.readValue(input1, configClass().java)!!
      Assertions.assertTrue(test1.softMasking!!)
      val input2 = "{\"-soft_masking\": false}"
      val test2 = json.readValue(input2, configClass().java)!!
      Assertions.assertFalse(test2.softMasking!!)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val test1 = newConfig()
      Assertions.assertEquals("{}", json.writeValueAsString(test1))
      test1.softMasking = true
      Assertions.assertEquals("{\"-soft_masking\":true}", json.writeValueAsString(test1))
      test1.softMasking = false
      Assertions.assertEquals("{}", json.writeValueAsString(test1))
    }
  }

  @Nested
  @DisplayName(Flag.LowercaseMasking)
  internal inner class LowercaseMaskingFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.lowercaseMasking = null
      Assertions.assertNull(test.lowercaseMasking)
      test.lowercaseMasking = true
      Assertions.assertTrue(test.lowercaseMasking!!)
      test.lowercaseMasking = false
      Assertions.assertFalse(test.lowercaseMasking!!)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input1 = "{\"-lcase_masking\": true}"
      val test1 = json.readValue(input1, configClass().java)!!
      Assertions.assertTrue(test1.lowercaseMasking!!)
      val input2 = "{\"-lcase_masking\": false}"
      val test2 = json.readValue(input2, configClass().java)!!
      Assertions.assertFalse(test2.lowercaseMasking!!)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val test1 = newConfig()
      Assertions.assertEquals("{}", json.writeValueAsString(test1))
      test1.lowercaseMasking = true
      Assertions.assertEquals("{\"-lcase_masking\":true}", json.writeValueAsString(test1))
      test1.lowercaseMasking = false
      Assertions.assertEquals("{}", json.writeValueAsString(test1))
    }
  }

  @Nested
  @DisplayName(Flag.EntrezQuery)
  internal inner class EntrezQueryFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.entrezQuery = null
      Assertions.assertNull(test.entrezQuery)
      test.entrezQuery = "yelp"
      Assertions.assertEquals("yelp", test.entrezQuery)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-entrez_query\": \"yellow\"}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals("yellow", parsed.entrezQuery)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.entrezQuery = "harps"
      Assertions.assertEquals("{\"-entrez_query\":\"harps\"}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.QueryCoverageHSPPercent)
  internal inner class QueryCoverageHSPPercentFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.queryCoverageHSPPercent = null
      Assertions.assertNull(test.queryCoverageHSPPercent)
      test.queryCoverageHSPPercent = 12.34
      Assertions.assertEquals(12.34, test.queryCoverageHSPPercent)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-qcov_hsp_perc\": 32.12}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals(32.12, parsed.queryCoverageHSPPercent)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.queryCoverageHSPPercent = 69.69
      Assertions.assertEquals("{\"-qcov_hsp_perc\":69.69}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.MaxHSPs)
  internal inner class MaxHSPsFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.maxHSPs = null
      Assertions.assertNull(test.maxHSPs)
      test.maxHSPs = 12L
      Assertions.assertEquals(12, test.maxHSPs)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-max_hsps\": 32}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals(32, parsed.maxHSPs)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.maxHSPs = 69L
      Assertions.assertEquals("{\"-max_hsps\":69}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.DBSize)
  internal inner class DBSizeFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.dbSize = null
      Assertions.assertNull(test.dbSize)
      test.dbSize = 12.toByte()
      Assertions.assertEquals(12.toByte(), test.dbSize)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-dbsize\": 32}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals(32.toByte(), parsed.dbSize)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.dbSize = 69.toByte()
      Assertions.assertEquals("{\"-dbsize\":69}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.SearchSpace)
  internal inner class SearchSpaceFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.searchSpace = null
      Assertions.assertNull(test.searchSpace)
      test.searchSpace = 12.toShort()
      Assertions.assertEquals(12.toShort(), test.searchSpace)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-searchsp\": 32}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals(32.toShort(), parsed.searchSpace)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.searchSpace = 69.toShort()
      Assertions.assertEquals("{\"-searchsp\":69}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.ImportSearchStrategy)
  internal inner class ImportSearchStrategyFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.importSearchStrategy = null
      Assertions.assertNull(test.importSearchStrategy)
      test.importSearchStrategy = "yelp"
      Assertions.assertEquals("yelp", test.importSearchStrategy)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-import_search_strategy\": \"yellow\"}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals("yellow", parsed.importSearchStrategy)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.importSearchStrategy = "harps"
      Assertions.assertEquals("{\"-import_search_strategy\":\"harps\"}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.ExportSearchStrategy)
  internal inner class ExportSearchStrategyFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.exportSearchStrategy = null
      Assertions.assertNull(test.exportSearchStrategy)
      test.exportSearchStrategy = "yelp"
      Assertions.assertEquals("yelp", test.exportSearchStrategy)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-export_search_strategy\": \"yellow\"}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals("yellow", parsed.exportSearchStrategy)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.exportSearchStrategy = "harps"
      Assertions.assertEquals("{\"-export_search_strategy\":\"harps\"}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.ExtensionDropoffUngapped)
  internal inner class ExtensionDropoffUngappedFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.extensionDropoffUngapped = null
      Assertions.assertNull(test.extensionDropoffUngapped)
      test.extensionDropoffUngapped = 12.34
      Assertions.assertEquals(12.34, test.extensionDropoffUngapped)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-xdrop_ungap\": 32.12}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals(32.12, parsed.extensionDropoffUngapped)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.extensionDropoffUngapped = 69.69
      Assertions.assertEquals("{\"-xdrop_ungap\":69.69}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.WindowSize)
  internal inner class WindowSizeFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.windowSize = null
      Assertions.assertNull(test.windowSize)
      test.windowSize = 12L
      Assertions.assertEquals(12, test.windowSize)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-window_size\": 32}"
      val parsed = json.readValue(input, configClass().java)!!
      Assertions.assertEquals(32, parsed.windowSize)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.windowSize = 69L
      Assertions.assertEquals("{\"-window_size\":69}", json.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.Remote)
  internal inner class RemoteFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.remote = null
      Assertions.assertNull(test.remote)
      test.remote = true
      Assertions.assertTrue(test.remote!!)
      test.remote = false
      Assertions.assertFalse(test.remote!!)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input1 = "{\"-remote\": true}"
      val test1 = json.readValue(input1, configClass().java)!!
      Assertions.assertTrue(test1.remote!!)
      val input2 = "{\"-remote\": false}"
      val test2 = json.readValue(input2, configClass().java)!!
      Assertions.assertFalse(test2.remote!!)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val test1 = newConfig()
      Assertions.assertEquals("{}", json.writeValueAsString(test1))
      test1.remote = true
      Assertions.assertEquals("{\"-remote\":true}", json.writeValueAsString(test1))
      test1.remote = false
      Assertions.assertEquals("{}", json.writeValueAsString(test1))
    }
  }

  companion object {
    private val json = ObjectMapper()
  }
}