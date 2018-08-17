package com.adoph.test.jvm;

/**
 * 引用计数算法测试
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/15
 */
public class GCTest {
    public static void main(String[] args) {
        GCReference a = new GCReference();
        GCReference b = new GCReference();
        a.instance = b;
        b.instance = a;
        a = null;
        b = null;
        System.gc();
    }

}

class GCReference {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[5 * _1MB];
}
