package com.dumm;
/**
 * Created by dumm on 2019/2/19.
 */

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm
 * @ClassName: TestSynchronized
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/2/19
 */
public class TestSynchronized {
    public static void main(String[]
                                    args) {
        Example01 example = new Example01();
        MyThread01
                thread1 = new MyThread01(example);
        Example01 example2 = new Example01();
        MyThread02
                thread2 = new MyThread02(example2);

        thread1.start();
        thread2.start();
    }
}

class MyThread01 extends Thread {
    private final Example01 example;

    public MyThread01(Example01 example) {
        this.example = example;
    }

    @Override
    public void run() {
        example.exec3();
    }
}

class MyThread02
        extends Thread {
    private final
    Example01 example;

    public MyThread02(Example01
                             example) {
        this.example
                = example;
    }

    @Override
    public void run() {
        example.exec3();
    }
}

class Example01 {
//synchronized修饰静态方法时，会对Class对象加锁。
    public synchronized static void exec3() {
        for (int i
             = 0; i < 10; i++) {
            try {
                long time
                        = (long)
                        (Math.random() * 1000);
                Thread.sleep(time);
            } catch (InterruptedException
                    ex) {
                ex.printStackTrace();
            }

            System.out.printf("%s,Static[%d]\n",
                    Thread.currentThread().getName(), i);
        }
    }

    public synchronized void exec() {
        for (int i
             = 0; i < 10; i++) {
            try {
                long time
                        = (long)
                        (Math.random() * 1000);
                Thread.sleep(time);
            } catch (InterruptedException
                    ex) {
                ex.printStackTrace();
            }

            System.out.printf("%s,Hello[%d]\n",
                    Thread.currentThread().getName(), i);
        }

    }

    public synchronized void exec2() {
        for (int i
             = 0; i < 10; i++) {
            try {
                long time
                        = (long)
                        (Math.random() * 1000);
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
