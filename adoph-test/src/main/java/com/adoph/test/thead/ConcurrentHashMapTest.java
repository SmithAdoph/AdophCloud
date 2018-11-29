package com.adoph.test.thead;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/11/13
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        final ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<>();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        newFixedThreadPool.submit(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    chm.put(123, "asd" + i);
                }
            }
        });
        newFixedThreadPool.submit(new Runnable() {
            public void run() {
                System.out.println(chm.get(123));
            }
        });
        newFixedThreadPool.shutdown();
    }
}
