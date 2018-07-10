package com.adoph.test.design.pattern.chain.v1;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/10
 */
public class ScriptFilter implements Filter {
    @Override
    public String doFilter(String msg) {
        return msg.replaceAll("<script>", "");
    }
}
