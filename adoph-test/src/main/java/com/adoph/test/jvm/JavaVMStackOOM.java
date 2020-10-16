package com.adoph.test.jvm;

/**
 * 备注：差不多消耗所有的线程和cpu，会导致系统假死
 * vm args: -Xss2M
 *
 * @author adoph
 * @version v1.0
 * @date 2020/3/1
 */
public class JavaVMStackOOM {

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

    private void dontStop() {
        while (true){

        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(this::dontStop).start();
        }
    }

}
