package com.adoph.test.design.pattern.chain.v1;

/**
 * 过滤器接口抽象
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/10
 */
public interface Filter {
    public String doFilter(String msg);
}
