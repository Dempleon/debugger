package interpreter.debugger.ui;

public class DebuggerExit extends DebuggerCommand {
    @Override
    public void execute() {
        System.out.println("Exiting system");
        System.exit(1);
    }
}
