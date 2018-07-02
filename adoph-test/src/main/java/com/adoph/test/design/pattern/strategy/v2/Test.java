package com.adoph.test.design.pattern.strategy.v2;

import java.util.Arrays;

/**
 * v2:满足任何类型数组的排序
 * 新需求：比较方式不固定
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/2
 */
public class Test {
    public static void main(String[] args) {
        Cat[] arr = new Cat[]{new Cat(1, "老幺"), new Cat(10, "老大"), new Cat(5, "老二")};
        SortUtils.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
