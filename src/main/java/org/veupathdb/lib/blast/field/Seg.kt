package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.databind.JsonNode
import org.veupathdb.lib.blast.consts.Key
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import org.veupathdb.lib.blast.util.JSONConstructor

sealed interface Seg : DefaultingJSONValue
{
  val isYes: Boolean
  val isNo: Boolean
  val isWLH: Boolean
  val window: Int
  val locut: Double
  val hicut: Double

  companion object {
    @JvmStatic
    val YesSeg: Seg = YesSegImpl

    @JvmStatic
    val NoSeg: Seg = NoSegImpl

    @JvmStatic
    fun newWLHSeg(window: Int, locut: Double, hicut: Double): Seg {
      return WLGSegImpl(window, locut, hicut)
    }

    @JvmStatic
    @JsonCreator
    fun fromJSON(node: JsonNode): Seg {
      if (node.isTextual) {
        return when (node.textValue()) {
          YesSegImpl.Value -> YesSeg
          NoSegImpl.Value  -> NoSeg
          else             -> throw IllegalArgumentException("Unrecognized seg value \"${node.textValue()}\"")
        }
      }

      if (node.isObject) {
        if (!node.has(Key.Window))
          throw IllegalArgumentException("Invalid seg value, missing required key " + Key.Window)
        if (!node.has(Key.Locut))
          throw IllegalArgumentException("Invalid seg value, missing required key " + Key.Locut)
        if (!node.has(Key.Hicut))
          throw IllegalArgumentException("Invalid seg value, missing required key " + Key.Hicut)

        return WLGSegImpl(
          node.get(Key.Window).intValue(),
          node.get(Key.Locut).doubleValue(),
          node.get(Key.Hicut).doubleValue()
        )
      }

      throw IllegalArgumentException(
        "Invalid seg value, must be one of \"yes\", \"no\", or an object containing the keys " +
          Key.Window + ", " +
          Key.Locut + ", " +
          Key.Hicut + "."
        )
    }

    @JvmStatic
    fun fromString(value: String): Seg {
      if (YesSegImpl.Value == value)
        return YesSegImpl

      if (NoSegImpl.Value == value)
        return NoSegImpl

      val split = value.split(" +")

      if (split.size != 3)
        throw IllegalArgumentException()

      return WLGSegImpl(
        split[0].toInt(),
        split[1].toDouble(),
        split[2].toDouble(),
      )
    }
  }
}

private object YesSegImpl : Seg {
  const val Value = "yes"

  override val isYes = true

  override val isNo = false

  override val isWLH = false

  override val window
    get() = throw UnsupportedOperationException()

  override val locut
    get() = throw UnsupportedOperationException()

  override val hicut
    get() = throw UnsupportedOperationException()

  override val isDefault = false

  override fun toJSON(): JsonNode = JSONConstructor.newText(Value)
}

private object NoSegImpl : Seg {
  const val Value = "no"

  override val isYes = false

  override val isNo = true

  override val isWLH = false

  override val window
    get() = throw UnsupportedOperationException()

  override val locut
    get() = throw UnsupportedOperationException()

  override val hicut
    get() = throw UnsupportedOperationException()

  override val isDefault = false

  override fun toJSON(): JsonNode = JSONConstructor.newText(YesSegImpl.Value)
}

private data class WLGSegImpl(override val window: Int, override val locut: Double, override val hicut: Double) : Seg
{
  override val isYes = false

  override val isNo = false

  override val isWLH = true

  override val isDefault = false

  override fun toJSON(): JsonNode = JSONConstructor.newObject()
    .put(Key.Window, window)
    .put(Key.Locut, locut)
    .put(Key.Hicut, hicut)
}
