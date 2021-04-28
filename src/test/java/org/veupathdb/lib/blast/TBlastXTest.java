package org.veupathdb.lib.blast;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.veupathdb.lib.blast.consts.Flag;
import org.veupathdb.lib.blast.field.Location;
import org.veupathdb.lib.blast.field.Seg;
import org.veupathdb.lib.blast.field.Strand;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TBlastX")
class TBlastXTest
{
  private final ObjectMapper json = new ObjectMapper();

  @Nested
  @DisplayName(Flag.Strand)
  class Strand1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setStrand(Strand.Minus);

      assertEquals("{\"-strand\":\"minus\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-strand\":\"minus\"}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals(Strand.Minus, tgt.getStrand());
    }
  }

  @Nested
  @DisplayName(Flag.QueryGenCode)
  class QueryGenCode1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setQueryGenCode((short) 1285);

      assertEquals("{\"-query_gencode\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-query_gencode\":1285}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals((short) 1285, tgt.getQueryGenCode());
    }
  }

  @Nested
  @DisplayName(Flag.WordSize)
  class WordSize1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setWordSize(1285L);

      assertEquals("{\"-word_size\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-word_size\":1285}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals(1285, tgt.getWordSize());
    }
  }

  @Nested
  @DisplayName(Flag.MaxIntronLength)
  class MaxIntronLength1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setMaxIntronLength(1285L);

      assertEquals("{\"-max_intron_length\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-max_intron_length\":1285}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals(1285, tgt.getMaxIntronLength());
    }
  }

  @Nested
  @DisplayName(Flag.Matrix)
  class Matrix1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setMatrix("hi");

      assertEquals("{\"-matrix\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-matrix\":\"hi\"}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals("hi", tgt.getMatrix());
    }
  }

  @Nested
  @DisplayName(Flag.Threshold)
  class Threshold1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setThreshold(3.14);

      assertEquals("{\"-threshold\":3.14}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-threshold\":3.14}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals(3.14, tgt.getThreshold());
    }
  }

  @Nested
  @DisplayName(Flag.DBGenCode)
  class DBGenCode1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setDBGenCode((short) 1285);

      assertEquals("{\"-db_gencode\":1285}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-db_gencode\":1285}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals((short) 1285, tgt.getDBGenCode());
    }
  }

  @Nested
  @DisplayName(Flag.SubjectFile)
  class SubjectFile1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setSubjectFile("hi");

      assertEquals("{\"-subject\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject\":\"hi\"}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals("hi", tgt.getSubjectFile());
    }
  }

  @Nested
  @DisplayName(Flag.SubjectLocation)
  class SubjectLocation1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setSubjectLocation(new Location(10, 11));

      assertEquals("{\"-subject_loc\":{\"start\":10,\"stop\":11}}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-subject_loc\":{\"start\":10,\"stop\":11}}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals(10, tgt.getSubjectLocation().getStart());
      assertEquals(11, tgt.getSubjectLocation().getStop());
    }
  }

  @Nested
  @DisplayName(Flag.Seg)
  class Seg1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setSeg(Seg.yesSeg());

      assertEquals("{\"-seg\":\"yes\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-seg\":\"yes\"}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertTrue(tgt.getSeg().isYes());
    }
  }

  @Nested
  @DisplayName(Flag.DBSoftMask)
  class DBSoftMask1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setDBSoftMask("hi");

      assertEquals("{\"-db_soft_mask\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-db_soft_mask\":\"hi\"}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals("hi", tgt.getDBSoftMask());
    }
  }

  @Nested
  @DisplayName(Flag.DBHardMask)
  class DBHardMask1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setDBHardMask("hi");

      assertEquals("{\"-db_hard_mask\":\"hi\"}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-db_hard_mask\":\"hi\"}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals("hi", tgt.getDBHardMask());
    }
  }

  @Nested
  @DisplayName(Flag.CullingLimit)
  class CullingLimit1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setCullingLimit(123L);

      assertEquals("{\"-culling_limit\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-culling_limit\":123}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals(123, tgt.getCullingLimit());
    }
  }

  @Nested
  @DisplayName(Flag.SumStats)
  class SumStats1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setSumStats(true);

      assertEquals("{\"-sum_stats\":true}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-sum_stats\":true}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals(true, tgt.getSumStats());
    }
  }

  @Nested
  @DisplayName(Flag.NumThreads)
  class NumThreads1
  {
    @Test
    @DisplayName("serialization")
    void test1() throws Exception {
      var tgt = new TBlastX();
      tgt.setNumThreads((short) 123);

      assertEquals("{\"-num_threads\":123}", json.writeValueAsString(tgt));
    }

    @Test
    @DisplayName("deserialization")
    void test2() throws Exception {
      var raw = "{\"-num_threads\":123}";
      var tgt = json.readValue(raw, TBlastX.class);

      assertEquals((short) 123, tgt.getNumThreads());
    }
  }

}