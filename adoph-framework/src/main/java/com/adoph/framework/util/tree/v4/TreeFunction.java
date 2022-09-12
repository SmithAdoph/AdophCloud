package com.adoph.framework.util.tree.v4;

import java.util.List;

/**
 * 设置子类FunctionalInterface
 *
 * @author tangqd
 * @version 1.0
 * @since 2022/8/31
 */
@FunctionalInterface
public interface TreeFunction<T> {

    void setChildren(T obj, List<T> val);

}