package com.adoph.test.jvm;

/**
 * 1.int 缓存 -128至+127
 * 2.没有遇到运算符，不会自动拆箱
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/9/11
 */
public class GenericTypes {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);//c Integer, d Integer, true
        System.out.println(e == f);//e Integer, f Integer, true
        System.out.println(c == (a + b));//c int, a int, b int, true
        System.out.println(c.equals(a + b));//false
        System.out.println(g == (a + b));//g long, true
        System.out.println(g.equals(a + b));//true
//        true
//        false
//        true
//        true
//        true
//        false
    }

}
