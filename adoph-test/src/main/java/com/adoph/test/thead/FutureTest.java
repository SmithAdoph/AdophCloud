package com.adoph.test.thead;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/10/31
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        final String[] result = new String[1];
//        Runnable r = () -> result[0] = "hello world";
//        Future<String[]> future = Executors.newSingleThreadExecutor().submit(r, result);
//        try {
//            System.out.println("result[0]: " + future.get()[0]);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(1,2,3,4);
        int total = getTotal(list1, list2);
        System.out.println("total = " + total);
    }

    public static int getTotal(final List<Integer> a, final List<Integer> b) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> f1 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int r = 0;
                for (int num : a) {
                    r += num;
                }
                return r;
            }
        });

        Future<Integer> f2 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int r = 0;
                for (int num : b) {
                    r += num;
                }
                return r;
            }
        });
        return f1.get() + f2.get();
    }
}
