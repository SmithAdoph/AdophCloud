package com.adoph.test.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * jconsole
 *
 * @author adoph
 * @version v1.0
 * @since 2018/8/17
 */
public class JConsoleTest {

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            TimeUnit.MILLISECONDS.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }
}
