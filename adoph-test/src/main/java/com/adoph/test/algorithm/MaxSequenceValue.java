package com.adoph.test.algorithm;

/**
 * 求最大连续子序列和
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/9
 */
public class MaxSequenceValue {

    public static void main(String[] args) {
        int[] arr = {-20, 3, -2, 11, -4, 13, -5, -2};
        System.out.println(calculate(arr));
        System.out.println(maxsequence3(arr, arr.length));
    }

    public static int calculate(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }


    static int maxsequence3(int a[], int len) {
        int maxsum, maxhere;
        maxsum = maxhere = a[0];   //初始化最大和为a【0】
        for (int i = 1; i < len; i++) {
            if (maxhere <= 0)
                maxhere = a[i];  //如果前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和为a[i]
            else
                maxhere += a[i]; //如果前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
            if (maxhere > maxsum) {
                maxsum = maxhere;  //更新最大连续子序列和
            }
        }
        return maxsum;
    }
}
