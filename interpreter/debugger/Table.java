package interpreter.debugger;

import java.util.HashMap;

public class Table {
    private java.util.HashMap<String, Binder> symbols = new java.util.HashMap<>();
    private String top;
    private Binder marks;


    public Table() {}

    public Object get(String key) {
        Binder e = symbols.get(key);
        //System.out.println("debug: " + symbols.get(key));
        return e.getValue();
    }

    public void put(String key, Object value) {
        symbols.put(key, new Binder(value, top, symbols.get(key)));
        top = key;
    }

    public void beginScope() {
        marks = new Binder(null, top, marks);
        top = null;
    }

    public void endScope() {
        while (top != null) {
            Binder e = symbols.get(top);
            if (e.getTail() != null) {
                symbols.put(top, e.getTail());
            }
            else {
                top = e.getPrevtop();
            }
        }

        top = marks.getPrevtop();
        marks = marks.getTail();
    }

    public java.util.Set<String> keys() {
        return symbols.keySet();
    }

    public void pop(int count) {

        for(int i = 0; i < count; i++){
            Binder topBinder = symbols.get(top);

            if(topBinder == null){
                //symbols.put(top, topBinder.getTail());
                symbols.remove(top);
            }
            else {
                //symbols.remove(top);
                symbols.put(top, topBinder.getTail());
            }
            top = topBinder.getPrevtop();
        }
    }

    public HashMap<String, Binder> getSymbols() {
        return this.symbols;
    }

}

class Binder {
    private Object value;
    private String prevtop;
    private Binder tail;

    Binder(Object val, String prev, Binder tail) {
        value = val;
        prevtop = prev;
        this.tail = tail;
    }

    Object getValue() {
        return value;
    }

    String getPrevtop() {
        return prevtop;
    }

    Binder getTail() {
        return tail;
    }


}
