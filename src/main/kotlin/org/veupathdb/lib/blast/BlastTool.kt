package org.veupathdb.lib.blast

import com.fasterxml.jackson.databind.node.ObjectNode

enum class BlastTool(val value: String) {
  BlastN("blastn"),
  BlastP("blastp"),
  BlastX("blastx"),
  DeltaBlast("deltablast"),
  PSIBlast("psiblast"),
  RPSBlast("rpsblast"),
  RPSTBlastN("rpstblastn"),
  TBlastN("tblastn"),
  TBlastX("tblastx"),
  BlastFormatter("blast_formatter");
}