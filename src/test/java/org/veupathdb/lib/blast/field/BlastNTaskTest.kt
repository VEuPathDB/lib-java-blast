package org.veupathdb.lib.blast.field

import org.veupathdb.lib.blast.field.BlastNTask.Companion.fromJSON
import org.veupathdb.lib.blast.util.JSONConstructor.newInt
import org.veupathdb.lib.blast.util.JSONConstructor.newText
import org.veupathdb.lib.blast.field.BlastNTask.Companion.fromString
import org.junit.jupiter.params.ParameterizedTest
import com.fasterxml.jackson.databind.JsonNode
import org.junit.jupiter.params.provider.EnumSource
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.util.*
import java.util.stream.Stream
import kotlin.Throws

@DisplayName("BlastNTask")
class BlastNTaskTest {
  companion object {
    @JvmStatic
    fun jsonWrappedValues(): Stream<Arguments> {
      return Arrays.stream(BlastNTask.values())
        .map { bt: BlastNTask -> Arguments.of(bt, newText(bt.value)) }
    }

    @JvmStatic
    fun textValues(): Stream<Arguments> {
      return Arrays.stream(BlastNTask.values())
        .map { bt: BlastNTask -> Arguments.of(bt, bt.value) }
    }
  }

  @Nested
  @DisplayName("::fromJSON(JsonNode)")
  internal inner class FromJSON1 {
    @ParameterizedTest(name = "Correctly deserializes the JSON value \"{1}\" to {0}.")
    @MethodSource("org.veupathdb.lib.blast.field.BlastNTaskTest#jsonWrappedValues")
    fun test1(bt: BlastNTask?, js: JsonNode?) {
      Assertions.assertSame(bt, fromJSON(js!!))
    }

    @Test
    @DisplayName("Throws an IllegalArgumentException if the input JSON is not text")
    fun test2() {
      Assertions.assertThrows(IllegalArgumentException::class.java) { fromJSON(newInt(3)) }
    }

    @Test
    @DisplayName("Throws an IllegalArgumentException if the JSON text does not match a valid BlastNTask value")
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
    @MethodSource("org.veupathdb.lib.blast.field.BlastNTaskTest#textValues")
    fun test1(bt: BlastNTask?, js: String?) {
      Assertions.assertSame(bt, fromString(js!!))
    }

    @Test
    @DisplayName("Throws an IllegalArgumentException if the given value is not a valid BlastNTask")
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
    @EnumSource(BlastNTask::class)
    fun test1(bt: BlastNTask) {
      Assertions.assertEquals(bt.value, bt.toJSON().textValue())
    }
  }

  @Nested
  @DisplayName("Jackson Serialization")
  internal inner class JacksonSerialization {
    val json = ObjectMapper()
    @ParameterizedTest(name = "Correctly converts {0}")
    @EnumSource(BlastNTask::class)
    @Throws(Exception::class)
    fun test1(bt: BlastNTask) {
      Assertions.assertEquals('"'.toString() + bt.value + '"', json.writeValueAsString(bt))
    }
  }

  @Nested
  @DisplayName("Jackson Deserialization")
  internal inner class JacksonDeserialization {
    val json = ObjectMapper()
    @ParameterizedTest(name = "Correctly converts {0}")
    @EnumSource(BlastNTask::class)
    @Throws(Exception::class)
    fun test1(bt: BlastNTask) {
      Assertions.assertEquals(bt, json.readValue(bt.toJSON().toString(), BlastNTask::class.java))
    }
  }
}