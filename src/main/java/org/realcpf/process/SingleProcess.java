package org.realcpf.process;

import org.realcpf.function.FF;
import org.realcpf.function.FFPrint;
import org.realcpf.line.LineEntry;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SingleProcess {
  private final String F;
  private final String script;
  private final List<FF> ffs = new ArrayList<>();

  public SingleProcess(String f, String script) {
    this.F = f;
    this.script = script;
    parseScript();
  }

  private void parseScript() {
    int left = script.indexOf("{");
    int right = script.lastIndexOf("}");
    String expressPart = script.substring(left, right);
    // get functions
    ffs.add(new FFPrint(expressPart));
  }

  public void doWith(String filepath) {
    Path path = Path.of(filepath);
    try (Stream<String> stream = Files.lines(path)) {
      stream.map(l -> new LineEntry().setValues(l.split(F))).forEach(lineEntry -> {
        ffs.forEach(ff -> {
          ff.eval(lineEntry);
        });
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
