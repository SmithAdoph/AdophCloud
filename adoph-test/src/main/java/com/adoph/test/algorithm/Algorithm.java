package com.adoph.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.每行两个对阵 就是4个数字算一个对阵
 * 2.每个数字代表一个人
 * 3.要求每个人只能和其他7个人搭档一次
 * 4.同一个对手只能遇到2次
 * 5.7*8的矩阵
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/10
 */
public class Algorithm {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> allGroups = combine(list);//所有分组情况
        List<List<String>> list1 = _combine(allGroups);//所有分组情况
        List<List<String>> list2 = new ArrayList<>(list1);//所有行结果
        for (List<String> row : list1) {
            StringBuilder sb = new StringBuilder(12);
            for (String group : row) {
                sb.append(group);
            }
            if (!isValid(sb.toString())) {
                list2.remove(row);
            }
        }
//        for (List s : list2) {
//            System.out.println(s);
//        }
        int rowNum = 7;//行数
        int size = list2.size();
        int a = size / rowNum;
//        System.out.println(size);
//        List<List<List<String>>> lastList = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            for (int j = a; j < a * 2; j++) {
                for (int k = a * 2; k < a * 3; k++) {
                    for (int l = a * 3; l < a * 4; l++) {
                        for (int m = a * 4; m < a * 5; m++) {
                            for (int n = a * 5; n < a * 6; n++) {
                                for (int o = a * 6; o < a * 7; o++) {
//                                    List<List<String>> rows = new ArrayList<>();
//                                    rows.add(list2.get(i));
//                                    rows.add(list2.get(j));
//                                    rows.add(list2.get(k));
//                                    rows.add(list2.get(l));
//                                    rows.add(list2.get(m));
//                                    rows.add(list2.get(n));
//                                    rows.add(list2.get(o));
//                                    lastList.add(rows);
                                    StringBuilder sb  =new StringBuilder(100);

                                    System.out.println(list2.get(i));
                                    System.out.println(list2.get(j));
                                    System.out.println(list2.get(k));
                                    System.out.println(list2.get(l));
                                    System.out.println(list2.get(m));
                                    System.out.println(list2.get(n));
                                    System.out.println(list2.get(o));
                                    System.out.println("----------------------------");
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("-------------------------");
        }
//        for (List<List<String>> matrix : lastList) {
//            for (List<String> row : matrix) {
//                System.out.println(row);
//            }
//            System.out.println("------------------");
//        }


//        System.out.println(lists);
//        System.out.println(lists.size());
//        for (String s : allGroups) {
//            System.out.println(s);
//        }
//        List<String> existGroups = new ArrayList<>();//已经存在的分组
//        List<List<String>> r = new ArrayList<>();//结果
//        for (String s : allGroups) {
//            if (existGroups.contains(s)) {//分组存在跳过
//                continue;
//            }
//            List<String> res = new ArrayList<>();
//            res = getRow(res, s, allGroups, existGroups);
//            if (res == null) {
//                continue;
//            }
////            existGroups.addAll(res);
//            r.add(res);
//        }
//        for (List<String> item : r) {
//            System.out.println(item);
    }

    private static boolean isValid(String str) {
        int length = str.length();
        for (int i = 1; i <= 8; i++) {
            String _str1 = str.replaceAll(i + "", "");
            int _length = _str1.length();
            if (length - _length > 1) {
                return false;
            }
        }
        return true;
    }

    private static List<List<String>> _combine(List<String> allGroups) {
        List<List<String>> r = new ArrayList<>();
        int size = allGroups.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    for (int l = k + 1; l < size; l++) {
                        List<String> row = new ArrayList<>();
                        row.add(allGroups.get(i));
                        row.add(allGroups.get(j));
                        row.add(allGroups.get(k));
                        row.add(allGroups.get(l));
                        r.add(row);
                    }
                }
            }

        }
        return r;
    }

    /**
     * @param row    行
     * @param group  行第一个分组
     * @param remain 剩余的组数
     * @param exist  已经存在的分组
     * @return 行
     */
    private static List<String> getRow(List<String> row, String group, List<String> remain, List<String> exist) {
        if (exist.contains(group)) {//分组存在返回null
            return null;
        }
        row.add(group);
        String[] keyArr = group.split("&");
        List<String> tmp = new ArrayList<>(remain);
        for (String s1 : remain) {
            if (s1.contains(keyArr[0]) || s1.contains(keyArr[1])) {
                tmp.remove(s1);//过滤已经分组的队员
            }
        }
        if (tmp.size() == 0) {
            return row;
        }
        return getRow(row, tmp.get(0), tmp, exist);
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
