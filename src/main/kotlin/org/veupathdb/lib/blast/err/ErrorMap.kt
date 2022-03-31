package org.veupathdb.lib.blast.err

class ErrorMap(size: Int = 16) {
  private val root = HashMap<String, ArrayList<String>>(size)

  fun addError(key: String, msg: String) {
    root.computeIfAbsent(key) { ArrayList(1) }
      .add(msg)
  }

  fun toMap(): Map<String, List<String>> = root
}