package com.adoph.test.jvm;

/**
 * gc日志测试
 * vm：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/17
 */
public class GCLog3Test {

    private static int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] arr1, arr2, arr3, arr4;
        arr1 = new byte[_1MB / 4];
        arr2 = new byte[4 * _1MB];
        arr3 = new byte[4 * _1MB];
        arr4 = new byte[4 * _1MB];
    }

}
