package com.adoph.test.jvm;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/9/13
 */
public class JITTest {

    public static final int NUM = 15000;

    public static int doubleValue(int i) {
        for (int j = 0; j < 10000; j++) {

        }
        return i * 2;
    }

    public static long calcSum() {
        long sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }
}
