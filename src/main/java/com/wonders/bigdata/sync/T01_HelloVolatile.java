package com.wonders.bigdata.sync;

import java.util.concurrent.TimeUnit;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/9/3 10:24
 */
public class T01_HelloVolatile {
    volatile boolean running = true;

    void m() {
        System.out.println("m start!");
        while (running) {
            System.out.println("running!");
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();

        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
