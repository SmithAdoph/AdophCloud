package com.adoph.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1.每行两个对阵 就是4个数字算一个对阵
 * 2.每个数字代表一个人
 * 3.要求每个人只能和其他7个人搭档一次
 * 4.同一个对手只能遇到2次
 * 5.8*8的矩阵
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/10
 */
public class Algorithm {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> groups = combine(list);
        List<List<String>> r = new ArrayList<>();
        for (String s : groups) {
            List<String> res = new ArrayList<>();
            res = getRow(res, s, groups);
            r.add(res);
        }
        for (List<String> item: r){
            System.out.println(item);
        }
    }

    private static List<String> getRow(List<String> res, String key, List<String> remain) {
        res.add(key);
        String[] keyArr = key.split("&");
        List<String> tmp = new ArrayList<>(remain);
        for (String s1 : remain) {
            if (s1.contains(keyArr[0]) || s1.contains(keyArr[1])) {
                tmp.remove(s1);
            }
        }
        if (tmp.size() == 0) {
            return res;
        }
        return getRow(res, tmp.get(0), tmp);
    }

    private static ArrayList<String> combine(List<Integer> list) {
        ArrayList<String> groups = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                String key = list.get(i) + "&" + list.get(j);
                groups.add(key);
            }
        }
        return groups;
    }
}
