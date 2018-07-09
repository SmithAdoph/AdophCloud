package com.adoph.test.design.pattern.observer.v6;

/**
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/9
 */
public class Parent implements Observer {

    @Override
    public void update() {
        System.out.println("喂奶！");
    }
}
