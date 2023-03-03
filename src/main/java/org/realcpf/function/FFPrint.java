package org.realcpf.function;

import org.realcpf.line.LineEntry;

import java.util.List;

public class FFPrint implements FF{

  @Override
  public Object eval(LineEntry lineEntry, List<String> theParam) {
    StringBuffer stringBuffer = new StringBuffer();
    theParam.forEach(e->{
      String[] strings = e.split(",");
      for (String s:strings) {
        if (is$Ele(s)) stringBuffer.append(lineEntry.getAt(s));
        else stringBuffer.append(s);
        stringBuffer.append(" ");
      }

    });
    return stringBuffer.toString();
  }

}
