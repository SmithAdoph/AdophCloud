package com.adoph.test.thead;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2019/2/28
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                0,//核心线程数大小
                5,//线程最大值
                100L,//线程空闲时间
                TimeUnit.MILLISECONDS,//线程空闲时间单位
//                new ArrayBlockingQueue<>(100),//任务队列
                new LinkedBlockingDeque<>(100),
//                new LinkedBlockingQueue<>(100),
//                new SynchronousQueue<>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "test-" + count.getAndIncrement());
                    }
                },//线程工厂
                // 线程拒绝策略，默认是抛出一个RejectedExecutionException异常
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("reject...");
                    }
                });
        //线程活跃时间
//        threadPoolExecutor.setKeepAliveTime(10, TimeUnit.SECONDS);
        //核心线程超时设置，设置为true时，当超过线程空闲时间就会
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        AtomicInteger proCt = new AtomicInteger(0);
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "---" + proCt.getAndIncrement());
                }
            });
        }

//        AtomicInteger atc = new AtomicInteger(2);
//        System.out.println(atc.get());
//        System.out.println(atc.get());
//        System.out.println(atc.get());
//        System.out.println(atc.get());
    }
}
