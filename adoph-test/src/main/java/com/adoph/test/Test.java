package com.adoph.test;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/8/31
 */
public class Test {

    /**
     * locksupport 会响应中断
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("111");
//            if(Thread.interrupted()) {
//                System.out.println("线程中断");
//            }
            System.out.println("before");
            System.out.println("t1: " + Thread.currentThread().getName());
            System.out.println("t1: " + Thread.currentThread().isInterrupted());
            System.out.println("after");
        });

        t1.start();
        t1.interrupt();
        System.out.println(t1.isInterrupted());
//        Thread.sleep(555555);



    }

}
