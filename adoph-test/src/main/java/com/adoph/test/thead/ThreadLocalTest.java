package com.adoph.test.thead;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/3/2
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("test");
        local.set("abc");
        System.out.println(local.get());

    }

}
