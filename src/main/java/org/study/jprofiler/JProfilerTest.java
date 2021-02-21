package org.study.jprofiler;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *  -XX:OnOutOfMemoryError
 * -XX:+PrintFlagsFinal -XX:+PrintCommandLineFlags -XX:+PrintVMOptions
 * @author wangyingjie5
 * @date 2021/2/19 16:42
 */
public class JProfilerTest {

    public static void main(String[] args) {
        while (true) {
            ArrayList<Object> list = new ArrayList<>();

            for (int i = 0; i < 50; i++) {
                Data data = new Data();
                list.add(data);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Data {
    int size = 10;
    String info = "hello,agguigu";
    // 1mb
    private byte[] buffer = new byte[1024 * 1024];
}