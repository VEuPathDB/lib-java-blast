package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

import java.util.Objects;

public class Dust implements DefaultingJSONValue
{
  private static final String YesValue = "yes";
  private static final String NoValue  = "no";

  public static final int DefaultLevel  = 20;
  public static final int DefaultWindow = 64;
  public static final int DefaultLinker = 1;

  private boolean yes;
  private boolean no;
  private int     level;
  private int     window;
  private int     linker;

  private Dust(boolean yes, boolean no, int level, int window, int linker) {
    this.yes    = yes;
    this.no     = no;
    this.level  = level;
    this.window = window;
    this.linker = linker;
  }

  public boolean isYes() {
    return yes;
  }

  public Dust setYes(boolean yes) {
    this.yes = yes;
    return this;
  }

  public boolean isNo() {
    return no;
  }

  public Dust setNo(boolean no) {
    this.no = no;
    return this;
  }

  public int getLevel() {
    return level;
  }

  public Dust setLevel(int level) {
    this.level = level;
    return this;
  }

  public int getWindow() {
    return window;
  }

  public Dust setWindow(int window) {
    this.window = window;
    return this;
  }

  public int getLinker() {
    return linker;
  }

  public Dust setLinker(int linker) {
    this.linker = linker;
    return this;
  }

  @Override
  public boolean isDefault() {
    if (yes)
      return false;
    if (no)
      return false;

    return level == DefaultLevel && window == DefaultWindow && linker == DefaultLinker;
  }

  @Override
  @JsonValue
  public JsonNode toJSON() {
    if (yes)
      return JSONConstructor.newText(YesValue);
    if (no)
      return JSONConstructor.newText(NoValue);

    var out = JSONConstructor.newObject();

    out.set(Key.Level, JSONConstructor.newInt(level));
    out.set(Key.Window, JSONConstructor.newInt(window));
    out.set(Key.Linker, JSONConstructor.newInt(linker));

    return out;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Dust dust = (Dust) o;
    return (isYes() && dust.isYes())
      || (isNo() && dust.isNo())
      || (
      getLevel() == dust.getLevel() &&
        getWindow() == dust.getWindow() &&
        getLinker() == dust.getLinker()
    );
  }

  @Override
  public int hashCode() {
    if (yes)
      return Objects.hash(YesValue);

    if (no)
      return Objects.hash(NoValue);

    return Objects.hash(getLevel(), getWindow(), getLinker());
  }

  public Dust copy() {
    return new Dust(yes, no, level, window, linker);
  }

  @JsonCreator
  public static Dust fromJSON(JsonNode node) {
    if (node.isTextual()) {
      return switch(node.textValue()) {
        case YesValue -> yesDust();
        case NoValue -> noDust();
        default -> throw new IllegalArgumentException();
      };
    }

    if (node.isObject()) {
      if (!node.has(Key.Level) || !node.has(Key.Window) || !node.has(Key.Linker))
        throw new IllegalArgumentException();
      return new Dust(
        false,
        false,
        node.get(Key.Level).intValue(),
        node.get(Key.Window).intValue(),
        node.get(Key.Linker).intValue()
      );
    }

    throw new IllegalArgumentException();
  }

  public static Dust yesDust() {
    return new Dust(true, false, 0, 0, 0);
  }

  public static Dust noDust() {
    return new Dust(false, true, 0, 0, 0);
  }

  public static Dust lwlDust(int level, int window, int linker) {
    return new Dust(false, false, level, window, linker);
  }

  public static Dust fromString(String value) {
    if (YesValue.equals(value))
      return yesDust();
    if (NoValue.equals(value))
      return noDust();

    var split = value.split(" +");

    if (split.length != 3)
      throw new IllegalArgumentException();

    return lwlDust(
      Integer.parseInt(split[0]),
      Integer.parseInt(split[1]),
      Integer.parseInt(split[2])
    );
  }
}
