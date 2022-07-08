package interpreter.debugger;

import java.util.HashMap;

import interpreter.CodeTable;

public class DebuggerCodeTable {
  private static HashMap<String, String> codeMap = new HashMap<>();

  public static void init() {
    CodeTable.init();

    // Initialize the new byte codes required for debugging:
    // codeMap.put(... etc. ...)

    codeMap.put("FORMAL", "FormalCode");
    codeMap.put("FUNCTION", "FunctionCode");
    codeMap.put("LINE", "LineCode");
    codeMap.put("POP", "PopDebugger");
    codeMap.put("RETURN", "ReturnDebugger");
    codeMap.put("LIT", "LitDebugger");
    codeMap.put("CALL", "CallDebugger");
  }

  public static String get(String code) {
    String result = codeMap.get(code.trim().toUpperCase());

    if(result == null) {
      return CodeTable.get(code);
    } else {
      return result;
    }
  }
}