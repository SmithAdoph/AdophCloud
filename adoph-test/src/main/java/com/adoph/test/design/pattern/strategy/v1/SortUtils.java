package com.adoph.test.design.pattern.strategy.v1;

/**
 * 排序工具类
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/2
 */
public class SortUtils {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
