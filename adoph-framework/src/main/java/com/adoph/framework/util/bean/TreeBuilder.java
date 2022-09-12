package com.adoph.framework.util.bean;

import com.adoph.framework.util.tree.v1.TreeFunction;
import com.adoph.framework.function.TFunction;
import com.adoph.framework.util.SerializedLambdaUtils;
import com.adoph.framework.util.tree.v4.TreeMethod;
import com.adoph.framework.util.tree.v4.TreeMethodUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class TreeBuilder<T, R> {

    public TreeBuilder(List<T> treeNodes) {
        this.treeNodes = treeNodes;
        this.clazz = treeNodes.get(0).getClass();
    }

    private final List<T> treeNodes;
    private final Class<?> clazz;
    private TFunction<T, R> id;
    private TFunction<T, R> pid;
    private TFunction<T, List<T>> childrenFunc;
    private Function<T, List<T>> getChildrenFunc;
    private TreeFunction<T> setChildrenFunc;

    public TreeBuilder<T, R> id(TFunction<T, R> id) {
        this.id = id;
        return this;
    }

    public TreeBuilder<T, R> pid(TFunction<T, R> pid) {
        this.pid = pid;
        return this;
    }

    public TreeBuilder<T, R> children(TFunction<T, List<T>> children) {
        this.childrenFunc = children;
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
        // 空校验
        if (treeNodes.isEmpty()) {
            return treeNodes;
        }

        // 获取getChildren和setChildren 方法
        TreeMethod treeMethod = TreeMethodUtils.getTreeMethod(childrenFunc);
        Method setMethod = null;
        try {
            setMethod = clazz.getDeclaredMethod(treeMethod.getSetChildrenMethodName(), List.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 1、通过反射实现
        List<T> tmpList = new ArrayList<>(treeNodes);
        for (T node1 : treeNodes) {
            for (T node2 : treeNodes) {
                if (!Objects.equals(id.apply(node1), id.apply(node2))) {
                    if (Objects.equals(id.apply(node1), pid.apply(node2))) {
                        List<T> children = childrenFunc.apply(node1);
                        if (children == null) {
                            children = new ArrayList<>();
                            try {
                                assert setMethod != null;
                                setMethod.invoke(node1, children);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                        children.add(node2);
                        tmpList.remove(node2);
                    }
                }
            }
        }

        // 2、通过function实现
//        List<T> tmpList = new ArrayList<>(treeNodes);
//        for (T node1 : treeNodes) {
//            for (T node2 : treeNodes) {
//                if (!Objects.equals(id.apply(node1), id.apply(node2))) {
//                    if (Objects.equals(id.apply(node1), pid.apply(node2))) {
//                        List<T> children = getChildrenFunc.apply(node1);
//                        if (children == null) {
//                            children = new ArrayList<>();
//                            setChildrenFunc.setChildren(node1, children);
//                        }
//                        children.add(node2);
//                        tmpList.remove(node2);
//                    }
//                }
//            }
//        }


        return tmpList;
    }

}