package com.adoph.test.jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/7/29
 */
public class LambadaOOMTest {

    public static void main(String[] args) {
//        List<LambadaTest> list = new ArrayList<>();
//
//        list.add(new LambadaTest("aa"));
//        list.add(new LambadaTest("bb"));
//        list.add(new LambadaTest("cc"));
//
//        list.forEach(item -> System.out.println(item.getName()));

//        System.out.println(Arrays.asList(LambadaOOMTest.class.getDeclaredMethods()));

        new LambadaTest("a").print();
    }

}

class LambadaTest {

    private String name;

    public LambadaTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(System.out::println);
        Runnable r = () -> System.out.println("Hello");
        System.out.println(Arrays.asList(LambadaTest.class.getDeclaredMethods()));
    }
}
