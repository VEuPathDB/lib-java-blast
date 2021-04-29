package org.veupathdb.lib.blast.field;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.veupathdb.lib.blast.consts.Key;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({Key.Type, Key.Delimiter, Key.Fields})
public class OutFormat
{
  private FormatType        type;
  private String            delimiter;
  private List<FormatField> fields = new ArrayList<>();

  @JsonGetter(Key.Type)
  public FormatType getType() {
    return type;
  }

  @JsonSetter(Key.Type)
  public OutFormat setType(FormatType type) {
    this.type = type;
    return this;
  }

  @JsonGetter(Key.Delimiter)
  public String getDelimiter() {
    return delimiter;
  }

  @JsonSetter(Key.Delimiter)
  public OutFormat setDelimiter(String delimiter) {
    this.delimiter = delimiter;
    return this;
  }

  @JsonGetter(Key.Fields)
  public List<FormatField> getFields() {
    return fields;
  }

  @JsonSetter(Key.Fields)
  public OutFormat setFields(List<FormatField> fields) {
    this.fields = fields;
    return this;
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
      .setFields(new ArrayList<>(fields));
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
}
