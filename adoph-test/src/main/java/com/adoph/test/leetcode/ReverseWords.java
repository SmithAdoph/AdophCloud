package com.adoph.test.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/10/10
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();

        String s = " hello  world!  ";
        System.out.println(reverseWords.reverseWords(s));
        System.out.println(reverseWords.reverseWords1(s));
        System.out.println(reverseWords.reverseWords2(s));
    }

    public String reverseWords(String s) {
        String str = s.trim();
        String[] arr = str.split("\\s+");
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i].trim());
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public String reverseWords2(String s) {
        String str = s.trim();
        String[] arr = str.split("\\s+");
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len / 2; i++) {
            // 首位交换
            sb.append(arr[i]);
            arr[i] = arr[len - 1 - i];
            arr[len - 1 - i] = sb.toString();
            sb.delete(0, sb.length());
        }
        return String.join(" ", Arrays.asList(arr));
    }
}
