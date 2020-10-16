package com.adoph.test.leetcode;

/**
 * todo: 描述
 * <p>
 * 当一个长度为n的字符串，包含一个字符串s中s(i) = s(n-i-1),则称s为一个回文字符串
 *
 * @author adoph
 * @version v1.0
 * @date 2020/9/27
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "babad";
        String str1 = "baae";
        String str2 = "cb";
        String str3 = "cc";
        String str4 = "ccc";
        String str5 = "c";
//        System.out.println(longestPalindrome1(str));
//        System.out.println(longestPalindrome1(str1));
//        System.out.println(longestPalindrome2(str));
//        System.out.println(longestPalindrome2(str1));
//        System.out.println(longestPalindrome2(str2));
//        System.out.println(longestPalindrome2(str3));
//        System.out.println(longestPalindrome2(str4));
//        System.out.println(longestPalindrome2(str5));

        System.out.println(longestPalindrome3(str));
        System.out.println(longestPalindrome3(str1));
        System.out.println(longestPalindrome3(str2));
        System.out.println(longestPalindrome3(str3));
        System.out.println(longestPalindrome3(str4));
        System.out.println(longestPalindrome3(str5));
    }

    public static String longestPalindrome2(String s) {
        // 注：转换为char数组，charAt会校验数据越界
        char[] chars = s.toCharArray();
        int len = chars.length;

        if (len < 2) {
            return s;
        }

        // 截取字符串性能消耗很大，所以通过开始下标和长度来代替
        // 开始下标
        int start = 0;
        // 回文最大长度
        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            // 偶数回文
            int evenNum = search(chars, i, i + 1);

            // 奇数回文
            int oddNum = search(chars, i, i);

            int currMaxLen = Math.max(evenNum, oddNum);

            if (currMaxLen > maxLen) {
                // 当为偶数回文，去掉最后一个字符就和奇数回文获取起始下标的算法一致(max-1)/2
                start = i - (currMaxLen - 1) / 2;
                maxLen = currMaxLen;
            }
        }

        // 截取结束下标刚好为开始下标加上回文长度max
        return s.substring(start, start + maxLen);
    }

    /**
     * 存在，则返回子回文长度
     */
    private static int search(char[] chars, int left, int right) {
        int len = chars.length;

        while (left >= 0 && right < len && chars[left] == chars[right]) {
            left--;
            right++;
        }

        // 多减一次left-1
        // 多加一次right+1
        // 以上需要减2
        // 加1刚好为回文长度
        return right - left - 1;
    }

    public static String longestPalindrome3(String s) {
        // 注：转换为char数组，charAt会校验数据越界
        char[] chars = s.toCharArray();
        int len = chars.length;

        if (len < 2) {
            return s;
        }

        // 截取字符串性能消耗很大，所以通过开始下标和长度来代替
        // 开始下标
        int start = 0;
        // 回文最大长度，从1开始
        int maxLen = 1;

        boolean[][] result = new boolean[len][len];

        // 对角线都为true（自身）
        for (int i = 0; i < len; i++) {
            result[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    result[i][j] = false;
                } else if (j - i > 3) {
                    // 当j - 1 - (i + 1) + 1 >= 2 时，继续校验子集是否为回文，整理得到 j - i > 3
                    result[i][j] = result[i + 1][j - 1];
                } else {
                    result[i][j] = true;
                }

                // 如果是回文，并且长度大于最大长度，重新赋值开始下标和最大长度
                if (result[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }


    /**
     * 暴力写法，列举所有子串，并判断是否回文串
     * 时间复杂度n^3
     */
    public static String longestPalindrome1(String strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length(); i++) {
            for (int j = i + 1; j < strs.length(); j++) {
                String childStr = strs.substring(i, j);
                if (isLongestPalindrome(childStr) && childStr.length() > sb.length()) {
                    sb.delete(0, sb.length());
                    sb.append(childStr);
                }
            }
        }
        return sb.toString();
    }

    public static boolean isLongestPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
