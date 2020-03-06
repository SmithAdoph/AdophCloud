package com.adoph.test.jvm;

/**
 * todo: 描述
 *
 * @author tangqiandong
 * @version v1.0
 * @date 2020/3/6
 */
public class ThreadInterruptedTest {

    public static void main(String[] args) {
        Thread t2 = new Thread(()->System.out.println(1), "t2");
        t2.start();
        t2.interrupt();
        boolean interrupted = t2.isInterrupted();
        System.out.println(interrupted);
    }

}
