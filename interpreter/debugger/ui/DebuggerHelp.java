package interpreter.debugger.ui;

public class DebuggerHelp extends DebuggerCommand {
    @Override
    public void execute() {
        System.out.println("help \nset \nlist \nsource \nstep \ncontinue \nexit");
    }
}
