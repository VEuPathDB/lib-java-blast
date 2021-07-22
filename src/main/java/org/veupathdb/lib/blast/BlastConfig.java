package org.veupathdb.lib.blast;

import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.field.*;
import org.veupathdb.lib.blast.util.JSONDecodable;
import org.veupathdb.lib.blast.util.JSONEncodable;
import org.veupathdb.lib.blast.util.JSONObjectDecoder;
import org.veupathdb.lib.blast.util.JSONObjectEncoder;

public interface BlastConfig extends JSONEncodable, JSONDecodable
{
  BlastTool getTool();

  Boolean getShortHelp();

  void setShortHelp(Boolean val);

  Boolean getLongHelp();

  void setLongHelp(Boolean val);

  Boolean getVersion();

  void setVersion(Boolean val);

  OutFile getOutFile();

  void setOutFile(String file);

  OutFormat getOutFormat();

  void setOutFormat(OutFormat fmt);

  Boolean getShowGIs();

  void setShowGIs(Boolean val);

  NumDescriptions getNumDescriptions();

  void setNumDescriptions(Long val);

  NumAlignments getNumAlignments();

  void setNumAlignments(Long val);

  LineLength getLineLength();

  void setLineLength(Integer val);

  Boolean getHTML();

  void setHTML(Boolean val);

  HitSorting getSortHits();

  void setSortHits(HitSorting val);

  HSPSorting getSortHSPs();

  void setSortHSPs(HSPSorting val);

  MaxTargetSeqs getMaxTargetSequences();

  void setMaxTargetSequences(Long val);

  Boolean getParseDefLines();

  void setParseDefLines(Boolean val);

  default JSONObjectEncoder toJSON(boolean includeTool) {
    final var out = new JSONObjectEncoder();

    if (includeTool)
      out.encode(Key.Tool, getTool());

    out.encode(Flag.ShortHelp, getShortHelp());
    out.encode(Flag.LongHelp, getLongHelp());
    out.encode(Flag.Version, getVersion());
    out.encode(Flag.OutFile, getOutFile());
    out.encode(Flag.OutFormat, getOutFormat());
    out.encode(Flag.ShowGIs, getShowGIs());
    out.encode(Flag.NumDescriptions, getNumDescriptions());
    out.encode(Flag.NumAlignments, getNumAlignments());
    out.encode(Flag.LineLength, getLineLength());
    out.encode(Flag.HTML, getHTML());
    out.encode(Flag.SortHits, getSortHits());
    out.encode(Flag.SortHSPs, getSortHSPs());
    out.encode(Flag.MaxTargetSequences, getMaxTargetSequences());
    out.encode(Flag.ParseDefLines, getParseDefLines());

    return out;
  }

  @Override
  default JSONObjectEncoder toJSON() {
    return toJSON(false);
  }

  @Override
  default void decodeJSON(JSONObjectDecoder node) {
    node.decode(Flag.ShortHelp, this::setShortHelp);
    node.decode(Flag.LongHelp, this::setLongHelp);
    node.decode(Flag.Version, this::setVersion);
    node.decode(Flag.OutFile, this::setOutFile);
    node.decode(Flag.OutFormat, this::setOutFormat, OutFormat::fromJSON);
    node.decode(Flag.ShowGIs, this::setShowGIs);
    node.decode(Flag.NumDescriptions, this::setNumDescriptions);
    node.decode(Flag.NumAlignments, this::setNumAlignments);
    node.decode(Flag.LineLength, this::setLineLength);
    node.decode(Flag.HTML, this::setHTML);
    node.decode(Flag.SortHits, this::setSortHits, HitSorting::fromJSON);
    node.decode(Flag.SortHSPs, this::setSortHSPs, HSPSorting::fromJSON);
    node.decode(Flag.MaxTargetSequences, this::setMaxTargetSequences);
    node.decode(Flag.ParseDefLines, this::setParseDefLines);
  }
}
