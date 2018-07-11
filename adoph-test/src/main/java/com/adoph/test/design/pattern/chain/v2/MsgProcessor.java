package com.adoph.test.design.pattern.chain.v2;

/**
 * 消息处理器
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/10
 */
public class MsgProcessor {

    private FilterChain filterChain;

    public String process(String msg) {
        Request<String> request = new Request<>();
        request.setData(msg);
        Response<String> response = new Response<>();
        filterChain.doFilter(request, response);
        return request.getData();
    }

    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }
}
