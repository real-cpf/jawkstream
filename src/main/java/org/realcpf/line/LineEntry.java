package org.realcpf.line;

import java.util.Arrays;

public class LineEntry {
  private String[] values;
  public LineEntry setValues(String[] values){
    this.values = values;
    return this;
  }
  public String getAt(String $i){
    if ("$0".equals($i)){
      return toString();
    }
    int i = Integer.parseInt($i.substring(1));
    if (i <= values.length) {
      return values[i-1];
    }
    throw new IllegalArgumentException(String.format("%d is out of range for values",i));
  }

  @Override
  public String toString() {
    return Arrays.toString(values);
  }
}
