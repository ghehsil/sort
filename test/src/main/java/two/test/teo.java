package two.test;

/**
 * Created by EDZ on 2019/6/5.
 */
public class teo {
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1(), "thread A");
        thread1.start();
        Thread thread2 = new Thread(new Thread2(), "thread B");
        thread2.start();
    }

    private static class Thread1 implements Runnable {
        public void run() {
            synchronized (Thread1.class) {
                while (true) {
                    if (flag) {
                        System.out.println("Thread1");
                        flag = !flag;
                    }
                }
            }
        }
    }

    private static class Thread2 implements Runnable {
        public void run() {
            synchronized (Thread2.class) {
                while (true) {
                    if (!flag) {
                        System.out.println("Thread2");
                        flag = !flag;
                    }
                }
            }
        }
    }
}

