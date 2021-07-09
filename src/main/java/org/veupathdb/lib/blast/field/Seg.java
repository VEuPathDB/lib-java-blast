package org.veupathdb.lib.blast.field;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public class Seg implements DefaultingJSONValue
{
  private static final String YesValue = "yes";
  private static final String NoValue = "no";

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

  public Seg copy() {
    return new Seg(yes, no, window, locut, hicut);
  }

  @JsonValue
  @Override
  public JsonNode toJSON() {
    if (yes)
      return JSONConstructor.newText(YesValue);
    if (no)
      return JSONConstructor.newText(NoValue);

    var out = JSONConstructor.newObject();

    out.set(Key.Window, JSONConstructor.newInt(window));
    out.set(Key.Locut, JSONConstructor.newDouble(locut));
    out.set(Key.Hicut, JSONConstructor.newDouble(hicut));

    return out;
  }

  @Override
  public boolean isDefault() {
    return no;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Seg seg = (Seg) o;
    return (isYes() && seg.isYes()) ||
      (isNo() && seg.isNo()) ||
      (getWindow() == seg.getWindow()
      && Double.compare(seg.getLocut(), getLocut()) == 0
      && Double.compare(seg.getHicut(), getHicut()) == 0);
  }

  @Override
  public int hashCode() {
    if (isYes())
      return Objects.hash(YesValue);
    if (isNo())
      return Objects.hash(NoValue);

    return Objects.hash(getWindow(), getLocut(), getHicut());
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
        case YesValue -> yesSeg();
        case NoValue -> noSeg();
        default -> throw new IllegalArgumentException(
          "Unrecognized seg value \"" + node.textValue() + "\""
        );
      };
    }

    if (node.isObject()) {
      if (!node.has(Key.Window))
        throw new IllegalArgumentException("Invalid seg value, missing required key " + Key.Window);
      if (!node.has(Key.Locut))
        throw new IllegalArgumentException("Invalid seg value, missing required key " + Key.Locut);
      if (!node.has(Key.Hicut))
        throw new IllegalArgumentException("Invalid seg value, missing required key " + Key.Hicut);

      return wlhSeg(
        node.get(Key.Window).intValue(),
        node.get(Key.Locut).doubleValue(),
        node.get(Key.Hicut).doubleValue()
      );
    }

    throw new IllegalArgumentException(
      "Invalid seg value, must be one of \"yes\", \"no\", or an object containing the keys " +
        Key.Window + ", " +
        Key.Locut  + ", " +
        Key.Hicut  + "."
    );
  }

  public static Seg fromString(String value) {
    if (value.equals(YesValue))
      return yesSeg();
    if (value.equals(NoValue))
      return noSeg();

    var split = value.split(" +");

    if (split.length != 3)
      throw new IllegalArgumentException();

    return wlhSeg(
      Integer.parseInt(split[0]),
      Double.parseDouble(split[1]),
      Double.parseDouble(split[2])
    );
  }
}
