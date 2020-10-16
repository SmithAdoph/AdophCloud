package com.adoph.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/8/5
 */
public class Merge {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] intervals1 = {{1, 4}, {4, 5}};
        int[][] intervals2 = {{1, 4}, {2, 3}};
        int[][] intervals3 = {{1, 4}, {0, 4}};
//        System.out.println(Arrays.deepToString(merge(intervals)));
//        System.out.println(Arrays.deepToString(merge(intervals1)));
//        System.out.println(Arrays.deepToString(merge(intervals2)));

        System.out.println(Arrays.deepToString(merge02(intervals)));
        System.out.println(Arrays.deepToString(merge02(intervals1)));
        System.out.println(Arrays.deepToString(merge02(intervals2)));
        System.out.println(Arrays.deepToString(merge02(intervals3)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }

        // 排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        // 当前待比较的
        int[] compareArr = new int[2];

        for (int i = 0; i < intervals.length; i++) {
            int[] interval1 = intervals[i];

            if (i == 0) {
                compareArr[0] = interval1[0];
                compareArr[1] = interval1[1];
            } else {
                if (compareArr[1] >= interval1[0]) {
                    if (compareArr[1] < interval1[1]) {
                        compareArr[1] = interval1[1];
                    }
                } else {
                    result.add(Arrays.copyOf(compareArr, 2));
                    compareArr[0] = interval1[0];
                    compareArr[1] = interval1[1];
                }
            }

            // 如果
            if (i == intervals.length - 1) {
                result.add(Arrays.copyOf(compareArr, 2));
            }

        }

        return result.toArray(new int[0][]);
    }

    public static int[][] merge02(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        int index = -1;

        Arrays.sort(intervals, Comparator.comparingInt(item -> item[0]));
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > result[index][1]) {
                result[++index] = interval;
            } else {
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }

}
