package org.veupathdb.lib.blast.field;

import java.util.Locale;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public enum Strand implements DefaultingJSONValue
{
  Both,
  Minus,
  Plus;

  public static final Strand DefaultStrand = Both;

  public String getValue() {
    return name().toLowerCase(Locale.ROOT);
  }

  @Override
  public boolean isDefault() {
    return this == DefaultStrand;
  }

  @Override
  @JsonValue
  public JsonNode toJSON() {
    return JSONConstructor.newText(getValue());
  }

  public static Strand fromString(String value) {
    Objects.requireNonNull(value);

    return switch (value.toLowerCase(Locale.ROOT)) {
      case "both"  -> Both;
      case "minus" -> Minus;
      case "plus"  -> Plus;

      default -> throw new IllegalArgumentException("Unrecognized strand value \"" + value + "\"");
    };
  }

  @JsonCreator
  public static Strand fromJSON(JsonNode js) {
    return fromString(js.textValue());
  }
}
