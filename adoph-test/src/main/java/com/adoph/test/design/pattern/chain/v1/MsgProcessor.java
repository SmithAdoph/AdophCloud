package com.adoph.test.design.pattern.chain.v1;

/**
 * 消息处理器
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/10
 */
public class MsgProcessor {
    private Filter filterChain;
    public String process(String msg) {
        return filterChain.doFilter(msg);
    }

    public void setFilterChain(Filter filterChain) {
        this.filterChain = filterChain;
    }
}
