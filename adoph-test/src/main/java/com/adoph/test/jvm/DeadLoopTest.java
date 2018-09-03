package com.adoph.test.jvm;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/29
 */
public class DeadLoopTest {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + " init DeadLoopTest");
            while (true) {
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");
                DeadLoopTest deadLoopTest = new DeadLoopTest();
                System.out.println(Thread.currentThread() + " run over");
            }
        };
        new Thread(script).start();
        new Thread(script).start();
    }
}
