package com.wonders.bigdata.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Description: 几种线程池的使用<br>
 *
 * @author: XB
 * @date: 2020/11/11 10:48
 */
public class ThreadPoolEcecutorTest {
    public static void main(String[] args) {
        //cachedThreadPool();
        //newFixedThreadPool();
        //newSingleThreadExecutor();
        //newScheduleThreadPool1();
        newScheduleThreadPool2();
    }

    /**
     * 可缓存线程池newCachedThreadPool
     */
    private static void cachedThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    /**
     * 指定工作线程数量的线程池newFixedThreadPool
     */
    private static void newFixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i=0;i<10;i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 单线程化的Executor
     */
    private static void newSingleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行
     * 延迟3秒执行
     */
    private static void newScheduleThreadPool1() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }

    /**
     * 定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行
     * 表示延迟1秒后每3秒执行一次
     */
    private static void newScheduleThreadPool2() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
