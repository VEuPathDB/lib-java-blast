package org.veupathdb.lib.blast

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Flag
import org.veupathdb.lib.blast.consts.Key
import org.veupathdb.lib.blast.field.*
import kotlin.reflect.KClass

@DisplayName("BlastConfig")
abstract class BlastConfigContractTest {
  abstract fun newConfig(): BlastConfig
  abstract fun configClass(): KClass<out BlastConfig>

  @Nested
  @DisplayName("#getTool()")
  internal inner class GetTool1 {
    @Test
    @DisplayName("Does not return null")
    fun test1() {
      Assertions.assertNotNull(newConfig().tool)
    }
  }

  @Nested
  @DisplayName("-h Flag")
  internal inner class ShortHelpFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.shortHelp = null
      Assertions.assertNull(test.shortHelp)
      var json = test.toJSON().toJSON()
      Assertions.assertFalse(json.has(Flag.ShortHelp))
      test.shortHelp = true
      Assertions.assertTrue(test.shortHelp!!)
      json = test.toJSON().toJSON()
      Assertions.assertTrue(json.has(Flag.ShortHelp))
      Assertions.assertTrue(json[Flag.ShortHelp].isBoolean)
      Assertions.assertTrue(json[Flag.ShortHelp].booleanValue())
      test.shortHelp = false
      Assertions.assertFalse(test.shortHelp!!)
      json = test.toJSON().toJSON()
      Assertions.assertFalse(json.has(Flag.ShortHelp))
    }
  }

  @Nested
  @DisplayName("-help Flag")
  internal inner class LongHelpFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.longHelp = null
      Assertions.assertNull(test.longHelp)
      var json = test.toJSON().toJSON()
      Assertions.assertFalse(json.has(Flag.LongHelp))
      test.longHelp = true
      Assertions.assertTrue(test.longHelp!!)
      json = test.toJSON().toJSON()
      Assertions.assertTrue(json.has(Flag.LongHelp))
      Assertions.assertTrue(json[Flag.LongHelp].isBoolean)
      Assertions.assertTrue(json[Flag.LongHelp].booleanValue())
      test.longHelp = false
      Assertions.assertFalse(test.longHelp!!)
      json = test.toJSON().toJSON()
      Assertions.assertFalse(json.has(Flag.LongHelp))
    }
  }

  @Nested
  @DisplayName("-version Flag")
  internal inner class VersionFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.version = null
      Assertions.assertNull(test.version)
      var json = test.toJSON().toJSON()
      Assertions.assertFalse(json.has(Flag.Version))
      test.version = true
      Assertions.assertTrue(test.version!!)
      json = test.toJSON().toJSON()
      Assertions.assertTrue(json.has(Flag.Version))
      Assertions.assertTrue(json[Flag.Version].isBoolean)
      Assertions.assertTrue(json[Flag.Version].booleanValue())
      test.version = false
      Assertions.assertFalse(test.version!!)
      json = test.toJSON().toJSON()
      Assertions.assertFalse(json.has(Flag.Version))
    }
  }

  @Nested
  @DisplayName("-out Flag")
  internal inner class OutFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.outFile = null
      Assertions.assertNull(test.outFile)
      var json = test.toJSON().toJSON()
      Assertions.assertFalse(json.has(Flag.OutFile))
      test.outFile = OutFile("Hello")
      Assertions.assertEquals("Hello", test.outFile)
      json = test.toJSON().toJSON()
      Assertions.assertTrue(json.has(Flag.OutFile))
      Assertions.assertTrue(json[Flag.OutFile].isTextual)
      Assertions.assertEquals("Hello", json[Flag.OutFile].textValue())
    }
  }

  @Nested
  @DisplayName("-outfmt Flag")
  internal inner class OutFmt {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.outFormat = null
      Assertions.assertNull(test.outFormat)
      var json = test.toJSON().toJSON()
      Assertions.assertFalse(json.has(Flag.OutFormat))
      test.outFormat = OutFormat()
      Assertions.assertNotNull(test.outFormat)
      json = test.toJSON().toJSON()
      Assertions.assertFalse(json.has(Flag.OutFormat))
      val outFmt = OutFormat()
      outFmt.delimiter = "@"
      test.outFormat = outFmt
      Assertions.assertNotNull(test.outFormat)
      json = test.toJSON().toJSON()
      Assertions.assertTrue(json.has(Flag.OutFormat))
      Assertions.assertTrue(json[Flag.OutFormat].isObject)
      Assertions.assertEquals(1, json[Flag.OutFormat].size())
      Assertions.assertTrue(json[Flag.OutFormat].has(Key.Delimiter))
      Assertions.assertTrue(json[Flag.OutFormat][Key.Delimiter].isTextual)
      Assertions.assertEquals("@", json[Flag.OutFormat][Key.Delimiter].textValue())
    }
  }

  @Nested
  @DisplayName(Flag.ShowGIs)
  internal inner class ShowGIsFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.showGIs = null
      Assertions.assertNull(test.showGIs)
      test.showGIs = true
      Assertions.assertTrue(test.showGIs!!)
      test.showGIs = false
      Assertions.assertFalse(test.showGIs!!)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input1 = "{\"-show_gis\": true}"
      val test1 = JSON.readValue(input1, configClass().java)!!
      Assertions.assertTrue(test1.showGIs!!)
      val input2 = "{\"-show_gis\": false}"
      val test2 = JSON.readValue(input2, configClass().java)!!
      Assertions.assertFalse(test2.showGIs!!)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val test1 = newConfig()
      Assertions.assertEquals("{}", JSON.writeValueAsString(test1))
      test1.showGIs = true
      Assertions.assertEquals("{\"-show_gis\":true}", JSON.writeValueAsString(test1))
      test1.showGIs = false
      Assertions.assertEquals("{}", JSON.writeValueAsString(test1))
    }
  }

  @Nested
  @DisplayName(Flag.NumDescriptions)
  internal inner class NumDescriptionsFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.numDescriptions = null
      Assertions.assertNull(test.numDescriptions)
      test.numDescriptions = NumDescriptions(12L)
      Assertions.assertEquals(12, test.numDescriptions!!.value)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-num_descriptions\": 32}"
      val parsed = JSON.readValue(input, configClass().java)!!
      Assertions.assertEquals(32, parsed.numDescriptions!!.value)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.numDescriptions = NumDescriptions(69L)
      Assertions.assertEquals("{\"-num_descriptions\":69}", JSON.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.NumAlignments)
  internal inner class NumAlignmentsFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.numAlignments = null
      Assertions.assertNull(test.numAlignments)
      test.numAlignments = NumAlignments(12L)
      Assertions.assertEquals(12, test.numAlignments!!.value)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-num_alignments\": 32}"
      val parsed = JSON.readValue(input, configClass().java)!!
      Assertions.assertEquals(32, parsed.numAlignments!!.value)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.numAlignments = NumAlignments(69L)
      Assertions.assertEquals("{\"-num_alignments\":69}", JSON.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.LineLength)
  internal inner class LineLengthFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.lineLength = null
      Assertions.assertNull(test.lineLength)
      test.lineLength = LineLength(12)
      Assertions.assertEquals(12, test.lineLength!!.value)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input = "{\"-line_length\": 32}"
      val parsed = JSON.readValue(input, configClass().java)!!
      Assertions.assertEquals(32, parsed.lineLength!!.value)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val `object` = newConfig()
      `object`.lineLength = LineLength(69)
      Assertions.assertEquals("{\"-line_length\":69}", JSON.writeValueAsString(`object`))
    }
  }

  @Nested
  @DisplayName(Flag.HTML)
  internal inner class HTMLFlag {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.html = null
      Assertions.assertNull(test.html)
      test.html = true
      Assertions.assertTrue(test.html!!)
      test.html = false
      Assertions.assertFalse(test.html!!)
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val input1 = "{\"-html\": true}"
      val test1 = JSON.readValue(input1, configClass().java)!!
      Assertions.assertTrue(test1.html!!)
      val input2 = "{\"-html\": false}"
      val test2 = JSON.readValue(input2, configClass().java)!!
      Assertions.assertFalse(test2.html!!)
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      val test1 = newConfig()
      Assertions.assertEquals("{}", JSON.writeValueAsString(test1))
      test1.html = true
      Assertions.assertEquals("{\"-html\":true}", JSON.writeValueAsString(test1))
      test1.html = false
      Assertions.assertEquals("{}", JSON.writeValueAsString(test1))
    }
  }

  @Nested
  @DisplayName(Flag.SortHits)
  internal inner class SortHits {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.sortHits = null
      Assertions.assertNull(test.sortHits)
      for (hs in HitSorting.values()) {
        test.sortHits = hs
        Assertions.assertEquals(hs, test.sortHits)
      }
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val test = newConfig()
      for (`val` in HitSorting.values()) {
        test.sortHits = `val`
        Assertions.assertEquals(
          "{\"" + Flag.SortHits + "\":" + `val`.ordinal + "}",
          JSON.writeValueAsString(test)
        )
      }
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      for (`val` in HitSorting.values()) {
        val json = "{\"" + Flag.SortHits + "\":" + `val`.ordinal + "}"
        val test = JSON.readValue(json, configClass().java)!!
        Assertions.assertEquals(`val`, test.sortHits)
      }
    }
  }

  @Nested
  @DisplayName(Flag.SortHSPs)
  internal inner class SortHSPs {
    @Test
    @DisplayName("Can be configured")
    fun test1() {
      val test = newConfig()
      test.sortHSPs = null
      Assertions.assertNull(test.sortHSPs)
      for (hs in HSPSorting.values()) {
        test.sortHSPs = hs
        Assertions.assertEquals(hs, test.sortHSPs)
      }
    }

    @Test
    @DisplayName("Can be serialized")
    @Throws(
      JsonProcessingException::class)
    fun test2() {
      val test = newConfig()
      for (`val` in HSPSorting.values()) {
        test.sortHSPs = `val`
        Assertions.assertEquals(
          "{\"" + Flag.SortHSPs + "\":" + `val`.ordinal + "}",
          JSON.writeValueAsString(test)
        )
      }
    }

    @Test
    @DisplayName("Can be deserialized")
    @Throws(
      JsonProcessingException::class)
    fun test3() {
      for (`val` in HSPSorting.values()) {
        val json = "{\"" + Flag.SortHSPs + "\":" + `val`.ordinal + "}"
        val test = JSON.readValue(json, configClass().java)!!
        Assertions.assertEquals(`val`, test.sortHSPs)
      }
    }
  }

  companion object {
    private val JSON = ObjectMapper()
  }
}