package com.adoph.test.thead;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/6/29
 */
public class ThreadTest {

    public static void main(String[] args) {
        Color threadTest = new Color();
        Thread t = new Thread(threadTest);
        t.start();
        threadTest.m2();
        System.out.println("main:" + threadTest.getB());
    }

}

class Color implements Runnable {
    private int b;

    @Override
    public void run() {
        m1();
    }

    public synchronized void m1() {
        b = 1000;
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("m1赋值。。。b=" + b);
    }

    public synchronized void m2() {
        try {
            Thread.sleep(250);
        } catch (Exception e) {
            e.printStackTrace();
        }
        b = 2000;
        System.out.println("m2赋值。。。b=" + b);
    }

    public int getB() {
        return b;
    }
}

class Car extends Color {

}

class Bus extends Color {

}
