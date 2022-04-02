package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.blastn.BlastN
import org.veupathdb.lib.blast.blastn.BlastNImpl
import org.veupathdb.lib.blast.blastp.BlastP
import org.veupathdb.lib.blast.blastp.BlastPImpl
import org.veupathdb.lib.blast.blastx.BlastX
import org.veupathdb.lib.blast.blastx.BlastXImpl
import org.veupathdb.lib.blast.deltablast.DeltaBlast
import org.veupathdb.lib.blast.deltablast.DeltaBlastImpl
import org.veupathdb.lib.blast.psiblast.PSIBlast
import org.veupathdb.lib.blast.psiblast.PSIBlastImpl
import org.veupathdb.lib.blast.rpsblast.RPSBlast
import org.veupathdb.lib.blast.rpsblast.RPSBlastImpl
import org.veupathdb.lib.blast.rpstblastn.RPSTBlastN
import org.veupathdb.lib.blast.rpstblastn.RPSTBlastNImpl

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

  /**
   * Creates a new [BlastX] instance by parsing the given JSON input.
   *
   * @param js JSON object to parse.
   *
   * @return The new [BlastX] instance.
   */
  fun blastx(js: ObjectNode): BlastX = BlastXImpl(js)

  /**
   * Creates a new, defaulted [BlastX] instance.
   *
   * @return The new [BlastX] instance.
   */
  fun blastx(): BlastX = BlastXImpl()

  /**
   * Creates a new [DeltaBlast] instance by parsing the given JSON input.
   *
   * @param js JSON object to parse.
   *
   * @return The new [DeltaBlast] instance.
   */
  fun deltaBlast(js: ObjectNode): DeltaBlast = DeltaBlastImpl(js)

  /**
   * Creates a new, defaulted [DeltaBlast] instance.
   *
   * @return The new [DeltaBlast] instance.
   */
  fun deltaBlast(): DeltaBlast = DeltaBlastImpl()

  /**
   * Creates a new [PSIBlast] instance by parsing the given JSON input.
   *
   * @param js JSON object to parse.
   *
   * @return The new [PSIBlast] instance.
   */
  fun psiBlast(js: ObjectNode): PSIBlast = PSIBlastImpl(js)

  /**
   * Creates a new, defaulted [PSIBlast] instance.
   *
   * @return The new [PSIBlast] instance.
   */
  fun psiBlast(): PSIBlast = PSIBlastImpl()

  /**
   * Creates a new [RPSBlast] instance by parsing the given JSON input.
   *
   * @param js JSON object to parse.
   *
   * @return The new [RPSBlast] instance.
   */
  fun rpsBlast(js: ObjectNode): RPSBlast = RPSBlastImpl(js)

  /**
   * Creates a new, defaulted [RPSBlast] instance.
   *
   * @return The new [RPSBlast] instance.
   */
  fun rpsBlast(): RPSBlast = RPSBlastImpl()

  /**
   * Creates a new [RPSBlast] instance by parsing the given JSON input.
   *
   * @param js JSON object to parse.
   *
   * @return The new [RPSBlast] instance.
   */
  fun rpsTBlastN(js: ObjectNode): RPSTBlastN = RPSTBlastNImpl(js)

  /**
   * Creates a new, defaulted [RPSTBlastN] instance.
   *
   * @return The new [RPSTBlastN] instance.
   */
  fun rpsTBlastN(): RPSTBlastN = RPSTBlastNImpl()
}