package com.adoph.test.leetcode;

import java.util.Arrays;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/9/22
 */
public class DiagonalOrder {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix1 = {
                {2, 5},
                {8, 4},
                {0, -1}
        };

        int[][] matrix2 = {
                {6},
                {9},
                {7}
        };

        int[][] matrix3 = {
                {1, 2},
                {3, 4}
        };

        int[][] matrix4 = {
                {2, 5, 8},
                {4, 0, -1}
        };
        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
        System.out.println(Arrays.toString(findDiagonalOrder(matrix1)));
        System.out.println(Arrays.toString(findDiagonalOrder(matrix2)));
        System.out.println(Arrays.toString(findDiagonalOrder(matrix3)));
        System.out.println(Arrays.toString(findDiagonalOrder(matrix4)));

    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        int outSize = matrix.length;

        if (outSize == 0) {
            return new int[0];
        }

        int innerSize = matrix[0].length;
        int[] result = new int[outSize * innerSize];

        int index = 0;

        // x+y = i(备注：核心规律，外层索引(x)和内层索引(y)值和等于第n次遍历->x+y=n，n从0开始)
        // 循环次数m+n-1次
        for (int i = 0; i < outSize + innerSize - 1; i++) {
            // 从（0，0）开始
            if (i % 2 == 0) {
                // 初始化x,y的值
                int x = i < outSize ? i : outSize - 1;
                int y = i - x;

                // 偶数向上走
                while (x >= 0 && y < innerSize) {
                    result[index++] = matrix[x][y];
                    x--;
                    y++;
                }
            } else {
                // 初始化x,y的值
                int y = i < innerSize ? i : innerSize - 1;
                int x = i - y;

                // 奇数往下走
                while (x < outSize && y >= 0) {
                    result[index++] = matrix[x][y];
                    x++;
                    y--;
                }
            }
        }
        return result;
    }


}
