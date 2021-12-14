package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import org.veupathdb.lib.blast.util.JSONConstructor

@JvmInline
value class ThreadMode(val value: Int) : DefaultingJSONValue {

  companion object {
    @JvmStatic
    val Auto    = ThreadMode(0)

    @JvmStatic
    val Disable = ThreadMode(1)

    const val DefaultThreadMode = 1

    @JvmStatic
    @JsonCreator
    fun fromJSON(js: JsonNode): ThreadMode {
      return when (val value = js.intValue()) {
        0    -> Auto
        1    -> Disable
        else -> ThreadMode(value)
      }
    }
  }

  override val isDefault
    get() = value == DefaultThreadMode

  @Override
  @JsonValue
  override fun toJSON(): JsonNode = JSONConstructor.newInt(value)

}
