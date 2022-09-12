package com.adoph.framework.util.tree.v1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * 树构造器
 */
public class TreeBuilder<T, R> {

    public TreeBuilder(List<T> treeNodes) {
        this.treeNodes = treeNodes;
    }

    public TreeBuilder(List<T> treeNodes, R rootPid) {
        this.treeNodes = treeNodes;
        this.rootPid = rootPid;
    }

    /**
     * 原数据集合
     */
    private final List<T> treeNodes;

    /**
     * 根节点pid
     */
    private R rootPid;

    /**
     * getId method
     */
    private Function<T, R> id;

    /**
     * getPid method
     */
    private Function<T, R> pid;

    /**
     * getChildren method
     */
    private Function<T, List<T>> getChildrenFunc;

    /**
     * setChildren method
     */
    private TreeFunction<T> setChildrenFunc;

    public TreeBuilder<T, R> id(Function<T, R> id) {
        this.id = id;
        return this;
    }

    public TreeBuilder<T, R> pid(Function<T, R> pid) {
        this.pid = pid;
        return this;
    }

    public TreeBuilder<T, R> ofGetChildrenFunc(Function<T, List<T>> getChildrenFunc) {
        this.getChildrenFunc = getChildrenFunc;
        return this;
    }

    public TreeBuilder<T, R> ofSetChildrenFunc(TreeFunction<T> setChildrenFunc) {
        this.setChildrenFunc = setChildrenFunc;
        return this;
    }

    public List<T> build() {
        if (treeNodes.isEmpty()) {
            return treeNodes;
        }

        if (Objects.isNull(rootPid)) {
            return doBuild();
        }

        return doBuild(rootPid);
    }

    public List<T> doBuild(R rootPid) {
        List<T> result = new ArrayList<>();
        List<T> tmpList = new ArrayList<>(treeNodes);
        List<T> rootNodes = new ArrayList<>();

        Iterator<T> iterator = tmpList.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (Objects.equals(rootPid, pid.apply(next))) {
                rootNodes.add(next);
                iterator.remove();
            }
        }

        for (T rootNode : rootNodes) {
            result.add(buildChild(tmpList, rootNode));
        }

        return result;
    }

    public List<T> doBuild() {
        List<T> tmpList = new ArrayList<>(treeNodes);
        for (T node1 : treeNodes) {
            for (T node2 : treeNodes) {
                if (!Objects.equals(id.apply(node1), id.apply(node2))) {
                    if (Objects.equals(id.apply(node1), pid.apply(node2))) {
                        List<T> children = getChildrenFunc.apply(node1);
                        if (children == null) {
                            children = new ArrayList<>();
                            setChildrenFunc.setChildren(node1, children);
                        }
                        children.add(node2);
                        tmpList.remove(node2);
                    }
                }
            }
        }

        return tmpList;
    }

    private T buildChild(List<T> tmpNodes, T parentNode) {
        List<T> children = new ArrayList<>();
        for (T node : tmpNodes) {
            if (Objects.equals(pid.apply(node), id.apply(parentNode))) {
                children.add(buildChild(tmpNodes, node));
            }
        }
        setChildrenFunc.setChildren(parentNode, children);
        return parentNode;
    }

}