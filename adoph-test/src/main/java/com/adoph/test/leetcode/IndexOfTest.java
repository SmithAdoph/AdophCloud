package com.adoph.test.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/10/16
 */
public class IndexOfTest {

    @Test
    public void testIndexOf() {
        String s1 = "abcdef";
        Assert.assertEquals(0, strStr(s1, ""));
        Assert.assertEquals(-1, strStr(s1, "ah"));
        Assert.assertEquals(0, strStr(s1, "a"));
        Assert.assertEquals(1, strStr(s1, "bc"));
        Assert.assertEquals(4, strStr(s1, "ef"));
        Assert.assertEquals(-1, strStr("mississippi", "issipi"));
    }

    public int strStr(String haystack, String needle) {
        int inputLen = needle.length();
        int originLen = haystack.length();

        // 输入长度0，返回0
        if (inputLen == 0) {
            return 0;
        }

        // 输入长度大于源长度，返回-1
        if (inputLen > originLen) {
            return -1;
        }

        char[] originArr = haystack.toCharArray();
        char[] inputArr = needle.toCharArray();

        for (int i = 0; i < originArr.length; i++) {
            for (int j = 0; j < inputArr.length; j++) {
                // 如果剩下的长度小于输入的长度，则返回-1
                if (originArr.length - i < inputArr.length) {
                    return -1;
                }
                if (originArr[i + j] == inputArr[j]) {
                    if (j == inputLen - 1) {
                        return i;
                    }
                    continue;
                }
                break;
            }
        }

        return -1;
    }

}
