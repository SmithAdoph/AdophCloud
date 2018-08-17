package com.adoph.test.jvm;

/**
 * 栈溢出测试
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/8/15
 */
public class StackTest {

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.increment();
        } catch (Exception e) {
            System.out.println("log start");
            System.out.println("count=" + sof.getCount());
            e.printStackTrace();
        }
    }

}

class JavaVMStackSOF {
    private int count = 1;

    public void increment() {
        count++;
        increment();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
