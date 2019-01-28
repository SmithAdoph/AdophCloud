package com.adoph.test.thead;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/12/19
 */
public class VisibilityTest extends Thread {
    private boolean stop;

    @Override
    public void run() {
        int i = 0;
        while (!stop) {
            i++;
        }
        System.out.println("finish loop,i=" + i);
    }

    public void stopIt() {
        stop = true;
    }

    public boolean getStop() {
        return stop;
    }

    public static void main(String[] args) throws Exception {
        VisibilityTest v = new VisibilityTest();
        v.start();

        Thread.sleep(1000);
        v.stopIt();
        Thread.sleep(2000);
        System.out.println("finish main");
        System.out.println(v.getStop());
    }

}
