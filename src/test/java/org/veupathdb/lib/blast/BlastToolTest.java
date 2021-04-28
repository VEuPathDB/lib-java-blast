package org.veupathdb.lib.blast;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BlastTool")
class BlastToolTest
{
  @Test
  @DisplayName("::fromString(String)")
  void fromString1() {
    for (var val : BlastTool.values()) {
      assertEquals(val, BlastTool.fromString(val.getValue()));
    }
  }
}