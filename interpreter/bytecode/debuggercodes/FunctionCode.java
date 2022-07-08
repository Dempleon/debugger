package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class FunctionCode extends ByteCode {

    private String name;
    private int start;
    private int end;

    @Override
    public void init(ArrayList args) {
        name = (String) args.get(0);
        start = Integer.parseInt((String) args.get(1));
        end = Integer.parseInt((String) args.get(2));
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

}
