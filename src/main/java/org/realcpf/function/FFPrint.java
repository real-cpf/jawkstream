package org.realcpf.function;

import org.realcpf.line.LineEntry;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FFPrint implements FF{

  private final String partScript;
  public FFPrint(String partScript){
    this.partScript = partScript;
  }

  @Override
  public Object eval(LineEntry lineEntry) {
    String[] params = getParams(this.partScript);
    String line = Arrays.stream(params).map(String::trim).map(e->{
      if (is$Ele(e)) return lineEntry.getAt(e);
      else return e;
    }).collect(Collectors.joining(" "));
    System.out.println(line);
    return "done";
  }

}
