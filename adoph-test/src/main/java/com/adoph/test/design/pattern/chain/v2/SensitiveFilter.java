package com.adoph.test.design.pattern.chain.v2;


/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/10
 */
public class SensitiveFilter implements Filter<String> {
    @Override
    public void doFilter(Request<String> request, Response<String> response, FilterChain filterChain) {
        System.out.println("请求：SensitiveFilter");
        request.setData(request.getData().replaceAll("毛泽东", "毛爷爷"));
        filterChain.doFilter(request, response, filterChain);
        System.out.println("返回：SensitiveFilter");
    }
}
