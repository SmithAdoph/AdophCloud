package com.adoph.test.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/9/21
 */
public class ReentrantLockTest {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        PrintLog p1 = new PrintLog(null);
        new Thread(p1).start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(System.currentTimeMillis() - start);
        p1.setType("");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(System.currentTimeMillis() - start);
        p1.setType("isValidate");
    }

    static class PrintLog implements Runnable {
        private final Lock lock = new ReentrantLock();
        Condition notNull = lock.newCondition();
        Condition notEmpty = lock.newCondition();
        Condition cc = lock.newCondition();
        private String type;

        PrintLog(String type) {
            this.type = type;
        }

        @Override
        public void run() {
            lock.lock();
            while (type == null) {
                try {
                    notNull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (type.length() == 0) {
                notEmpty.signal();
            }
            cc.signalAll();
            System.out.println(type);
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
