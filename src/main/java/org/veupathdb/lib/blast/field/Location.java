package org.veupathdb.lib.blast.field;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.veupathdb.lib.blast.consts.Key;

@JsonPropertyOrder({Key.Start, Key.Stop})
public class Location
{
  private final int start;
  private final int stop;

  @JsonCreator
  public Location(@JsonProperty(Key.Start) int start, @JsonProperty(Key.Stop) int stop) {
    this.start = start;
    this.stop  = stop;
  }

  @JsonGetter(Key.Start)
  public int getStart() {
    return start;
  }

  @JsonGetter(Key.Stop)
  public int getStop() {
    return stop;
  }

  @Override
  public String toString() {
    return start + "-" + stop;
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
