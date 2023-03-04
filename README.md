## try awk in java with stream

[The GNU Awk User’s Guide](https://www.gnu.org/software/gawk/manual/gawk.html)

### current impl examples
+ awk -F, '{print($1)}' src/main/resources/test-file.csv
 ```java
 public class Demo {
  public static void main(String[] args) {
    String path = "./src/main/resources/test-file.csv";
    ExprProcess exprProcess = new ExprProcess(",","{print($1)}");
    exprProcess.doWith(path);
  }
}
 ```
+ awk -F, '{if($1==1)print($1,$2,$3)}' src/main/resources/test-file.csv
 ```java
public class Demo {
  public static void main(String[] args) {
    String path = "./src/main/resources/test-file.csv";
    ExprProcess exprProcess = new ExprProcess(",","{if($1==a) print($1,$2,$3)}");
    exprProcess.doWith(path);
  }
}
 ```
