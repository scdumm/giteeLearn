package com.dumm;
/**
 * Created by dumm on 2019/2/19.
 */

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm
 * @ClassName: SynchronizedTest
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/2/19
 */
public class SynchronizedTest {
//    public static  int counter = 0;
//
//    public synchronized static void increase() {
//        for(int i = 0; i < 10000; i++) {
//            counter++;
//        }
//    }
//
//    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(100);
//        for(int i = 0; i < 10; i ++) {
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    increase();
//                }
//            });
//        }
//        executor.shutdown();
//        while (!executor.isTerminated()) {}
//        System.out.println(counter);
//    }
//------------------

    public static void main(String[] args) {
        Object object = new Object();
        Example example = new Example(object);
        MyThread thread1 = new MyThread(example);
        MyThread2 thread2 = new MyThread2(example);
        thread1.start();
        thread2.start();
    }
}

class MyThread extends Thread {
    private final Example example;

    public MyThread(Example example) {
        this.example = example;
    }

    @Override
    public void run() {
        example.exec();
    }
}

class MyThread2  extends Thread {
    private final Example example;

    public MyThread2(Example example) {
        this.example = example;
    }

    @Override
    public void run() {
        example.exec();
    }
}

class Example {
    private final Object object;

    Example(Object object) {
        this.object = object;
    }
//    synchronized修饰对象时锁住的是修饰的对象。
//
//    当一个线程执行时，将object对象锁住，另一个线程就不能执行对应的块
    public void exec()
    {
        System.out.printf("woshi--", Thread.currentThread().getName());
        synchronized (object)
        {
            for (int i
                 = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                }
                catch (InterruptedException
                        ex) {
                    ex.printStackTrace();
                }
                System.out.printf("%s,Hello%d\n",
                        Thread.currentThread().getName(), i);
            }
        }
    }
    public synchronized void exec1() {
        for (int i= 0; i < 10; i++) {
            try {
                long time = (long)(Math.random() * 1000);
                Thread.sleep(time);
            } catch (InterruptedException
                    ex) {
                ex.printStackTrace();
            }

            System.out.printf("%s,Hello[%d]\n",
                    Thread.currentThread().getName(), i);
        }

    }
    //当类中存在多个synchronized方法时，线程访问synchronized方法时会对类的实例加锁，因此，该实例的其他synchronized方法在线程未结束之前无法访
    public synchronized void exec2() {
        for (int i = 0; i < 10; i++) {
            try {
                long time = (long) (Math.random() * 1000);
                Thread.sleep(time);
            } catch (InterruptedException
                    ex) {
                ex.printStackTrace();
            }

            System.out.printf("%s,world[%d]\n",
                    Thread.currentThread().getName(), i);
        }
    }

}
