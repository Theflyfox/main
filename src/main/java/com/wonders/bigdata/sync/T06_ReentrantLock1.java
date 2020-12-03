package com.wonders.bigdata.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: synchronized可重入锁<br>
 *
 * @author: XB
 * @date: 2020/9/18 10:39
 */
public class T06_ReentrantLock1 {
    Lock lock = new ReentrantLock();
    private synchronized void m1() {
        for (int i=0;i<10;i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 2) {
                m2();
            }
        }
    }

    private synchronized void m2() {
        System.out.println("m2...");
    }

    public static void main(String[] args) {
        T06_ReentrantLock1 rl = new T06_ReentrantLock1();
        new Thread(rl :: m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(rl :: m2).start();
    }
}
