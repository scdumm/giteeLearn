package com.dumm.thread;
/**
 * Created by dumm on 2019/2/19.
 */

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm
 * @ClassName: TwoThreadWaitNotify
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/2/19
 */
public class TwoThreadWaitNotify {

    private int start = 1;

    private boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        TwoThreadWaitNotify.join();
//        TwoThreadWaitNotify twoThread = new TwoThreadWaitNotify();
//
//        Thread t1 = new Thread(new OuNum(twoThread));
//        t1.setName("A");
//
//
//        Thread t2 = new Thread(new JiNum(twoThread));
//        t2.setName("B");
//
//        t1.start();
//        t2.start();
    }

    /**
     * 偶数线程
     */
    public static class OuNum implements Runnable {
        private TwoThreadWaitNotify number;

        public OuNum(TwoThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {

            while (number.start <= 100) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("偶数线程抢到锁了");
                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + "+-+偶数" + number.start);
                        number.start++;

                        number.flag = false;
                        TwoThreadWaitNotify.class.notify();

                    }else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }


    /**
     * 奇数线程
     */
    public static class JiNum implements Runnable {
        private TwoThreadWaitNotify number;

        public JiNum(TwoThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 100) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("奇数线程抢到锁了");
                    if (!number.flag) {
                        System.out.println(Thread.currentThread().getName() + "+-+奇数" + number.start);
                        number.start++;

                        number.flag = true;

                        TwoThreadWaitNotify.class.notify();
                    }else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static void join() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "" );
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) ;
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "" );
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) ;

        t1.start();
        t2.start();

        //等待线程1终止
        t1.join();

        //等待线程2终止
        t2.join();

    }
}
