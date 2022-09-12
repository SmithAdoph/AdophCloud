package com.adoph.framework.util;

import com.adoph.framework.util.bean.Menu;
import com.adoph.framework.util.bean.TreeNode;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 扁平化数据转树形结构数据
 *
 * @author adoph
 * @version v1.0
 * @date 2019/11/28
 */
public class TreeDataUtils {

    public static void main(String[] args) {
        Node n1 = new Node(1L, 0L, "父亲");
        Node n2 = new Node(2L, 1L, "儿子");
        Node n3 = new Node(3L, 1L, "女儿");
        Node n4 = new Node(4L, 2L, "小三");
        Node n5 = new Node(5L, 2L, "小四");
        Node n6 = new Node(6L, 3L, "花花");
        Node n7 = new Node(7L, 6L, "红红");

        List<Node> list = Arrays.asList(n1, n2, n3, n4, n5, n6, n7);
        System.out.println("-------------完美分割线------------------");

        List<Menu> list2 = Arrays.asList(
                new Menu("100", "0", "第一位"),
                new Menu("1", "0", "alibaba"),
                new Menu("1000", "0", "第三位"),
                new Menu("99", "0", "sefon"),
                new Menu("2", "1", "tengxun"),
                new Menu("3", "2", "baidu")
        );


//        System.out.println(JSON.toJSONString(getTree(list2)));


    }

    /**
     * 数组转换树形数据
     *
     * @param list 带转换数组
     * @return 转换后的集合
     */
    @SuppressWarnings("all")
    public static <T extends TreeNode> List<T> getTree(List<T> list) {
        List<T> tmpList = new ArrayList<>(list);
        for (T node1 : list) {
            for (T node2 : list) {
                if (!node1.getId().equals(node2.getId())) {
                    if (node1.getId().equals(node2.getPid())) {
                        List<T> children = node1.getChildren();
                        if (children == null) {
                            children = new ArrayList<>();
                            node1.setChildren(children);
                        }
                        children.add(node2);
                        tmpList.remove(node2);
                    }
                }
            }
        }
        return tmpList;
    }

}

@Data
class Node {

    Node(Long id, Long pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    private Long id;
    private Long pid;
    private List<Node> children;
    private String name;

}



