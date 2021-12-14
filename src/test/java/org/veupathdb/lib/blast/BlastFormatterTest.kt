package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.veupathdb.lib.blast.consts.Flag

@DisplayName("BlastFormatter")
internal class BlastFormatterTest {
  private val json = ObjectMapper()

  @Nested
  @DisplayName(Flag.RequestID)
  internal inner class RequestID {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastFormatter()
      tgt.requestID = "hi"
      Assertions.assertEquals("{\"-rid\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-rid\":\"hi\"}"
      val tgt = json.readValue(raw, BlastFormatter::class.java)
      Assertions.assertEquals("hi", tgt.requestID)
    }
  }

  @Nested
  @DisplayName(Flag.ArchiveFile)
  internal inner class ArchiveFile {
    @Test
    @DisplayName("serialization")
    @Throws(Exception::class)
    fun test1() {
      val tgt = BlastFormatter()
      tgt.archiveFile = "hi"
      Assertions.assertEquals("{\"-archive\":\"hi\"}", json.writeValueAsString(tgt))
    }

    @Test
    @DisplayName("deserialization")
    @Throws(Exception::class)
    fun test2() {
      val raw = "{\"-archive\":\"hi\"}"
      val tgt = json.readValue(raw, BlastFormatter::class.java)
      Assertions.assertEquals("hi", tgt.archiveFile)
    }
  }
}