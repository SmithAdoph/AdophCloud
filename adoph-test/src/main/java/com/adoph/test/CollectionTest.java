package com.adoph.test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * todo: 描述
 *
 * @author tangqiandong
 * @version v1.0
 * @date 2021/2/5
 */
public class CollectionTest {

    public static void main(String[] args) {
        ImmutableList<String> list = ImmutableList.of("a", "b", "c");

        System.out.println("-----------------原生遍历-----------------");
        // 原生遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("------------------增强循环----------------");

        // 增强循环
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("------------------list.stream().iterator()----------------");

        // iterator
        Iterator<String> iterator1 = list.stream().iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("------------------iterator----------------");

        UnmodifiableIterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println("------------------stream forEach----------------");

        // stream forEach
        list.stream().forEach(System.out::println);
        System.out.println("------------------stream forEach simple----------------");
        list.forEach(System.out::println);

    }

}
