package com.adoph.test.leetcode;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/10/9
 */
public class RobotTest {

    public static void main(String[] args) {
        RobotTest robotTest = new RobotTest();
        System.out.println(robotTest.findPath(1, 1));
    }

    public int findPath(int m, int n) {
        // 边界1
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] valArr = new int[m][n];

        // 边界2
        // m == 1
        for (int i = 0; i < n; i++) {
            valArr[0][i] = 1;
        }

        // n == 1
        for (int i = 0; i < m; i++) {
            valArr[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                valArr[i][j] = valArr[i - 1][j] + valArr[i][j - 1];
            }
        }

        return valArr[m - 1][n - 1];
    }

}
