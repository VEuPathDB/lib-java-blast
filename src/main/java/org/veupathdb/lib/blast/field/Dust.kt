package org.veupathdb.lib.blast.field

import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.databind.JsonNode

import org.veupathdb.lib.blast.consts.Key
import org.veupathdb.lib.blast.util.DefaultingJSONValue
import org.veupathdb.lib.blast.util.JSONConstructor

class Dust private constructor(
  var isYes: Boolean,
  var isNo: Boolean,
  var level: Int,
  var window: Int,
  var linker: Int
) : DefaultingJSONValue {
  fun setYes(yes: Boolean): Dust {
    isYes = yes
    return this
  }

  fun setNo(no: Boolean): Dust {
    isNo = no
    return this
  }

  fun setLevel(level: Int): Dust {
    this.level = level
    return this
  }

  fun setWindow(window: Int): Dust {
    this.window = window
    return this
  }

  fun setLinker(linker: Int): Dust {
    this.linker = linker
    return this
  }

  override val isDefault: Boolean
    get() {
      if (isYes) return false
      return if (isNo) false else level == DefaultLevel && window == DefaultWindow && linker == DefaultLinker
    }

  @JsonValue
  override fun toJSON(): JsonNode {
    if (isYes) return JSONConstructor.newText(YesValue)
    if (isNo) return JSONConstructor.newText(NoValue)
    val out = JSONConstructor.newObject()
    out.set<JsonNode>(Key.Level, JSONConstructor.newInt(level))
    out.set<JsonNode>(Key.Window, JSONConstructor.newInt(window))
    out.set<JsonNode>(Key.Linker, JSONConstructor.newInt(linker))
    return out
  }

  fun copy(): Dust {
    return Dust(isYes, isNo, level, window, linker)
  }

  companion object {
    private const val YesValue = "yes"
    private const val NoValue = "no"

    const val DefaultLevel = 20
    const val DefaultWindow = 64
    const val DefaultLinker = 1

    @JvmStatic
    @JsonCreator
    fun fromJSON(node: JsonNode): Dust {
      if (node.isTextual) {
        return when (node.textValue()) {
          YesValue -> yesDust()
          NoValue  -> noDust()
          else     -> throw IllegalArgumentException()
        }
      }
      if (node.isObject) {
        require(!(!node.has(Key.Level) || !node.has(Key.Window) || !node.has(
          Key.Linker)))
        return Dust(
          false,
          false,
          node[Key.Level].intValue(),
          node[Key.Window].intValue(),
          node[Key.Linker].intValue()
        )
      }
      throw IllegalArgumentException()
    }

    @JvmStatic
    fun yesDust(): Dust {
      return Dust(true, false, 0, 0, 0)
    }

    @JvmStatic
    fun noDust(): Dust {
      return Dust(false, true, 0, 0, 0)
    }

    @JvmStatic
    fun lwlDust(level: Int, window: Int, linker: Int): Dust {
      return Dust(false, false, level, window, linker)
    }

    @JvmStatic
    fun fromString(value: String): Dust {
      if (YesValue == value) return yesDust()
      if (NoValue == value) return noDust()
      val split = value.split(" +").toTypedArray()
      require(split.size == 3)
      return lwlDust(split[0].toInt(), split[1].toInt(), split[2].toInt())
    }
  }
}