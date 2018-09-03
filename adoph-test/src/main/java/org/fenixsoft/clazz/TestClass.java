package org.fenixsoft.clazz;

public class TestClass {
    private int m;

    public synchronized void sub() {
        System.out.println(1);
    }

    public void action() {
        synchronized (this) {
            System.out.println(2);
        }
    }

    public int inc() {
        return m + 1;
    }
}