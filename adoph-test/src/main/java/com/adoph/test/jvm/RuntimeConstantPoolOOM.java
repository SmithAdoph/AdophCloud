package com.adoph.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区和运行时常量池溢出测试:
 * 备注：1、运行时常量池过多；2、动态加载类过多（如：cglib加载的类）
 * JDK1.6返回OutOfMemoryError
 *
 * vm args:-XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/15
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        int i = 0;
//        while (true) {
//            // java.lang.String.intern() 本地方法
//            // 如果字符串常量池中已经包含一个等于此String对象的字符串，
//            // 则返回代表池中的对象；否则将此String对象添加到常量池中
//            list.add(String.valueOf(i++).intern());
//        }

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

//        System.out.println("java".intern() == "java");
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
