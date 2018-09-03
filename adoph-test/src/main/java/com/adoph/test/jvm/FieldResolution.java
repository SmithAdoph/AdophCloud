package com.adoph.test.jvm;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/29
 */
public class FieldResolution {

    interface T1 {
        int a = 1;
    }

    interface T2 extends T1 {
        int a = 2;
    }

    interface T3 {
        int a = 3;
    }

    static class Parent implements T2 {
        public static int a = 4;
    }

    static class Sub extends Parent implements T3 {
//        注释
//        public static int a = 5;
    }

    public static void main(String[] args) {
//        注释掉30行，36行编译报错，如下：
//        Reference to 'a' is ambiguous, both Parent.a and T3.a match
//        System.out.println(Sub.a);
    }
}
