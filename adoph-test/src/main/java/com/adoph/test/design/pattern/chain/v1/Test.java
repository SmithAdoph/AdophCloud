package com.adoph.test.design.pattern.chain.v1;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/10
 */
public class Test {

    public static void main(String[] args) {
        String msg = "我是毛泽东<script>xxxx</script>,hello world!";
        MsgProcessor processor = new MsgProcessor();
        FilterChain fc = new FilterChain();
        fc.addFilter(new ScriptFilter())
                .addFilter(new SensitiveFilter());
        processor.setFilterChain(fc);
        System.out.println(processor.process(msg));
    }
}
