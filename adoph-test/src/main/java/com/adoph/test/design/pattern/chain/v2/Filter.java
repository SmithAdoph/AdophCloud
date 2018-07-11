package com.adoph.test.design.pattern.chain.v2;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/11
 */
public interface Filter<T> {
    void doFilter(Request<T> request, Response<T> response, FilterChain filterChain);
}
