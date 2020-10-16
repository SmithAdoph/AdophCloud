package org.fenixsoft.clazz;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/6/14
 */
public class CollectionTest {

    @Test
    public void testMap() {
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 6.19));
        pairArrayList.add(new Pair<>("version", 10.24));
        pairArrayList.add(new Pair<>("version", 13.14));
        Map<String, Double> map = pairArrayList.stream().collect(Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
        System.out.println(map);
    }

    @Test
    public void testMap2() {
        String[] departments = new String[]{"iERP", "iERP", "EIBU"};
        // 抛出 IllegalStateException 异常
        Map<Integer, String> map = Arrays.stream(departments).collect(Collectors.toMap(String::hashCode, str -> str));
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = list.toArray(new String[0]);
        System.out.println(array);
    }

    @Test
    public void testSplit() {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        // 预期大于 3，结果是 3
        System.out.println(ary.length);
    }

    @Test
    public void testAsList() {
        String[] str = new String[]{"yang", "hao"};
        List list = Arrays.asList(str);
        list.add("abc");
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if (item.equals("1")) {
//                iterator.remove();
//            }
//        }

        for (String item : list) {
            System.out.println(item);
            if ("1".equals(item)) {
//                list.remove(item);
            }
        }
        System.out.println(list);
    }
}
