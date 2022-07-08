package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class FormalCode extends ByteCode {

    private String name;
    private int offset;


    @Override
    public void init(ArrayList args) {
        name = (String) args.get(0);
        offset = Integer.parseInt((String) args.get(1));
    }

    @Override
    public void execute(VirtualMachine vm) {

    }
}
