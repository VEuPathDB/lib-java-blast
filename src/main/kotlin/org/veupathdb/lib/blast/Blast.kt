package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.blastn.BlastN
import org.veupathdb.lib.blast.blastn.BlastNImpl
import org.veupathdb.lib.blast.blastp.BlastP
import org.veupathdb.lib.blast.blastp.BlastPImpl

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

  /**
   * Creates a new [BlastP] instance by parsing the given JSON input.
   *
   * @param js JSON object to parse.
   *
   * @return The new [BlastP] instance.
   */
  fun blastp(js: ObjectNode): BlastP = BlastPImpl(js)

  /**
   * Creates a new, defaulted [BlastP] instance.
   *
   * @return The new [BlastP] instance.
   */
  fun blastp(): BlastP = BlastPImpl()
}