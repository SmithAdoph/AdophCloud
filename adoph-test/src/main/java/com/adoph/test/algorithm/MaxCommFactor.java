package com.adoph.test.algorithm;

/**
 * 最大公因数
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/9
 */
public class MaxCommFactor {

    public static void main(String[] args) {
        System.out.println(calculate(399, 393));
    }

    private static long calculate(long m, long n) {
        while (n != 0) {
            long tmp = m % n;
            m = n;
            n = tmp;
        }
        return m;
    }
}
