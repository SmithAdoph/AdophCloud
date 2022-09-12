package com.adoph.framework.util.tree.v4;

import com.adoph.framework.function.TFunction;
import com.adoph.framework.util.SerializedLambdaUtils;

import java.lang.invoke.SerializedLambda;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 树方法工具
 *
 * @author tangqd
 * @version 1.0
 * @since 2022/9/12
 */
public class TreeMethodUtils {

    /**
     * 树方法缓存
     */
    private static final Map<Class<?>, WeakReference<TreeMethod>> TREE_METHOD_CACHE = new ConcurrentHashMap<>();

    /**
     * 获取TreeMethod
     */
    public static <T> TreeMethod getTreeMethod(TFunction<T, ?> func) {
        Class<?> clazz = func.getClass();
        return Optional.ofNullable(TREE_METHOD_CACHE.get(clazz))
                .map(WeakReference::get)
                .orElseGet(() -> {
                    SerializedLambda lambda = SerializedLambdaUtils.getSerializedLambda(func);
                    TreeMethod tm = new TreeMethod();
                    tm.setSetChildrenMethodName(requireSetMethod(lambda));
                    TREE_METHOD_CACHE.put(clazz, new WeakReference<>(tm));
                    return tm;
                });
    }

    /**
     * 根据get lambda方法获取set方法名
     */
    private static String requireSetMethod(SerializedLambda serializedLambda) {
        return serializedLambda.getImplMethodName().replaceFirst("get", "set");
    }

}
