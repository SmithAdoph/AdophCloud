package com.adoph.test.design.pattern.strategy.v1;

import java.util.Arrays;

/**
 * v1:固定数据类型的数组排序
 * 新需求：满足任何类型数组的排序
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/2
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 10, 9, 1, 5};
        SortUtils.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
