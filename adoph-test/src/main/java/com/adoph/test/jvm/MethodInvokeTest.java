package com.adoph.test.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/9/5
 */
public class MethodInvokeTest {

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        System.out.println(obj.getClass());
        getPrintMH(obj).invokeExact("abc");
    }

    private static MethodHandle getPrintMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }

}
