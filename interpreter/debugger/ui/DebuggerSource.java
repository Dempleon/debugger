package interpreter.debugger.ui;

import interpreter.debugger.Debugger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DebuggerSource extends DebuggerCommand {
    private String sourceFile;



    @Override
    public void execute() {

    }

//    private void printSource() throws IOException {
//        String sourceCode = "";
//        sourceCode = new String(Files.readAllBytes(Paths.get(sourceFile)));
//        System.out.println(sourceCode);
//    }
}
