package org.veupathdb.lib.blast.util;

import com.fasterxml.jackson.annotation.JsonValue;

public interface JSONEncodable
{
  @JsonValue
  JSONObjectEncoder toJSON();
}
