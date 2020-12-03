package com.wonders.bigdata.sync;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Description: 多线程高并发下测试不同锁对同一个变量加到一千万的时间<br>
 *
 * @author: XB
 * @date: 2020/9/17 15:52
 */
public class T05_SyncVsAtomicVsLongAdder {
    private static long count1 = 0L;//加锁
    private static AtomicLong count2 = new AtomicLong(0L);//CAS
    private static LongAdder count3 = new LongAdder();//分段锁CAS

    public static void main(String[] args) {
        Thread[] threads = new Thread[1000];
        int length = 10000;
        Object lock = new Object();
        for (int i=0;i<threads.length;i++) {
            threads[i] = new Thread(()->{
                for (int k=0;k<length;k++) {
                    synchronized (lock) {
                        count1++;
                    }
                }
            });
        }
        Long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("Sync: " + count1 + " time " + (end - start));

        //-------------------------------------------
        for (int i=0;i<threads.length;i++) {
            threads[i] = new Thread(()->{
                for (int k=0;k<length;k++) {
                    count2.getAndIncrement();
                }
            });
        }
        start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Atomic: " + count2 + " time " + (end - start));

        //----------------------------------------
        for (int i=0;i<threads.length;i++) {
            threads[i] = new Thread(()->{
                for (int k=0;k<length;k++) {
                    count3.increment();
                }
            });
        }
        start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("LongAdder: " + count3 + " time " + (end - start));
    }
}
