package com.adoph.test.design.pattern.observer.v6;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/9
 */
public class Test {
    public static void main(String[] args) {
        Child c = new Child();
        c.addObserver(new Parent());
        new Thread(c).start();
    }
}
