package com.adoph.test.design.pattern.strategy.v3;

/**
 * 比较器
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/2
 */
public interface Comparator<T> {
    int compare(T t1, T t2);
}
