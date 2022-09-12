package com.adoph.test.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 无论是sleep或wait都不会释放线程资源
 *
 * @author tangqd
 * @version 1.0
 * @since 2021/9/9
 */
public class ThreadResourceTest {

    public static void main(String[] args) {
//        testWait();
        testSleep();
    }

    public static final Object lock = new Object();

    public static void testWait() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 2; i++) {
            int tmp = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (tmp == 0) {
                            synchronized (lock) {
                                System.out.println(Thread.currentThread().getName() + " invoke wait.");
                                lock.wait();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + " print log" + tmp);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void testSleep() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
            int tmp = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (tmp == 0) {
                            System.out.println(Thread.currentThread().getName() + " invoke sleep.");
                            TimeUnit.SECONDS.sleep(2);
                        }
                        System.out.println(Thread.currentThread().getName() + " print log" + tmp);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
