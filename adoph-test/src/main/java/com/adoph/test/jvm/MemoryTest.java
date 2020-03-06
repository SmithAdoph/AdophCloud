package com.adoph.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出测试
 * vm args:-Xms20M -Xmx20M --XX:+HeapDumpOnOutOfMemoryError
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/14
 */
public class MemoryTest {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    private static class OOMObject {

    }

}
