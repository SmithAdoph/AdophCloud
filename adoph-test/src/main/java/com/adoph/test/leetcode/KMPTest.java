package com.adoph.test.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/10/10
 */
public class KMPTest {

    @Test
    public void test() {
        KMPTest test = new KMPTest();
        String originStr = "acacaaaeacdfa";

        // true
        Assert.assertTrue(test.isSubstring(originStr, "a"));
        Assert.assertTrue(test.isSubstring(originStr, "ac"));
        Assert.assertTrue(test.isSubstring(originStr, "aca"));
        Assert.assertTrue(test.isSubstring(originStr, "aa"));
        Assert.assertTrue(test.isSubstring(originStr, "eac"));
        Assert.assertTrue(test.isSubstring(originStr, "acd"));
        Assert.assertTrue(test.isSubstring(originStr, "cac"));

        // false
        Assert.assertFalse(test.isSubstring(originStr, "cacd"));
        Assert.assertFalse(test.isSubstring(originStr, "12"));
        Assert.assertFalse(test.isSubstring(originStr, "acace"));
    }

    public boolean isSubstring(String originStr, String targetStr) {
        char[] originArr = originStr.toCharArray();
        char[] targetArr = targetStr.toCharArray();
        int[] indexes = getMatchIndexes(targetStr);

        int i = 0;
        int j = 0;

        for (; i < originArr.length; i++) {
            for (; j < targetArr.length; j++) {
                // 如果i+j大于原串长度，则不需要继续匹配，直接返回false
                if (i + j >= originArr.length) {
                    return false;
                }

                // 相同则继续匹配
                if (originArr[i + j] == targetArr[j]) {
                    if (j == targetArr.length - 1) {
                        return true;
                    }
                } else {
                    // 不相同，并且j>0，则计算i和j的位置
                    if (j > 0) {
                        // 当匹配下标不为0时，原字符串匹配位置移动到i+j
                        if (indexes[j - 1] != 0) {
                            i = i + j;
                        }
                        // 待匹配串移动位置为匹配索引值
                        j = indexes[j - 1];
                    }
                    break;
                }
            }
        }

        return false;
    }

    public int[] getMatchIndexes(String str) {
        int len = str.length();
        int[] matchValues = new int[len];
        matchValues[0] = 0;

        for (int i = 1; i < len; i++) {
            int m = 0;
            // 相同的前后公共前缀长度
            int n = 0;
            while (i - m > m) {
                String s1 = str.substring(0, m + 1);
                String s2 = str.substring(i - m, i + 1);
                if (s1.equals(s2)) {
                    n = s1.length();
                }
                m++;
            }
            matchValues[i] = n;
        }
        return matchValues;
    }

}
