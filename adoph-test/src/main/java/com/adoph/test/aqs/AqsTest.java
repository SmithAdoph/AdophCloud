package com.adoph.test.aqs;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试Object的wait和notify
 *
 * @author tangqiandong
 * @version v1.0
 * @date 2020/3/8
 */
public class AqsTest {

    @Test
    public void testReentrantLock() throws InterruptedException {
        ReentrantLockTest t1 = new ReentrantLockTest("线程1");
        ReentrantLockTest t2 = new ReentrantLockTest("线程2");

        t1.start();
        t2.start();

        // 让主线程等待子线程执行完成，t1、t2线程会交替执行
        t1.join();
        t2.join();

        System.out.println(ReentrantLockTest.total);
    }

    static class ReentrantLockTest extends Thread {

        public static ReentrantLock lock = new ReentrantLock();
        public static int total = 0;

        public ReentrantLockTest(String name) {
            this.setName(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    total++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    @Test
    public void testSync() {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Thread t1 = new Thread(synchronizedTest::print1);
        Thread t2 = new Thread(synchronizedTest::print2);

        t2.start();
        t1.start();
    }

    @Test
    public void testSync1() {
        SynchronizedTest1 synchronizedTest = new SynchronizedTest1();
        Thread t1 = new Thread(synchronizedTest::print1);
        Thread t2 = new Thread(synchronizedTest::print2);

        t2.start();
        t1.start();
    }

    public static void main(String[] args) {
//        SynchronizedTest1 synchronizedTest = new SynchronizedTest1();
//        Thread t1 = new Thread(synchronizedTest::print1);
//        Thread t2 = new Thread(synchronizedTest::print2);
//
//        t2.start();
//        t1.start();


        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Thread t1 = new Thread(synchronizedTest::print1);
        Thread t2 = new Thread(synchronizedTest::print2);

        t2.start();
        t1.start();
    }


}

class SynchronizedTest {
    public final Object lock = new Object();

    public void print2() {
        synchronized (lock) {
            for (int i = 0; i <= 50; i += 2) {
                System.out.println("偶数:" + i);
                lock.notify();
                if(i == 50) {
                    break;
                }
                try {
                    lock.wait();
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ignored) {

                }
            }
        }
    }

    public void print1() {
        synchronized (lock) {
            for (int i = 1; i <= 50; i += 2) {
                System.out.println("奇数》:" + i);
                lock.notify();
                if(i == 49) {
                    break;
                }
                try {
                    lock.wait();
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ignored) {

                }
            }
        }
    }

}

class SynchronizedTest1 {
    public final int num = 100;

    public synchronized void print2() {
        for (int i = 0; i <= num; i += 2) {
            System.out.println("偶数:" + i);
            this.notify();
            if (i == num) {
                break;
            }
            try {
                this.wait();
            } catch (InterruptedException ignored) {

            }
        }
    }

    public synchronized void print1() {
        for (int i = 1; i <= num; i += 2) {
            System.out.println("奇数》:" + i);
            this.notify();
            if (i == num - 1) {
                break;
            }
            try {
                this.wait();
            } catch (InterruptedException ignored) {

            }
        }
    }

}
