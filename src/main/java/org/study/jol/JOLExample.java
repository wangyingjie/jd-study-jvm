package org.study.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.HashMap;

/**
 * <p>Desc: </p>
 * <p>Date:2020/6/24 14:52</p>
 *
 * @author wangyingjie1
 */
public class JOLExample {

    public static void main(String[] args) {
        System.out.println(VM.current().details());

        System.out.println(ClassLayout.parseClass(String.class).toPrintable());
        System.out.println(ClassLayout.parseInstance("www.flydean.comwww.flydean.comwww.flydean.comwww.flydean.comwww.flydean.comwww.flydean.comwww.flydean.comwww.flydean.comwww.flydean.comwww.flydean.comwww.flydean.comwww.flydean.comwww.flydean.com").toPrintable());

        // 分析引用对象
        HashMap hashMap = new HashMap();
        hashMap.put("flydean", "www.flydean.com");
        System.out.println(GraphLayout.parseInstance(hashMap).toPrintable());

    }
}
