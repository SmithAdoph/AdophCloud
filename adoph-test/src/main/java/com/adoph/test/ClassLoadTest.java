package com.adoph.test;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/6/22
 */
public class ClassLoadTest {
    static final int GANA = 12;

    static {
        System.out.println("主方法静态代码块！");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("执行main方法！");
//        Class<Initable> initableClass = Initable.class;
//        System.out.println(Initable.ERP);
//        //执行forName会初始化类（包括初始化静态变量和执行静态代码块）
//        Class<?> initable = Class.forName("com.adoph.test.Initable");
//        Initable1.print();

//        编译无法通过
//        Class<Number> integerClass = Integer.class;

//        编译通过
//        Class<? extends Number> carClass = Integer.class;
//        carClass = Integer.class;
//        carClass = Number.class;
    }
}

class Initable {
    static final int ERP = 1;

    static {
        System.out.println("静态代码块！");
    }
}

class Initable1 {
    static void print() {
        System.out.println("打印主方法静态变量：" + ClassLoadTest.GANA);
    }
}

class Car extends Ve {
}

class Ve {
}
