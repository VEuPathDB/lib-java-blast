package org.veupathdb.lib.blast.field;

import java.util.Locale;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.util.JSONConstructor;
import org.veupathdb.lib.blast.util.JSONValue;

public enum ScoringMatrix implements JSONValue
{
  Blosum45,
  Blosum50,
  Blosum62,
  Blosum80,
  Blosum90,
  Pam30,
  Pam70,
  Pam250,
  Identity;

  public String getValue() {
    return name().toUpperCase(Locale.ROOT);
  }

  public static ScoringMatrix fromString(String value) {
    Objects.requireNonNull(value);

    return switch (value.toLowerCase(Locale.ROOT)) {
      case "blosum45" -> Blosum45;
      case "blosum50" -> Blosum50;
      case "blosum62" -> Blosum62;
      case "blosum80" -> Blosum80;
      case "blosum90" -> Blosum90;
      case "pam30"    -> Pam30;
      case "pam70"    -> Pam70;
      case "pam250"   -> Pam250;
      case "identity" -> Identity;
      default -> throw new IllegalArgumentException(
        "Unrecognized scoring matrix value \"" + value + "\""
      );
    };
  }

  @JsonCreator
  public static ScoringMatrix fromJSON(JsonNode js) {
    return fromString(js.textValue());
  }

  @JsonValue
  @Override
  public JsonNode toJSON() {
    return JSONConstructor.newText(getValue());
  }
}
