package com.adoph.test.leetcode;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/8/5
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};
        System.out.println(searchInsert(nums1, 5));
        System.out.println(searchInsert(nums1, 2));
        System.out.println(searchInsert(nums1, 7));
        System.out.println(searchInsert(nums1, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;

        for (int num : nums) {
            if (num >= target) {
                break;
            }
            index++;
        }


        return index;
    }

}
