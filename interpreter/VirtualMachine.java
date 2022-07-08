package interpreter;

import java.util.Stack;
import interpreter.bytecode.ByteCode;

public class VirtualMachine {

  private int pc;
  private RunTimeStack runTimeStack;
  // This may not be the right parameterized type!!
  private Stack<Object> returnAddresses;
  private boolean isRunning;
  private Program program;
  private boolean dumpState = false;

  public VirtualMachine(Program program) {
    this.program = program;
  }

  public void executeProgram() {
    pc = 0;
    runTimeStack = new RunTimeStack();
    returnAddresses = new Stack<>();
    isRunning = true;

    while (isRunning) {
      ByteCode code = program.getCode(pc);
      code.execute(this);
      //runTimeStack.dump(); // check that the operation is correct
      if(dumpState == true){
        runTimeStack.dump();
      }
      pc++;
    }
  }

  public void haltRun() {
    isRunning = false;
  }

  public int popRunStack() {
    return runTimeStack.pop();
  }

  public void setPc (int target) {
    this.pc = target;
  }

  public void pushAddress(int address) {
    returnAddresses.push(pc);
    setPc(address);
  }

  public void vmPush(int n) {
    runTimeStack.push(n);
  }
  public int vmPop() {
    return runTimeStack.pop();
  }

  public void vmNewFrame(Integer offset) {
    runTimeStack.newFrameAt(offset);
  }

  public void vmPopFrame() {
    runTimeStack.popFrame();
  }

  public int vmPeek() {
    return runTimeStack.peek();
  }

  public void vmStore(int offset) {
    runTimeStack.store(offset);
  }

  public void vmLoad(int offset) {
    runTimeStack.load(offset);
  }

  public int vmPopReturnAddresses() {
    return (int) returnAddresses.pop();
  }

  public void setDumpOn() {
    this.dumpState = true;
  }
  public void setDumpOff() {
    this.dumpState = false;
  }
  public boolean getDumpStatus() {
    return dumpState;
  }
}