package interpreter.debugger;


import java.util.Iterator;

public class FunctionEnvironmentRecord {


  private String functionName;
  private int startline;
  private int endLine;
  private int currentLine;
  private static Table table;

  public FunctionEnvironmentRecord() {
    table = new Table();
    functionName = new String();
    startline = 0;
    endLine = 0;
    currentLine = 0;
  }

  public void beginScope() {
    table.beginScope();
  }

  public void setFunctionInfo(String functionName, int startingLineNumber, int endingLineNumber) {
    this.functionName = functionName;
    startline = startingLineNumber;
    endLine = endingLineNumber;
  }

  public void setCurrentLineNumber(int currentLineNumber) {
    currentLine = currentLineNumber;
  }

  public void enter(String symbol, int value) {
    table.put(symbol, value);
  }

  public void pop(int count) {
    table.pop(count);
  }

  /**
   * Utility method to test your implementation. The output should be:
   * (<>, -, -, -, -)
   * (<>, g, 1, 20, -)
   * (<>, g, 1, 20, 5)
   * (<a/4>, g, 1, 20, 5)
   * (<b/2, a/4>, g, 1, 20, 5)
   * (<b/2, a/4, c/7>, g, 1, 20, 5)
   * (<b/2, a/1, c/7>, g, 1, 20, 5)
   * (<b/2, a/4>, g, 1, 20, 5)
   * (<a/4>, g, 1, 20, 5)
   */
  public static void main(String[] args) {
    FunctionEnvironmentRecord record = new FunctionEnvironmentRecord();

    record.beginScope();
    System.out.println(record);

    record.setFunctionInfo("g", 1, 20);
    System.out.println(record);

    record.setCurrentLineNumber(5);
    System.out.println(record);

    record.enter("a", 4);
    System.out.println(record);

    record.enter("b", 2);
    System.out.println(record);

    record.enter("c", 7);
    System.out.println(record);

    record.enter("a", 1);
    System.out.println(record);

    record.pop(2);
    System.out.println(record);

    record.pop(1);
    System.out.println(record);
  }


  public String toString() {

    String str = "(<";
    Iterator iterator = table.keys().iterator();
    String command;
    Integer value;

    while (iterator.hasNext()) {

      command = iterator.next().toString();
      value = (Integer) table.get(command);

      if (iterator.hasNext()) {
        str += command + "/" + value.toString() + ", ";
      }
      else {
        str += command + "/" + value.toString();
      }
    }
    str += ">, ";
    if (functionName.isEmpty()) {
      str += "-, -, -, -";
    } else if (currentLine == 0) {
      str += functionName + ", " + startline + ", " + endLine + ", -";

    } else {
      str += functionName + ", " + startline + ", " + endLine + ", " + currentLine;
    }

    str += ")";
    return str;
  }



}
