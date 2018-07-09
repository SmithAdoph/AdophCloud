package com.adoph.test.design.pattern.observer.v5;

import java.util.Observable;
import java.util.Observer;

/**
 * jdk自带观察者实现
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/9
 */
public class Parent implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("喂奶！");
    }
}
