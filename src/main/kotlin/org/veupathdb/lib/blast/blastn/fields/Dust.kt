package org.veupathdb.lib.blast.blastn.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField


private const val KeyDust   = "-dust"
private const val KeyLevel  = "level"
private const val KeyWindow = "window"
private const val KeyLinker = "linker"
private const val DefLevel  = 20
private const val DefWindow = 64
private const val DefLinker = 1


sealed interface Dust : BlastField {
  val isYes: Boolean

  val isNo: Boolean

  val level: Int

  val window: Int

  val linker: Int

  companion object {

    @JvmStatic
    fun yes(): Dust = YesDust

    @JvmStatic
    fun no(): Dust = NoDust

    @JvmStatic
    fun of(
      level:  Int = DefLevel,
      window: Int = DefWindow,
      linker: Int = DefLinker,
    ): Dust =
      ValDust(level, window, linker)
  }
}


////////////////////////////////////////////////////////////////////////////////


internal fun ParseDust(js: ObjectNode): Dust {
  val tmp = js[KeyDust] ?: return ValDust()

  if (tmp.isTextual)
    return parseTextDust(tmp.textValue())

  if (tmp.isObject)
    return parseValDust(tmp as ObjectNode)

  throw IllegalArgumentException("Invalid dust value $tmp")
}


////////////////////////////////////////////////////////////////////////////////


private fun parseValDust(js: ObjectNode): ValDust {
  val nLevel  = js[KeyLevel]
  val nWindow = js[KeyWindow]
  val nLinker = js[KeyLinker]

  if (nLevel != null && !nLevel.isIntegralNumber)
    throw IllegalArgumentException("$KeyDust.$KeyLevel must be an int value.")
  if (nWindow != null && !nWindow.isIntegralNumber)
    throw IllegalArgumentException("$KeyDust.$KeyWindow must be an int value.")
  if (nLinker != null && !nLinker.isIntegralNumber)
    throw IllegalArgumentException("$KeyDust.$KeyLinker must be an int value.")

  return ValDust(
    nLevel?.intValue() ?: DefLevel,
    nWindow?.intValue() ?: DefWindow,
    nLinker?.intValue() ?: DefLinker,
  )
}


////////////////////////////////////////////////////////////////////////////////


internal data class ValDust(
  override val level:  Int = DefLevel,
  override val window: Int = DefWindow,
  override val linker: Int = DefLinker,
) : Dust {
  override val isYes get() = false

  override val isNo get() = false

  override val isDefault
    get() = level == DefLevel && window == DefWindow && linker == DefLinker

  override fun appendJson(js: ObjectNode) {
    if (isDefault)
      return

    with(js.putObject(KeyDust)) {
      put(KeyLevel, level)
      put(KeyWindow, window)
      put(KeyLinker, linker)
    }
  }

  override fun appendCliSegment(cli: StringBuilder) {
    if (!isDefault)
      cli.append(' ')
        .append(KeyDust)
        .append(" '")
        .append(level)
        .append(' ')
        .append(window)
        .append(' ')
        .append(linker)
        .append('\'')
  }

  override fun appendCliParts(cli: MutableList<String>) {
    if (!isDefault) {
      cli.add(KeyDust)
      cli.add("$level $window $linker")
    }
  }
}


////////////////////////////////////////////////////////////////////////////////


private fun parseTextDust(value: String) =
  when(value) {
    "yes" -> YesDust
    "no"  -> NoDust
    else  -> throw IllegalArgumentException("Invalid dust value $value")
  }


////////////////////////////////////////////////////////////////////////////////


internal object YesDust : Dust {
  override val isYes get() = true

  override val isNo  get() = false

  override val level
    get() = throw IllegalStateException("Cannot get the level value from a \"yes\" dust argument.")

  override val window
    get() = throw IllegalStateException("Cannot get the window value from a \"yes\" dust argument.")

  override val linker
    get() = throw IllegalStateException("Cannot get the linker value from a \"yes\" dust argument.")

  override val isDefault get() = false

  override fun appendJson(js: ObjectNode) {
    js.put(KeyDust, "yes")
  }

  override fun appendCliSegment(cli: StringBuilder) {
    cli.append(' ').append(KeyDust).append(' ').append("yes")
  }

  override fun appendCliParts(cli: MutableList<String>) {
    cli.add(KeyDust)
    cli.add("yes")
  }
}


////////////////////////////////////////////////////////////////////////////////


internal object NoDust : Dust {
  override val isYes get() = false

  override val isNo  get() = true

  override val level: Int
    get() = throw IllegalStateException("Cannot get the level value from a \"no\" dust argument.")

  override val window: Int
    get() = throw IllegalStateException("Cannot get the window value from a \"no\" dust argument.")

  override val linker: Int
    get() = throw IllegalStateException("Cannot get the linker value from a \"no\" dust argument.")

  override val isDefault get() = false

  override fun appendJson(js: ObjectNode) {
    js.put(KeyDust, "no")
  }

  override fun appendCliSegment(cli: StringBuilder) {
    cli.append(' ').append(KeyDust).append(' ').append("no")
  }

  override fun appendCliParts(cli: MutableList<String>) {
    cli.add(KeyDust)
    cli.add("no")
  }
}
