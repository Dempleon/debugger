package interpreter.debugger;

public class Entry {

    private int lineNumber;
    private String sourceLine;
    private Boolean isBreakPointLine;

    public void setLineNumber(int line) {
        lineNumber = line;
    }

    public void setSourceLine(String sourceLine) {
        this.sourceLine = sourceLine;
    }

    public void setIsBreakPointLine(Boolean status) {
        isBreakPointLine = status;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getSourceLine() {
        return sourceLine;
    }

    Boolean getIsBreakPointLine(){
        return isBreakPointLine;
    }

}
