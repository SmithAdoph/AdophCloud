package com.adoph.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * todo: 描述
 *
 * @author tangqiandong
 * @version v1.0
 * @date 2020/12/1
 */
public class StringTest {


    public static void main(String[] args) {
        //去除html标记
        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        String string = matcher.replaceAll("");
        System.out.println(string);

    }
}
