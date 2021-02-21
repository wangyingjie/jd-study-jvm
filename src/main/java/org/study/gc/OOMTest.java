package org.study.gc;

import java.util.ArrayList;
import java.util.Random;

/**
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+PrintFlagsFinal
 *
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+PrintCommandLineFlags
 *
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+PrintTLAB
 *
 * @author wangyingjie5
 * @date 2021/2/21 11:21
 */
public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<>();
        while (true) {
            // try {
            //     Thread.sleep(100);
            //     // TimeUnit.MILLISECONDS.sleep(100);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            list.add(new Picture(new Random().nextInt(100 * 50)));
        }
    }

}

class Picture {
    int id;

    public Picture(int id) {
        this.id = id;
    }
}