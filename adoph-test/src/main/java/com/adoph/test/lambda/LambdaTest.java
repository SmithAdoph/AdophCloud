package com.adoph.test.lambda;

/**
 * lambda：
 * 1、生成一个静态内部类
 * 2、生成一个静态私有方法
 * 备注：
 * 当使用Java反射时，Java虚拟机有两种方法获取被反射的类的信息。
 * 它可以使用一个JNI存取器；如果使用Java字节码存取器，
 * 则需要拥有它自己的Java类和类加载器（sun/reflect/GeneratedMethodAccessor类和sun/reflect/DelegatingClassLoader)，
 * 这些类和类加载器使用本机内存。字节码存取器也可以被JIT编译，这样会增加本机内存的使用。
 * 如果Java反射被频繁使用，会显著地增加本机内存的使用，可能导致metaspace oom
 *
 * 推荐：-Dsun.reflect.inflationThreshold=0直接使用JNI存取器
 *
 * @author adoph
 * @version v1.0
 * @date 2020/7/30
 */
public class LambdaTest {

    public static void PrintString(String s, Print<String> print) {
        print.print(s);
    }

    public static void main(String[] args) {
        PrintString("test", (x) -> System.out.println(x));
    }

    /*private static void lambda$main$0(String str) {

    }*/

}
