package org.study.jol;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+PrintGC
 * @author wangyingjie5
 * @date 2021/2/18 11:06
 */
public class GCDemo {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 100000000; i++) {

            byte[] bytes = new byte[1024 * 100];
            list.add(bytes);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
