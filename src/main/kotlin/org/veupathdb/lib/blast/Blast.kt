package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.blastn.BlastN
import org.veupathdb.lib.blast.blastn.BlastNImpl

object Blast {

  /**
   * Creates a new [BlastN] instance by parsing the given JSON input.
   *
   * @param js JSON object to parse.
   *
   * @return The new [BlastN] instance.
   */
  fun blastn(js: ObjectNode): BlastN = BlastNImpl(js)

  /**
   * Creates a new, defaulted [BlastN] instance.
   *
   * @return The new [BlastN] instance.
   */
  fun blastn(): BlastN = BlastNImpl()

}