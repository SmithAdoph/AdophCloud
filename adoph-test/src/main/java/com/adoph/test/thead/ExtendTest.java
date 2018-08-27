package com.adoph.test.thead;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author adoph
 * @version v1.0
 * @since 2018/8/23
 */
public class ExtendTest {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.eat();
    }
}

class Animal {
    synchronized void eat() {
        System.out.println("父类");
    }
}

class Cat extends Animal {
    @Override
    synchronized void eat() {
        System.out.println("我是猫");
        super.eat();
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
