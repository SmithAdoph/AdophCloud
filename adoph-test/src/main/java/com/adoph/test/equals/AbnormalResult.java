package com.adoph.test.equals;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/11/8
 */

import java.util.ArrayList;
import java.util.List;

public class AbnormalResult {
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        A a = new A();
        B b = new B();
        list.add(a);
        System.out.println("list.contains(a)->" + list.contains(a));
        System.out.println("list.contains(b)->" + list.contains(b));
        list.clear();
        list.add(b);
        System.out.println("list.contains(a)->" + list.contains(a));
        System.out.println("list.contains(b)->" + list.contains(b));
    }

    static class A {
        @Override
        public boolean equals(Object obj) {
            return obj instanceof A;
        }
    }

//    static class B extends A {
//        @Override
//        public boolean equals(Object obj) {
//            return obj instanceof B;
//        }
//    }

    static class B extends A{
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof B){
                return true;
            }
            return super.equals(obj);
        }
    }

}
