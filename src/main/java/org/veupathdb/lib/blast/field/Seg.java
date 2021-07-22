package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public interface Seg extends DefaultingJSONValue
{
  default boolean isYes() {
    return false;
  }

  default boolean isNo() {
    return false;
  }

  default boolean isWLH() {
    return false;
  }

  default int getWindow() {
    throw new UnsupportedOperationException();
  }

  default double getLocut() {
    throw new UnsupportedOperationException();
  }

  default double getHicut() {
    throw new UnsupportedOperationException();
  }

  @Override
  default boolean isDefault() {
    return false;
  }

  static Seg newYesSeg() {
    return yesSeg.instance;
  }

  static Seg newNoSeg() {
    return noSeg.instance;
  }

  static Seg newWLHSeg(int window, double locut, double hicut) {
    return new wlhSeg(window, locut, hicut);
  }

  @JsonCreator
  static Seg fromJSON(JsonNode node) {
    if (node.isTextual()) {
      return switch (node.textValue()) {
        case yesSeg.Value -> yesSeg.instance;
        case noSeg.Value  -> noSeg.instance;
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

      return new wlhSeg(
        node.get(Key.Window).intValue(),
        node.get(Key.Locut).doubleValue(),
        node.get(Key.Hicut).doubleValue()
      );
    }

    throw new IllegalArgumentException(
      "Invalid seg value, must be one of \"yes\", \"no\", or an object containing the keys " +
        Key.Window + ", " +
        Key.Locut + ", " +
        Key.Hicut + "."
    );
  }

  static Seg fromString(String value) {
    if (yesSeg.Value.equals(value))
      return yesSeg.instance;
    if (noSeg.Value.equals(value))
      return noSeg.instance;

    var split = value.split(" +");

    if (split.length != 3)
      throw new IllegalArgumentException();

    return new wlhSeg(
      Integer.parseInt(split[0]),
      Double.parseDouble(split[1]),
      Double.parseDouble(split[2])
    );
  }
}

record yesSeg() implements Seg
{
  static final Seg instance = new yesSeg();
  static final String Value = "yes";

  @Override
  public boolean isYes() {
    return true;
  }

  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newText(Value);
  }
}

record noSeg() implements Seg
{
  static final Seg instance = new noSeg();
  static final String Value = "no";

  @Override
  public boolean isNo() {
    return true;
  }

  @Override
  public boolean isDefault() {
    return true;
  }

  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newText(Value);
  }
}

record wlhSeg(int window, double locut, double hicut) implements Seg
{
  @Override
  public boolean isWLH() {
    return true;
  }

  @Override
  public int getWindow() {
    return window;
  }

  @Override
  public double getLocut() {
    return locut;
  }

  @Override
  public double getHicut() {
    return hicut;
  }

  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newObject()
      .put(Key.Window, window)
      .put(Key.Locut, locut)
      .put(Key.Hicut, hicut);
  }
}
