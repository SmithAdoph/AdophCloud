package com.adoph.framework.util.bean;

import lombok.Data;

import java.util.List;

@Data
public abstract class TreeNode<T extends TreeNode> {

    private Object id;
    private Object pid;
    private List<T> children;

}
