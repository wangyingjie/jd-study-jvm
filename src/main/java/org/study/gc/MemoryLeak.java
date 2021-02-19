package org.study.gc;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author wangyingjie5
 * @date 2021/2/19 16:26
 */
public class MemoryLeak {

    public static void main(String[] args) {
        while (true) {
            ArrayList<Object> beanList = new ArrayList<>();
            for (int i = 0; i < 500; i++) {
                Bean data = new Bean();
                // 10kb
                data.list.add(new byte[1024 * 10]);
                beanList.add(data);
            }

            try {
                TimeUnit.MILLISECONDS.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Bean {
    int size = 10;
    String info = "hello,agguigu";
    static ArrayList list = new ArrayList<>();
}
