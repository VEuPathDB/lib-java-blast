package org.veupathdb.lib.blast.field;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.consts.Key;

public class Seg
{
  private boolean yes;
  private boolean no;
  private int     window;
  private double  locut;
  private double  hicut;

  private Seg(boolean yes, boolean no, int window, double locut, double hicut) {
    this.yes    = yes;
    this.no     = no;
    this.window = window;
    this.locut  = locut;
    this.hicut  = hicut;
  }

  public boolean isYes() {
    return yes;
  }

  public Seg setYes(boolean yes) {
    this.yes = yes;
    return this;
  }

  public boolean isNo() {
    return no;
  }

  public Seg setNo(boolean no) {
    this.no = no;
    return this;
  }

  public int getWindow() {
    return window;
  }

  public Seg setWindow(int window) {
    this.window = window;
    return this;
  }

  public double getLocut() {
    return locut;
  }

  public Seg setLocut(double locut) {
    this.locut = locut;
    return this;
  }

  public double getHicut() {
    return hicut;
  }

  public Seg setHicut(double hicut) {
    this.hicut = hicut;
    return this;
  }

  @JsonValue
  public Object toJSONSerializable() {
    if (isYes())
      return "yes";
    if (isNo())
      return "no";

    return new LinkedHashMap<String, Number>()
    {{
      put(Key.Window, getWindow());
      put(Key.Locut, getLocut());
      put(Key.Hicut, getHicut());
    }};
  }

  public static Seg yesSeg() {
    return new Seg(true, false, 0, 0, 0);
  }

  public static Seg noSeg() {
    return new Seg(false, true, 0, 0, 0);
  }

  public static Seg wlhSeg(int window, double locut, double hicut) {
    return new Seg(false, false, window, locut, hicut);
  }

  @JsonCreator
  public static Seg fromJSON(JsonNode node) {
    if (node.isTextual()) {
      return switch (node.textValue()) {
        case "yes" -> yesSeg();
        case "no" -> noSeg();
        default -> throw new IllegalArgumentException();
      };
    }

    if (node.isObject()) {
      if (!node.has(Key.Window) || !node.has(Key.Locut) || !node.has(Key.Hicut)) {
        throw new IllegalArgumentException();
      }

      return wlhSeg(
        node.get(Key.Window).intValue(),
        node.get(Key.Locut).doubleValue(),
        node.get(Key.Hicut).doubleValue()
      );
    }

    throw new IllegalArgumentException();
  }
}
