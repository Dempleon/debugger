package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class LineCode extends ByteCode {

    private int lineNumber;

    @Override
    public void init(ArrayList args) {
        lineNumber = Integer.parseInt((String) args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {

    }
}
