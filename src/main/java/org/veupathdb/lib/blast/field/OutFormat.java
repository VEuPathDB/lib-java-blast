package org.veupathdb.lib.blast.field;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.consts.Key;
import org.veupathdb.lib.blast.util.DefaultingJSONValue;
import org.veupathdb.lib.blast.util.JSONConstructor;

public class OutFormat implements DefaultingJSONValue
{
  public static final FormatType DefaultFormatType = FormatType.Pairwise;

  private FormatType        type;
  private String            delimiter;
  private List<FormatField> fields = new ArrayList<>();

  public FormatType getType() {
    return type;
  }

  public OutFormat setType(FormatType type) {
    this.type = type;
    return this;
  }

  public String getDelimiter() {
    return delimiter;
  }

  public OutFormat setDelimiter(String delimiter) {
    this.delimiter = delimiter;
    return this;
  }

  public List<FormatField> getFields() {
    return fields;
  }

  public OutFormat setFields(List<FormatField> fields) {
    this.fields = fields;
    return this;
  }

  @Override
  public boolean isDefault() {
    return (type == null || type == DefaultFormatType) &&
      (delimiter == null || delimiter.isBlank()) &&
      (
        fields == null ||
        fields.isEmpty() ||
        (fields.size() == 1 && fields.get(0) == FormatField.StandardFields)
      );
  }

  @Override
  public String toString() {
    var out = new StringBuilder();
    if (getType() != null)
      out.append(getType().getValue());

    if (!getDelimiter().isEmpty()) {
      out.append(" delim=").append(getDelimiter());
    }

    for (var field : getFields())
      out.append(" ").append(field.getValue());

    return out.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OutFormat outFormat = (OutFormat) o;
    return getType() == outFormat.getType() && Objects.equals(
      getDelimiter(),
      outFormat.getDelimiter()
    ) && Objects.equals(getFields(), outFormat.getFields());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getType(), getDelimiter(), getFields());
  }

  public OutFormat copy() {
    return new OutFormat()
      .setType(getType())
      .setDelimiter(getDelimiter())
      .setFields(fields == null ? null : new ArrayList<>(fields));
  }

  public static OutFormat fromString(String value) {
    if (value.isBlank())
      return new OutFormat().setType(FormatType.Pairwise);

    var split = value.split(" +");
    var out   = new OutFormat();

    out.setType(FormatType.fromIntValue(Integer.parseInt(split[0])));

    if (split.length > 1) {
      var start = 1;
      if (split[1].startsWith("delim=")) {
        out.setDelimiter(split[1].substring(6));
        start = 2;
      }

      for (; start < split.length; start++) {
        out.getFields().add(FormatField.fromString(split[start]));
      }
    }

    return out;
  }

  @JsonValue
  @Override
  public JsonNode toJSON() {
    var out = JSONConstructor.newObject();

    if (type != null)
      out.set(Key.Type, type.toJSON());

    if (delimiter != null && !delimiter.isBlank())
      out.set(Key.Delimiter, JSONConstructor.newText(delimiter));

    if (
      fields != null &&
      !fields.isEmpty() &&
      (fields.size() > 1 || fields.get(0) != FormatField.StandardFields)
    )
      out.set(Key.Fields, JSONConstructor.newArray(fields));

    return out;
  }

  @JsonCreator
  public static OutFormat fromJSON(JsonNode js) {
    var out = new OutFormat();

    if (js.has(Key.Type))
      out.type = FormatType.fromIntValue(js.get(Key.Type).intValue());
    if (js.has(Key.Delimiter))
      out.delimiter = js.get(Key.Delimiter).textValue();
    if (js.has(Key.Fields))
      js.get(Key.Fields).forEach(f -> out.fields.add(FormatField.fromString(f.textValue())));

    return out;
  }
}
