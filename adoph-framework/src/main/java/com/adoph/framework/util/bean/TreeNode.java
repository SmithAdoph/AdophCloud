package com.adoph.framework.util.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public abstract class TreeNode<T extends TreeNode> implements Serializable {

    private Object id;
    private Object pid;
    private List<T> children;

}
