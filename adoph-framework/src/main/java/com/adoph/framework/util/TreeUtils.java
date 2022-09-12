package com.adoph.framework.util;

import com.adoph.framework.util.bean.Menu;
import com.adoph.framework.util.bean.TreeBuilder;

import java.util.*;
import java.util.function.Function;

/**
 * todo 描述
 *
 * @author tangqd
 * @version 1.0
 * @since 2022/8/30
 */
public class TreeUtils {

    public static <T, R> TreeBuilder<T, R> builder(List<T> treeNodes) {
        return new TreeBuilder<>(treeNodes);
    }

    public static <T, R> void build(List<T> list, Function<T, R> getIdFunc, Function<T, R> getPidFunc, Function<T, List<T>> getChildrenFunc) {
        List<T> tmpList = new ArrayList<>(list);
        for (T node1 : list) {
            for (T node2 : list) {
                if (!getIdFunc.apply(node1).equals(getIdFunc.apply(node2))) {
                    if (getIdFunc.apply(node1).equals(getPidFunc.apply(node2))) {
                        List<T> children = getChildrenFunc.apply(node1);
                        if (children == null) {
                            children = new ArrayList<>();
//                            node1.setChildren(children);
                        }
                        children.add(node2);
                        tmpList.remove(node2);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Menu> list2 = Arrays.asList(
                new Menu("100", "0", "第一位"),
                new Menu("1", "0", "alibaba"),
                new Menu("1000", "0", "第三位"),
                new Menu("99", "0", "sefon"),
                new Menu("2", "1", "tengxun"),
                new Menu("3", "2", "baidu")
        );

        Menu m1 = new Menu("100", "0", "第一位");
//        m1.setChildren(1);

        List<Menu> list1 = TreeUtils.builder(list2)
                .id(Menu::getId)
                .pid(Menu::getPid)
                .children(Menu::getChildren)
//                .ofSetChildrenFunc(Menu::setChildren)
//                .ofGetChildrenFunc(Menu::getChildren)
                .build();

//        System.out.println(JSON.toJSONString(list1));

    }

}
