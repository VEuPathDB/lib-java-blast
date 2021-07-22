package org.veupathdb.lib.blast;

import java.util.Arrays;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.veupathdb.lib.blast.util.JSONConstructor;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BlastTool")
class BlastToolTest
{
  @Nested
  @DisplayName("::fromJSON(JsonNode)")
  class FromJSON1
  {
    @ParameterizedTest(name = "Correctly deserializes the JSON value \"{1}\" to {0}.")
    @MethodSource("org.veupathdb.lib.blast.BlastToolTest#jsonWrappedValues")
    void test1(BlastTool bt, JsonNode js) {
      assertSame(bt, BlastTool.fromJSON(js));
    }

    @Test
    @DisplayName("Throws an IllegalArgumentException if the input JSON is not text")
    void test2() {
      assertThrows(
        IllegalArgumentException.class,
        () -> BlastTool.fromJSON(JSONConstructor.newInt(3))
      );
    }

    @Test
    @DisplayName("Throws an IllegalArgumentException if the JSON text does not match a valid BlastTool value")
    void test3() {
      assertThrows(
        IllegalArgumentException.class,
        () -> BlastTool.fromJSON(JSONConstructor.newText("hello"))
      );
    }
  }

  @Nested
  @DisplayName("::fromString(String)")
  class FromString1
  {
    @ParameterizedTest(name = "Correctly matches the given value \"{1}\" to {0}.")
    @MethodSource("org.veupathdb.lib.blast.BlastToolTest#textValues")
    void test1(BlastTool bt, String js) {
      assertSame(bt, BlastTool.fromString(js));
    }

    @Test
    @DisplayName("Throws an IllegalArgumentException if the given value is not a valid BlastTool")
    void test2() {
      assertThrows(
        IllegalArgumentException.class,
        () -> BlastTool.fromString("hello")
      );
    }
  }

  @Nested
  @DisplayName("#toJSON()")
  class ToJSON1
  {
    @ParameterizedTest(name = "Correctly converts {0} to \"{1}\"")
    @EnumSource(BlastTool.class)
    void test1(BlastTool bt) {
      assertEquals(bt.getValue(), bt.toJSON().textValue());
    }
  }

  @Nested
  @DisplayName("Jackson Serialization")
  class JacksonSerialization
  {
    final ObjectMapper json = new ObjectMapper();

    @ParameterizedTest(name = "Correctly converts {0}")
    @EnumSource(BlastTool.class)
    void test1(BlastTool bt) throws Exception {
      assertEquals('"' + bt.getValue() + '"', json.writeValueAsString(bt));
    }
  }

  @Nested
  @DisplayName("Jackson Deserialization")
  class JacksonDeserialization
  {
    final ObjectMapper json = new ObjectMapper();

    @ParameterizedTest(name = "Correctly converts {0}")
    @EnumSource(BlastTool.class)
    void test1(BlastTool bt) throws Exception {
      assertEquals(bt, json.readValue(bt.toJSON().toString(), BlastTool.class));
    }
  }

  static Stream<Arguments> jsonWrappedValues() {
    return Arrays.stream(BlastTool.values())
      .map(bt -> Arguments.of(bt, JSONConstructor.newText(bt.getValue())));
  }

  static Stream<Arguments> textValues() {
    return Arrays.stream(BlastTool.values())
      .map(bt -> Arguments.of(bt, bt.getValue()));
  }
}