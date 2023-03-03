package org.realcpf.function;

import org.realcpf.line.LineEntry;

import java.util.List;

public interface FF {
  Object eval(LineEntry lineEntry, List<String> theParams);
  default boolean is$Ele(String s){
    return s.startsWith("$");
  }
}
