package com.adoph.framework.function;

import java.io.Serializable;
import java.util.function.Function;

/**
 * 树型结构数据转换工具
 *
 * @author tangqd
 * @version 1.0
 * @since 2022/8/31
 */
@FunctionalInterface
public interface TFunction<T, R> extends Function<T, R>, Serializable {

    R apply(T t);

}
