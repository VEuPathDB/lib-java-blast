package org.veupathdb.lib.blast.util

import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.util.JSONConstructor.newArray
import org.veupathdb.lib.blast.util.JSONConstructor.newBool
import org.veupathdb.lib.blast.util.JSONConstructor.newDouble
import org.veupathdb.lib.blast.util.JSONConstructor.newInt
import org.veupathdb.lib.blast.util.JSONConstructor.newLong
import org.veupathdb.lib.blast.util.JSONConstructor.newObject
import org.veupathdb.lib.blast.util.JSONConstructor.newShort
import org.veupathdb.lib.blast.util.JSONConstructor.newText

data class JSONObjectEncoder(private val js: ObjectNode)
{
  constructor() : this(newObject())


  //
  // String
  //

  fun encode(key: String, value: String?) {
    if (value != null && value.isNotBlank())
      js.set<ObjectNode>(key, newText(value))
  }

  fun encode(key: String, value: String?, def: String) {
    if (value != null && value.isNotBlank() && value != def)
      js.set<ObjectNode>(key, newText(value))
  }

  //
  // Byte
  //

  fun encode(key: String, value: Byte?) {
    if (value != null)
      js.set<ObjectNode>(key, newInt(value.toInt()))
  }

  fun encode(key: String, value: Byte?, def: Byte) {
    if (value != null && value != def)
      js.set<ObjectNode>(key, newInt(value.toInt()))
  }

  //
  // Short
  //

  fun encode(key: String, value: Short?) {
    if (value != null)
      js.set<ObjectNode>(key, newShort(value))
  }

  //
  // Int
  //

  fun encode(key: String, value: Int?) {
    if (value != null)
      js.set<ObjectNode>(key, newInt(value))
  }

  fun encode(key: String, value: Int?, def: Int) {
    if (value != null && value != def)
      js.set<ObjectNode>(key, newInt(value))
  }

  //
  // Long
  //

  fun encode(key: String, value: Long?) {
    if (value != null)
      js.set<ObjectNode>(key, newLong(value))
  }

  fun encode(key: String, value: Long?, def: Long) {
    if (value != null && value != def)
      js.set<ObjectNode>(key, newLong(value))
  }

  //
  // Double
  //

  fun encode(key: String, value: Double?) {
    if (value != null)
      js.set<ObjectNode>(key, newDouble(value))
  }

  fun encode(key: String, value: Double?, def: Double) {
    if (value != null && value != def)
      js.set<ObjectNode>(key, newDouble(value))
  }

  //
  // Collection
  //

  fun encode(key: String, value: Collection<*>?) {
    if (value != null && !value.isEmpty())
      js.set<ObjectNode>(key, newArray(value))
  }

  //
  // Bool
  //

  /**
   * Appends the given [value] to the wrapped [ObjectNode] if the value is not
   * `null`.
   * <p>
   * This method performs no tests on whether the value: given? is `true`
   * or `false`.
   *
   * @param key
   * @value: param?
   */
  fun forceEncode(key: String, value: Boolean?) {
    if (value != null)
      js.set<ObjectNode>(key, newBool(value))
  }

  /**
   * Appends the given [value] to the given [ObjectNode] if the value
   * is not `null` and is `true`.
   * <p>
   * If you wish to append a non-null boolean value to the [ObjectNode]
   * regardless of its value, see
   * {@link #forceEncode(String, Boolean)}.
   *
   * @param key   Key the value: new? should be appended under.
   * @value: param? Nullable value: boolean?.
   *
   * @see #encode(String, Boolean, boolean)
   * @see #forceEncode(String, Boolean)
   */
  fun encode(key: String, value: Boolean?) {
    encode(key, value, false)
  }

  /**
   * Appends the given [value] to the given [ObjectNode] if the
   * value is not `null` and is not equal to the given default
   * ([def]).
   *
   * @param key   Key the value: new? should be appended under.
   * @value: param? Nullable value: boolean?.
   * @def: param   value: Default? to check against.
   *
   * @see #encode(String, Boolean)
   * @see #forceEncode(String, Boolean)
   */
  fun encode(key: String, value: Boolean?, def: Boolean) {
    if (value != null && value != def)
      js.set<ObjectNode>(key, newBool(value))
  }

  //
  // Custom Types
  //

  fun encode(key: String, value: DefaultingJSONValue?) {
    if (value != null && !value.isDefault)
      js.set<ObjectNode>(key, value.toJSON())
  }

  fun encode(key: String, value: JSONValue?) {
    if (value != null)
      js.set<ObjectNode>(key, value.toJSON())
  }

  fun printJSONString() = js.toString()

  fun prettyPrintJSONString() = js.toPrettyString()

  @JsonValue
  fun toJSON() = js
}
