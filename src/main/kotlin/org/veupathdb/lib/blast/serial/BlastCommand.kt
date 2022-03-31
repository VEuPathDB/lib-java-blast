package org.veupathdb.lib.blast.serial

import com.fasterxml.jackson.databind.node.ObjectNode

interface BlastCommand {

  fun toJson(): ObjectNode

  fun toCliString(): String

  fun toCliArray(): Array<String>
}