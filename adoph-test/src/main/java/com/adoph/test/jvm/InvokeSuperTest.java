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
public class InvokeSuperTest {

    public static void main(String[] args) {
        new InvokeSuperTest().new Son().thinking();
    }

    class GrandFather {
        void thinking() {
            System.out.println("GrandFather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("Father");
        }
    }

    class Son extends Father {
        void thinking() {
            MethodType mt = MethodType.methodType(void.class);
            MethodHandle mh;
            try {
                mh = lookup().findVirtual(GrandFather.class, "thinking", mt).bindTo(new GrandFather());
                mh.invokeExact();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}


