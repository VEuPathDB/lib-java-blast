@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.blast.util

internal inline fun StringBuilder.append(
  isDefault: Boolean,
  key:       String,
  value:     Boolean,
) {
  if (!isDefault)
    append(' ').append(key).append(' ').append(value)
}

internal inline fun StringBuilder.append(
  isDefault: Boolean,
  key:       String,
  value:     Int,
) {
  if (!isDefault)
    append(' ').append(key).append(' ').append(value)
}

internal inline fun StringBuilder.append(
  isDefault: Boolean,
  key:       String,
  value:     UInt
) {
  if (!isDefault)
    append(' ').append(key).append(' ').append(value.toString())
}

internal inline fun StringBuilder.append(
  isDefault: Boolean,
  key:       String,
  value:     String,
) {
  if (!isDefault)
    append(' ').append(key).append(' ').append(value)
}
