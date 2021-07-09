package org.veupathdb.lib.blast.util;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import static org.veupathdb.lib.blast.util.JSONConstructor.*;

public class JSONObjectEncoder
{
  private final ObjectNode js;

  public JSONObjectEncoder() {
    this(newObject());
  }

  public JSONObjectEncoder(ObjectNode js) {
    this.js = js;
  }

  //
  // String
  //

  public void encode(String key, String value) {
    if (value != null && !value.isBlank())
      js.set(key, newText(value));
  }

  public void encode(String key, String value, String def) {
    if (value != null && !value.isBlank() && !value.equals(def))
      js.set(key, newText(value));
  }

  //
  // Byte
  //

  public void encode(String key, Byte value) {
    if (value != null)
      js.set(key, newInt(value));
  }

  public void encode(String key, Byte value, byte def) {
    if (value != null && value != def)
      js.set(key, newInt(value));
  }

  //
  // Short
  //

  public void encode(String key, Short value) {
    if (value != null)
      js.set(key, newShort(value));
  }

  //
  // Int
  //

  public void encode(String key, Integer value) {
    if (value != null)
      js.set(key, newInt(value));
  }

  public void encode(String key, Integer value, int def) {
    if (value != null && value != def)
      js.set(key, newInt(value));
  }

  //
  // Long
  //

  public void encode(String key, Long value) {
    if (value != null)
      js.set(key, newLong(value));
  }

  public void encode(String key, Long value, long def) {
    if (value != null && value != def)
      js.set(key, newLong(value));
  }

  //
  // Double
  //

  public void encode(String key, Double value) {
    if (value != null)
      js.set(key, newDouble(value));
  }

  public void encode(String key, Double value, double def) {
    if (value != null && value != def)
      js.set(key, newDouble(value));
  }

  //
  // Collection
  //

  public void encode(String key, Collection<?> value) {
    if (value != null && !value.isEmpty())
      js.set(key, newArray(value));
  }

  //
  // Bool
  //

  /**
   * Appends the given {@code value} to the given {@code JsonNode} if the value
   * is not {@code null}.
   * <p>
   * This method performs no tests on whether or not the given value is
   * {@code true} or {@code false}.
   *
   * @param key
   * @param value
   */
  public void forceEncode(String key, Boolean value) {
    if (value != null)
      js.set(key, newBool(value));
  }

  /**
   * Appends the given {@code value} to the given {@code JsonNode} if the value
   * is not {@code null} and is {@code true}.
   * <p>
   * If you wish to append a non-null boolean value to the {@code JsonNode}
   * regardless of its value, see
   * {@link #forceEncode(String, Boolean)}.
   *
   * @param key   Key the new value should be appended under.
   * @param value Nullable boolean value.
   *
   * @see #encode(String, Boolean, boolean)
   * @see #forceEncode(String, Boolean)
   */
  public void encode(String key, Boolean value) {
    encode(key, value, false);
  }

  /**
   * Appends the given {@code value} to the given {@code ObjectNode} if the
   * value is not {@code null} and is not equal to the given default
   * ({@code def}).
   *
   * @param key   Key the new value should be appended under.
   * @param value Nullable boolean value.
   * @param def   Default value to check against.
   *
   * @see #encode(String, Boolean)
   * @see #forceEncode(String, Boolean)
   */
  public void encode(String key, Boolean value, boolean def) {
    if (value != null && value != def)
      js.set(key, newBool(value));
  }

  //
  // Custom Types
  //

  public void encode(String key, DefaultingJSONValue value) {
    if (value != null && !value.isDefault())
      js.set(key, value.toJSON());
  }

  public void encode(String key, JSONValue value) {
    if (value != null)
      js.set(key, value.toJSON());
  }

  public String printJSONString() {
    return js.toString();
  }

  public String prettyPrintJSONString() {
    return js.toPrettyString();
  }

  @JsonValue
  public JsonNode toJSON() {
    return js;
  }
}
