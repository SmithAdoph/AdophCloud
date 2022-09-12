package com.adoph.framework.util.v2;

import com.adoph.framework.util.bean.Menu;
import com.adoph.framework.util.tree.v1.TreeBuilder;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 扁平数据结构转树形数据v1:
 * 使用
 *
 * @author tangqd
 * @version 1.0
 * @since 2022/8/30
 */
@Slf4j
public class TreeUtils {

    public static <T, R> TreeBuilder<T, R> builder(List<T> treeNodes) {
        return new TreeBuilder<>(treeNodes);
    }

    public static <T, R> TreeBuilder<T, R> builder(List<T> treeNodes, R rootPid) {
        return new TreeBuilder<>(treeNodes, rootPid);
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

//        test1(list2);
        test2(list2);
    }

    public static void test1(List<Menu> list) {
        List<Menu> list1 = TreeUtils.builder(list)
                .id(Menu::getId)
                .pid(Menu::getPid)
                .ofSetChildrenFunc(Menu::setChildren)
                .ofGetChildrenFunc(Menu::getChildren)
                .build();

        log.info("结果：{}", JSON.toJSONString(list1));
    }

    public static void test2(List<Menu> list) {
        List<Menu> list1 = TreeUtils.builder(list, "0")
                .id(Menu::getId)
                .pid(Menu::getPid)
                .ofSetChildrenFunc(Menu::setChildren)
                .ofGetChildrenFunc(Menu::getChildren)
                .build();

        log.info("结果：{}", JSON.toJSONString(list1));
    }

}
