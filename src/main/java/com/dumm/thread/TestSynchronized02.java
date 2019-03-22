package com.dumm.thread;
/**
 * Created by dumm on 2019/3/21.
 */

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm.thread
 * @ClassName: TestSynchronized02
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/3/21
 */
public class TestSynchronized02 {


    public void test1() {
        synchronized (TestSynchronized.class) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public static synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final TestSynchronized02 myt2 = new TestSynchronized02();
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                myt2.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                TestSynchronized02.test2();
            }
        }, "test2");
        test1.start();
        test2.start();

    }
}
