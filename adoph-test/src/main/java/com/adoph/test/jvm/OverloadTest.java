package com.adoph.test.jvm;

import java.io.Serializable;

/**
 * 静态分派：重载
 * 面试题而已，没有任何实际意义
 * char->int->long->double->Character->Serializable->char...->Object
 * Object的优先级最低
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/9/4
 */
public class OverloadTest {

    //    7.Object
    public static void sayHello(Object obj) {
        System.out.println("hell obj");
    }

//    2.int
//    public static void sayHello(int arg) {
//        System.out.println("hell int");
//    }

//    3.long
//    public static void sayHello(long arg) {
//        System.out.println("hell long");
//    }

//    4.double
//    public static void sayHello(double arg) {
//        System.out.println("hell double");
//    }

//    1.char
//    public static void sayHello(char arg) {
//        System.out.println("hell char");
//    }

//    5.Character
//    public static void sayHello(Character arg) {
//        System.out.println("hell Character");
//    }

//    8.char...
//    public static void sayHello(char... arg) {
//        System.out.println("hell char...");
//    }

//    6.Serializable
//    public static void sayHello(Serializable arg) {
//        System.out.println("hell Serializable");
//    }

//    public static void sayHello(int... arg) {
//        System.out.println("hell int...");
//    }

    public static void main(String[] args) {
//        sayHello('a');
        sayHello(null);
    }

}
