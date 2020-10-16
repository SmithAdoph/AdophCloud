package com.adoph.test.leetcode;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {

    public static void main(String[] args) {
//        System.out.println(reverse01(123));
//        System.out.println(reverse01(-123));
//        System.out.println(reverse01(120));
//        System.out.println(reverse01(0));
//        System.out.println(reverse01(-2147483648));

        System.out.println(reverse02(123));
        System.out.println(reverse02(-123));
        System.out.println(reverse02(120));
        System.out.println(reverse02(0));
        System.out.println(reverse02(-2147483648));
    }

    public static int reverse01(int x) {
        long r = 0;

        while (x != 0) {
            r = r * 10 + (x % 10);
            x /= 10;
        }

        if (r < Integer.MIN_VALUE || r > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) r;
    }

    public static int reverse02(int n) {
        for (int i = 0; i < 16; i++) {
            int low = (n >> i) & 1;
            int high = (n >> 32 - 1 - i) & 1;
            if ((high ^ low) == 1) n ^= (1 << i) | (1 << 32 - 1 - i);
        }
        return n;
    }

}
