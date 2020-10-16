package com.adoph.test.thead;

/**
 * 利用volatile整型和volatile的标志交替打印奇偶数
 *
 * @author adoph
 * @version v1.0
 * @date 2020/3/9
 */
public class PrintTest2 {

    public static void main(String[] args) {
        PrintTest2 printTest2 = new PrintTest2();
        Thread t1 = new Thread(printTest2::print1);
        Thread t2 = new Thread(printTest2::print2);

        t1.start();
        t2.start();
    }

    public volatile int num = 0;
    public volatile boolean flag = true;

    public void print1() {
        while (num <= 100) {
            if (flag) {
                System.out.println("偶数：" + num);
                num++;
                flag = false;
            }
        }
    }

    public void print2() {
        while (num <= 100) {
            if (!flag) {
                System.out.println("奇数》》：" + num);
                num++;
                flag = true;
            }
        }
    }

}
