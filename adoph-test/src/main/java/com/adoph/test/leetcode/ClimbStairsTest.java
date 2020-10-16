package com.adoph.test.leetcode;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/9/29
 */
public class ClimbStairsTest {

    public static void main(String[] args) {
        ClimbStairsTest cst = new ClimbStairsTest();
        int staris = 10;
        System.out.println(cst.climbStairs(staris));
        System.out.println(cst.climbStairs2(staris));
    }

    public int climbStairs(int stairsNum) {
        if (stairsNum <= 2) {
            return stairsNum;
        }
        return climbStairs(stairsNum - 1) + climbStairs(stairsNum - 2);
    }

    public int climbStairs2(int stairsNum) {
        if (stairsNum <= 2) {
            return stairsNum;
        }

        int pre1 = 1;
        int pre2 = 2;
        int result = 0;

        for (int i = 3; i <= stairsNum; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        
        return result;
    }
}
