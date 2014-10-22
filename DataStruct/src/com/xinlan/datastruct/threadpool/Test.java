package com.xinlan.datastruct.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Test
{

    public static void main(String[] args)
    {
        ExecutorService pool = createStackThreadPool(2);
        
        pool.execute(new MyTask("1"));
        pool.execute(new MyTask("2"));
        pool.execute(new MyTask("3"));
        pool.execute(new MyTask("4"));
        pool.execute(new MyTask("5"));
        pool.execute(new MyTask("6"));
        pool.execute(new MyTask("7"));
    }
    
    public static ExecutorService createStackThreadPool(int threadSize){
        return new ThreadPoolExecutor(threadSize, threadSize, 0L,
                TimeUnit.MILLISECONDS, new LIFOLinkedBlockingDeque<Runnable>());
    }

    static final class MyTask implements Runnable
    {
        private String name;

        public MyTask(String name)
        {
            this.name = name;
        }

        @Override
        public void run()
        {
            int index = 0;
            while (index < 10)
            {
                System.out.println("线程:" + name + " 运行   " + (index++));
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }// end while
        }

    }// end inner class
}
