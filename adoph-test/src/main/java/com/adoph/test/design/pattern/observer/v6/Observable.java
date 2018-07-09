package com.adoph.test.design.pattern.observer.v6;

import java.util.Vector;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/9
 */
public abstract class Observable {
    private Vector<Observer> obs;

    Observable() {
        obs = new Vector<>();
    }

    public void addObserver(Observer o) {
        obs.add(o);
    }

    void notifyObservers() {
        for (Observer o : obs) {
            o.update();
        }
    }
}
