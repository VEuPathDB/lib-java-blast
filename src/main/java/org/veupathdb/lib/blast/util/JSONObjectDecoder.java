package org.veupathdb.lib.blast.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class JSONObjectDecoder
{
  private final ObjectNode js;

  @JsonCreator
  public JSONObjectDecoder(ObjectNode js) {
    this.js = js;
  }

  public void decode(String key, StringSetter fn) {
    var val = js.get(key);
    if (val != null)
      fn.accept(val.textValue());
  }

  public void decode(String key, LongSetter fn) {
    var val = js.get(key);
    if (val != null)
      fn.accept(val.longValue());
  }

  public void decode(String key, DoubleSetter fn) {
    var val = js.get(key);
    if (val != null)
      fn.accept(val.doubleValue());
  }

  public void decode(String key, BoolSetter fn) {
    var val = js.get(key);
    if (val != null)
      fn.accept(val.booleanValue());
  }

  public void decode(String key, IntSetter fn) {
    var val = js.get(key);
    if (val != null)
      fn.accept(val.intValue());
  }

  public void decode(String key, ByteSetter fn) {
    var val = js.get(key);
    if (val != null) {
      fn.accept((byte) val.intValue());
    }
  }

  public void decode(String key, ShortSetter fn) {
    var val = js.get(key);
    if (val != null)
      fn.accept(val.shortValue());
  }

  public void decode(String key, StrArrSetter fn) {
    var val = js.get(key);

    if (val == null || val.isEmpty())
      return;

    var tmp = new ArrayList<String>(val.size());

    val.forEach(v -> tmp.add(v.textValue()));

    fn.accept(tmp);
  }

  public <T> void decode(String key, Consumer<T> fn, Function<JsonNode, T> conv) {
    var val = js.get(key);
    if (val != null)
      fn.accept(conv.apply(val));
  }

  public interface BoolSetter   extends Consumer<Boolean>      {}
  public interface ByteSetter   extends Consumer<Byte>         {}
  public interface ShortSetter  extends Consumer<Short>        {}
  public interface IntSetter    extends Consumer<Integer>      {}
  public interface LongSetter   extends Consumer<Long>         {}
  public interface DoubleSetter extends Consumer<Double>       {}
  public interface StringSetter extends Consumer<String>       {}
  public interface StrArrSetter extends Consumer<List<String>> {}

  @Override
  public String toString() {
    return js.toString();
  }
}
