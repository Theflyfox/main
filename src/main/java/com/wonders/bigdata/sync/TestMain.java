package com.wonders.bigdata.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/9/1 14:16
 */
public class TestMain {
    public static void main(String[] args) {
        Object o = new Object();
        String s = "abc";
        Integer i = 9;
        Long l = 9L;
        char c = 'a';
        System.out.println(ClassLayout.parseInstance(c).toPrintable());
        synchronized (l) {
            System.out.println(ClassLayout.parseInstance(l).toPrintable());

        }
    }
}
