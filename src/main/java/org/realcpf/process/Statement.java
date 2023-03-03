package org.realcpf.process;

import org.realcpf.function.FF;
import org.realcpf.function.FFIf;
import org.realcpf.function.FFPrint;

import java.util.HashSet;
import java.util.Set;

public class Statement {
  private static final Set<String> FUNC_SET = new HashSet<>(16);

  static {
    FUNC_SET.add("if");
    FUNC_SET.add("print");
  }
  final private String text;
  public Statement(String text) {
    this.text = text;
  }
  public boolean isFunc(){
    return FUNC_SET.contains(this.text);
  }
  public FF getFunc(){
    switch (text) {
      case "if" ->{
        return new FFIf();
      }
      case "print" ->{
        return new FFPrint();
      }
      default -> {
        return null;
      }
    }
  }

  @Override
  public String toString() {
    return text;
  }
}
