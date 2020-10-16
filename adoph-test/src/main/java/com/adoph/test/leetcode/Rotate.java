package com.adoph.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/clpgd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * 总结：找规律 result[j][size - i - 1] = matrix[i][j];
 *
 * @author adoph
 * @version v1.0
 * @date 2020/8/10
 */
public class Rotate {

    public static void main(String[] args) {
        int[][] matrix01 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};

        int[][] matrix02 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix03 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int[][] matrix04 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] matrix05 = {
                {2, 29, 20, 26, 16, 28},
                {12, 27, 9, 25, 13, 21},
                {32, 33, 32, 2, 28, 14},
                {13, 14, 32, 27, 22, 26},
                {33, 1, 20, 7, 21, 7},
                {4, 24, 1, 6, 32, 34}
        };

        System.out.println("#################################");
//        printArr(matrix02);
//        printArr(matrix01);
//        printArr(matrix03);
//        printArr(matrix04);
//        printArr(matrix05);
//        System.out.println("[[4,33,13,32,12,2],[24,1,14,33,27,29],[1,20,32,32,9,20],[6,7,27,2,25,26],[32,21,22,28,13,16],[34,7,26,14,21,28]]");
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        System.out.println(ids);
    }

    public static void rotate01(int[][] matrix) {
        int size = matrix.length;

        if (size <= 0) {
            return;
        }

        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[j][size - i - 1] = matrix[i][j];
            }
        }

        matrix = result;
    }

    /**
     * 多次对折交换
     */
    public static void rotate02(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size >> 1); j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][size - j - 1];
                matrix[i][size - j - 1] = tmp;
            }
        }
    }


    private static int[] getIndex(int firstIndex, int secondIndex, int size) {
        return new int[]{secondIndex, size - 1 - firstIndex};
    }

    public static void printArr(int[][] matrix) {
//        rotate01(matrix);
        rotate02(matrix);

        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("---------------------------------");
    }

}
