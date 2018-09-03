package com.adoph.test.jvm;

/**
 * TODO
 *
 * @author Tangqiandong
 * @version v1.0
 * @since 2018/8/29
 */
public class VariableTest {

//    static {
//        int i = 1;
//        System.out.println("VariableTest:" + i);
//    }
//
//    static int i = 0;

    public static void main(String[] args) {
        System.out.println("子类：" + Sub.b);
    }

    static class Parent {
        public static int a = 1;

        static {
            System.out.println("赋值前:" + a);
            a = 2;
//            System.out.println("赋值后:" + a);
        }
    }

    static class Sub extends Parent {
        public static int b = a;
    }

}
