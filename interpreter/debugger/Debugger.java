package interpreter.debugger;

import interpreter.ByteCodeLoader;
import interpreter.Interpreter;
import interpreter.Program;
import interpreter.debugger.ui.DebuggerShell;
import java.util.Stack;
import java.io.IOException;
import java.util.Vector;
import java.nio.file.*;

public class Debugger extends Interpreter {
  private String sourceFileName;
  private String codeFileName;
  private DebuggerShell shell;
  Vector<Entry> entries = new Vector<>();
  private Stack <FunctionEnvironmentRecord> functionEnvironmentRecordStack;


  public Debugger(String baseFileName) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
    super(baseFileName);
    // Update to add the correct extensions to the base file name to
    // load the byte code file, as well as to load the source file

    sourceFileName = baseFileName + ".x";
    codeFileName = sourceFileName + ".cod";

    printSource();
    try{
      DebuggerCodeTable.init();
      byteCodeLoader = new ByteCodeLoader(sourceFileName);
    } catch (Exception e) {
      System.out.println("debugger ***" + e);
    }

  }

  @Override
  public void run() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
    shell = new DebuggerShell(this);

    Program program = byteCodeLoader.loadCodes();


    DebuggerVirtualMachine vm = new DebuggerVirtualMachine(program, this);

    shell.prompt().execute();
  }

  private void printSource() throws IOException {
    String sourceCode = "";
    sourceCode = new String(Files.readAllBytes(Paths.get(sourceFileName)));
    System.out.println(sourceCode);
  }

  public String getSourceFileName() {
    return sourceFileName;
  }

}

