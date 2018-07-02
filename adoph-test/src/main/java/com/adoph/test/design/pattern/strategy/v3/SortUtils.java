package com.adoph.test.design.pattern.strategy.v3;

/**
 * 排序工具类
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/2
 */
public class SortUtils {

    @SuppressWarnings("unchecked")
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) == 1) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
