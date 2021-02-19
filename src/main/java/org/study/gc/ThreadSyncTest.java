package org.study.gc;

/**
 * @author wangyingjie5
 * @date 2021/2/18 15:44
 */
public class ThreadSyncTest {

    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.start();
        t2.start();
    }

}

class Number implements Runnable {

    private int number;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (number <= 10000) {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                } else {
                    break;
                }
            }

        }
    }
}