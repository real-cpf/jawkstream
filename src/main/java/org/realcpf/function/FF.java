package org.realcpf.function;

import org.realcpf.line.LineEntry;

public interface FF {
  Object eval(LineEntry lineEntry);
  default String[] getParams(String part){
    int index1 = part.indexOf(" ");
    if (index1 == -1 || index1 == part.length() - 1) {
      return null;
    }
    String params = part.substring(index1);
    return params.split(",");
  }
  default boolean is$Ele(String s){
    return s.startsWith("$");
  }
}
