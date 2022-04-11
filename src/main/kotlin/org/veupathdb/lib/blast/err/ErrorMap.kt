package org.veupathdb.lib.blast.err

import org.veupathdb.lib.blast.serial.BlastField

class ErrorMap(size: Int = 16) {
  private val root = HashMap<String, ArrayList<String>>(size)

  /**
   * Appends an error to this [ErrorMap].
   *
   * @param key Name of the field the given error message relates to.
   *
   * @param msg Error message to append.
   */
  fun addError(key: String, msg: String) {
    root.computeIfAbsent(key) { ArrayList(1) }
      .add(msg)
  }

  /**
   * Extracts a Java [Map] of errors from this [ErrorMap].
   *
   * @return The raw [Map] of errors wrapped by this [ErrorMap].
   */
  fun toMap(): Map<String, List<String>> = root

  /**
   * Tests whether this [ErrorMap] contains any errors.
   *
   * @return `true` if this [ErrorMap] contains 1 or more errors, otherwise
   * `false`.
   */
  fun hasErrors() = root.isNotEmpty()

  fun incompatible(field: BlastField, vararg others: BlastField) {
    if (field.isDefault)
      return

    for (f in others) {
      if (!f.isDefault) {
        addError(field.name, "Flag ${field.name} is incompatible with ${f.name}")
        addError(f.name, "Flag ${f.name} is incompatible with ${field.name}")
      }
    }
  }

  fun requires(field1: BlastField, field2: BlastField) {
    if (!field1.isDefault && field2.isDefault)
      addError(field1.name, "Flag ${field1.name} requires ${field2.name}")
  }
}