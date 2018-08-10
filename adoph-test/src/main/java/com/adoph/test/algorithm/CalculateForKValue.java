package com.adoph.test.algorithm;

import com.adoph.framework.algorithm.sort.SortUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

/**
 * 计算第k个值
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/24
 */
public class CalculateForKValue {

    public static void main(String[] args) {
        System.out.println();
        int size = 30000000;
        int[] arr = SortUtils.randomArray(size);
        int k = 10001;
        System.out.println("第" + k + "个值是：" + execute(arr, k));

    }

    private static int execute(int[] arr, int k) {
        SortUtils.quickSort(arr);
        return arr[k];
    }

    private static int exec(int[] arr, int k) {
//        int
        for (int i = 0; i < k; i++) {
            SortUtils.quickSort(arr);
        }
        return 0;
    }

    //18-1.3
    public void print() {
        File file = new File("");
//        printDigit
    }

}
