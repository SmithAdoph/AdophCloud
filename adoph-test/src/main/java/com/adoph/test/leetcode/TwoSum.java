package com.adoph.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;
//        System.out.println(Arrays.toString(twoSum01(nums, target)));
        System.out.println(Arrays.toString(twoSum02(nums, target)));
    }

    /**
     * 时间复杂度：n^2
     * 空间复杂度：n
     */
    public static int[] twoSum01(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                int r = nums[i] + nums[j];
                if (r == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度：n
     * 空间复杂度：n
     */
    public static int[] twoSum02(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (sumMap.containsKey(val)) {
                result[0] = sumMap.get(val);
                result[1] = i;
                return result;
            }
            sumMap.put(target - val, i);
        }
        return result;
    }
}