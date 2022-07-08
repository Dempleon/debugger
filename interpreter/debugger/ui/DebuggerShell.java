package interpreter.debugger.ui;

import interpreter.debugger.Debugger;

import java.util.Scanner;

public class DebuggerShell {
  private String source;
  private String userCommand;
  private DebuggerCommand command;
  Debugger debugger;

  public DebuggerShell(Debugger debugger) {
    this.debugger = debugger;
  }

  public DebuggerCommand prompt() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Create the correct command object here, based on user interaction,
    // and return
    //System.out.println("user command:" + userCommand);

    source = debugger.getSourceFileName();
    System.out.println("Type ? for help");
    System.out.print(">");
    Scanner scan = new Scanner(System.in);
    userCommand = scan.next();

    if(userCommand.equals("?")){
      command = (DebuggerCommand) Class.forName("interpreter.debugger.ui.DebuggerHelp").newInstance();
    }
    else {
      userCommand = userCommand.substring(0,1).toUpperCase() + userCommand.substring(1);
      command = (DebuggerCommand) (Class.forName("interpreter.debugger.ui.Debugger" + userCommand).newInstance());
    }

    //command.execute();
    return command;
  }
}