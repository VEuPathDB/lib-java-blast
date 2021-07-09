package org.veupathdb.lib.blast.field;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public class ThreadMode implements DefaultingJSONValue
{
  public static final ThreadMode Auto    = new ThreadMode(0);
  public static final ThreadMode Disable = new ThreadMode(1);

  public static final int DefaultThreadMode = 1;

  private final int value;

  public ThreadMode(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean isDefault() {
    return value == DefaultThreadMode;
  }

  @Override
  @JsonValue
  public JsonNode toJSON() {
    return JSONConstructor.newInt(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ThreadMode that = (ThreadMode) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @JsonCreator
  public static ThreadMode fromJSON(JsonNode js) {
    var val = js.intValue();

    return switch (val) {
      case 0  -> Auto;
      case 1  -> Disable;
      default -> new ThreadMode(val);
    };
  }
}
