package com.adoph.test.sync;

/**
 * Synchronized
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/9/21
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        Object lock = new Object();
        PrintLog p1 = new PrintLog(lock, "wait");
        PrintLog p2 = new PrintLog(lock, "info");
        new Thread(p1).start();
        new Thread(p2).start();
    }

    static class PrintLog implements Runnable {

        private final Object lock;
        private String type;

        PrintLog(Object lock, String type) {
            this.lock = lock;
            this.type = type;
        }

        @Override
        public void run() {
            synchronized (lock) {
                if (type.equals("info")) {
                    System.out.println("info...");
                    System.out.println("notify...");
                    lock.notify();
                }
                if (type.equals("wait")) {
                    try {
                        System.out.println("wait start...");
                        lock.wait();
                        System.out.println("wait end...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
