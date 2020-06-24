package org.study.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * <p>Desc:计算对象所占内存的大小，参考文档：https://www.jianshu.com/p/6d62c3ee48d0 </p>
 * <p>Date:2020/6/24 13:31</p>
 *
 * @author wangyingjie1
 */
public class JOLTest {


    public static void main(String[] args) {
        // A a = new A();
        // System.out.println(ClassLayout.parseInstance(a).toPrintable());
        // System.out.println(GraphLayout.parseInstance(a).totalSize());
        //
        // B b = new B();
        // System.out.println(ClassLayout.parseInstance(b).toPrintable());

        C c = new C();
        System.out.println(ClassLayout.parseInstance(c).toPrintable());

        int[] aa = new int[2];
        System.out.println(ClassLayout.parseInstance(aa).toPrintable());

    }


}
