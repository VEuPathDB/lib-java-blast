package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.MethodSource
import org.veupathdb.lib.blast.field.BlastPTask.Companion.fromJSON
import org.veupathdb.lib.blast.field.BlastPTask.Companion.fromString
import org.veupathdb.lib.blast.util.JSONConstructor.newInt
import org.veupathdb.lib.blast.util.JSONConstructor.newText
import java.util.*
import java.util.stream.Stream

@DisplayName("BlastPTask")
class BlastPTaskTest {
  fun jsonWrappedValues(): Stream<Arguments> {
    return Arrays.stream(BlastPTask.values())
      .map { bt: BlastPTask -> Arguments.of(bt, newText(bt.value)) }
  }

  fun textValues(): Stream<Arguments> {
    return Arrays.stream(BlastPTask.values())
      .map { bt: BlastPTask -> Arguments.of(bt, bt.value) }
  }

  @Nested
  @DisplayName("::fromJSON(JsonNode)")
  internal inner class FromJSON1 {
    @ParameterizedTest(name = "Correctly deserializes the JSON value \"{1}\" to {0}.")
    @MethodSource("org.veupathdb.lib.blast.field.BlastPTaskTest#jsonWrappedValues")
    fun test1(bt: BlastPTask?, js: JsonNode?) {
      Assertions.assertSame(bt, fromJSON(js!!))
    }

    @Test
    @DisplayName("Throws an IllegalArgumentException if the input JSON is not text")
    fun test2() {
      Assertions.assertThrows(
        IllegalArgumentException::class.java
      ) { fromJSON(newInt(3)) }
    }

    @Test
    @DisplayName("Throws an IllegalArgumentException if the JSON text does not match a valid BlastPTask value")
    fun test3() {
      Assertions.assertThrows(
        IllegalArgumentException::class.java
      ) { fromJSON(newText("hello")) }
    }
  }

  @Nested
  @DisplayName("::fromString(String)")
  internal inner class FromString1 {
    @ParameterizedTest(name = "Correctly matches the given value \"{1}\" to {0}.")
    @MethodSource("org.veupathdb.lib.blast.field.BlastPTaskTest#textValues")
    fun test1(bt: BlastPTask?, js: String?) {
      Assertions.assertSame(bt, fromString(js!!))
    }

    @Test
    @DisplayName("Throws an IllegalArgumentException if the given value is not a valid BlastPTask")
    fun test2() {
      Assertions.assertThrows(
        IllegalArgumentException::class.java
      ) { fromString("hello") }
    }
  }

  @Nested
  @DisplayName("#toJSON()")
  internal inner class ToJSON1 {
    @ParameterizedTest(name = "Correctly converts {0} to \"{1}\"")
    @EnumSource(BlastPTask::class)
    fun test1(bt: BlastPTask) {
      Assertions.assertEquals(bt.value, bt.toJSON().textValue())
    }
  }

  @Nested
  @DisplayName("Jackson Serialization")
  internal inner class JacksonSerialization {
    val json = ObjectMapper()
    @ParameterizedTest(name = "Correctly converts {0}")
    @EnumSource(BlastPTask::class)
    @Throws(Exception::class)
    fun test1(bt: BlastPTask) {
      Assertions.assertEquals('"'.toString() + bt.value + '"', json.writeValueAsString(bt))
    }
  }

  @Nested
  @DisplayName("Jackson Deserialization")
  internal inner class JacksonDeserialization {
    val json = ObjectMapper()
    @ParameterizedTest(name = "Correctly converts {0}")
    @EnumSource(BlastPTask::class)
    @Throws(Exception::class)
    fun test1(bt: BlastPTask) {
      Assertions.assertEquals(bt, json.readValue(bt.toJSON().toString(), BlastPTask::class.java))
    }
  }
}