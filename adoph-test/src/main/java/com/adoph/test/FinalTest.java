package com.adoph.test;

/**
 * FinalTest
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/6/27
 */
public class FinalTest {

    public static void main(String[] args) {

    }

}

class Girl {
    private int a;
    private final int b;
    public Girl() {
        b = 1; //编译不通过
    }
}
