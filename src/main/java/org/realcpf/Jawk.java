package org.realcpf;

import org.realcpf.process.SingleProcess;

public class Jawk {
  public static void main(String[] args) {
    SingleProcess process = new SingleProcess(",","{print $1,$2}");
    process.doWith("./src/main/resources/test-file.csv");
  }
}
