package org.study.gc;

import java.util.Map;

/**
 * @author wangyingjie5
 * @date 2021/2/18 15:29
 */
public class ThreadDeadLock {

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        new Thread(() -> {
            synchronized (s1) {
                s1.append("a");
                s2.append("1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (s2) {
                    s1.append("a");
                    s2.append("2");
                }
            }


        }).start();

        new Thread(() -> {

            synchronized (s2) {
                s1.append("b");
                s2.append("1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (s1) {
                    s1.append("b");
                    s2.append("2");
                }
            }

        }).start();

        System.out.println(s1 + "===========" + s2);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            allStackTraces.forEach((k, v) -> {
                System.out.println("Thread name is:" + k.getName());
                for (StackTraceElement s : v) {
                    System.out.println("\t" + s.toString());
                }

            });
        }).start();
    }
}
