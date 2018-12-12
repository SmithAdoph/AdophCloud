package org.fenixsoft.clazz;

import org.apache.commons.lang.CharSet;

import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestClass {
    private int m;

    public synchronized void sub() {
        System.out.println(1);
    }

    public void action() {
        synchronized (this) {
            System.out.println(2);
        }
    }

    public int inc() {
        return m + 1;
    }

    public static void main(String[] args) {
//        System.out.println(Charset.defaultCharset());
//        TreeMap<String, String> header = new TreeMap<>();
//        header.put("name", "姓名");
//        header.put("sex", "性别");
//        header.put("high", "身高");
//        header.put("fav", "爱好");
//        for (Map.Entry item : header.entrySet()) {
//            System.out.println(item.getKey() + ":" + item.getValue());
//        }

        LinkedHashMap<String, String> header = new LinkedHashMap<>();
        header.put("name", "姓名");
        header.put("sex", "性别");
        header.put("high", "身高");
        header.put("fav", "爱好");
        for (Map.Entry item : header.entrySet()) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }
    }
}