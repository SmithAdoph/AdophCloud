package com.adoph.test.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/17
 */
public class ThreadTest {

    private final Object lock = new Object();

    private void notifyThread() {
        synchronized (lock) {
            lock.notify();
        }
    }

    private void createBusyThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        }, "testBusyThread").start();
    }

    private void createLockThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread").start();
    }

    public static void main(String[] args) throws Exception {
        ThreadTest tt = new ThreadTest();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//        tt.createBusyThread();
//        br.readLine();
//        tt.createLockThread();
//        br.readLine();
//        tt.notifyThread();
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }

    static class SynAddRunnable implements Runnable {
        int a, b;

        public SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(Thread.currentThread().getName() + ":" + (a + b));
                }
            }
        }
    }

}
