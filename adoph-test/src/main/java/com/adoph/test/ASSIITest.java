package com.adoph.test;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/8/3
 */
public class ASSIITest {

    public static void main(String[] args) {
        System.out.println(sumStrAscii("A"));
    }

    public static int sumStrAscii(String str) {
        byte[] bytes = str.getBytes();
        int sum = 0;
        for (byte b : bytes) {
            sum += b;
        }
        return sum;
    }

}
