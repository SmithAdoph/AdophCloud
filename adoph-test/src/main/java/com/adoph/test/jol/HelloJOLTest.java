package com.adoph.test.jol;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 锁，对象布局测试
 * 1、偏向锁    1，01
 * 2、轻量级锁  0，00
 * 3、重量级锁  0，10
 *
 * @author adoph
 * @version v1.0
 * @date 2020/7/26
 */
public class HelloJOLTest {

    public static void main(String[] args) throws InterruptedException {
        // 偏向锁，默认开始延时时间4秒
        // 因为启动的时候，需要给大量的对象分配空间，使用偏向锁更消耗性能（偏向锁撤销过程）
        TimeUnit.SECONDS.sleep(5);

        // 刚创建的对象，不偏向一个线程，则为匿名偏向锁
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        // 偏向锁，线程id指向main方法线程
        synchronized(o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

}
