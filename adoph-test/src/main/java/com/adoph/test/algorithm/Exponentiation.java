package com.adoph.test.algorithm;

/**
 * 幂运算
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/9
 */
public class Exponentiation {

    public static void main(String[] args) {
        int x = 3;//底数
        int n = 63;//幂
        int times = 10000000;//执行次数
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            calculate(x, n);
        }
        System.out.println("方法一执行时间：" + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            calculate1(x, n);
        }
        System.out.println("方法二执行时间：" + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            calculate1(2, n);
        }
        System.out.println("方法三执行时间：" + (System.currentTimeMillis() - start3));
    }

    private static long calculate(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if(x == 2) {
            return 2 << n;
        }
        if (isEven(n)) {
            return calculate(x * x, n / 2);
        } else {
            return calculate(x * x, n / 2) * x;
        }
    }

    private static boolean isEven(long num) {
        return num % 2 == 0;
    }

    private static long calculate1(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        return x * calculate1(x, n - 1);
    }

}
