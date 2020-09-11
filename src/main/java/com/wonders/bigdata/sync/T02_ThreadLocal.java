package com.wonders.bigdata.sync;

import java.util.concurrent.TimeUnit;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/9/8 14:33
 */
public class T02_ThreadLocal {
    static ThreadLocal<String> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set("1234");
        }).start();
    }
}
