package com.adoph.framework.util.tree.v4;

import com.adoph.framework.function.TFunction;
import lombok.extern.slf4j.Slf4j;

import java.lang.invoke.MethodType;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * 树构造器
 */
@Slf4j
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
    private TFunction<T, List<T>> children;

    /**
     * treeMethod
     */
    private TreeMethod treeMethod;

    /**
     * setChildrenMethodType
     */
    private static final MethodType setChildrenMethodType = MethodType.methodType(void.class, List.class);

    /**
     * 排序字段，仅支持整数类型（Byte、Short、Integer、Long）
     */
    private ToLongFunction<T> sort;

    public TreeBuilder<T, R> id(Function<T, R> id) {
        this.id = id;
        return this;
    }

    public TreeBuilder<T, R> pid(Function<T, R> pid) {
        this.pid = pid;
        return this;
    }

    public TreeBuilder<T, R> children(TFunction<T, List<T>> children) {
        this.children = children;
        return this;
    }

    public TreeBuilder<T, R> sort(ToLongFunction<T> sort) {
        this.sort = sort;
        return this;
    }

    public List<T> build() {
        if (treeNodes.isEmpty()) {
            return treeNodes;
        }

        treeMethod = TreeMethodUtils.getTreeMethod(children);

        if (Objects.isNull(rootPid)) {
            return doBuild();
        }

        return doBuild(rootPid);
    }

    public List<T> doBuild(R rootPid) {
        List<T> tmpList = new ArrayList<>(treeNodes);

        // 按父节点分组
        Map<R, List<T>> treeMap = tmpList.stream().collect(Collectors.groupingBy(node -> pid.apply(node)));

        // 排序
        if (Objects.nonNull(sort)) {
            treeMap.forEach((k, v) -> v.sort(Comparator.comparingLong(sort)));
        }

        // 根节点集
        List<T> rootNodes = treeMap.get(rootPid);

        rootNodes.forEach(node -> buildChild(node, treeMap));

        return rootNodes;
    }

    private void buildChild(T pNode, Map<R, List<T>> treeMap) {
        R tmpPid = id.apply(pNode);
        List<T> tmpChildren = treeMap.get(tmpPid);
        if (Objects.nonNull(tmpChildren)) {
            setChildrenByMethodHandle(pNode, tmpChildren);
            tmpChildren.forEach(node -> buildChild(node, treeMap));
        }
    }

    public List<T> doBuild() {
        List<T> tmpList = new ArrayList<>(treeNodes);
        for (T node1 : treeNodes) {
            for (T node2 : treeNodes) {
                if (!Objects.equals(id.apply(node1), id.apply(node2))) {
                    if (Objects.equals(id.apply(node1), pid.apply(node2))) {
                        List<T> subNodes = children.apply(node1);
                        if (subNodes == null) {
                            subNodes = new ArrayList<>();
                            setChildrenByMethodHandle(node1, subNodes);
                        }
                        subNodes.add(node2);
                        // 排序子节点
                        if (Objects.nonNull(sort)) {
                            subNodes.sort(Comparator.comparingLong(sort));
                        }
                        tmpList.remove(node2);
                    }
                }
            }
        }

        // 排序根节点
        tmpList.sort(Comparator.comparingLong(sort));

        return tmpList;
    }

    private void setChildrenByMethodHandle(T node, List<T> children) {
        try {
            lookup().findVirtual(node.getClass(), treeMethod.getSetChildrenMethodName(), setChildrenMethodType).bindTo(node).invokeExact(children);
        } catch (Throwable e) {
            log.error("invoke setChildren exception!", e);
        }
    }

}