package com.adoph.test.leetcode;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/9/27
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        String[] strs2 = {"aa", "a"};
//        System.out.println(longestCommonPrefix(strs));
//        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix1(strs));
        System.out.println(longestCommonPrefix1(strs1));
        System.out.println(longestCommonPrefix1(strs2));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        // 遍历查找长度最短的字符串shortestStr
        String shortestStr = "";
        for (String str : strs) {
            if (shortestStr.length() == 0) {
                shortestStr = str;
            } else {
                if (str.length() < shortestStr.length()) {
                    shortestStr = str;
                }
            }
        }

        // 分割最短的字符串shortestStr
        char[] chars = shortestStr.toCharArray();
        String[] shortestStrArr = new String[chars.length];
        StringBuilder shortestSb = new StringBuilder(chars.length);

        for (int i = 0; i < chars.length; i++) {
            shortestSb.append(chars[i]);
            shortestStrArr[i] = shortestSb.toString();
        }


        // 遍历，查找符合条件的最长字符串
        // 先校验最长的字符串
        for (int i = shortestStrArr.length - 1; i >= 0; i--) {
            boolean isShortest = true;
            for (String str : strs) {
                if (!str.startsWith(shortestStrArr[i])) {
                    isShortest = false;
                    break;
                }
            }

            if (isShortest) {
                return shortestStrArr[i];
            }
        }

        return "";
    }

    public static String longestCommonPrefix1(String[] strs) {
        // 边界
        if (strs.length == 0) {
            return "";
        }

        // 初始化最长前缀为第一个元素
        String shortestStr = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String currStr = strs[i];
            if (currStr.length() == 0) {
                return "";
            }

            int j = 0;

            for (; j < shortestStr.length() && j < currStr.length(); j++) {
                if (shortestStr.charAt(j) != currStr.charAt(j)) {
                    break;
                }
            }

            shortestStr = shortestStr.substring(0, j);

            if (shortestStr.length() == 0) {
                return "";
            }
        }

        return shortestStr;

    }

}
