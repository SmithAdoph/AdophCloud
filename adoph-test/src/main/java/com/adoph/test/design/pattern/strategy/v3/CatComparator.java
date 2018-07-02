package com.adoph.test.design.pattern.strategy.v3;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/2
 */
public class CatComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        return Integer.compare(t1.getLength(), t2.getLength());
    }
}
