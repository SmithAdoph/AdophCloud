package com.adoph.test.leetcode;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/10/9
 */
public class FindPathMinTest {

    public static void main(String[] args) {
        FindPathMinTest findPathMinTest = new FindPathMinTest();

    }

    public int findPathMin(int[][] arr) {
        int m = arr.length;
        if (m == 0) {
            return 0;
        }
        int n = arr[0].length;
        if (n == 0) {
            return 0;
        }

        // 存储临时值
        int[][] result = new int[m][n];

        // 第一个元素
        result[0][0] = arr[0][0];

        // 第一行
        for (int i = 1; i < n; i++) {
            result[0][i] = result[0][i - 1] + arr[0][i];
        }
        // 第一列
        for (int i = 1; i < n; i++) {
            result[i][0] = result[i - 1][0] + arr[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[j][i]) + arr[i][j];
            }
        }

        return result[m - 1][n - 1];
    }
}
