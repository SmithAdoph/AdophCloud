package com.adoph.test.design.pattern.chain.v2;


/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/10
 */
public class ScriptFilter implements Filter<String> {
    @Override
    public void doFilter(Request<String> request, Response<String> response, FilterChain filterChain) {
        System.out.println("请求：ScriptFilter");
        request.setData(request.getData().replaceAll("<script>", "{脚本}"));
        filterChain.doFilter(request, response, filterChain);
        System.out.println("返回：ScriptFilter");
    }
}
