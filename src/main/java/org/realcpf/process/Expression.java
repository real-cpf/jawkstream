package org.realcpf.process;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Expression {
  public Expression(String text) {
    this.text = text;
  }

  final private String text;

  public List<Statement> parse() {
    final String s = this.text.replaceAll("\\s+", "");
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    List<Statement> statements = new LinkedList<>();
    StringBuilder stringBuffer = new StringBuilder();
    for (char c : chars) {
      if ('(' == c) {
        stack.add(')');
        if (stringBuffer.length() > 0) {
          statements.add(new Statement(stringBuffer.toString()));
          stringBuffer.setLength(0);
        }
      } else if (')' == c) {
        stack.pop();
        if (stringBuffer.length() > 0) {
          statements.add(new Statement(stringBuffer.toString()));
          stringBuffer.setLength(0);
        }
      } else {
        stringBuffer.append(c);
      }
    }
    return statements;
  }

}
