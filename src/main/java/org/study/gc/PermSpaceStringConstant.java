package org.study.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Desc: 老年代溢出</p>
 * <p>Date:2020/6/16 18:23</p>
 *
 * @author wangyingjie1
 */
public class PermSpaceStringConstant {

    /**
     * -Xmx128m -Xms64m -XX:PermSize=5m -XX:MaxPermSize=10M
     * @param args
     */
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        int i = 0;

        while (true) {
            strs.add(String.valueOf(i++).intern());
            System.out.println("We have created " + i + " constant String.");
        }
    }


}
