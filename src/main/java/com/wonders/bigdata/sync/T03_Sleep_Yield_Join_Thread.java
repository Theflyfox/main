package com.wonders.bigdata.sync;

/**
 * Description: 线程sleep、join的使用<br>
 *
 * @author: XB
 * @date: 2020/9/10 10:13
 */
public class T03_Sleep_Yield_Join_Thread {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i=0;i<10;i++) {
                System.out.println("T1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i=0;i<10;i++) {
                System.out.println("T2");
                try {
                    Thread.sleep(500);
                    t1.join(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
