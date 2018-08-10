package com.adoph.test.design.pattern.strategy.v3;

import java.util.List;

/**
 * 排序工具类
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/2
 */
public class SortUtils {

    @SuppressWarnings("unchecked")
    public static <T extends Comparable> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) == 1) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static <T extends Comparable> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
