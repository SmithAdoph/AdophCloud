package com.adoph.framework.util.tree.v4;

import com.adoph.framework.util.bean.Menu;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 扁平数据结构转树形数据v4:
 * 使用Lambda和MethodHandle是实现，支持排序
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
        Menu m1 = new Menu("100", "0", "第一位");
        m1.setSort(50);
        Menu m2 = new Menu("1", "0", "alibaba");
        m2.setSort(30);
        Menu m3 = new Menu("1000", "0", "第三位");
        m3.setSort(10);
        Menu m4 = new Menu("99", "0", "sefon");
        m4.setSort(40);
        Menu m5 = new Menu("2", "1", "tengxun");
        Menu m6 = new Menu("3", "2", "baidu");
        m6.setSort(100);
        Menu m7 = new Menu("3", "2", "baidu");
        m7.setSort(7);
        Menu m8 = new Menu("3", "2", "baidu");
        m8.setSort(200);
        List<Menu> list = Arrays.asList(m1, m2, m3, m4, m5, m6, m7);

        // 设置了根节点父id
        test1(list);

        // 注意：两个方法不能同时执行

        // 未设置根节点父id
//        test2(list);
    }

    public static void test1(List<Menu> list) {
        List<Menu> menuList = TreeUtils.builder(list, "0") // 构造参数：list待转换集合，根节点父id
                .id(Menu::getId) // id标识
                .pid(Menu::getPid) // pid标识
                .children(Menu::getChildren) // 子节点集
                .sort(Menu::getSort) // 排序字段
                .build();
        log.info("设置根节点父id时的使用场景：{}", JSON.toJSONString(menuList));
    }

    public static void test2(List<Menu> list) {
        List<Menu> list1 = TreeUtils.builder(list)
                .id(Menu::getId)
                .pid(Menu::getPid)
                .children(Menu::getChildren)
                .sort(Menu::getSort)
                .build();

        log.info("结果2：{}", JSON.toJSONString(list1));
    }

}
