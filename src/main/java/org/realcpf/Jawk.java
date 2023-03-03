package org.realcpf;

import org.realcpf.process.ExprProcess;

public class Jawk {
  public static void main(String[] args) {
    String path = "./src/main/resources/test-file.csv";

    ExprProcess exprProcess = new ExprProcess(",","{if(($1==a)&&(2==2)) print($1,$2,$3)}");
    exprProcess.doWith(path);


  }
}
