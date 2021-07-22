package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.util.JSONConstructor;
import org.veupathdb.lib.blast.util.JSONValue;

import java.util.Objects;

public record Location(int start, int stop) implements JSONValue
{
  @Override
  public String toString() {
    return start + "-" + stop;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Location location = (Location) o;
    return start == location.start && stop == location.stop;
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, stop);
  }

  public Location copy() {
    return new Location(start, stop);
  }

  @Override
  @JsonValue
  public ObjectNode toJSON() {
    var out = JSONConstructor.newObject();

    out.set(Key.Start, JSONConstructor.newInt(start));
    out.set(Key.Stop, JSONConstructor.newInt(stop));

    return out;
  }

  @JsonCreator
  public static Location fromJSON(JsonNode js) {
    return new Location(js.get(Key.Start).intValue(), js.get(Key.Stop).intValue());
  }

  public static Location fromString(String value) {
    var dashPos = value.indexOf('-');
    if (dashPos < 1)
      throw new IllegalArgumentException("Invalid location string");

    int start, stop;
    try {
      start = Integer.parseInt(value.substring(0, dashPos));
      stop  = Integer.parseInt(value.substring(dashPos + 1));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(e);
    }

    return new Location(start, stop);
  }
}
