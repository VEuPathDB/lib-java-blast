@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.blast.util

internal inline fun MutableList<String>.add(
  isDefault: Boolean,
  key:       String,
  value:     Boolean,
) {
  if (!isDefault) {
    add(key)
    add(value.toString())
  }
}

internal inline fun MutableList<String>.add(
  isDefault: Boolean,
  key:       String,
  value:     Int,
) {
  if (!isDefault) {
    add(key)
    add(value.toString())
  }
}

internal inline fun MutableList<String>.add(
  isDefault: Boolean,
  key:       String,
  value:     UInt,
) {
  if (!isDefault) {
    add(key)
    add(value.toString())
  }
}

internal inline fun MutableList<String>.add(
  isDefault: Boolean,
  key:       String,
  value:     String,
) {
  if (!isDefault) {
    add(key)
    add(value)
  }
}
