package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.field.FormatField.BitScore
import org.veupathdb.lib.blast.field.FormatType.Pairwise
import org.veupathdb.lib.blast.field.FormatType.Tabular

@DisplayName("OutFormat")
internal class OutFormatTest {
  private val json = ObjectMapper()
  @Test
  @DisplayName("format serialization")
  @Throws(Exception::class)
  fun test1() {
    val tgt = OutFormat()
    Assertions.assertEquals("{}", json.writeValueAsString(tgt))
    tgt.type = Pairwise
    Assertions.assertEquals("{\"type\":0}", json.writeValueAsString(tgt))
    tgt.delimiter = "@"
    Assertions.assertEquals("{\"type\":0,\"delimiter\":\"@\"}", json.writeValueAsString(tgt))
    tgt.fields.add(BitScore)
    Assertions.assertEquals("{\"type\":0,\"delimiter\":\"@\",\"fields\":[\"bitscore\"]}", json.writeValueAsString(tgt))
  }

  @Test
  @DisplayName("format deserialization")
  @Throws(Exception::class)
  fun test2() {
    var raw = "{}"
    var tgt = json.readValue(raw, OutFormat::class.java)
    Assertions.assertNull(tgt.type)
    Assertions.assertNull(tgt.delimiter)
    Assertions.assertTrue(tgt.fields.isEmpty())
    raw = "{\"type\":6}"
    tgt = json.readValue(raw, OutFormat::class.java)
    Assertions.assertEquals(Tabular, tgt.type)
    Assertions.assertNull(tgt.delimiter)
    Assertions.assertTrue(tgt.fields.isEmpty())
    raw = "{\"type\":6,\"delimiter\":\"$\"}"
    tgt = json.readValue(raw, OutFormat::class.java)
    Assertions.assertEquals(Tabular, tgt.type)
    Assertions.assertEquals("$", tgt.delimiter)
    Assertions.assertTrue(tgt.fields.isEmpty())
    raw = "{\"type\":6,\"delimiter\":\"$\",\"fields\":[\"bitscore\"]}"
    tgt = json.readValue(raw, OutFormat::class.java)
    Assertions.assertEquals(Tabular, tgt.type)
    Assertions.assertEquals("$", tgt.delimiter)
    Assertions.assertEquals(1, tgt.fields.size)
    Assertions.assertEquals(BitScore, tgt.fields[0])
  }
}