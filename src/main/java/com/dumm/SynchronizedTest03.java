package com.dumm;
/**
 * Created by dumm on 2019/2/19.
 */

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm
 * @ClassName: B
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/2/19
 */
class B {
    //静态方法，上类锁，函数功能为连续打印1000个value值，调用时会传1，所以会打印1000个1
    synchronized public static void mB(String value) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            System.out.println(value);
        }
    }

    public void mC(String value) {
        //修饰this上对象锁，函数功能也是连续打印1000个value值，调用时会传2，所以会打印1000个2
        synchronized (this) {
            for (int i = 0; i < 1000; i++) {
                System.out.println(value);
            }
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    B.mB("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                new B().mC("2");
            }
        });
        thread.start();
        thread2.start();

    }
}

