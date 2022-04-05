package org.veupathdb.lib.blast


internal fun parseTool(value: String): BlastTool {
  for (t in BlastTool.values())
    if (value == t.value)
      return t

  throw IllegalArgumentException("Invalid BlastTool value \"$value\".")
}


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