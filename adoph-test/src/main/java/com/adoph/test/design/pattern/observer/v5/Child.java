package com.adoph.test.design.pattern.observer.v5;

import java.util.Observable;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/9
 */
public class Child extends Observable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.setChanged();
        super.notifyObservers();
    }
}
