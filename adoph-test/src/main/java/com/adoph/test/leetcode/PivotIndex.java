package com.adoph.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * <p>
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/yf47s/
 * 来源：力扣（LeetCode）
 */
public class PivotIndex {

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {-1, -1, -1, -1, -1, -1};
        int[] nums3 = {-1, -1, -1, 0, 1, 1};
        System.out.println(pivotIndex01(nums1));
        System.out.println(pivotIndex01(nums2));
        System.out.println(pivotIndex01(nums3));
    }

    public static int pivotIndex01(int[] nums) {
        int left = 0;
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {
            // 被2整除，且除以2等于左边的和
            if (left << 1 == total - nums[i]) {
                return i;
            }

            left += nums[i];
        }

        return -1;
    }

}
