package interpreter.debugger.ui;

import java.util.Scanner;

public class DebuggerSet extends DebuggerCommand{

    private int lineNumber;

    @Override
    public void execute() {
        System.out.println("Enter Line");
        Scanner userScan = new Scanner(System.in);
        lineNumber = userScan.nextInt();

    }
}
