package com.adoph.framework.util;

import com.adoph.framework.function.TFunction;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * lambda serialize tool
 *
 * @author tangqd
 * @version 1.0
 * @since 2022/8/31
 */
@Slf4j
public class SerializedLambdaUtils {

    /**
     * 获取lambda对应的SerializedLambda
     */
    public static <T> SerializedLambda getSerializedLambda(TFunction<T, ?> func) {
        return resolveSerializedLambda(func);
    }

    private static <T extends Serializable> SerializedLambda resolveSerializedLambda(T potentialLambda) {
        try {
            Class<?> potentialLambdaClass = potentialLambda.getClass();
            if (!potentialLambdaClass.isSynthetic()) {
                throw new IllegalArgumentException("potentialLambda must be lambda-class");
            }
            Method writeReplaceMethod = potentialLambdaClass.getDeclaredMethod("writeReplace");
            boolean isAccessible = writeReplaceMethod.isAccessible();
            writeReplaceMethod.setAccessible(true);
            Object writeReplaceObject = null;
            try {
                writeReplaceObject = writeReplaceMethod.invoke(potentialLambda);
            } catch (InvocationTargetException e) {
                log.error("invoke error", e);
            }
            writeReplaceMethod.setAccessible(isAccessible);
            if (writeReplaceObject == null || !SerializedLambda.class.isAssignableFrom(writeReplaceObject.getClass())) {
                throw new IllegalArgumentException("potentialLambda must be lambda-class. writeReplaceObject should not be " + writeReplaceObject);
            }
            return (SerializedLambda) writeReplaceObject;
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new IllegalArgumentException("potentialLambda must be lambda-class", e);
        }
    }

}
