package com.adoph.test.thead;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用原子类和volatile标识交替打印奇偶数
 *
 * @author tangqiandong
 * @version v1.0
 * @date 2020/3/9
 */
public class PrintTest {

    public static void main(String[] args) {
        PrintTest printTest = new PrintTest();
        Thread t1 = new Thread(printTest::print1);
        Thread t2 = new Thread(printTest::print2);

        t1.start();
        t2.start();

    }

    public static AtomicInteger num = new AtomicInteger(0);

    public void print1() {
        while (num.get() <= 500) {
            if (num.get() % 2 == 0) {
                System.out.println("偶数：" + num.get());
                num.incrementAndGet();
            }
        }
    }

    public void print2() {
        while (num.get() <= 500) {
            if (num.get() % 2 != 0) {
                System.out.println("奇数》：" + num.get());
                num.incrementAndGet();
            }
        }
    }

}
