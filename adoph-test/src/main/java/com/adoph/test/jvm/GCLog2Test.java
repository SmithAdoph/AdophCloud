package com.adoph.test.jvm;

/**
 * gc日志测试
 * vm：-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/17
 */
public class GCLog2Test {

    private static int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] arr4;
        arr4 = new byte[4 * _1MB];
    }

}
