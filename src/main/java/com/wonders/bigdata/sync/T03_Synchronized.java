package com.wonders.bigdata.sync;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/9/10 15:56
 */
public class T03_Synchronized implements Runnable {
    private int count = 100;
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T03_Synchronized t = new T03_Synchronized();
        for (int i=0;i<100;i++) {
            new Thread(t, "Thread" + i).start();
        }
    }
}
