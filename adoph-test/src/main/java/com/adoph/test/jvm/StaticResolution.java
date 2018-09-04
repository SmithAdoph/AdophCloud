package com.adoph.test.jvm;

/**
 * 解析：
 * 1.静态方法
 * 2.私有方法
 * 静态分派：JVM(准确的说是编译器)在重载时是通过参数的静态类型而不是实际类型作为判定依据
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/9/4
 */
public class StaticResolution {

    public static void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

//        1.在编译时已经确定调用的Human的sayHello方法
//        StaticResolution.sayHello(man);
//        StaticResolution.sayHello(woman);

//        2.运行报错，编译器并不知道变量的实际类型
//        StaticResolution.sayHello((Man)woman);
//        StaticResolution.sayHello((Woman)man);

    }

    static class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public static void sayHello(Human human) {
        System.out.println("say human");
    }

    public static void sayHello(Man man) {
        System.out.println("say man");
    }

    public static void sayHello(Woman woman) {
        System.out.println("say woman");
    }

}
