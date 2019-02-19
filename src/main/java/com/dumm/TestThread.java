package com.dumm;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm
 * @ClassName: TestThread
 * @Description: java类作用描述
 * @Author: dumm
 * @Version: 1.0
 */
public class TestThread {
    public static void  main(String args[]){
        boolean flag= true;
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//
//                }
//            }
//        }).start();
//

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
//        Executors.newFixedThreadPool(10).execute(); 不推荐使用了
        //Common Thread Pool 推荐方式 这样的处理方式可以更加明确线程池的运行规则，规避资源耗尽的风险。
        ExecutorService threadPool = new ThreadPoolExecutor(5, 200,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//
        threadPool.execute(new TestThread(). new Myrun());


        Future<String> future = threadPool.submit(new TestThread().new CallableTest());
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("11111"+future.get());
        } catch (InterruptedException e) {//处理中断
            e.printStackTrace();
        } catch (ExecutionException e) {//处理无法执行任务异常
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
                threadPool.shutdown();//gracefully shutdown
    }
    class CallableTest implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            //your operation
            return "1231231";
        }
    }

    class Myrun implements  Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            ThreadLocal local = new ThreadLocal();
            local.set("dumm");
            System.out.println(local.get());
        }
    }


}
