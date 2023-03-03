package org.realcpf.process;

import org.realcpf.function.FF;
import org.realcpf.line.LineEntry;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class ExprProcess {
  private final String F;
  private final List<Statement> statements;

  public ExprProcess(String f, String script) {
    this.F = f;
    int left = script.indexOf("{");
    int right = script.lastIndexOf("}");
    String expressPart = script.substring(left + 1, right);
    Expression expression = new Expression(expressPart);
    statements = expression.parse();
  }

  private String exec(LineEntry lineEntry) {
    Object state = null;
    Stack<FF> ffs = new Stack<>();
    List<String> tmp = new ArrayList<>();
    boolean hasFunc = false;
    for (Statement s:statements) {
      if (s.isFunc()) {
        if (hasFunc) {
          state = ffs.pop().eval(lineEntry,tmp);
          if (state instanceof Boolean b) {
            if (!b) return "";
          }
          tmp.clear();
        }
        ffs.add(s.getFunc());
        hasFunc = true;
      } else {
        tmp.add(s.toString());
      }
    }
    if (hasFunc) {
      state = ffs.pop().eval(lineEntry,tmp);
    }
    return (String) state;
  }

  public void doWith(String filepath) {
    Path path = Path.of(filepath);
    try (Stream<String> stream = Files.lines(path)) {
      stream.map(l -> new LineEntry().setValues(l.split(F))).
        forEach(lineEntry -> System.out.println(exec(lineEntry)));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
