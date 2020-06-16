package org.study.gc;

/**
 * <p>Desc: </p>
 * <p>Date:2020/6/15 15:09</p>
 *
 * @author wangyingjie1
 */
public class GCTest {

    private static final int size = 1024 * 1024;

    /**
     * 运行参数
     * -Xms30m -Xmx30m -XX:+PrintGCDetails -XX:+PrintHeapAtGC -XX:+UseParNewGC
     *
     * -server -verbose -Xms10m -Xmx10m -XX:+PrintGC -XX:+DoEscapeAnalysis -XX:+UseTLAB -XX:+EliminateAllocations
     *
     * @param args
     */
    public static void main(String[] args) {
        LargeObject largeObject1 = null;
        testMinorGC();
    }

    private static void testMinorGC() {
        // LargeObject largeObject1 = new LargeObject(size / 2, "largeObject1");
        // LargeObject largeObject2 = new LargeObject(size, "largeObject2");
        // LargeObject largeObject3 = new LargeObject(size * 2, "largeObject3");
        // largeObject3 = null;
        // LargeObject largeObject4 = new LargeObject(size * 3, "largeObject4");
        // LargeObject largeObject5 = new LargeObject(size * 2, "largeObject5");

        while (true) {
            LargeObject largeObject1 = new LargeObject(size / 2, "largeObject1");
            LargeObject largeObject2 = new LargeObject(size, "largeObject2");
            LargeObject largeObject3 = new LargeObject(size * 2, "largeObject3");
            largeObject3 = null;
            LargeObject largeObject4 = new LargeObject(size * 3, "largeObject4");
            LargeObject largeObject5 = new LargeObject(size * 2, "largeObject5");
        }
    }

    static class LargeObject {
        private byte[] data;
        private String name;

        public LargeObject(int size, String name) {
            this.data = new byte[size];
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
