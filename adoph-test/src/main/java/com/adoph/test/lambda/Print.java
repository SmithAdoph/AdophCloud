package com.adoph.test.lambda;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/7/30
 */
@FunctionalInterface
interface Print<T> {
    void print(T x);
}
