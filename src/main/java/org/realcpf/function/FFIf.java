package org.realcpf.function;

import org.realcpf.line.LineEntry;

import java.util.List;

public class FFIf implements FF{
  private boolean calc(LineEntry lineEntry,String part) {
    String[] pp = part.split("==|<|>");
    String left = is$Ele(pp[0]) ? lineEntry.getAt(pp[0]) : pp[0];
    String right = is$Ele(pp[1]) ? lineEntry.getAt(pp[1]) : pp[1];
    if (part.contains("==")) {
      return left.equals(right);
    }else if(part.contains("<")) {
      return left.compareTo(right) > 0;
    } else {
      return left.compareTo(right) < 0;
    }
  }
  @Override
  public Object eval(LineEntry lineEntry, List<String> theParam) {

    boolean tmp =calc(lineEntry,theParam.get(0));
    boolean res = tmp;
    String flag = "";
    for (int i = 1; i < theParam.size(); i++) {
      if ("&&".equals(theParam.get(i)) || "||".equals(theParam.get(i))) {
        flag = theParam.get(i);
      } else {
        if (flag.equals("&&")) {
          res = tmp && calc(lineEntry,theParam.get(i));
        } else{
          res = tmp || calc(lineEntry,theParam.get(i));
        }
      }
    }
    return res;
  }

}
