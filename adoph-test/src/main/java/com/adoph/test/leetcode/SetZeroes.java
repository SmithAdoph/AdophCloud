package com.adoph.test.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/9/22
 */
public class SetZeroes {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        setZeroes(matrix2);


        for (int[] arr : matrix2) {
            for (int item : arr) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i]) {
                    matrix[i][j] = 0;
                    continue;
                }

                if (cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
